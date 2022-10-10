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

COMPATIBLE_MACHINE = "(agilex|agilex_fm87|stratix10)"

SRC_URI:append:agilex = " \
					file://socfpga_agilex_ghrd_sgmii.dtsi \
					file://socfpga_agilex_ghrd.dtsi \
					file://agilex_pr_fpga_static_region.dts \
					file://agilex_pr_persona0.dts \
					file://agilex_pr_persona1.dts \
					"

SRC_URI:append:agilex_fm87 = " \
					file://socfpga_agilex_ghrd.dtsi \
					"

SRC_URI:append:stratix10 = " \
					file://socfpga_stratix10_qse_sgmii_ghrd.dtsi \
					file://socfpga_stratix10_qse_sgmii_ghrd_nand.dtsi \
					file://stratix10_pr_fpga_static_region.dts \
					file://stratix10_pr_persona0.dts \
					file://stratix10_pr_persona1.dts \
					"

do_configure[depends] += "virtual/kernel:do_configure"

do_configure:append() {
	if [[ "${MACHINE}" == *"agilex"* ]]; then
		# Vanilla DTB Generation
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_${MACHINE}_vanilla.dts
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex.dtsi ${WORKDIR}/socfpga_${MACHINE}.dtsi

		# FM61
		if [[ "${MACHINE}" == "agilex" ]]; then
			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_${MACHINE}_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex_ghrd_sgmii.dtsi\"' ${WORKDIR}/socfpga_${MACHINE}_socdk.dts
			# NAND
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk_nand.dts ${WORKDIR}/socfpga_${MACHINE}_socdk_nand.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex_ghrd_sgmii.dtsi\"' ${WORKDIR}/socfpga_${MACHINE}_socdk_nand.dts
			# PR
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex_socdk_pr.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex_ghrd.dtsi\"' ${WORKDIR}/socfpga_agilex_socdk_pr.dts
		fi
		# FM87
		if [[ "${MACHINE}" == "agilex_fm87" ]]; then
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_${MACHINE}_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex_ghrd.dtsi\"' ${WORKDIR}/socfpga_${MACHINE}_socdk.dts
		fi
	fi
}

do_configure:append:stratix10() {
	# Vanilla DTB Generation
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk.dts ${WORKDIR}/socfpga_stratix10_vanilla.dts
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10.dtsi ${WORKDIR}

	# GSRD DTB Generation
	# MMC, QSPI
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk.dts ${WORKDIR}
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd.dtsi\"' ${WORKDIR}/socfpga_stratix10_socdk.dts
	sed -i '/\#include \"socfpga_stratix10_qse.dtsi\"/d' ${WORKDIR}/socfpga_stratix10_socdk.dts
	# NAND
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk_nand.dts ${WORKDIR}
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd_nand.dtsi\"' ${WORKDIR}/socfpga_stratix10_socdk_nand.dts
}