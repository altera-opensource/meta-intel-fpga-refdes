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

SRC_URI[agilex5_dk_a5e065bb32aes1_gsrd_core.sha256sum] = "fc63ccd08becada13319e41aed447d0637f0cc76d76e048d0d76be516b83ee9e"
SRC_URI[agilex5_dk_a5e065bb32aes1_nand_core.sha256sum] = "4a33d0377d84f5ce05066fde57982253b2bef972b5565cb31a381b9b631b8c9a"
SRC_URI[agilex5_dk_a5e065bb32aes1_emmc_core.sha256sum] = "ebee65fd00ee72e207631d12c3a111649c0e7950b44545641e4ce1b040a2c4fe"

SRC_URI[agilex5_dk_a5e013bb32aesi0_gsrd_core.sha256sum] = "bc23b8e9d30afe9e9ab6af27707b5241d01999b61a95aeb68393ce801cd2426b"

SRC_URI[agilex5_modular_gsrd_core.sha256sum] = "7b2eea7016d61937a699534d4ec82e689a933be607f83cd0e6cd55da3b340cd5"

SRC_URI[agilex7_dk_si_agf014ea_gsrd_core.sha256sum] = "239d85d5e8ef06cf41639b9dec8565420032f61b836de9bc66aa7f1f290b574a"
SRC_URI[agilex7_dk_si_agf014ea_nand_core.sha256sum] = "df7563a472b61de54a00741840ac3be8475fbca02b7bff92016e07c8c326cd64"
SRC_URI[agilex7_dk_si_agf014ea_pr_core.sha256sum] = "6411660a2dee8a56f6fc6a2d8630359af5d8daf80b1fc34928f90ba70cbe993c"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona0.sha256sum] = "85b4e83e32857f3cc9d8093553554a4864d05f515a1ccb3afb3661f4f28c9f66"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona1.sha256sum] = "813a15bab0e099f01b6b7a2de0304ece9043cf00b1e80ad95f3bcd20e3fea2a9"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "48b4473c675393cbc629d5bce3c18f1628d10b2c872ec33b18e1726e5abac57b"
SRC_URI[agilex7_dk_si_agf014eb_nand_core.sha256sum] = "52726e7d413a3af5dc451c44ae08283c50997b3d7bc2d5702fc83a83a8c51014"
SRC_URI[agilex7_dk_si_agf014eb_pr_core.sha256sum] = "61baf07b059e62a6d7637b31c41ffcf72decc011682ba8b11d94df6f22a0b6c8"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona0.sha256sum] = "6dcf5f78e25437f71ba136f716432b187b694a7cfb4ca8e5055cc2df60bdab8d"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona1.sha256sum] = "19daf0bc7a702c4532a90aab4ca1d3f08cd7c5ba25cea8c120379a60fb258caf"

SRC_URI[agilex7_dk_si_agi027fb_gsrd_core.sha256sum] = "004a1eb3a2bd1c81faf648bf086152cf31c43b7577bc5168d82bf7bfc22f2d5b"
SRC_URI[agilex7_dk_si_agi027fa_gsrd_core.sha256sum] = "a80eb33a4e30d19e50ef3f481a89b7c76b7705e35b032960929fea7129eeb87b"
SRC_URI[agilex7_dk_si_agi027fc_gsrd_core.sha256sum] = "145093ebd3867ac1ef0140d2808384e0660184e4a6d94144441e96402f47c088"
SRC_URI[agilex7_dk_dev_agf027f1es_gsrd_core.sha256sum] = "55b39b3f36187ef8eb9a868a02ab1d0a21a85f3a7ee4523e80c9d7af1c790643"

SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "644a409e472ef40a440640056780c446504c02b04ebcb652e92fd1cb0eea18c7"

SRC_URI[stratix10_gsrd_core.sha256sum] = "c3cb00c06e393efac87044c3e3e389249a04396152e5ba9470267852061274a6"
SRC_URI[stratix10_nand_core.sha256sum] = "2e992c01234ac948451719dbcf8d6c92a08119c9b81cab75ae0eeb4e41bdc2b1"
SRC_URI[stratix10_pr_persona0.sha256sum] = "0b376019dcc4ad2912f47a1dca6be9a0782e82f5ad8085d41ee653a8062a58c9"
SRC_URI[stratix10_pr_persona1.sha256sum] = "cd081be04ed6c1e566377c3163ef38d7ac402a46c5e458f8861a3dcb9da55300"

