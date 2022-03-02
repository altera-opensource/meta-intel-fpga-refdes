SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2022.03"
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

SRC_URI[agilex_gsrd_core.sha256sum] = "7df24b5354f348e0319733ae0c90c820b5670776c23c5686eda1625f53116d84"
SRC_URI[agilex_nand_core.sha256sum] = "1d857c76d91ee0b783eede5bbdacdc450c9ff585e0b2af8a0cbd1bc941d16fcf"
SRC_URI[agilex_pr_core.sha256sum] = "d5c6aed65cea94ce567a3bfbda760b6d620b12bb10f3f5455d3de25657e7d478"
SRC_URI[agilex_pr_persona0.sha256sum] = "0c6f3718fce0edf064c45fd90eddcfa2ed0ad0f9540c4676480c87629dada78e"
SRC_URI[agilex_pr_persona1.sha256sum] = "7ca65b4699102aacfad858a3ec69be85006b045fd15ad1333af7869ebf65ac9c"

SRC_URI[stratix10_gsrd_core.sha256sum] = "b2d2336ea14bf69462c08a82c8bfb663be8d5bed7fc06075e354483023aaaa06"
SRC_URI[stratix10_nand_core.sha256sum] = "5cf80a6111bb5808bdf0c63d6efae94ff55a5ebfde911bedfebadff793a2e653"
SRC_URI[stratix10_pr_persona0.sha256sum] = "f108551876c12f0d67fa6e8cdad97b46519b7c0fd5f28fee7a829d2864460426"
SRC_URI[stratix10_pr_persona1.sha256sum] = "46c3cb12fc0cec841b5b5636db2b53c91a14d89d4808925a1c1a77d612709470"

SRC_URI[arria10_gsrd_core.sha256sum] = "a75e3fb6e0d4d4172b18f03468ef91c41f056b812d2688229f6dbc5ef44ca4d5"
SRC_URI[arria10_gsrd_periph.sha256sum] = "3508b2d1da1d7164adf8e11058e3cacd0e21293775dcc41a4db66f1f69ea7f92"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "743755f39e025f1c45f7ca91b3b7c4c7b1b1213a0f1a9a914ad64bebae8d127d"
SRC_URI[arria10_nand_core.sha256sum] = "4f71de75649a130e50f9f341bfa50916832961a8ff22171eef637d867d290438"
SRC_URI[arria10_nand_periph.sha256sum] = "a19a6c66a01613b362c7fd557e0e0362e3a940f3b8cab3ece44da40553c90c2a"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "d4e7f93c3fdc2caaa74487816e44c782b10137faf0b0d6aafe3bee205238a44c"
SRC_URI[arria10_pcie_core.sha256sum] = "d37bb529379f44203b8c219c1525eb1087aac5481c6565d747fdd5a2520833e6"
SRC_URI[arria10_pcie_periph.sha256sum] = "8ccf9be655f0167fb4465d303db75daad2e208dbe445161e584b1471eb4c137a"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "0925c321a838aa13232b795533afe5ff30af90f80a7b266530f9c689ee737ba0"
SRC_URI[arria10_pr_core.sha256sum] = "feffa50a009865e04df8c41c1f5b7667563909997f99bee43c5ee9950e30353d"
SRC_URI[arria10_pr_periph.sha256sum] = "7b825646f66a1a9b5de30c546dbfd78b31bcff413b3b64fd1346f87be62d2f5c"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "0473d4a67fc88d3426c3e386799248ba40ac5d31ecf66a1630b6cdfc0bf05d54"
SRC_URI[arria10_pr_persona0.sha256sum] = "6d005c972c0bb7beee570a4251185c953c6c565a88a868a08ec2b50c4a08cb81"
SRC_URI[arria10_pr_persona1.sha256sum] = "0aed1c7c6c0d7f4ebb32ab824115298cfa71746f7d76f0ae7ad6d4c2b6bbaf81"
SRC_URI[arria10_qspi_core.sha256sum] = "1b32a6c779f399a7d8c1b8f820217fadf9d6a259790779ac3561d25006984f8e"
SRC_URI[arria10_qspi_periph.sha256sum] = "a91e6eff41b2acbd7f069d0d776005e947a6420759933f649a729269cb705ce8"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "9e1f44464053e8e08bb9c6ae83812c8605f36206c1d73695cd169e883e08ba8b"
SRC_URI[arria10_sgmii_core.sha256sum] = "7b074cf3ecc14d72ab2bd8e637785a443bf6ee90d8ffd00f1cd8bca019ed831a"
SRC_URI[arria10_sgmii_periph.sha256sum] = "891be67feea3d81baef926f2875cdd0e26944ddaa556da27932a282d55ffacb8"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "893f2483cc646051c1753edbae6dec5766ed0aadd473d9d1a10da5c43f48166a"
SRC_URI[arria10_tse_core.sha256sum] = "611ea4494c31751e72c1d06b3565ceb6dd0ad171ffc2d0184fe3a55c7acbdd7c"
SRC_URI[arria10_tse_periph.sha256sum] = "52e7e4d6f9c039e73b4a06512f472a1bc22ab0c42f48bc742739ce759d57b574"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "2cc3c163f5227a7638f84559f2bd5f5cf7042431ba5592fef58dc96b8de171cf"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "6c3bc32e8f336846c6b4b40bb7785e76f7fc8210821e71dd017be76aa673551c"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES:${PN} += " \
		/boot \
		/lib/firmware \
		"

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy[nostamp] = "1"

do_install () {
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${D}/boot/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi
}

do_deploy () {
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_hps.xml ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/hps.xml
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_PERIPH_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi
}

addtask install after do_configure before do_deploy
addtask deploy after do_install