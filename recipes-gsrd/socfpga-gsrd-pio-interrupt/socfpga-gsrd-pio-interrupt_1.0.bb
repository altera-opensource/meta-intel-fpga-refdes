DESCRIPTION = "Altera SoCFPGA GSRD pio interrupt module"
AUTHOR = "Tien Hock Loh <tien.hock.loh@intel.com>"
SECTION = "gsrd"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"

REFDES_REPO ?= "git://github.com/altera-fpga/linux-refdesigns.git"
REFDES_PROT ?= "http"
REFDES_BRANCH ?= "master"
SRCREV = "57b44fdf88bb344491118db066142938344ee3c3"

SRC_URI = "${REFDES_REPO};protocol=${REFDES_PROT};branch=${REFDES_BRANCH} "

S = "${WORKDIR}/git/pio-interrupt"
