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

COMPATIBLE_MACHINE = "(agilex7_dk_si_agf014ea|agilex7_dk_si_agf014eb|agilex7_dk_si_agi027fb|agilex7_dk_si_agi027fa|agilex7_dk_dev_agf027f1es|agilex7_dk_dev_agm039fes|stratix10)"

SRC_URI:append:agilex7_dk_si_agf014ea = " \
					file://socfpga_agilex7_ghrd_sgmii.dtsi \
					file://socfpga_agilex7_ghrd.dtsi \
					file://agilex7_pr_fpga_static_region.dts \
					file://agilex7_pr_persona0.dts \
					file://agilex7_pr_persona1.dts \
					"

SRC_URI:append:agilex7_dk_si_agf014eb = " \
					file://socfpga_agilex7_ghrd_sgmii.dtsi \
					file://socfpga_agilex7_ghrd.dtsi \
					file://agilex7_pr_fpga_static_region.dts \
					file://agilex7_pr_persona0.dts \
					file://agilex7_pr_persona1.dts \
					"

SRC_URI:append:agilex7_dk_si_agi027fb = " \
					file://socfpga_agilex7_ghrd.dtsi \
					"

SRC_URI:append:agilex7_dk_si_agi027fa = " \
					file://socfpga_agilex7_ghrd.dtsi \
					"

SRC_URI:append:agilex7_dk_dev_agf027f1es = " \
					file://socfpga_agilex7_dk_dev_agf027f1es_ghrd.dtsi \
					"

SRC_URI:append:agilex7_dk_dev_agm039fes = " \
					file://socfpga_agilex7_ghrd.dtsi \
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
	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		# Vanilla DTB Generation
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_vanilla.dts
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex.dtsi ${WORKDIR}/socfpga_agilex7.dtsi

    # Agilex7 DK-SI-AGF014EB
		if [[ "${MACHINE}" == "agilex7_dk_si_agf014eb" ]]; then
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
			# NAND
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk_nand.dts ${WORKDIR}/socfpga_agilex7_socdk_nand.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd_sgmii.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk_nand.dts
			# PR
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk_pr.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk_pr.dts
    fi
		# Agilex7 DK-SI-AGF014EA
		if [[ "${MACHINE}" == "agilex7_dk_si_agf014ea" ]]; then
			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd_sgmii.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
			# NAND
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk_nand.dts ${WORKDIR}/socfpga_agilex7_socdk_nand.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd_sgmii.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk_nand.dts
			# PR
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk_pr.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk_pr.dts
		fi
		# Agilex7 DK-SI-AGI027F
		if [[ "${MACHINE}" == "agilex7_dk_si_agi027f"* ]]; then
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
		fi
		# Agilex7 DK-DEV-AGF027F1ES
		if [[ "${MACHINE}" == "agilex7_dk_dev_agf027f1es" ]]; then
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_dk_dev_agf027f1es_ghrd.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
		fi
		# Agilex7 DK-DEV-AGM039FES
		if [[ "${MACHINE}" == "agilex7_dk_dev_agm039fes" ]]; then
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
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
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_stratix10_socdk.dts
	sed -i '/\#include \"socfpga_stratix10_qse.dtsi\"/d' ${WORKDIR}/socfpga_stratix10_socdk.dts
	# NAND
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk_nand.dts ${WORKDIR}
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd_nand.dtsi\" \#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_stratix10_socdk_nand.dts
}
