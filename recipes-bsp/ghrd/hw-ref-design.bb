SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2022.10"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex ?= "\
		${GHRD_REPO}/agilex_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex_gsrd_core \
		${GHRD_REPO}/agilex_nand_${ARM64_GHRD_CORE_RBF};name=agilex_nand_core \
		${GHRD_REPO}/agilex_pr_${ARM64_GHRD_CORE_RBF};name=agilex_pr_core \
		${GHRD_REPO}/agilex_pr_persona0.rbf;name=agilex_pr_persona0 \
		${GHRD_REPO}/agilex_pr_persona1.rbf;name=agilex_pr_persona1 \
		"

SRC_URI:agilex_fm87 ?= "\
		${GHRD_REPO}/agilex_fm87_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex_fm87_gsrd_core \
		"

SRC_URI:agilex_fm86 ?= "\
		${GHRD_REPO}/agilex_fm86_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex_fm86_gsrd_core \
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

SRC_URI[agilex_gsrd_core.sha256sum] = "492e8d6395a63297966de33c82e03079b044fde4e023951527eb97e11532329c"
SRC_URI[agilex_nand_core.sha256sum] = "4946ad0c5f0f84f25c69840d557160806ff5692f30e1c36e5fca9bc6a9a678ba"
SRC_URI[agilex_pr_core.sha256sum] = "1079e6a8d5dcffc2cd393d1e2d6a7bbe9e247f207b26eebfa81e63a7222a8c93"
SRC_URI[agilex_pr_persona0.sha256sum] = "f7c2d3f2a81128c9d01c9b768daec3dea9b3c63d1558106e75de1a7f862c2ac9"
SRC_URI[agilex_pr_persona1.sha256sum] = "5098d667a5b08bbf6a7541d2b2ed669ea3fc535f1b699989a866c536e55a8951"

SRC_URI[agilex_fm87_gsrd_core.sha256sum] = "492e8d6395a63297966de33c82e03079b044fde4e023951527eb97e11532329c"
SRC_URI[agilex_fm86_gsrd_core.sha256sum] = "492e8d6395a63297966de33c82e03079b044fde4e023951527eb97e11532329c"

SRC_URI[stratix10_gsrd_core.sha256sum] = "35eeb11af3e77c74585a9b17377e4fed13b5dce5e3c619828032063e8927ca88"
SRC_URI[stratix10_nand_core.sha256sum] = "8bdc602e830eba8a72eb09f491f0184e0f34985f1a889d595f576224e9ed35d4"
SRC_URI[stratix10_pr_persona0.sha256sum] = "eb5342af152508332d8b55c003831308db89557ae5ecd4bd63aad41645fcae5e"
SRC_URI[stratix10_pr_persona1.sha256sum] = "9ed4a266ecd1218651a3f85e0f86debd422a014a1a8d5fbb966e49c8fc5e8435"

SRC_URI[arria10_gsrd_core.sha256sum] = "df604331de37c8153bcbff1b1b26a207c27269350f13829b023807491bd6b82d"
SRC_URI[arria10_gsrd_periph.sha256sum] = "18efa62bba4aba959d141a8f322bb2fca085bbfc398a1a0668c1c3980c0d37c0"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "8b20fb9736b30e47a40d2a2da862b81f9c591301f70ac866a5949bde77d93292"
SRC_URI[arria10_nand_core.sha256sum] = "2e5eed7df9ec8a5fe652d55b61e11075fad118591c1b19d5428f07ff338edf99"
SRC_URI[arria10_nand_periph.sha256sum] = "8e1a66270c43a1bbc38f54d6a8c692aa3ee6f51a068c286a0e1f68ce4bedf183"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "d674b2e2683bd22cf0f93bd818f38f01dca403aea14c7aef675b6290823a4ee2"
SRC_URI[arria10_pcie_core.sha256sum] = "f28d095e42b74b3aaa9dc9f0bcd3989ef7ca89c71c803b3636b57780a5fa635f"
SRC_URI[arria10_pcie_periph.sha256sum] = "49b3cd5d21af5c546cfcf4aaeb19a0e7e9233a394404b0eb9550331f796e1f0c"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "ae5b011a9daee3b434a0ed780310ee4e67fcdf7948a0caaf680ac98afd0bc450"
SRC_URI[arria10_pr_core.sha256sum] = "34ce7bc61ad55f5ce1c5a987d589fd8de8bca70af0b74eed498fa103b70158ea"
SRC_URI[arria10_pr_periph.sha256sum] = "d5f58d877fdaf919f9d3a96f5562b063e5b9473361c6ecb9f1104a17db5a044a"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "7813f55dde9524b1ef22787d2c0560ee6261f9616c71868de2dc3f444431c8fd"
SRC_URI[arria10_pr_persona0.sha256sum] = "b3f4563cd01f1623ac044e605a53fa0536e0f8f42c2d28d1dc2d94d23ec968a6"
SRC_URI[arria10_pr_persona1.sha256sum] = "37be1c772f3ecf407a2c55836a8ea21bfb74b4a9403f723a150494ad5421a014"
SRC_URI[arria10_qspi_core.sha256sum] = "20ecb3f48cd2ea078f2ec8489ae3f95e0e691501817c5a230811336e7d05b73f"
SRC_URI[arria10_qspi_periph.sha256sum] = "3cc80668688cfd17761079cc4a010b3b248a757b6fc965d3f652cb9b6657aa77"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "bc9f89c0900c1ed0e7d179eff6357658a7a55fa338333b9edbfaf0a2a91bff83"
SRC_URI[arria10_sgmii_core.sha256sum] = "670554ebf79e6162671f9d319e9dfe2472711ebdc4d4c6b807bb154902a2b46e"
SRC_URI[arria10_sgmii_periph.sha256sum] = "e6f9356ee4d1722248450a1fb2e7317ba67c8a3ad2acefa3e303b83b7381f921"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "169f6f176e2d3d24b2b85ee6d4cadd08b51711bd61af0a661f5fc902ccce191e"
SRC_URI[arria10_tse_core.sha256sum] = "7c41078e9f0dedb96a03262a5f71c4e7238a5baec4f2144a404fd0ab09751a43"
SRC_URI[arria10_tse_periph.sha256sum] = "a7ca9d17f068feeadf242b53b7ddcc9246f92031780f01880a1a4359b251f134"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "bb70e367cbcf2653733ee1c693d51bada80f2e520f0db2d2aedeab42369e0982"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "6c3bc32e8f336846c6b4b40bb7785e76f7fc8210821e71dd017be76aa673551c"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES:${PN} = " \
		/boot \
		/lib/firmware \
		"

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install () {
	if [[ "${MACHINE}" == *"agilex"* ]]; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		if [[ "${MACHINE}" == "agilex" ]]; then
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
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex"* ]]; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		if [[ "${MACHINE}" == "agilex" ]]; then
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
