SRCREV = "${AUTOREV}"

XEN_REPO ?= "git://github.com/altera-opensource/xen-hypervisor.git"
XEN_PROT ?= "http"
XEN_REL ?= "4.18"
XEN_BRANCH ?= "stable-4.18"

SRC_URI = " \
	${XEN_REPO};protocol=${XEN_PROT};branch=${XEN_BRANCH} \
	file://0001-menuconfig-mconf-cfg-Allow-specification-of-ncurses-location.patch \
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