SRC_URI[stratix10_htile_gsrd_core.sha256sum] = "22e48d1692f34014022d1f4d5d8770b358ea523f93e705a1c138bfc2b1f02d4c"
SRC_URI[stratix10_htile_nand_core.sha256sum] = "71cf95f8654b33fdb73b21e454169ba58926758a4a933a0f8c0f770f2e5e74ef"
SRC_URI[stratix10_htile_pr_persona0.sha256sum] = "ab84ff151f1ccc60aa34f7cc25384fff51a9cbf7df964580de298a149cc5ff05"
SRC_URI[stratix10_htile_pr_persona1.sha256sum] = "c44abf17c4599b109fcb6ab59db06a2edc0bb49d53ae51044a618888d4fadc4a"

SRC_URI[arria10_gsrd_core.sha256sum] = "a79ec08f7d3be05824e8e24968cfea19cb29392270e3197b9e07c8890a4b4ace"
SRC_URI[arria10_gsrd_periph.sha256sum] = "768529365dd19d9d7d6064c2d109c9a972c8435844fd1568845bc94178e82408"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "5e9033edbdb2615e04274300b28a0b18caebde1bcc5e12931852e21e6752421b"
SRC_URI[arria10_nand_core.sha256sum] = "8e922f3f7434657cd804b95d257864fccd24c3f3fb6b2387a2959f9abd6456d4"
SRC_URI[arria10_nand_periph.sha256sum] = "45a6ddab8bf4cdcaa314bf928e853cdbaf50cef3b4f6f721bd080391f9a341e3"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "a5f8d61dc6ba4d29ef5f7f0bdeadcc01cc380cfc367f46e76577f8cb14bb5947"
SRC_URI[arria10_pcie_core.sha256sum] = "69841ecd6490fba9de60c333df83095ffb16ffee96d4a0592d92c90ea9939a00"
SRC_URI[arria10_pcie_periph.sha256sum] = "92218fc6c7d2f6c6f38bcd93ee0d300f05cb0c50d79caf49fc191a890578b213"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "99a014f75a14697e4c4dbe496bb30236915fd9355f468f60c7fa5d4bb922a5aa"
SRC_URI[arria10_pr_core.sha256sum] = "5bde42f448ec3ea34ae154e3ef25529fbad80741d2ad62cb59ed508c8c6d7e33"
SRC_URI[arria10_pr_periph.sha256sum] = "0b9557dfedec0e9b220f4e3b8cc6f51106ef93fc32d009b3a9a546c7fb4aae79"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "6895beff1e8146eaaee6c052c929be06c21337991baf2b8cc971639fbf8f5b4f"
SRC_URI[arria10_pr_persona0.sha256sum] = "0f8e55f03f7f99dafc7bd9fb61b670e2fa60b968dee9c3487e75d4108f45f3f3"
SRC_URI[arria10_pr_persona1.sha256sum] = "fcc6ef2c685bc53d864b6865c12dd405d5ee8a87a4cb39b9f48fa419bda3e1a7"
SRC_URI[arria10_qspi_core.sha256sum] = "858020e916e3cd8ed7c2b62ee505618632ac48e7f7b956826ca937819d35c77e"
SRC_URI[arria10_qspi_periph.sha256sum] = "42c8298bc13df8dfed0d53e0b29a51e5e4f51baec13a5dd4f7c37ec44ba954e7"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "43589b24ec63d09bc8cac36bd2611c6e2e75b1aecfd30a61b664baf3848a9bd3"
SRC_URI[arria10_sgmii_core.sha256sum] = "cebc08be4b655145d426d8084f6b7ed17aa3b959b6df7de84474776e208572ae"
SRC_URI[arria10_sgmii_periph.sha256sum] = "9340bc35bcadeef861cab49866b380cfd492492cfc14376c124835f1c72fe699"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "ffda8528e842f5a5a978090d67169f2fdfca5b305fe31e7ccd3d78e5ab54aebe"
SRC_URI[arria10_tse_core.sha256sum] = "8a06799321bd12c50d4af7764d59591642095e0c1c5867a5a7d93058a3d4fbc9"
SRC_URI[arria10_tse_periph.sha256sum] = "3c9a7177d9a8a816d55352614818c2d06aa05089685052ce845d7357b35909de"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "7a4a6bc5f3e9d61db559e052d461b6eccf2b1539ebb535b11273596169abf399"

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
