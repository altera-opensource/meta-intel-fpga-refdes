SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2023.11"
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
		"

SRC_URI:agilex7_dk_si_agi027fb ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fb_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fb_gsrd_core \
		"

SRC_URI:agilex7_dk_si_agi027fa ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fa_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fa_gsrd_core \
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

SRC_URI:arria10 ?= "\
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_hps.xml;name=arria10_${IMAGE_TYPE}_hps_xml \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF};name=arria10_${IMAGE_TYPE}_core \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF};name=arria10_${IMAGE_TYPE}_periph \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona0.rbf;name=arria10_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona1.rbf;name=arria10_pr_persona1", "", d)} \
		"

SRC_URI:cyclone5 ?= "${GHRD_REPO}/cyclone5_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF};name=cyclone5_${IMAGE_TYPE}_core"

SRC_URI[agilex5_devkit_gsrd_core.sha256sum] = "f0f1a01e843786f81879b6e864861b2f3816a55edee24db3403dbba4a396de61"
SRC_URI[agilex5_devkit_nand_core.sha256sum] = "f0f1a01e843786f81879b6e864861b2f3816a55edee24db3403dbba4a396de61"
SRC_URI[agilex5_devkit_emmc_core.sha256sum] = "f0f1a01e843786f81879b6e864861b2f3816a55edee24db3403dbba4a396de61"

SRC_URI[agilex7_dk_si_agf014ea_gsrd_core.sha256sum] = "f0f1a01e843786f81879b6e864861b2f3816a55edee24db3403dbba4a396de61"
SRC_URI[agilex7_dk_si_agf014ea_nand_core.sha256sum] = "64a9229927d642ad6a16550e386d578a5e4d843b561d2d7f7f0e4fd6c8001c37"
SRC_URI[agilex7_dk_si_agf014ea_pr_core.sha256sum] = "7b77f3ed882874db048b8f573eef1b12555cbf45e701f5cbde90b2affac54b67"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona0.sha256sum] = "083fda088148b9c410be3e28fef8db1b3f25c2378740030c9a1edc9e1ed46e7e"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona1.sha256sum] = "18d68271dc224ade9bb60c78c2e044d3b3ed68dee8f491aa5372bb2a4c68cfe8"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "287d385b878282ebb1bf13d585cc7dcc0ffa61de8c1b52a3c16328e241965d55"

SRC_URI[agilex7_dk_si_agi027fb_gsrd_core.sha256sum] = "78a6bf4220ad167fbdeda52bb417c5df563d2efba49d4c0629bff572be70bfad"
SRC_URI[agilex7_dk_si_agi027fa_gsrd_core.sha256sum] = "8cde675e1f02293ae0dd8bedc76466b762eb6f3665f133238185a6f02332307b"
SRC_URI[agilex7_dk_dev_agf027f1es_gsrd_core.sha256sum] = "fe9a888ffe3df58ada5eb068761a25250f9751a1f77e780500a500a4b5dc7e9e"

SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "ae994d3a51510a6cc5f6f22391226f6b76f94ffddf95408130d011faeffe4c73"

SRC_URI[stratix10_gsrd_core.sha256sum] = "b83db9e1cd2d328a9279a3dee04ac09faa616e7303a8969a61bc38c8cdaa5f50"
SRC_URI[stratix10_nand_core.sha256sum] = "e503e16e25fdba43689ce45d2ffd018fadf28de9f36c6f61297fc9a3bc08a67b"
SRC_URI[stratix10_pr_persona0.sha256sum] = "abffb5ee92a5c89b376b3a60e665e4602c4de9f3e89a1f3ad1b2f5b1b4bdef2d"
SRC_URI[stratix10_pr_persona1.sha256sum] = "35a7e9f783ef2ac7308ad19365b6eff714b2c55ae9c4321b18282688b6062b2d"

