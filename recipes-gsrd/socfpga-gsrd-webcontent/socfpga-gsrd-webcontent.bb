DESCRIPTION = "Intel SoCFPGA GSRD web content"
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
		file://agilex7_dk_si_agf014ea-board-image.jpg \
		file://agilex7_dk_dev_agf027f1es-board-image.jpg \
		file://agilex7_dk_si_agi027fb-board-image.jpg \
	    "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/www/pages/cgi-bin
	install -d ${D}/home/root/intelFPGA
	install -m 0755 intel-logo.jpg ${D}/www/pages/
	install -m 0755 arriav-board-image.jpg ${D}/www/pages/
	install -m 0755 arria10-board-image.jpg ${D}/www/pages/
	install -m 0755 blinkled.gif ${D}/www/pages/
	install -m 0755 board-flash.jpg ${D}/www/pages/
	install -m 0755 board.jpg ${D}/www/pages/
	install -m 0755 cyclonev-board-image.jpg ${D}/www/pages/
	install -m 0755 favicon.ico ${D}/www/pages/
	install -m 0755 helper_script.js ${D}/www/pages/
	install -m 0755 not_found.html ${D}/www/pages/
	install -m 0755 offled.jpg ${D}/www/pages/
	install -m 0755 onled.jpg ${D}/www/pages/
	install -m 0755 progress.js ${D}/www/pages/
	install -m 0755 runningled.gif ${D}/www/pages/
	install -m 0755 style.css ${D}/www/pages/
	install -m 0755 validation_script.js ${D}/www/pages/
	install -m 0755 stratix10-board-image.jpg ${D}/www/pages/
	install -m 0755 index.sh ${D}/www/pages/cgi-bin
	install -m 0755 agilex7_dk_si_agf014ea-board-image.jpg ${D}/www/pages/
	install -m 0755 agilex7_dk_dev_agf027f1es-board-image.jpg ${D}/www/pages/
	install -m 0755 agilex7_dk_si_agi027fb-board-image.jpg ${D}/www/pages/
}

FILES:${PN} = "/www/pages/* /home/*"
