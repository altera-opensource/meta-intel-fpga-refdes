DESCRIPTION = "Altera SoCFPGA GSRD pio ilc custom module"
AUTHOR = "Rod Frazer<rod.frazer@intel.com>"
SECTION = "gsrd"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"

REFDES_REPO ?= "git://github.com/altera-fpga/linux-refdesigns.git"
REFDES_PROT ?= "http"
REFDES_BRANCH ?= "master"
SRCREV = "${@'bcb6180adec1f10a7a20a6a91c913019095de35d' if d.getVar('PREFERRED_VERSION_linux-socfpga-lts') == '6.12%' else '57b44fdf88bb344491118db066142938344ee3c3'}"

SRC_URI = "${REFDES_REPO};protocol=${REFDES_PROT};branch=${REFDES_BRANCH} "

S = "${WORKDIR}/git/pio_ilc_demo"

RPROVIDES_${PN} += "kernel-module-intel_pio_ilc"
