DESCRIPTION = "Altera GSRD web content"
AUTHOR = "Tien Hock Loh <thloh@altera.com>"
SECTION = "gsrd"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
PR = "r0"
FILES_${PN} = "/www/pages/* \
		"

SRC_URI = "file://AC_RunActiveContent.js "
SRC_URI += "file://altera-logo.gif "
SRC_URI += "file://arriav-board-flash.swf "
SRC_URI += "file://blinkled.gif "
SRC_URI += "file://board-flash.jpg "
SRC_URI += "file://board.jpg "
SRC_URI += "file://cyclonev-board-flash.swf "
SRC_URI += "file://favicon.ico "
SRC_URI += "file://helper_script.js "
SRC_URI += "file://not_found.html "
SRC_URI += "file://offled.jpg "
SRC_URI += "file://onled.jpg "
SRC_URI += "file://progress.js "
SRC_URI += "file://runningled.gif "
SRC_URI += "file://style.css "
SRC_URI += "file://validation_script.js "
SRC_URI += "file://index.sh "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/www/pages/cgi-bin
	install -d ${D}/home/root/altera
	install -m 0755 AC_RunActiveContent.js ${D}/www/pages/
	install -m 0755 altera-logo.gif ${D}/www/pages/
	install -m 0755 arriav-board-flash.swf ${D}/www/pages/
	install -m 0755 blinkled.gif ${D}/www/pages/
	install -m 0755 board-flash.jpg ${D}/www/pages/
	install -m 0755 board.jpg ${D}/www/pages/
	install -m 0755 cyclonev-board-flash.swf ${D}/www/pages/
	install -m 0755 favicon.ico ${D}/www/pages/
	install -m 0755 helper_script.js ${D}/www/pages/
	install -m 0755 not_found.html ${D}/www/pages/
	install -m 0755 offled.jpg ${D}/www/pages/
	install -m 0755 onled.jpg ${D}/www/pages/
	install -m 0755 progress.js ${D}/www/pages/
	install -m 0755 runningled.gif ${D}/www/pages/
	install -m 0755 style.css ${D}/www/pages/
	install -m 0755 validation_script.js ${D}/www/pages/
	install -m 0755 index.sh ${D}/www/pages/cgi-bin
}
