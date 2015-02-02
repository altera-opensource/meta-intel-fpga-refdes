DESCRIPTION = "Altera GSRD pio interrupt module."
AUTHOR = "Tien Hock Loh <thloh@altera.com>"
SECTION = "gsrd"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"

REFDES_REPO ?= "git://git.rocketboards.org/linux-refdesigns.git"
REFDES_PROT ?= "http"
REFDES_BRANCH ?= "socfpga-14.0.1"
SRCREV = "1c757ba635747c7ddbdc4746d62820b0c1fa9f7f"

SRC_URI = "${REFDES_REPO};protocol=${REFDES_PROT};branch=${REFDES_BRANCH} "

S = "${WORKDIR}/git/pio-interrupt"
