DESCRIPTION = "List of packages that are commonly needed for development purposes"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

PACKAGES = "packagegroup-dev-tools-essential"

RDEPENDS:packagegroup-dev-tools-essential = "\
	bash \
	devmem2 \
	e2fsprogs \
	ethtool \
	gcc \
	gdbserver \
	git \
	iperf3 \
	linuxptp \
	iproute2-tc \
	iproute2-ip \
	open62541 \
	netcat \
	openssh-sftp-server \
	pciutils \
	tcpdump \
	perf \
	"
