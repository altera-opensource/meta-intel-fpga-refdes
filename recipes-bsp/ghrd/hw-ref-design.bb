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

SRC_URI[agilex_gsrd_core.sha256sum] = "54fd617395bb4ea7f8e1617ecda66a06683930fbd851f7e240c01df1e63486e0"
SRC_URI[agilex_nand_core.sha256sum] = "36bd663642ae0bf6dad71f18dcc57724ac610a2493023923eaa65164d1a77b83"
SRC_URI[agilex_pr_core.sha256sum] = "69245470a36274f1f002cb275748664902d9262f577cae4bba92813cb48fdeaf"
SRC_URI[agilex_pr_persona0.sha256sum] = "6556cc83a8e8a38fb1e52945d91bd651466e9553f8e60c04df5e71ee36dc45f2"
SRC_URI[agilex_pr_persona1.sha256sum] = "8a0cdcb38aead468a62eb0cba68af05a4e242bd79a617f49176647d766b70b28"

SRC_URI[stratix10_gsrd_core.sha256sum] = "46023956a14668fb9fc75fdc54f63acf12dd63170c502c7251c3076e0df1d8c6"
SRC_URI[stratix10_nand_core.sha256sum] = "0f3a5966e1953a4d0a8aecbe0ee60075a7e79696306c712488cf4c2b3d8b050f"
SRC_URI[stratix10_pr_persona0.sha256sum] = "225f4734f6da223bdb18c6b79db0926492238a7213633e2af9887d743f558e50"
SRC_URI[stratix10_pr_persona1.sha256sum] = "8ecd6f6b500efbefffb53726a734fd57634a129d322335d77a1bdaea1f1f872d"

SRC_URI[arria10_gsrd_core.sha256sum] = "59530d1b91d7e3c8a4d948271616a2c23901031ef24baa8879d08eda7a5ba32c"
SRC_URI[arria10_gsrd_periph.sha256sum] = "20a05a8cf8767e15516fa259c379828890a7dc9e7916ea20a5b197ebe3ddbbc3"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "ab453259519d54daaa119b24421ac13798335947d3e64877f750433cfb32baf3"
SRC_URI[arria10_nand_core.sha256sum] = "a1b02a858b852f670dced0689a2238e8ef8d76098e06aecd7ea1f7f1127b51eb"
SRC_URI[arria10_nand_periph.sha256sum] = "4344a55c26e975cc92d5357459e1d7544a70320faf75269ddca647ccf35e6ec3"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "ae44f5e4766d78267746f51aad2ce1cf6f69273ee237afa1ed338269ba406132"
SRC_URI[arria10_pcie_core.sha256sum] = "db791b4f91481f52b6382dd75983762748fe73f6ed28566d9c7f10b83e80afe8"
SRC_URI[arria10_pcie_periph.sha256sum] = "dfec39897ba18b5e8edcc72fa18a0ca09248a0e04c05962824f1e73462c26174"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "ab529e75aa52c36bcba9a2586a1205376531b094ffc34959b1ba18ecae205cb9"
SRC_URI[arria10_pr_core.sha256sum] = "c4bf4ba247603eed4fb8040427a111b9e2a63dbbdafa05f6b2bd60a1bc1f4c0f"
SRC_URI[arria10_pr_periph.sha256sum] = "4b61c59fb39c119ba68119ce9143a2be496f54b8953d3c438dcdb4e93224a283"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "936d249fec78585f1346240d017811f5a474080ea9310578c76bb5614cefa418"
SRC_URI[arria10_pr_persona0.sha256sum] = "ac3f026e272bb5c129d75c7f5e3762391e1db48bfd8a16d4106725d9d5aacaaa"
SRC_URI[arria10_pr_persona1.sha256sum] = "cdf06659a1648774a6ff006441fef011f2755762e0e3f9c147de7b7b930720ae"
SRC_URI[arria10_qspi_core.sha256sum] = "b0e81f7ecee8d9ad20a64e1da0df33b99898e3aa603a9e29960b9afb607ee375"
SRC_URI[arria10_qspi_periph.sha256sum] = "7090de29f1baa7ac86bf3084591e54d0174339fc5ea38398b5744d3b229aec25"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "ffe659ff74d8e0010ba322df810739ca04b3c7d6597a846f3388124727825b89"
SRC_URI[arria10_sgmii_core.sha256sum] = "06f8f9ae20485e09c1699274e5f48c5d9eebcc03d74be085536017797b94be2e"
SRC_URI[arria10_sgmii_periph.sha256sum] = "c6b93237615d6d6f86b2f2ecd7e5aac51c9e0f86e9b9d11f5a44e41be149d58b"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "b7f5eb29505079d2c9845b0369c2e600482fc47a1eecb3301fb90fb935cbef73"
SRC_URI[arria10_tse_core.sha256sum] = "29715b7520f8ed447cfecebea83b68a709f7f3d09c5e13731e3307d2b6bf77b2"
SRC_URI[arria10_tse_periph.sha256sum] = "50cef6b929cca9a81b1eb972f6850b420465fe30cdbe9ebde0ba72b3344624b8"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "2043a828c7d6395464e20ac23e28be907b25d37fad6c26315aca360af45a2079"

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