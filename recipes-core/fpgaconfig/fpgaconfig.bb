LICENSE = "GPL-2.0-only"
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

	install -m 0644 ${WORKDIR}/sources-unpack/fpgaconfig@fpga_static_region.service ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/sources-unpack/fpgaconfig@persona0.service ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/sources-unpack/fpgaconfig@persona1.service ${D}${systemd_unitdir}/system/
	install -m 0744 ${WORKDIR}/sources-unpack/fpgaconfig.sh ${D}/${bindir}/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"

FILES:${PN} += "${@"/usr/lib/systemd" if d.getVar('MACHINE', True).startswith('agilex5_dk_a5e') else "${base_libdir}/systemd"}"