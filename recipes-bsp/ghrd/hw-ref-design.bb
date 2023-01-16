SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2022.12"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex_fm61 ?= "\
		${GHRD_REPO}/agilex_fm61_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex_fm61_gsrd_core \
		${GHRD_REPO}/agilex_fm61_nand_${ARM64_GHRD_CORE_RBF};name=agilex_fm61_nand_core \
		${GHRD_REPO}/agilex_fm61_pr_${ARM64_GHRD_CORE_RBF};name=agilex_fm61_pr_core \
		${GHRD_REPO}/agilex_fm61_pr_persona0.rbf;name=agilex_fm61_pr_persona0 \
		${GHRD_REPO}/agilex_fm61_pr_persona1.rbf;name=agilex_fm61_pr_persona1 \
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

SRC_URI[agilex_fm61_gsrd_core.sha256sum] = "5822f5d955df2b4551ba6b200157091d602950cb1721603d80bc41fa47a649a5"
SRC_URI[agilex_fm61_nand_core.sha256sum] = "f7a9a7f60f6c1c1c0197292573c844be625d9cd3e96c1c1105e1a6057aad699c"
SRC_URI[agilex_fm61_pr_core.sha256sum] = "c80ccbbcaa7af9531f35a0c81974759de66bc6e27c667d89977b81a12952e2bc"
SRC_URI[agilex_fm61_pr_persona0.sha256sum] = "898d43bb2da306ee834c31100d1c80a9e846a3aee7aee9b49207c52ed45c786a"
SRC_URI[agilex_fm61_pr_persona1.sha256sum] = "95f950343951d6813a332eb6dbdee0af782d5c52d98cd92f69212e1d0c90336f"

SRC_URI[agilex_fm87_gsrd_core.sha256sum] = "225869090fe181cb3968eeaee8422fc409c11115a9f3b366a31e3219b9615267"
SRC_URI[agilex_fm86_gsrd_core.sha256sum] = "ef166166986756c1d1cc3d1316de6fa1be030bc19ae621b147a06209b5a866e6"

SRC_URI[stratix10_gsrd_core.sha256sum] = "3372c90427e6c5c6a888cdb1c4fa3ef268f16a2f42c23b403239fed8577067c5"
SRC_URI[stratix10_nand_core.sha256sum] = "ed69939be63d34d3fed13c36e3dc6c4f70bf86811c27b4d07bc4e5758f2188c5"
SRC_URI[stratix10_pr_persona0.sha256sum] = "2a26d3464665f05c69a81be3b9e0e31f2cf9cd1c89e5b1214dc8d15a2d2def9f"
SRC_URI[stratix10_pr_persona1.sha256sum] = "2030da925d537600cb239ed029ec4ee8c06eb2a3e6f0b332ad29500f788501fd"

SRC_URI[arria10_gsrd_core.sha256sum] = "623f042c1b67d7c367ef97c2d56714350de928e33f7f2ded84a00fbaa027f37d"
SRC_URI[arria10_gsrd_periph.sha256sum] = "541f4353218a08fb5088c0df24213ab54074172b71f88118bb66ec007969e64c"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "13ad3ac834ccab0326153df3faa92f02f3cf749073b2985d703cebaa8d623217"
SRC_URI[arria10_nand_core.sha256sum] = "baa4409b7b5adb30807372663e6b7850a55979f22162240b217ac0c578df184f"
SRC_URI[arria10_nand_periph.sha256sum] = "031d494be82f99fd016f1eee11013214d22f98a27823125bad6abcb3a620789c"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "aa8b7237119e1a795c072399ecb2ad4813063b35f6d6519112c8a6540de568a2"
SRC_URI[arria10_pcie_core.sha256sum] = "1293bf0cad9ca7b16dbfac5c0c227e08bbef908111f57dda069b4d858a7f0704"
SRC_URI[arria10_pcie_periph.sha256sum] = "c4593a9c3a0909beaeedd8c4a4ade41ff0b724eb0e7e1d23759162e342a44625"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "ed4260c1de6667dbe6ed49b124dfafad41f2ac63c61c849419dfc3fc8c379a0f"
SRC_URI[arria10_pr_core.sha256sum] = "b6cd624684cef27cbc7bcd078c52ec63a18ed6228d45f624dd71e15bcee9abe0"
SRC_URI[arria10_pr_periph.sha256sum] = "3cf04b9d1ed5ca1908babbc98be1767f00dbd56c98c4a1aed6d18ca11caa2c33"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "48a6b1ae1a5c85dc906546049569dba3ecfe4e784f494f3918bf8ee83a6be967"
SRC_URI[arria10_pr_persona0.sha256sum] = "98a81c9fb68957946061fe70d0a16d8205eb6aac15165e5cceec81eab09a703f"
SRC_URI[arria10_pr_persona1.sha256sum] = "3e1b66f42f22bd64fcdf6eb4fd7151d6d60d0e3259d4ffc3337e32abeba7c869"
SRC_URI[arria10_qspi_core.sha256sum] = "2de47229901035067ed960d8c33e51287f5211c5e4c002d16ce5fdf58472b57b"
SRC_URI[arria10_qspi_periph.sha256sum] = "a290d49a421b365e6d96d05b506c79a20f6f3adb509ec941cd9d2fbab726d341"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "405abef3f70652e38b3b2d2540963abd4d0003e69a6f277f3ca168fdc1e02d91"
SRC_URI[arria10_sgmii_core.sha256sum] = "d0e8f8e96596061061ac0128227c6319305bab8b73e115f2144d78e36168dde0"
SRC_URI[arria10_sgmii_periph.sha256sum] = "806f6e35994a6c3e376533739d5d7ae7d496f1a2047629a26b9827f77c82665b"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "488f6e528431e8bf84cacc1539fb8f91fe7b8f60445ef91cc5942577cb0a65e0"
SRC_URI[arria10_tse_core.sha256sum] = "24bd1cf2c7b1b74f081c018a012747c59e8ec46c23c455b01bd02ad479625cd1"
SRC_URI[arria10_tse_periph.sha256sum] = "d2bc1ab822c16ba912b6b625226914969f3f252abe41c11360f9d35ee1fc40ca"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "ad08202c16d30f28ece6841bec9c7e356c2f44ae3c8929e7fa9a08efa3abd967"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "66aba3b771153b63e54373bbc526b86236a07e0bef84d4a0cc3b5559c1b0af55"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES:${PN} = " \
		/boot \
		/lib/firmware \
		"

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install () {
	if [[ "${MACHINE}" == *"agilex_"* ]]; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		if [[ "${MACHINE}" == "agilex_fm61" ]]; then
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
	if [[ "${MACHINE}" == *"agilex_"* ]]; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		if [[ "${MACHINE}" == "agilex_fm61" ]]; then
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
