# Append GSRD SoCFPGA device tree source include files
# As this is custom to Intel SoCFPGA GSRD, hence it is not suitable to be upstreamed to meta-intel-fpga

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-socfpga-lts:"

SRC_URI:append:agilex += "\
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-dts-arm64-intel-enable-FPGA-PR-DTBs-for-Agilex.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "sgmii", "file://0001-dts-arm64-intel-enable-Agilex-SGMII-support.patch", "", d)} \
			 "

SRC_URI:append:stratix10 += "\
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://0001-socfpga_stratix10_socdk-include-reference-design-dts.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-socfpga_stratix10_socdk-include-reference-design-dts.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-dts-arm64-altera-enable-FPGA-PR-DTBs-for-Stratix10.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pcie", "file://0001-socfpga_stratix10_socdk-pcie-include-reference-desig.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "sgmii", "file://0001-socfpga_stratix10_socdk-sgmii-include-reference-desi.patch", "", d)} \
			 "

SRC_URI:append:arria10 += "\
			${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-dts-arm-enable-FPGA-PR-DTBs-for-Arria10.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "nand", "file://0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "qspi", "file://0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pcie", "file://0001-socfpga_arria10_socdk-pcie-include-reference-design-.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "sgmii", "file://0001-socfpga_arria10_socdk-sgmii-include-reference-design.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "tse", "file://0001-socfpga_arria10_socdk-tse-include-reference-design-d.patch", "", d)} \
			"

SRC_URI:append:cyclone5 += "file://0001-socfpga_cyclone5_socdk-include-reference-design-dtsi.patch"

# Append GSRD specific kernel config fragments
SRC_URI += "file://ubifs.scc"
SRC_URI:append:agilex += "file://sgmii.scc"
SRC_URI:append:stratix10 += "file://sgmii.scc"
SRC_URI:append:arria10 += "file://tse.scc"
SRC_URI:append:cyclone5 += "file://tse.scc"

do_install:append() {
	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)} ; then
		install -D -m 0644 ${D}/boot/fpga_static_region.dtb ${D}/boot/fpga_static_region.dtbo
		install -D -m 0644 ${D}/boot/persona1.dtb ${D}/boot/persona1.dtbo
		install -D -m 0644 ${D}/boot/persona0.dtb ${D}/boot/persona0.dtbo
	fi
}
