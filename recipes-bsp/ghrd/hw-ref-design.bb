SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2024.03"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex5_devkit ?= "\
		${GHRD_REPO}/agilex5_devkit_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_devkit_gsrd_core \
		${GHRD_REPO}/agilex5_devkit_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_devkit_nand_core \
		${GHRD_REPO}/agilex5_devkit_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_devkit_emmc_core \
		file://agilex5_devkit_aic0_ghrd.core.rbf \
		file://agilex5_devkit_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex5_modular ?= "\
		${GHRD_REPO}/agilex5_modular_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_modular_gsrd_core \
		"

SRC_URI:agilex5_mudv_cvr ?= "\
		${GHRD_REPO}/agilex5_devkit_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_devkit_gsrd_core \
		${GHRD_REPO}/agilex5_devkit_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_devkit_nand_core \
		${GHRD_REPO}/agilex5_devkit_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_devkit_emmc_core \
		file://agilex5_devkit_aic0_ghrd.core.rbf \
		file://agilex5_devkit_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex5_mucv ?= "\
		${GHRD_REPO}/agilex5_devkit_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_devkit_gsrd_core \
		${GHRD_REPO}/agilex5_devkit_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_devkit_nand_core \
		${GHRD_REPO}/agilex5_devkit_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_devkit_emmc_core \
		file://agilex5_devkit_aic0_ghrd.core.rbf \
		file://agilex5_devkit_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex7_dk_si_agf014ea ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_gsrd_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_nand_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_nand_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_pr_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_persona0.rbf;name=agilex7_dk_si_agf014ea_pr_persona0 \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_persona1.rbf;name=agilex7_dk_si_agf014ea_pr_persona1 \
		"

SRC_URI:agilex7_dk_si_agf014eb ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014eb_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_gsrd_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_nand_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_nand_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_pr_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_pr_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_pr_persona0.rbf;name=agilex7_dk_si_agf014eb_pr_persona0 \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_pr_persona1.rbf;name=agilex7_dk_si_agf014eb_pr_persona1 \
		"

SRC_URI:agilex7_dk_si_agi027fb ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fb_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fb_gsrd_core \
		"

SRC_URI:agilex7_dk_si_agi027fa ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fa_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fa_gsrd_core \
		"

SRC_URI:agilex7_dk_si_agi027fc ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fc_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fc_gsrd_core \
		"

SRC_URI:agilex7_dk_dev_agf027f1es ?= "\
		${GHRD_REPO}/agilex7_dk_dev_agf027f1es_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_dev_agf027f1es_gsrd_core \
		"

SRC_URI:agilex7_dk_dev_agm039fes ?= "\
		${GHRD_REPO}/agilex7_dk_dev_agm039fes_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_dev_agm039fes_gsrd_core \
		"

SRC_URI:stratix10 ?= "\
		${GHRD_REPO}/stratix10_gsrd_${ARM64_GHRD_CORE_RBF};name=stratix10_gsrd_core \
		${GHRD_REPO}/stratix10_nand_${ARM64_GHRD_CORE_RBF};name=stratix10_nand_core \
		${GHRD_REPO}/stratix10_pr_persona0.rbf;name=stratix10_pr_persona0 \
		${GHRD_REPO}/stratix10_pr_persona1.rbf;name=stratix10_pr_persona1 \
		"

SRC_URI:stratix10_htile ?= "\
		${GHRD_REPO}/stratix10_htile_gsrd_${ARM64_GHRD_CORE_RBF};name=stratix10_htile_gsrd_core \
		${GHRD_REPO}/stratix10_htile_nand_${ARM64_GHRD_CORE_RBF};name=stratix10_htile_nand_core \
		${GHRD_REPO}/stratix10_htile_pr_persona0.rbf;name=stratix10_htile_pr_persona0 \
		${GHRD_REPO}/stratix10_htile_pr_persona1.rbf;name=stratix10_htile_pr_persona1 \
		"

SRC_URI:arria10 ?= "\
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_hps.xml;name=arria10_${IMAGE_TYPE}_hps_xml \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF};name=arria10_${IMAGE_TYPE}_core \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF};name=arria10_${IMAGE_TYPE}_periph \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona0.rbf;name=arria10_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona1.rbf;name=arria10_pr_persona1", "", d)} \
		"

SRC_URI:cyclone5 ?= "${GHRD_REPO}/cyclone5_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF};name=cyclone5_${IMAGE_TYPE}_core"

