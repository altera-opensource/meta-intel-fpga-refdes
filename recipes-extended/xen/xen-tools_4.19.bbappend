SRCREV = "${AUTOREV}"

XEN_REPO ?= "git://github.com/altera-fpga/xen-hypervisor.git"
XEN_PROT ?= "http"
XEN_REL ?= "4.18"
XEN_BRANCH ?= "stable-4.18"

SRC_URI = " \
        ${XEN_REPO};protocol=${XEN_PROT};branch=${XEN_BRANCH} \
        file://0001-python-pygrub-pass-DISTUTILS-xen-4.19.patch \
        file://10-ether.network \
        file://10-xenbr0.netdev \
        file://10-xenbr0.network \
	"
