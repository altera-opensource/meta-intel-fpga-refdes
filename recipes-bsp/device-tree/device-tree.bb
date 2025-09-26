SUMMARY = "Altera SoCFPGA Development Kit devicetrees"
DESCRIPTION = "Devicetree addons for Altera SoCFPGA Development Kit examples"
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

COMPATIBLE_MACHINE = "(agilex3|agilex5_dk_a5e065bb32aes1|agilex5_dk_a5e013bm16aea|agilex5_dk_a5e013bb32aes|agilex5_dk_a5e013bb32aes_5s|agilex5_mk_a5e065bb32aes1|agilex7_dk_si_agf014eb|agilex7_dk_si_agi027fc|agilex7_dk_dev_agm039fes|agilex7_dk_dev_agm039ea|agilex7_dk_dev_agf023fa|stratix10_htile)"

SRC_URI:append:agilex7_dk_si_agf014eb = " \
					file://socfpga_agilex7_ghrd.dtsi \
					file://agilex7_pr_fpga_static_region.dts \
					file://agilex7_pr_persona0.dts \
					file://agilex7_pr_persona1.dts \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_si_agi027fc = " \
					file://socfpga_agilex7_ghrd.dtsi \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_dev_agm039fes = " \
					file://socfpga_agilex7_ghrd.dtsi \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_dev_agm039ea = " \
					file://socfpga_agilex7_ghrd.dtsi \
					file://socfpga_ilc.dtsi \
					"

SRC_URI:append:agilex7_dk_dev_agf023fa = " \
					file://socfpga_agilex7_dk_dev_agf_ghrd.dtsi \
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

SRC_URI:append:agilex5_dk_a5e065bb32aes1 = " \
					file://socfpga_agilex5_ghrd.dtsi \
					file://0001-AIC0-tsn-config.patch_bc \
					"

SRC_URI:append:agilex5_dk_a5e013bm16aea = " \
					file://socfpga_agilex5_ghrd.dtsi \
					"

SRC_URI:append:agilex5_dk_a5e013bb32aes = " \
					file://socfpga_agilex5_ghrd.dtsi \
					"

SRC_URI:append:agilex5_dk_a5e013bb32aes_5s = " \
					file://socfpga_agilex5_ghrd.dtsi \
					"

SRC_URI:append:agilex5_mk_a5e065bb32aes1 = " \
					file://socfpga_agilex5_ghrd.dtsi \
					file://0001-AIC0-tsn-config.patch_bc \
					"

SRC_URI:append:agilex3 = " \
					file://socfpga_agilex3_ghrd.dtsi \
					"

do_configure[depends] += "virtual/kernel:do_configure"

