DESCRIPTION = "Device Tree Overlay management tool (dtbt)"
AUTHOR = "Yves Vandervennet <yves.vandervennet@intel.com>"
SECTION = "tools"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

S = "${WORKDIR}/git"

DTBT_REPO ?= "git://github.com/altera-opensource/dtbt"
DTBT_PROT ?= "https"
DTBT_BRANCH ?= "master"
SRCREV = "d04e096df01dac54296be577c5a39c89a83c446b"

RPROVIDES:${PN} = "dtbt"

SRC_URI = "${DTBT_REPO};protocol=${DTBT_PROT};branch=${DTBT_BRANCH}"

FILES:${PN} = "/sbin/dtbt"
FILES:${PN}-dbg = ""

RDEPENDS:${PN}="python3"

PR = "r5"

do_compile() {
        :
}

do_install() {
        install -d ${D}/sbin
        install -m 0755 dtbt ${D}/sbin/dtbt
}
