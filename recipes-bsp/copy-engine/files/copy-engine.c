#include <sys/mman.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <errno.h>
#include <fcntl.h>
#include <getopt.h>
#include <signal.h>
#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define __SHORT_FILE__                                    \
({                                                        \
	const char *file = __FILE__;                      \
	const char *p = file;                             \
	while (*p)                                        \
		++p;                                      \
	while ((p > file) && ('/' != *p) && ('\\' != *p)) \
		--p;                                      \
	if (p > file)                                     \
		++p;                                      \
	p;                                                \
})

#define ERR(format, ...)                                 \
fprintf(stderr, "%s:%u:%s() [ERROR] : " format "\n",     \
	__SHORT_FILE__, __LINE__, __func__, ##__VA_ARGS__)

#define DBG(format, ...)                                 \
if (config.debug) \
  fprintf(stderr, "%s:%u:%s() [DEBUG] : " format "\n",   \
	__SHORT_FILE__, __LINE__, __func__, ##__VA_ARGS__)

#define ERRNO(format, ...)                               \
fprintf(stderr, "%s:%u:%s() [ERROR: %s] : " format "\n", \
	__SHORT_FILE__, __LINE__, __func__, strerror(errno), ##__VA_ARGS__)

#define HPS2HOST_RSP 0x0158
#define KERNEL_VFY_RESET 0b0000
#define KERNEL_VFY_SUCCESS 0b0100
#define KERNEL_VFY_ERROR 0b1000
#define KERNEL_VFY_RESERVED 0b1100
#define SEC2USEC 1000000

int QUIT;

struct {
	short foreground;
	short heartbeat;
	short debug;
} config = { 0, 0, 0 };


void sig_handler(int signal)
{
	QUIT = 1;
}

void daemonize()
{
	int fd = 0;
	pid_t pid = fork();
	if (pid < 0) {
		ERRNO("first fork");
		return;
	}
	if (pid > 0) exit(0);
	if (setsid() < 0) {
		ERRNO("setsid failure");
		exit(1);
	}
	signal(SIGCHLD, SIG_IGN);
	pid = fork();
	if (pid < 0){
		ERRNO("second fork");
		exit(1);
	}

	if (pid > 0) {
		exit(0);
	}

	umask(0);
	for (fd = sysconf(_SC_OPEN_MAX); fd > 0; fd--) {
		close(fd);
	}

	stdin = fopen("/dev/null", "r");
	stdout = fopen("/dev/null", "w+");
	stderr = fopen("/dev/null", "w+");
}

void heartbeat(uint32_t *ptr)
{
	if (!config.foreground)
		daemonize();
	uint32_t value = *ptr & 0xFFFF;
	uint32_t count = 0;
	signal(SIGTERM, sig_handler);
	while (!QUIT) {
		*ptr = (count++<<16) | value;
		printf("heartbeat: 0x%x\n", *ptr);
		usleep(1 * SEC2USEC);
	}
	printf("goodbye\n");
}


void print_usage(char *program)
{
	printf("%s [-H|--heartbeat] [-f|--foreground]\n", program);
}


char get_opt_char(int argc, char *argv[], int i, struct option *l_opts)
{
	while(l_opts->name) {
		if (strlen(argv[i]) > 2 && !strncmp(argv[i], "--", 2)) {
			if (!strcmp(l_opts->name, argv[i]+2)) {
				return l_opts->val;
			}
		} else if (strlen(argv[i]) == 2 && argv[i][0] == '-') {
			if (argv[i][1] == l_opts->val) {
				return l_opts->val;
			}
		}
		l_opts++;
	}
	return 0;
}

int process_args(int argc, char *argv[])
{
	if (argc == 1)
		return 0;
	struct option l_opts[] = {
		{ "help", no_argument, NULL, 'h' },
		{ "foreground", no_argument, NULL, 'f' },
		{ "heartbeat", no_argument, NULL, 'H' },
		{ "debug", no_argument, NULL, 'D' },
		{0, 0, 0, 0}
	};
	char opt_ret = 0;
	for (int i = 1; i < argc; ++i) {
		opt_ret = get_opt_char(argc, argv, i, l_opts);
		if (opt_ret == -1) {
			break;
		}
		switch(opt_ret) {
		case 'h':
			print_usage(argv[0]);
			return 1;
		case 'f':
			config.foreground = 1;
			break;
		case 'H':
			config.heartbeat = 1;
			break;
		case 'D':
			config.debug = 1;
			break;
		default:
			printf("invalid command\n");
			print_usage(argv[0]);
			return 2;
		}
	}


	return 0;
}

int main(int argc, char *argv[])
{
	int res = process_args(argc, argv);
	if (res)
		return res;
	const char *devpath = "/dev/uio0";
	DBG("opening %s", devpath);
	int fd = open(devpath, O_RDWR);
	if (fd < 0) {
		ERRNO("could not open uio device: %s", devpath);
		return errno;
	}
	// TODO: read size, offset, addr from:
	// 	/sys/class/uio/uio0/device/{size, offset, addr}
	size_t size = 0x1000;
	size_t offset = 0x0;
	// TODO: use dyanmic index based on /sys/class/uio/uio0/maps/map<index>
	size_t index = 0;
	DBG("getting page size...");
	size_t pg_size = sysconf(_SC_PAGE_SIZE);
	DBG("page size: %lu", pg_size);
	DBG("mmap(NULL, %lu, PROT_READ|PROT_WRITE, MAP_SHARED, %d, %lu)",
			size, fd, index * pg_size);
	uint8_t *ptr = mmap(NULL,
			    size,
			    PROT_READ|PROT_WRITE,
			    MAP_SHARED,
			    fd,
			    index * pg_size);
	if (ptr == MAP_FAILED) {
		ERRNO("could mmap uio map");
		res = errno;
		goto out_close;
	}
        DBG("getting pointer to mmio register (HOST_RSP)  @0x%p:", ptr + HPS2HOST_RSP);
	uint32_t *rsp = (uint32_t*)(ptr + HPS2HOST_RSP);
        DBG("value of register: 0x%x:", *rsp);
        DBG("setting verify success");
	*rsp |= KERNEL_VFY_SUCCESS;

out_close:
	close(fd);
	if (!res)
		printf("%s kernel boot notification...!\n", argv[0]);
	else
		ERR("%s, error with verify boot notification", argv[0]);
	if (config.heartbeat) {
		DBG("starting heartbeat");
		heartbeat(rsp);
	}
	return res;
}
