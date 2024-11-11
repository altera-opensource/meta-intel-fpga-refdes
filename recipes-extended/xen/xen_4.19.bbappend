SRCREV = "${AUTOREV}"

XEN_REPO ?= "git://github.com/intel-innersource/applications.fpga.soc.xen-hypervisor.git"
XEN_PROT ?= "http"
XEN_REL ?= "4.19"
XEN_BRANCH ?= "stable-4.19"

SRC_URI = " \
	${XEN_REPO};protocol=${XEN_PROT};branch=${XEN_BRANCH} \
	file://0001-menuconfig-mconf-cfg-Allow-specification-of-ncurses-location.patch \
	file://0001-arm-silence-gcc14-warning-error-on-irq-bounds-check.patch \
	"

do_deploy() {
    install -d ${DEPLOYDIR}

    if [ -f ${B}/xen/xen ]; then
        install -m 0644 ${B}/xen/xen ${DEPLOYDIR}/xen
    fi

    if [ -f ${B}/xen/xen.gz ]; then
        install -m 0644 ${B}/xen/xen.gz ${DEPLOYDIR}/xen.gz
    fi

    if [ -f ${B}/xen/xen.efi ]; then
        install -m 0644 ${B}/xen/xen.efi ${DEPLOYDIR}/xen.efi
    fi
}

