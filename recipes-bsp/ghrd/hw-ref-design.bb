SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

RBO_RELEASE_VER ?= "2021.04"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}"
ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI_agilex ?= "\
		${GHRD_REPO}/${IMAGE_TYPE}/agilex_${IMAGE_TYPE}/${ARM64_GHRD_CORE_RBF};name=agilex_${IMAGE_TYPE}_core \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/agilex_${IMAGE_TYPE}/persona0.rbf;name=agilex_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/agilex_${IMAGE_TYPE}/persona1.rbf;name=agilex_pr_persona1", "", d)} \
		"

SRC_URI_stratix10 ?= "\
		${GHRD_REPO}/${IMAGE_TYPE}/s10_${IMAGE_TYPE}/${ARM64_GHRD_CORE_RBF};name=stratix10_${IMAGE_TYPE}_core \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/s10_${IMAGE_TYPE}/persona0.rbf;name=stratix10_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/s10_${IMAGE_TYPE}/persona1.rbf;name=stratix10_pr_persona1", "", d)} \
		"

SRC_URI_arria10 ?= "\
		${GHRD_REPO}/${IMAGE_TYPE}/a10_${IMAGE_TYPE}/hps.xml;name=a10_${IMAGE_TYPE}_handoff_xml \
		${GHRD_REPO}/${IMAGE_TYPE}/a10_${IMAGE_TYPE}/${A10_GHRD_CORE_RBF};name=a10_${IMAGE_TYPE}_core \
		${GHRD_REPO}/${IMAGE_TYPE}/a10_${IMAGE_TYPE}/${A10_GHRD_PERIPH_RBF};name=a10_${IMAGE_TYPE}_periph \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/a10_${IMAGE_TYPE}/persona0.rbf;name=a10_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/a10_${IMAGE_TYPE}/persona1.rbf;name=a10_pr_persona1", "", d)} \
		"

SRC_URI_cyclone5 ?= "\
		${GHRD_REPO}/${IMAGE_TYPE}/c5_${IMAGE_TYPE}/${C5_GHRD_CORE_RBF};name=c5_${IMAGE_TYPE}_core \
		"

SRC_URI[agilex_gsrd_core.sha256sum] = "5c76e498172bef11a3c7187e2bf49de5cb5d9334d78b6d0e3bc2925a2e74e37d"
SRC_URI[agilex_qspi_core.sha256sum] = "5c76e498172bef11a3c7187e2bf49de5cb5d9334d78b6d0e3bc2925a2e74e37d"
SRC_URI[agilex_pr_core.sha256sum] = "fb3d8804868ff39f3e814ba638d9408e90b206dd669a12753f07a5a564582732"
SRC_URI[agilex_pr_persona0.sha256sum] = "8a818091281aba9b0606b74c6bf779a26878cf1cc0badc4f23e12f6def3c2e00"
SRC_URI[agilex_pr_persona1.sha256sum] = "606987c012a250ea94c00d2284fbe4b95c42975e83569aec53f2e149c48d1db4"

SRC_URI[stratix10_gsrd_core.sha256sum] = "83d5b08ec29ea75902dd1cfa06bbf2be4b8fbb2a8848bf51c1219ed13a03591f"
SRC_URI[stratix10_pcie_core.sha256sum] = "01140a8ca98f6aed35adab9a07f48f4799f8f5afe65f8bd17f9bfd1ca83888da"
SRC_URI[stratix10_qspi_core.sha256sum] = "83d5b08ec29ea75902dd1cfa06bbf2be4b8fbb2a8848bf51c1219ed13a03591f"
SRC_URI[stratix10_sgmii_core.sha256sum] = "c98b81e971192baa0d39d46ed34eb22cfc138e77c73b5382adc4c5bf10c28f80"
SRC_URI[stratix10_pr_core.sha256sum] = "e2c42e84a8cd85eb87bca34159e1d7568c1bc1a7ca4c236d1b51ef4a00ba231a"
SRC_URI[stratix10_pr_persona0.sha256sum] = "b015625fda6523466a1d8ad335454ae00f40108f6a060f238000d9595e832388"
SRC_URI[stratix10_pr_persona1.sha256sum] = "9f4518522875bd02916c7b4bdfdfc0dca215da82f8ee06f615c344bbb629bfe1"

