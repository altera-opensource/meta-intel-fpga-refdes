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

COMPATIBLE_MACHINE = "(agilex5_devkit|agilex5_modular|agilex5_mucv|agilex5_mudv_cvr|agilex7_dk_si_agf014ea|agilex7_dk_si_agf014eb|agilex7_dk_si_agi027fb|agilex7_dk_si_agi027fa|agilex7_dk_si_agi027fc|agilex7_dk_dev_agf027f1es|agilex7_dk_dev_agm039fes|stratix10|stratix10_htile)"

SRC_URI:append:agilex7_dk_si_agf014ea = " \
					file://socfpga_agilex7_ghrd_sgmii.dtsi \
					file://socfpga_agilex7_ghrd.dtsi \
					file://agilex7_pr_fpga_static_region.dts \
					file://agilex7_pr_persona0.dts \
					file://agilex7_pr_persona1.dts \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_si_agf014eb = " \
					file://socfpga_agilex7_ghrd_sgmii.dtsi \
					file://socfpga_agilex7_ghrd.dtsi \
					file://agilex7_pr_fpga_static_region.dts \
					file://agilex7_pr_persona0.dts \
					file://agilex7_pr_persona1.dts \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_si_agi027fb = " \
					file://socfpga_agilex7_ghrd.dtsi \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_si_agi027fa = " \
					file://socfpga_agilex7_ghrd.dtsi \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_si_agi027fc = " \
					file://socfpga_agilex7_ghrd.dtsi \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_dev_agf027f1es = " \
					file://socfpga_agilex7_dk_dev_agf027f1es_ghrd.dtsi \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_dev_agm039fes = " \
					file://socfpga_agilex7_ghrd.dtsi \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:stratix10 = " \
					file://socfpga_stratix10_qse_sgmii_ghrd.dtsi \
					file://socfpga_stratix10_qse_sgmii_ghrd_nand.dtsi \
					file://stratix10_pr_fpga_static_region.dts \
					file://stratix10_pr_persona0.dts \
					file://stratix10_pr_persona1.dts \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:stratix10_htile = " \
					file://socfpga_stratix10_qse_sgmii_ghrd.dtsi \
					file://socfpga_stratix10_qse_sgmii_ghrd_nand.dtsi \
					file://stratix10_pr_fpga_static_region.dts \
					file://stratix10_pr_persona0.dts \
					file://stratix10_pr_persona1.dts \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex5_devkit = " \
					file://socfpga_agilex5_ghrd.dtsi \
					file://0001-AIC0-tsn-config.patch_bc \
					file://0001-emmc-debug2-tsn-config.patch_bc \
					"

SRC_URI:append:agilex5_modular = " \
					file://socfpga_agilex5_ghrd.dtsi \
					file://0001-AIC0-tsn-config.patch_bc \
					file://0001-emmc-debug2-tsn-config.patch_bc \
					"

SRC_URI:append:agilex5_mudv_cvr = " \
					file://socfpga_agilex5_ghrd.dtsi \
					file://0001-AIC0-tsn-config.patch_bc \
					file://0001-emmc-debug2-tsn-config.patch_bc \
					"

SRC_URI:append:agilex5_mucv = " \
					file://socfpga_agilex5_ghrd.dtsi \
					file://0001-AIC0-tsn-config.patch_bc \
					file://0001-emmc-debug2-tsn-config.patch_bc \
					"

do_configure[depends] += "virtual/kernel:do_configure"

