DESCRIPTION = "Altera PCIe DMA transfer benchmarking application"
AUTHOR = "Ley Foon Tan <lftan@altera.com>"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

REFDES_REPO ?= "git://github.com/altera-opensource/linux-refdesigns.git"
REFDES_PROT ?= "http"
REFDES_BRANCH ?= "socfpga-15.1"
SRCREV = "${AUTOREV}"

FILES_${PN} = "/home/root/altera/*"

SRC_URI = "${REFDES_REPO};protocol=${REFDES_PROT};branch=${REFDES_BRANCH} "

S = "${WORKDIR}/git/pcie/dmaxfer"

do_compile() {
	unset CFLAGS
	oe_runmake all
}

do_install() {
	install -d ${D}/home/root/altera
	install -m 0755 dmaxfer ${D}/home/root/altera/dmaxfer
}