SRC_URI[a10_gsrd_core.sha256sum] = "aebb5d4ef7afa94d9035b1cbb85f04d32b23f1d16a409cc223d8521b2508be48"
SRC_URI[a10_gsrd_periph.sha256sum] = "107139edb841ef26cebbd250dfd876c2d8792122c6a2571947610b902ed3ca8a"
SRC_URI[a10_nand_core.sha256sum] = "0c621099f5900ef7bbc80a535c65360ff862e34f625a2bc8aeb44beced1cee92"
SRC_URI[a10_nand_periph.sha256sum] = "7780a476b65d8b54d24dfefc7268a54b62886f377625ceb8267c6612ca35c080"
SRC_URI[a10_pcie_core.sha256sum] = "bdb74e1b6c673cf089e37b5ba3e50b02883c929e17920959ae2ec2cafaafd91a"
SRC_URI[a10_pcie_periph.sha256sum] = "1b2799b8569dbb0dd2d18001e04e703f3af08dbf1f9d7858a1e7d4efc1c5d326"
SRC_URI[a10_qspi_core.sha256sum] = "de61a5d4b93123820456752e9c6739aa6c3fcf93a52d3722c1cfd93bbd00188c"
SRC_URI[a10_qspi_periph.sha256sum] = "088c86508637989eb78f3437161281502803d91ea0866bde2b396ae366272b5d"
SRC_URI[a10_tse_core.sha256sum] = "729849610fb2576608bb1ebe56576dc4b34c0b894ad81a4de077a840aa915e7a"
SRC_URI[a10_tse_periph.sha256sum] = "92d6c5d5f7ebe8d090979f0edad1a61e37f28fc3530ec3ace5765164163b8e62"
SRC_URI[a10_pr_core.sha256sum] = "7bee9452d0081368cb3ee35b59eef26aabedc1f5e6013032f4567df5f775e6a0"
SRC_URI[a10_pr_periph.sha256sum] = "b9d4f61fcd409bc0784e2db1ac6e6faaaa4db3b0c0e57cc681738ee65fe1d53f"
SRC_URI[a10_pr_persona0.sha256sum] = "db1ec6d490ac77b2703fe9a9898627deb3f47f630ac0a9bbd818592d985affaf"
SRC_URI[a10_pr_persona1.sha256sum] = "f5f3ac468b85e2211724ced77b9c5ad702c3492f5c7926a4bd82c44fa2a26c68"
SRC_URI[a10_sgmii_core.sha256sum] = "c2b79d1be633ac8b4b0245ada0b597ca45893dd3617b14056e82e6a6fdf98781"
SRC_URI[a10_sgmii_periph.sha256sum] = "17daaa0d808c8ab76f3351db5daab030297333156cd19b1123ec90c6c3cb5b1c"

SRC_URI[c5_gsrd_core.sha256sum] = "3d07ec43264e7a667bccef6465f3e2d60cc05744a114d54812955964847c4f1e"

SRC_URI[a10_gsrd_handoff_xml.sha256sum] = "0f70cec794743823f1c3cd31dd56032b17bc096e3f444102fda3e4d994d58aa1"
SRC_URI[a10_nand_handoff_xml.sha256sum] = "1548c28a4dba9fcf13cf4933853703b57c77ca1bbc0d08b2d0666bd98e35a0b1"
SRC_URI[a10_pcie_handoff_xml.sha256sum] = "c2af0ddcabd4222e0c803f4550210301fa424b2f060318c2adfd6a6ced005941"
SRC_URI[a10_pr_handoff_xml.sha256sum] = "35f5650cb488ee8a24648419917aa9ac9156195e91126eb80521fe6312f7079f"
SRC_URI[a10_qspi_handoff_xml.sha256sum] = "f6436f13e5a1849ab8a4493e1a7d95038b19fa4ac380d1cad0563d2cd54fa061"
SRC_URI[a10_sgmii_handoff_xml.sha256sum] = "5a00ab66bb1590aff8cedcb5ebbfe316cdff30dcbfc9e2966141392939d1fecb"
SRC_URI[a10_tse_handoff_xml.sha256sum] = "26f7a2574e8560e57d110f435f0756918e2ce90f06807b17f0f77bf4e7efcafc"

PV = "${RBO_RELEASE_VER}"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES_${PN} += " \
		/boot \
		/lib/firmware \
		"

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy[nostamp] = "1"

do_install () {
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${C5_GHRD_CORE_RBF} ${D}/boot/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi
}

do_deploy () {
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/hps.xml ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/hps.xml
		install -D -m 0644 ${WORKDIR}/${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_PERIPH_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${C5_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi
}

addtask install after do_configure before do_deploy
addtask deploy after do_install
