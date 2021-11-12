LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

RDEPENDS:${PN} = "dtbt"

inherit allarch systemd

SRC_URI = "file://fpgaconfig.sh \
	   file://fpgaconfig@fpga_static_region.service \
	   file://fpgaconfig@persona0.service \
	   file://fpgaconfig@persona1.service \
          "

do_compile() {
	:
}

do_install () {
	install -d ${D}${systemd_unitdir}/system
	install -d ${D}/${bindir}/

	install -m 0644 ${WORKDIR}/fpgaconfig@fpga_static_region.service ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/fpgaconfig@persona0.service ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/fpgaconfig@persona1.service ${D}${systemd_unitdir}/system/
	install -m 0744 ${WORKDIR}/fpgaconfig.sh ${D}/${bindir}/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"

FILES:${PN} += "${base_libdir}/systemd"