SRC_URI[arria10_gsrd_core.sha256sum] = "45815c409f01f9781af538efe3958dbba1c0882be30f577ce8ffaef50dd26b04"
SRC_URI[arria10_gsrd_periph.sha256sum] = "12deae04d48ed64b7d4bc42ef3671c56fbb3555a4b58693697cebe9961338b5e"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "c37828b42fbd88547773fdea04616d9caba5955a37516536711e4b6adf6e1dda"
SRC_URI[arria10_nand_core.sha256sum] = "821e8e977805e49aa67fb5cd754b634e516ebaffece06d31340bb318a88eafdf"
SRC_URI[arria10_nand_periph.sha256sum] = "02bce68dea51494e318e165d37e657976de4868a1e427b7256ca4392f540c454"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "cdcff9a8e879cbb3741a0ba61bce3e746aa11104ebf71e15ef3d4a59ac9a160a"
SRC_URI[arria10_pcie_core.sha256sum] = "adbaefe29a23fa38475e609f55e38bd5c26aea8117b68a99c8ad626ba36bd66d"
SRC_URI[arria10_pcie_periph.sha256sum] = "e69537dbbce79b01e77c6ff62b3afc16a0ead4112229daeb2cc6e3dceabfa242"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "df586057f2d4d5eb38fedafe786ea465ac68de18823e0e6f5b772ec1e5352056"
SRC_URI[arria10_pr_core.sha256sum] = "89a56fdf6828b14839ed6a32cb7c164db8731ff95ca3e6b7643eda2f54932c15"
SRC_URI[arria10_pr_periph.sha256sum] = "30764e97a81546ee46437f682438d86664db7bc5fbc6b389f1b5b909e15b4042"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "836a22e68379b949076a793358b96f96f783a6bbdebdf9415fa26af3cfc1ba58"
SRC_URI[arria10_pr_persona0.sha256sum] = "13465d90b6490205cddd2e575ca6f5db6f76f2832908f93c116b3639b3d25b07"
SRC_URI[arria10_pr_persona1.sha256sum] = "6f31e0256237eeb22538b3d8467e6c77ab8f1e5f4c1af9cc854efed4440bd092"
SRC_URI[arria10_qspi_core.sha256sum] = "6dda6b18033e9a529315e56e802266256a855396779ce5e2a446f3e94eeb1251"
SRC_URI[arria10_qspi_periph.sha256sum] = "7b8abad680f59bb019b85aefac58d791fe5d5c1bb8149899dde2946bdb1136c6"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "6a567c91f00b785fa2afaf7a98b14a92b8a2dfeb9a3b149a1bc953b34e806b0d"
SRC_URI[arria10_sgmii_core.sha256sum] = "ea11661edeba46daa84e77c6ad0636c1dbefe408c60eab4356b9591ed5801a3d"
SRC_URI[arria10_sgmii_periph.sha256sum] = "f7ff142bdbb433832c62026e37c3e9bd81ed20f088cbd93a4eee4704c9a2a93a"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "29d75abb9b4b59eea95dd0ea0ed05ce7a5c382b9143a68f2464f0bfc864a3b37"
SRC_URI[arria10_tse_core.sha256sum] = "8cd30622d8a441731dd1c1bb879847e5a1357e03640af533ab16a4542542d033"
SRC_URI[arria10_tse_periph.sha256sum] = "937c8d74ee69046c978f3111cf5e9c07953e790883c3c067704e74508de9fb76"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "e61193d7b0a919fb8ab51d15edc98c3da78313e0030b4df716ed2ae8ce558750"

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
    #TODO
    if [[ "${MACHINE}" == "agilex7_dk_si_agf014eb" ]]; then 
		   install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
    else
		   install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	  fi

		if [[ "${MACHINE}" == "agilex7_dk_si_agf014ea" ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)}; then
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
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/aic0.core.rbf
		install -D -m 0644 ${WORKDIR}/agilex5_devkit_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/debug2.core.rbf
	fi

	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		#TODO
    if [[ "${MACHINE}" == "agilex7_dk_si_agf014eb" ]]; then 
		   install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
    else
		   install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
	  fi

		if [[ "${MACHINE}" == "agilex7_dk_si_agf014ea" ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)}; then
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