SRC_URI[agilex5_devkit_gsrd_core.sha256sum] = "bf11c8cb3b6d9487f93ce0e055b1e5256998a25b25ac4690bef3fcd6225ee1ae"
SRC_URI[agilex5_devkit_nand_core.sha256sum] = "91735040db8fb39149f91756b0b19b87ed712af2e4723623fd17b527c95f7b82"
SRC_URI[agilex5_devkit_emmc_core.sha256sum] = "2412a7fa89955d8856eb528507822605bb2065117765b9b9dc77dfaff3af1bb6"

#TO DO: UPDATE AGILEX5 MODULAR HASH
SRC_URI[agilex5_modular_gsrd_core.sha256sum] = "bf11c8cb3b6d9487f93ce0e055b1e5256998a25b25ac4690bef3fcd6225ee1ae"

SRC_URI[agilex7_dk_si_agf014ea_gsrd_core.sha256sum] = "a5f012e84ad337527e8a8c28a1650aea484e51887765b8c9f0ab25c497c62827"
SRC_URI[agilex7_dk_si_agf014ea_nand_core.sha256sum] = "1f4d191696c98905551b824dae93980819fbd1d2e9e492711954b00f7366cdf2"
SRC_URI[agilex7_dk_si_agf014ea_pr_core.sha256sum] = "8251f5c9f7e5879545dca74d2dbef3fe5d58661ec83b054bb45ee341c4894c2a"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona0.sha256sum] = "50a0b8c9e0fc91af87d5901fb2b74db15adcbf8a3ee3527f824409c45197e046"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona1.sha256sum] = "654edd0b54b17a5610f1aac01f1a14073f08e849fd44c18ea23e37fe0c6a98be"

#TO DO: UPDATE AGILEX7 DK-SI-AGF014EB HASH
SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "58cfdd9814e832332acbbfddc2fa55268fdb1ac75be38f2e65f809f9402899f0"
SRC_URI[agilex7_dk_si_agf014eb_nand_core.sha256sum] = "1f4d191696c98905551b824dae93980819fbd1d2e9e492711954b00f7366cdf2"
SRC_URI[agilex7_dk_si_agf014eb_pr_core.sha256sum] = "8251f5c9f7e5879545dca74d2dbef3fe5d58661ec83b054bb45ee341c4894c2a"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona0.sha256sum] = "50a0b8c9e0fc91af87d5901fb2b74db15adcbf8a3ee3527f824409c45197e046"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona1.sha256sum] = "654edd0b54b17a5610f1aac01f1a14073f08e849fd44c18ea23e37fe0c6a98be"

SRC_URI[agilex7_dk_si_agi027fb_gsrd_core.sha256sum] = "18d55f3991d6efeec06748267140dee7654c4f5664c0def3ada5fb052ae5cd3c"
SRC_URI[agilex7_dk_si_agi027fa_gsrd_core.sha256sum] = "37548ea13a19f0ef681de00af8aa8f01878fd7a0c93df9bcd15cc5752a389e81"
#TO DO: UPDATE AGILEX7 DK-SI-AGI027FC HASH 
#SRC_URI[agilex7_dk_si_agi027fc_gsrd_core.sha256sum] = "37548ea13a19f0ef681de00af8aa8f01878fd7a0c93df9bcd15cc5752a389e81"
SRC_URI[agilex7_dk_dev_agf027f1es_gsrd_core.sha256sum] = "5484361052460d2b627f2518b0f6a19a8435e9891aaf676adc29def8f3ae9035"

SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "ec26555c759a0de0e1e1d2024ab07208d35f44e0ce32791ebfefcfcf7970054f"

SRC_URI[stratix10_gsrd_core.sha256sum] = "4ec219828c3fc357ffbb3c8dc2ddbead5630dfbf8221c2ea2b7ebd9b3a86cc89"
SRC_URI[stratix10_nand_core.sha256sum] = "f48a1dd9eb88bd672e2ef246b0c7f78ffa5148a7b7b272b9e84274f416e09de3"
SRC_URI[stratix10_pr_persona0.sha256sum] = "a8ac5962e79254ba8a12f6b72a5c2088ca28e60e73292366460f44f99a55d65e"
SRC_URI[stratix10_pr_persona1.sha256sum] = "94cefba1b9de7a4c57eec5c8c0779aa7d65b26352e4b1232c14fea261cd29c73"

#TO DO: UPDATE STRATIX10 H-TILE HASH
SRC_URI[stratix10_htile_gsrd_core.sha256sum] = "4ec219828c3fc357ffbb3c8dc2ddbead5630dfbf8221c2ea2b7ebd9b3a86cc89"
SRC_URI[stratix10_htile_nand_core.sha256sum] = "f48a1dd9eb88bd672e2ef246b0c7f78ffa5148a7b7b272b9e84274f416e09de3"
SRC_URI[stratix10_htile_pr_persona0.sha256sum] = "a8ac5962e79254ba8a12f6b72a5c2088ca28e60e73292366460f44f99a55d65e"
SRC_URI[stratix10_htile_pr_persona1.sha256sum] = "94cefba1b9de7a4c57eec5c8c0779aa7d65b26352e4b1232c14fea261cd29c73"

