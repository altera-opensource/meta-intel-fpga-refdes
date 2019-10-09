DESCRIPTION = "Altera GSRD customization"
AUTHOR = "Tien Hock Loh <thloh@altera.com>"
SECTION = "gsrd"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
S="${WORKDIR}/git"
DEPENDS="ncurses"

REFDES_REPO ?= "git://github.com/altera-opensource/linux-refdesigns.git"
REFDES_PROT ?= "http"
REFDES_BRANCH ?= "poky-upgrade-dev"
SRCREV = "${AUTOREV}"

INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

SRC_URI = "${REFDES_REPO};protocol=${REFDES_PROT};branch=${REFDES_BRANCH} "

FILES_${PN} = "/www/pages/* \
                /home/root/intelFPGA/* \
                /home/root/README \
		"

FILES_${PN}-dbg = "/www/pages/cgi-bin/.debug/ /usr /home/root/intelFPGA/.debug"

do_compile() {
	echo "Compiling GSRD"
	cd ${S}
	oe_runmake all
}

do_install() {
	cd ${S}
        install -d ${D}/www/pages/cgi-bin
        install -d ${D}/home/root/intelFPGA
        install -m 0755 blink/blink ${D}/www/pages/cgi-bin/blink
        install -m 0755 scroll_server/scroll_server ${D}/www/pages/cgi-bin/scroll_server
        install -m 0755 scroll_client/scroll_client ${D}/www/pages/cgi-bin/scroll_client
        install -m 0755 toggle/toggle ${D}/www/pages/cgi-bin/toggle

        install -m 0755 syschk/syschk ${D}/home/root/intelFPGA/syschk
        install -m 0755 blink/blink ${D}/home/root/intelFPGA/blink
        install -m 0755 scroll_client/scroll_client ${D}/home/root/intelFPGA/scroll_client
        install -m 0755 toggle/toggle ${D}/home/root/intelFPGA/toggle
        install -m 0755 hello/hello ${D}/home/root/intelFPGA/hello
        install -m 0755 doc/README ${D}/home/root/
}

