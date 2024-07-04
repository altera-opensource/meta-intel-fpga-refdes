SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2024.07"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex5_dk_a5e065bb32aes1 ?= "\
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_emmc_core \
		file://agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf \
		file://agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex5_dk_a5e013bb32aesi0 ?= "\
		${GHRD_REPO}/agilex5_dk_a5e013bb32aesi0_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aesi0_gsrd_core \
		"

SRC_URI:agilex5_modular ?= "\
		${GHRD_REPO}/agilex5_modular_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_modular_gsrd_core \
		"

SRC_URI:agilex5_mudv_cvr ?= "\
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_emmc_core \
		file://agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf \
		file://agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex5_mucv ?= "\
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_emmc_core \
		file://agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf \
		file://agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf \
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

SRC_URI[agilex5_dk_a5e065bb32aes1_gsrd_core.sha256sum] = "5384f9d54420ee39051b4b1e97573d2e34428c959f070da72fd1976b049a8669"
SRC_URI[agilex5_dk_a5e065bb32aes1_nand_core.sha256sum] = "122051fa11d48aea566aab7f1bed460000d7c058f945bf8cba47766c684058d0"
SRC_URI[agilex5_dk_a5e065bb32aes1_emmc_core.sha256sum] = "ffaf6722d7eaccb93e4e51e1f5c3c61808c4fe4731bf71c0f674c2a6ba83a98c"

SRC_URI[agilex5_dk_a5e013bb32aesi0_gsrd_core.sha256sum] = "58d9a103e56bbd50d4f84f5234daea48e132bdc6a230b1d3fd6dc86087042c30"

SRC_URI[agilex5_modular_gsrd_core.sha256sum] = "2d1d056b976d57999b1bf372431b84cdc29fed304c68f9cb1dd799df328c86b4"

SRC_URI[agilex7_dk_si_agf014ea_gsrd_core.sha256sum] = "e051bf778cab3fde7ad4eb75775f16dc68917b713514aff0ea2cff698dfe05cf"
SRC_URI[agilex7_dk_si_agf014ea_nand_core.sha256sum] = "45b732f2feef9f9f57ece5132e89c2862776db6b494eda6d999b7c2cde3290c9"
SRC_URI[agilex7_dk_si_agf014ea_pr_core.sha256sum] = "2660167a34d946d8598c90197166df32ed608508849a00b88221a81b8d88ec84"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona0.sha256sum] = "7c5a38d539a342ec18d1c508d497e63a857e9ed1cfab7212b418982dd36c500d"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona1.sha256sum] = "6dc422e6790ef68ba3fa24c27f7d50853582fe174f43e5910b20fa147f486a40"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "1ce3db660f3e42338925844f393de2f9744703cb1e4a0a46bdb18249a2eae951"
SRC_URI[agilex7_dk_si_agf014eb_nand_core.sha256sum] = "f1d30e14a648a08e931e0a2f56a30dc719cbae87c0c0f55b3aceef3fcec3745a"
SRC_URI[agilex7_dk_si_agf014eb_pr_core.sha256sum] = "4f205229fbd6b12a87a3817df772e0c5f47ac84a0c770976a65d5dc8c6186b96"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona0.sha256sum] = "efa47f670397763fea88aae91da3d5842953b554aaf0d2cf3d693ff37dd425d3"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona1.sha256sum] = "eadd694522785a83f75ffa78c97ec8c79c9946c42dae2c8e1331ab4916d9381f"

SRC_URI[agilex7_dk_si_agi027fb_gsrd_core.sha256sum] = "5c78157442c9ad5465befa584e9b43bae8a72d259626744781fe395989c3d910"
SRC_URI[agilex7_dk_si_agi027fa_gsrd_core.sha256sum] = "1434701f446eee5ba01fd18e0cffeb79decf68aad6dedbbb0000b41f90927c35"
SRC_URI[agilex7_dk_si_agi027fc_gsrd_core.sha256sum] = "e8f53c21ea23cf4d034ea71c1534174088961f507aeeecde9626a99b7cff4513"
SRC_URI[agilex7_dk_dev_agf027f1es_gsrd_core.sha256sum] = "d2456d4f1d5a43697d957022e8e08112d9d7ccddafd660d7c7c8c78c9d377671"

SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "3e41f853e3a486e165566e73ba6e2938d589edb4bf57d066968938188a6a439d"

SRC_URI[stratix10_gsrd_core.sha256sum] = "98a6bde47058c8d736f1161f0e759023b62cc7caaf8f3f7247624df73ec879db"
SRC_URI[stratix10_nand_core.sha256sum] = "a1d554cdb2925e62f76b811e235050603a674e2c94aedc5c1332afaa546ed8d8"
SRC_URI[stratix10_pr_persona0.sha256sum] = "dd5554e3466defd292a53e36c99a5fb3c52cc55d0b74870414d0f9b866c04caf"
SRC_URI[stratix10_pr_persona1.sha256sum] = "408bb6fb70eccc3b3772af78c8e63d3dab300bdce46741acf43b0e92805bface"