SRC_URI[arria10_gsrd_core.sha256sum] = "81c827cca0eb491e631a291f3ab4df6e36979b32c25f063cbb92c30c701034a2"
SRC_URI[arria10_gsrd_periph.sha256sum] = "91dd91750599221c715b6de9b81bd3abe8e75d6f709b408110573e7ea27f67fb"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "94fdadb172513e3f5fe7cd3c2f5dc73a4e99b015e8a8a921e8c89a854fc159c7"
SRC_URI[arria10_nand_core.sha256sum] = "cb18792661a02042be84b15a05dcb5f6ca9c2c16edc3402c7e92248c0ad4ca71"
SRC_URI[arria10_nand_periph.sha256sum] = "275e33bb8e8cec6d6f78c6fc2b1da4a8164f34dc9bf741069fd708618fda8cc7"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "d6d02478734bf36ca431f1afea1c6330f6d2ae6d942af69bf20e0af0b697fd41"
SRC_URI[arria10_pcie_core.sha256sum] = "d32ae72a76f9010108ec526719425ce0a46faa73f9b5da22639005c900706888"
SRC_URI[arria10_pcie_periph.sha256sum] = "6659c703c3b336af0ca02705c55171ada2d379d492d425bead62c3832d1c06a0"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "816656de3e35ccaca16d98ee81e79ad3c547be6ff47f05523303050c1549989b"
SRC_URI[arria10_pr_core.sha256sum] = "7af702ed8e0a123bb34cb8e693cdb74dc25a197cbfe305f4a9ead18cb3b54196"
SRC_URI[arria10_pr_periph.sha256sum] = "d2dffe3924d0a1119de0e1c2465f05eb6d9842ced90c148717b41a7a7016965f"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "9ffa62ee11abff040546e94ec524b50b4c4da78ba5e569f51278caf1f4c8aa74"
SRC_URI[arria10_pr_persona0.sha256sum] = "8e7231df407205fe97e0a224443969fb40ddea68d0d2e0483bb6ccd91ae99156"
SRC_URI[arria10_pr_persona1.sha256sum] = "64d6ceda0dd011431d336004e6c18d698af947fe4c170850b825a44e209fea71"
SRC_URI[arria10_qspi_core.sha256sum] = "19d8196740bf732a76221e9c98bd36c3ab910dd266deffeaa20bbd5f0be9ccd9"
SRC_URI[arria10_qspi_periph.sha256sum] = "5ee703758faf6e0d6c426c07621e86724b54d2736fe52e5add43a6106576ca4c"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "338b78f3cddcbbed0f7be1044c830fdf3d678073e2cca8eff50ec648d8156286"
SRC_URI[arria10_sgmii_core.sha256sum] = "9bf5c32cd428f26f7b43cd33b3663f78e97f363daf52db84255ca31604c9208d"
SRC_URI[arria10_sgmii_periph.sha256sum] = "b3d440de34949e4374329752cd812f8cf23e6fbca2b0197280f89fa85743f07e"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "2552894eb32a450394436de51f3e875562a3e5b0aaa7c7cad4ec5f0e52263602"
SRC_URI[arria10_tse_core.sha256sum] = "ba2334fef0258a76edecc64bdf65a7f9a3fa9a52f24be8f96c83ec1246c79f16"
SRC_URI[arria10_tse_periph.sha256sum] = "3a9b0a12979f3a2350c3b8650a62232ee23cb6484d2c4b639cbcc96aa1271a02"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "1390177e3f9784f043a15d49d908ad15469f323504f694fd6b1b6dd12ce4a8dc"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "0498c9c97e48e2e6de97410b998d6f9d751c630e233071234b146d2ee399f268"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES:${PN} = " \
		/boot \
		/usr/lib/firmware \
		"

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install () {
	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		if [[ "${MACHINE}" == *"agilex7_dk_si_agf014e"* ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
		else
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${D}/boot/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi
	
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [[ "${MACHINE}" == "agilex5_modular" ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		else
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
		fi
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [[ "${MACHINE}" == "agilex5_modular" ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
		else
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/aic0.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_devkit_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/debug2.core.rbf
		fi
	fi

	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		if [[ "${MACHINE}" == *"agilex7_dk_si_agf014e"* ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
		else
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_hps.xml ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/hps.xml
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_PERIPH_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi
}

addtask install after do_configure before do_deploy
addtask deploy after do_install
