DESCRIPTION = "Altera SoCFPGA GSRD web content"
AUTHOR = "Tien Hock Loh <tien.hock.loh@intel.com>"
SECTION = "gsrd"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PR = "r0"

SRC_URI:append = " \
	    file://arria10-board-image.jpg \
	    file://arriav-board-image.jpg \
	    file://blinkled.gif \
	    file://board-flash.jpg \
	    file://board.jpg \
	    file://cyclonev-board-image.jpg \
	    file://favicon.ico \
	    file://helper_script.js \
	    file://index.sh \
	    file://intel-logo.jpg \
	    file://not_found.html \
	    file://offled.jpg \
	    file://onled.jpg \
	    file://progress.js \
	    file://runningled.gif \
	    file://stratix10-board-image.jpg \
	    file://style.css \
	    file://validation_script.js \
		file://agilex7_dk_si_agf014eb-board-image.jpg \
		file://agilex7_dk_si_agi027fc-board-image.jpg \
		file://agilex7_dk_dev_agm039fes-board-image.jpg \
		file://agilex7_dk_dev_agm039ea-board-image.jpg \
		file://agilex7_dk_dev_agf023fa-board-image.jpg \
	    "

do_install() {
	install -d ${D}/www/pages/cgi-bin
	install -d ${D}/home/root/intelFPGA
	install -m 0755 ${UNPACKDIR}/intel-logo.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/arriav-board-image.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/arria10-board-image.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/blinkled.gif ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/board-flash.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/board.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/cyclonev-board-image.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/favicon.ico ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/helper_script.js ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/not_found.html ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/offled.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/onled.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/progress.js ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/runningled.gif ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/style.css ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/validation_script.js ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/stratix10-board-image.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/index.sh ${D}/www/pages/cgi-bin
	install -m 0755 ${UNPACKDIR}/agilex7_dk_si_agf014eb-board-image.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/agilex7_dk_si_agi027fc-board-image.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/agilex7_dk_dev_agm039fes-board-image.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/agilex7_dk_dev_agm039ea-board-image.jpg ${D}/www/pages/
	install -m 0755 ${UNPACKDIR}/agilex7_dk_dev_agf023fa-board-image.jpg ${D}/www/pages/
}

FILES:${PN} = "/www/pages/* /home/*"
