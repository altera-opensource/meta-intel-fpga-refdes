DESCRIPTION = "Altera GSRD initialization script"
AUTHOR = "Tien Hock Loh <thloh@altera.com>"
SECTION = "gsrd"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

DEPENDS = "altera-gsrd-apps"

inherit allarch systemd

SRC_URI = "file://altera-gsrd.service \
	  file://altera-gsrd-init.sh \
          "

do_compile() {
	:
}


do_install () {
	install -d ${D}${systemd_unitdir}/system
	install -d ${D}/${bindir}/

	install -m 0744 ${WORKDIR}/altera-gsrd.service ${D}${systemd_unitdir}/system/
	install -m 0744 ${WORKDIR}/altera-gsrd-init.sh ${D}/${bindir}/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "altera-gsrd.service"

FILES_${PN} += "${base_libdir}/systemd"

