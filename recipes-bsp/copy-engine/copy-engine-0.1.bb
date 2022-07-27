SUMMARY = "copy-engine SW recipe"
DESCRIPTION = "copy-engine SW on SoC notifies copy-engine IP registers on FPGA"
AUTHOR = "Rodrigo Rojo <rodrigo.rojo@intel.com>"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "cpeng.service"

SRC_URI = "file://copy-engine.c"
SRC_URI += "file://cpeng.service"
S = "${WORKDIR}"
FILES_${PN} += "${systemd_unitdir}/system/cpeng.service"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  copy-engine SW                             *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build
do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} copy-engine.c -o copy-engine
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 copy-engine ${D}${bindir}
	install -d ${D}/${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/cpeng.service ${D}/${systemd_unitdir}/system
}


