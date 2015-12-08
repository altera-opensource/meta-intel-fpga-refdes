DESCRIPTION = "Altera PCIe benchmarking module"
AUTHOR = "Ley Foon Tan <lftan@altera.com>"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"

REFDES_REPO ?= "git://github.com/altera-opensource/linux-refdesigns.git"
REFDES_PROT ?= "http"
REFDES_BRANCH ?= "socfpga-15.1"
SRCREV = "${AUTOREV}"

SRC_URI = "${REFDES_REPO};protocol=${REFDES_PROT};branch=${REFDES_BRANCH}"

S = "${WORKDIR}/git/pcie/modules"