SRC_URI[stratix10_htile_gsrd_core.sha256sum] = "27b4423df913193ec8bb9c1e4784ba30c163d3d5b2f17daf1233e1220d918ff8"
SRC_URI[stratix10_htile_nand_core.sha256sum] = "8d09ba84000c7171fd2ebef1516004bdb9c97282ef991e8da6b77b4e836a17ea"
SRC_URI[stratix10_htile_pr_persona0.sha256sum] = "d2bf594dbdaab43bc64361d5adf3670a6ac5c1e803f6acd6a79234214dabeb3e"
SRC_URI[stratix10_htile_pr_persona1.sha256sum] = "ddba5bd23045667a1013c8a73bf60a7ce8ceed99950f1a3fb27e5a78ece0b89a"

SRC_URI[arria10_gsrd_core.sha256sum] = "0313a410f4c17c5c5c462d78f7a24ef3b743c9de987a061a16696d7273521994"
SRC_URI[arria10_gsrd_periph.sha256sum] = "f3177179d3d12b7d974b1608655b61411f6586f758de1a0eca72c627f2e90e97"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "9a3189ae6088a442a384bf803dbc330ed1329808dea4466de112187d9e4f2e20"
SRC_URI[arria10_nand_core.sha256sum] = "ba7e6845e8f371f03bf9f219ebb978b9b3b8800a7151d666b0d96927c6fc9256"
SRC_URI[arria10_nand_periph.sha256sum] = "cfeb88323cf2c9d061601a56a49a955f4536f6e889f14bfc7e9c0fc1e1c24041"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "29e057e8e11ae3998d8ae7bab649175991daed9fbf979c0793885a0b6d57193f"
SRC_URI[arria10_pcie_core.sha256sum] = "27d16e30881c03cf78c4114fac754b2f9336a4486d59f5c8027109a57c0e1461"
SRC_URI[arria10_pcie_periph.sha256sum] = "0cc643b0fdf258974c31c037c684ae7cb4ce38ee5a6e0a8d45fe359cc4965213"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "a396d1c3b1d657540cdea6e6d5787f51d2a5e4c1c08c926900c48e2c9b24f093"
SRC_URI[arria10_pr_core.sha256sum] = "d2135fbc95fb9755610bee925f7eb23239856057136f5cdd02f638a9331a2d97"
SRC_URI[arria10_pr_periph.sha256sum] = "1e2a6bf84cf578a6edda067e934131dcf768376450c3be40a9fd563cdc992fd9"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "22e5f5faa0d29fc5e34d276c3743ccea39e274ed7b254f6fae0e6361b7a7d456"
SRC_URI[arria10_pr_persona0.sha256sum] = "1ac5e47184349ed5d5638fb8802e739af32c866906ddd6ac3d70b70b280982d7"
SRC_URI[arria10_pr_persona1.sha256sum] = "c71498f899cfc58012ed93b48e52f4d7f8554795344563e31becb85d5209d4aa"
SRC_URI[arria10_qspi_core.sha256sum] = "17c0fbf6fe6cb5aac4724d4800a638ff5990d773b44f13b715c066827cf1ad88"
SRC_URI[arria10_qspi_periph.sha256sum] = "8458bda18a11be96b85dfeead30a0dde3829d3959d96641297067108232239d8"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "ddfe03ad06a8c4921353bc958df58673926f6d1ed4af20e57cffce95d57d64ea"
SRC_URI[arria10_sgmii_core.sha256sum] = "bd55cbf251710094cdf682ea968c05c9613a40f46b9d83643eb20163770110d0"
SRC_URI[arria10_sgmii_periph.sha256sum] = "5675159fa4c51762fed9b8ab3f191748cd0ed54d7d3580b40fb6366e47ab673e"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "f36f371af2cf68104e52d5b947f443ddd89c0349e925a65f6879919380cdd543"
SRC_URI[arria10_tse_core.sha256sum] = "c43fb7cf8f2761454816d5f04c72e711d4f64b524dc4bc420e2471283f724064"
SRC_URI[arria10_tse_periph.sha256sum] = "5a6cd370f56dd4ae38e65fe47e5ddd1ebad66b4755c38171997f90b1d66bd3c4"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "c25b14f81dd5dc17eef6701344de81aa06736cdf7722a63427a7a178c1f23712"

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
		if [[ "${MACHINE}" == "agilex5_modular" || "${MACHINE}" == "agilex5_dk_a5e013bb32aesi0" ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		else
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
		fi
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [[ "${MACHINE}" == "agilex5_modular" || "${MACHINE}" == "agilex5_dk_a5e013bb32aesi0" ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
		else
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/aic0.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/debug2.core.rbf
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
