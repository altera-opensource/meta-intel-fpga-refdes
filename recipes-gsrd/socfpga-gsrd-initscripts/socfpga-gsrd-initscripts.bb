DESCRIPTION = "Intel SoCFPGA GSRD Initialization Script"
AUTHOR = "Tien Hock Loh <tien.hock.loh@intel.com>"
SECTION = "gsrd"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

DEPENDS = "socfpga-gsrd-apps"

inherit allarch systemd

SRC_URI = "file://socfpga-gsrd.service \
	   file://socfpga-gsrd-init.sh"

do_compile() {
	:
}

do_install () {
	install -d ${D}${systemd_unitdir}/system
	install -d ${D}/${bindir}/

	install -m 0644 ${WORKDIR}/socfpga-gsrd.service ${D}${systemd_unitdir}/system/
	install -m 0744 ${WORKDIR}/socfpga-gsrd-init.sh ${D}/${bindir}/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "socfpga-gsrd.service"

FILES_${PN} += "${base_libdir}/systemd"