do_configure:append() {
	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		# Vanilla DTB Generation
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_vanilla.dts
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex.dtsi ${WORKDIR}/socfpga_agilex.dtsi

		# AGILEX7 DK-SI-AGF014EB
		if [[ "${MACHINE}" == "agilex7_dk_si_agf014eb" ]]; then
			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd_sgmii.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
			# NAND
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk_nand.dts ${WORKDIR}/socfpga_agilex7_socdk_nand.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd_sgmii.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk_nand.dts
			# PR
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk_pr.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk_pr.dts
		fi
		# AGILEX7 DK-SI-AGF014EA
		if [[ "${MACHINE}" == "agilex7_dk_si_agf014ea" ]]; then
			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd_sgmii.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
			# NAND
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk_nand.dts ${WORKDIR}/socfpga_agilex7_socdk_nand.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd_sgmii.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk_nand.dts
			# PR
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk_pr.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk_pr.dts
		fi
		# AGILEX7 DK-SI-AGI027F
		if [[ "${MACHINE}" == "agilex7_dk_si_agi027f"* ]]; then
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
		fi
		# AGILEX7 DK-DEV-AGF027F1ES
		if [[ "${MACHINE}" == "agilex7_dk_dev_agf027f1es" ]]; then
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_dk_dev_agf027f1es_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
		fi
		# Agilex7 DK-DEV-AGM039FES
		if [[ "${MACHINE}" == "agilex7_dk_dev_agm039fes" ]]; then
			# Vanilla DTB Generation for Agilex7 DK-DEV-AGM039FES
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex7m_socdk.dts ${WORKDIR}/socfpga_agilex7_vanilla.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/socfpga_agilex_socdk.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex.dtsi ${WORKDIR}/socfpga_agilex.dtsi
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex7m_socdk.dts ${WORKDIR}/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex_socdk.dts\"/a \#include \"socfpga_agilex7_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_agilex7_socdk.dts
		fi
	fi
	
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [[ "${MACHINE}" == "agilex5_modular" ]]; then
			# Vanilla DTB Generation
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/socfpga_agilex5_vanilla.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5.dtsi ${WORKDIR}/socfpga_agilex5.dtsi

			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/socfpga_agilex5_socdk.dts
			sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/socfpga_agilex5_socdk.dts
		else
			# Vanilla DTB Generation
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/socfpga_agilex5_vanilla.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5.dtsi ${WORKDIR}/socfpga_agilex5.dtsi
			#cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_usb_peripheral.dts ${WORKDIR}/socfpga_agilex5_socdk_usb_peripheral.dts

			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/socfpga_agilex5_socdk.dts
			sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/socfpga_agilex5_socdk.dts
			# AIC0
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/socfpga_agilex5_socdk_aic0.dts
			mv ${WORKDIR}/0001-AIC0-tsn-config.patch_bc ${WORKDIR}/0001-AIC0-tsn-config.patch
			patch -p1 ${WORKDIR}/socfpga_agilex5_socdk_aic0.dts ${WORKDIR}/0001-AIC0-tsn-config.patch
			# EMMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/socfpga_agilex5_socdk_emmc.dts
			mv  ${WORKDIR}/0001-emmc-debug2-tsn-config.patch_bc ${WORKDIR}/0001-emmc-debug2-tsn-config.patch
			patch -p1 ${WORKDIR}/socfpga_agilex5_socdk_emmc.dts ${WORKDIR}/0001-emmc-debug2-tsn-config.patch
			# DEBUG2
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/socfpga_agilex5_socdk_debug2.dts
			patch -p1 ${WORKDIR}/socfpga_agilex5_socdk_debug2.dts ${WORKDIR}/0001-emmc-debug2-tsn-config.patch
			# NAND
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_nand.dts ${WORKDIR}/socfpga_agilex5_socdk_nand.dts
			sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/socfpga_agilex5_socdk_nand.dts
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
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_stratix10_socdk.dts
	sed -i '/\#include \"socfpga_stratix10_qse.dtsi\"/d' ${WORKDIR}/socfpga_stratix10_socdk.dts
	# NAND
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk_nand.dts ${WORKDIR}
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd_nand.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_stratix10_socdk_nand.dts
}

do_configure:append:stratix10_htile() {
	# Vanilla DTB Generation
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk.dts ${WORKDIR}/socfpga_stratix10_vanilla.dts
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10.dtsi ${WORKDIR}

	# GSRD DTB Generation
	# MMC, QSPI
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk.dts ${WORKDIR}
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_stratix10_socdk.dts
	sed -i '/\#include \"socfpga_stratix10_qse.dtsi\"/d' ${WORKDIR}/socfpga_stratix10_socdk.dts
	# NAND
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk_nand.dts ${WORKDIR}
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd_nand.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/socfpga_stratix10_socdk_nand.dts
}