do_configure:append() {
	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		# Vanilla DTB Generation
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/sources/socfpga_agilex7_vanilla.dts
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex.dtsi ${WORKDIR}/sources/socfpga_agilex.dtsi

		# AGILEX7 DK-SI-AGF014EB
		if [[ "${MACHINE}" == "agilex7_dk_si_agf014eb" ]]; then
			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/sources/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/sources/socfpga_agilex7_socdk.dts
			# NAND
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk_nand.dts ${WORKDIR}/sources/socfpga_agilex7_socdk_nand.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/sources/socfpga_agilex7_socdk_nand.dts
			# PR
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/sources/socfpga_agilex7_socdk_pr.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/sources/socfpga_agilex7_socdk_pr.dts
		fi
		# AGILEX7 DK-SI-AGI027F
		if [[ "${MACHINE}" == "agilex7_dk_si_agi027f"* ]]; then
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/sources/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/sources/socfpga_agilex7_socdk.dts
		fi
		# AGILEX7 DK-DEV-AGF023FA
		if [[ "${MACHINE}" == "agilex7_dk_dev_agf02"* ]]; then
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/sources/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex.dtsi\"/a \#include \"socfpga_agilex7_dk_dev_agf_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/sources/socfpga_agilex7_socdk.dts
		fi
		# Agilex7 DK-DEV-AGM039
		if [[ "${MACHINE}" == "agilex7_dk_dev_agm039"* ]]; then
			# Vanilla DTB Generation for Agilex7 DK-DEV-AGM039
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex7m_socdk.dts ${WORKDIR}/sources/socfpga_agilex7_vanilla.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex_socdk.dts ${WORKDIR}/sources/socfpga_agilex_socdk.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex.dtsi ${WORKDIR}/sources/socfpga_agilex.dtsi
			# GSRD DTB Generation
			# MMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex7m_socdk.dts ${WORKDIR}/sources/socfpga_agilex7_socdk.dts
			sed -i '/\#include \"socfpga_agilex_socdk.dts\"/a \#include \"socfpga_agilex7_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/sources/socfpga_agilex7_socdk.dts
		fi
	fi
	
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [[ "${MACHINE}" == "agilex5_mk_a5e065bb32aes1" ]]; then
			# Vanilla DTB Generation
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_a0.dts ${WORKDIR}/sources/socfpga_agilex5_socdk.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_modular.dts ${WORKDIR}/sources/socfpga_agilex5_vanilla_modular.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5.dtsi ${WORKDIR}/sources/socfpga_agilex5.dtsi

			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_modular.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_modular.dts
			sed -i '/\#include \"socfpga_agilex5_socdk.dts\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_modular.dts

		elif [[ "${MACHINE}" == "agilex5_dk_a5e013bm16aea" ]]; then
			# Vanilla DTB Generation
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_013b.dts ${WORKDIR}/sources/socfpga_agilex5_vanilla_013b.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5.dtsi ${WORKDIR}/sources/socfpga_agilex5.dtsi

			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_013b.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_013b.dts
			sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_013b.dts
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e013bb32aes"* ]]; then
			# Vanilla DTB Generation
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/sources/socfpga_agilex5_vanilla.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5.dtsi ${WORKDIR}/sources/socfpga_agilex5.dtsi
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_emmc.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_emmc_vanilla.dts

			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/sources/socfpga_agilex5_socdk.dts
			sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk.dts
			# EMMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_emmc.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_emmc.dts
			sed -i '/\#include \"socfpga_agilex5_socdk_nand.dts\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_emmc.dts
			# NAND
			if [ "${IMAGE_TYPE}" == "nand" ]; then
				cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_nand.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_nand_vanilla.dts
				cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_nand.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_nand.dts
				sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_nand.dts
			fi
			# TSN CONFIG2
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_tsn_cfg2.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_tsn_cfg2.dts
			sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_tsn_cfg2.dts
		else
			# Vanilla DTB Generation
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_a0.dts ${WORKDIR}/sources/socfpga_agilex5_vanilla_a0.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5.dtsi ${WORKDIR}/sources/socfpga_agilex5.dtsi
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_emmc.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_emmc_vanilla_a0.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_debug.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_debug_vanilla_a0.dts
			#cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_usb_peripheral.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_usb_peripheral.dts

			# GSRD DTB Generation
			# MMC, QSPI
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_a0.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_a0.dts
			sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_a0.dts
			# AIC0
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_a0.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_aic0_a0.dts
			mv ${WORKDIR}/sources/0001-AIC0-tsn-config.patch_bc ${WORKDIR}/sources/0001-AIC0-tsn-config.patch
			patch -p1 ${WORKDIR}/sources/socfpga_agilex5_socdk_aic0_a0.dts ${WORKDIR}/sources/0001-AIC0-tsn-config.patch
			# EMMC
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_nand.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_nand.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_emmc.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_emmc_a0.dts
			sed -i '/\#include \"socfpga_agilex5_socdk_nand.dts\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_emmc_a0.dts
			# DEBUG2
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk.dts ${WORKDIR}/sources/socfpga_agilex5_socdk.dts
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_debug.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_debug_a0.dts
			sed -i '/\#include \"socfpga_agilex5_socdk.dts\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_debug_a0.dts
			# NAND
			if [ "${IMAGE_TYPE}" == "nand" ]; then
				cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_nand_a0.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_nand_vanilla_a0.dts
				cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_nand_a0.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_nand_a0.dts
				sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_nand_a0.dts
			fi
			# TSN CONFIG2
			cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5_socdk_tsn_cfg2_a0.dts ${WORKDIR}/sources/socfpga_agilex5_socdk_tsn_cfg2_a0.dts
			sed -i '/\#include \"socfpga_agilex5_socdk_a0.dts\"/a \#include \"socfpga_agilex5_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex5_socdk_tsn_cfg2_a0.dts
		fi
	fi

	if [[ "${MACHINE}" == *"agilex3"* ]]; then
		# Vanilla DTB Generation
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex3_socdk.dts ${WORKDIR}/sources/socfpga_agilex3_vanilla.dts
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex5.dtsi ${WORKDIR}/sources/socfpga_agilex5.dtsi

		# GSRD DTB Generation
		# MMC, QSPI
		cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/intel/socfpga_agilex3_socdk.dts ${WORKDIR}/sources/socfpga_agilex3_socdk.dts
		sed -i '/\#include \"socfpga_agilex5.dtsi\"/a \#include \"socfpga_agilex3_ghrd.dtsi\"' ${WORKDIR}/sources/socfpga_agilex3_socdk.dts
	fi
}

do_configure:append:stratix10_htile() {
	# Vanilla DTB Generation
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk.dts ${WORKDIR}/sources/socfpga_stratix10_vanilla.dts
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10.dtsi ${WORKDIR}/sources

	# GSRD DTB Generation
	# MMC, QSPI
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk.dts ${WORKDIR}/sources
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/sources/socfpga_stratix10_socdk.dts
	sed -i '/\#include \"socfpga_stratix10_qse.dtsi\"/d' ${WORKDIR}/sources/socfpga_stratix10_socdk.dts
	# NAND
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk_nand.dts ${WORKDIR}/sources
	sed -i '/\#include \"socfpga_stratix10.dtsi\"/a \#include \"socfpga_stratix10_qse_sgmii_ghrd_nand.dtsi\"\n\#include \"socfpga_ilc.dtsi\"' ${WORKDIR}/sources/socfpga_stratix10_socdk_nand.dts
	# PR
	cp ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/altera/socfpga_stratix10_socdk.dts ${WORKDIR}/sources/socfpga_stratix10_socdk_pr.dts
}
