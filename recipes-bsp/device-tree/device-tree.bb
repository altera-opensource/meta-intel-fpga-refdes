SUMMARY = "Intel SoCFPGA Development Kit devicetrees"
DESCRIPTION = "Devicetree addons for Intel SoCFPGA Development Kit examples"
SECTION = "bsp"

LICENSE = "MIT & GPL-2.0-only"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

KERNEL_INCLUDE = " \
        ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts \
        ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/* \
        ${STAGING_KERNEL_DIR}/scripts/dtc/include-prefixes \
        "
inherit devicetree

PROVIDES = "virtual/dtb"

SRC_URI:append:agilex = " \
					file://socfpga_agilex_ghrd_sgmii.dtsi \
					file://socfpga_agilex.dtsi \
					file://socfpga_agilex_socdk.dts \
					file://socfpga_agilex_socdk_nand.dts \
					file://socfpga_agilex_socdk_pr.dtb \
					file://socfpga_agilex_vanilla.dtb \
					file://agilex_pr_fpga_static_region.dts \
					file://agilex_pr_persona0.dts \
					file://agilex_pr_persona1.dts \
					"
COMPATIBLE_MACHINE:agilex = ".*"

SRC_URI:append:stratix10 = " \
					file://socfpga_stratix10.dtsi \
					file://socfpga_stratix10_qse_pcie_sgmii_ghrd.dtsi \
					file://socfpga_stratix10_socdk.dts \
					file://socfpga_stratix10_qse_pcie_sgmii_ghrd_nand.dtsi \
					file://socfpga_stratix10_socdk_nand.dts \
					file://socfpga_stratix10_vanilla.dtb \
					file://stratix10_pr_fpga_static_region.dts \
					file://stratix10_pr_persona0.dts \
					file://stratix10_pr_persona1.dts \
					"

COMPATIBLE_MACHINE:stratix10 = ".*"

devicetree_do_deploy:append() {
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/socfpga_${MACHINE}_vanilla.dtb ${DEPLOYDIR}/devicetree/socfpga_${MACHINE}_vanilla.dtb
		if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)}; then
			install -D -m 0644 ${WORKDIR}/socfpga_agilex_socdk_pr.dtb ${DEPLOYDIR}/devicetree/socfpga_agilex_socdk_pr.dtb
		fi
	fi
}