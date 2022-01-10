SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2022.01"
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

SRC_URI[agilex_gsrd_core.sha256sum] = "83585e7a681786f73b9d35f1fb9fa25fd1a8192b81c223cc89c5eb402c6e9d88"
SRC_URI[agilex_nand_core.sha256sum] = "bd48dc077322acc492f68d943b57b2f219aff3df831095f4259c2dccb5799396"
SRC_URI[agilex_pr_core.sha256sum] = "dd8d32644380a6f86541e22d98e4177e314effd22d2088698ef2395eb8dd16ae"
SRC_URI[agilex_pr_persona0.sha256sum] = "9c5b1a24ae3bfee0933c744426399dffdf7aabf611ad65ca63cdb1c8fe5f9de6"
SRC_URI[agilex_pr_persona1.sha256sum] = "8863fea5a666c283f425bb0ad556458a60632d04f41559506c02b72462ae13b0"

SRC_URI[stratix10_gsrd_core.sha256sum] = "f3e22088e42ea36403e4cf271785e2e3199842d67dfc4ea70f7c8cfd91b3e36c"
SRC_URI[stratix10_nand_core.sha256sum] = "2599cbd0d1c80b1f885bd38a859284d042a605e4e5d0cab1c5002a9d005a91b6"
SRC_URI[stratix10_pr_persona0.sha256sum] = "2e824032feb89ab30531083cb23d37a7a556d333ba9ad12ef87ea658874fc738"
SRC_URI[stratix10_pr_persona1.sha256sum] = "d93444ad68a40823a1a5b080224547128fddeebc6fc3d6170f4cf21842cbbe3c"

SRC_URI[arria10_gsrd_core.sha256sum] = "59530d1b91d7e3c8a4d948271616a2c23901031ef24baa8879d08eda7a5ba32c"
SRC_URI[arria10_gsrd_periph.sha256sum] = "20a05a8cf8767e15516fa259c379828890a7dc9e7916ea20a5b197ebe3ddbbc3"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "7a977bb69db241666cd06509eea63f2b726b064ccf0461e95fb6f524ca7efa3d"
SRC_URI[arria10_nand_core.sha256sum] = "a1b02a858b852f670dced0689a2238e8ef8d76098e06aecd7ea1f7f1127b51eb"
SRC_URI[arria10_nand_periph.sha256sum] = "4344a55c26e975cc92d5357459e1d7544a70320faf75269ddca647ccf35e6ec3"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "62465334c0caab5d674d161a06c301cdbede62ee2924afb4bb2610fc40502530"
SRC_URI[arria10_pcie_core.sha256sum] = "db791b4f91481f52b6382dd75983762748fe73f6ed28566d9c7f10b83e80afe8"
SRC_URI[arria10_pcie_periph.sha256sum] = "dfec39897ba18b5e8edcc72fa18a0ca09248a0e04c05962824f1e73462c26174"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "7c726c0287f4207ab7ff0b69e5b29459a07fd0ca853363b99be14bc904184fd7"
SRC_URI[arria10_pr_core.sha256sum] = "c4bf4ba247603eed4fb8040427a111b9e2a63dbbdafa05f6b2bd60a1bc1f4c0f"
SRC_URI[arria10_pr_periph.sha256sum] = "4b61c59fb39c119ba68119ce9143a2be496f54b8953d3c438dcdb4e93224a283"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "ad119cfcdaa1b6512e2624245a0a41f1482df2176e8d92da31c9674101e09593"
SRC_URI[arria10_pr_persona0.sha256sum] = "4859a4837c3aa6ab4866b97159f98a8dc0882997be3a4f2359ddce7b9970c42c"
SRC_URI[arria10_pr_persona1.sha256sum] = "7ee3a605926a85c30009b2d813571871bf8fe70d64916bef4a57bf4c9f614768"
SRC_URI[arria10_qspi_core.sha256sum] = "b0e81f7ecee8d9ad20a64e1da0df33b99898e3aa603a9e29960b9afb607ee375"
SRC_URI[arria10_qspi_periph.sha256sum] = "7090de29f1baa7ac86bf3084591e54d0174339fc5ea38398b5744d3b229aec25"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "806039a71d8069c0d922a9ffee4941891f9baca68b4689eb50813317a5c0ca8c"
SRC_URI[arria10_sgmii_core.sha256sum] = "06f8f9ae20485e09c1699274e5f48c5d9eebcc03d74be085536017797b94be2e"
SRC_URI[arria10_sgmii_periph.sha256sum] = "c6b93237615d6d6f86b2f2ecd7e5aac51c9e0f86e9b9d11f5a44e41be149d58b"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "be5d89c96416c72bfaf02637b74f24063a0efafc63f7d8b3472f9dc34a746b7c"
SRC_URI[arria10_tse_core.sha256sum] = "29715b7520f8ed447cfecebea83b68a709f7f3d09c5e13731e3307d2b6bf77b2"
SRC_URI[arria10_tse_periph.sha256sum] = "50cef6b929cca9a81b1eb972f6850b420465fe30cdbe9ebde0ba72b3344624b8"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "41cf2cab7486ac7a2acd81eb3d6bc48c39062c0199aa810d416cf9c88a484a53"

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