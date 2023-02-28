SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2023.03"
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

SRC_URI[agilex_fm61_gsrd_core.sha256sum] = "1f5aab6f8f82f6c789f784fcd4412917c46cdc94af5085c3bc3c3df5d8c47144"
SRC_URI[agilex_fm61_nand_core.sha256sum] = "f8dc3db19549d630f63ad2d77f965d853ea06650af841d0e1d367dd944a3b8e6"
SRC_URI[agilex_fm61_pr_core.sha256sum] = "43e7427c668d7dc42d8dc9e8324db819cea11a7645c1ae0c2867c42095267390"
SRC_URI[agilex_fm61_pr_persona0.sha256sum] = "dc986b9f69d30d78e0dace1cf08590a9f6b49e70b89f3fd15a6252dcc39c810f"
SRC_URI[agilex_fm61_pr_persona1.sha256sum] = "7d2deabf2dad9ec9b175c9154a9802ca393ac7c42f88db53ce4c1bd47cd44f33"

SRC_URI[agilex_fm87_gsrd_core.sha256sum] = "0d4f6b61fafb3ce6d8103061749cdd10c04bc436e5471d18820dacd700d309f1"
SRC_URI[agilex_fm86_gsrd_core.sha256sum] = "e3d5169d8fa75284b5580210e04b56e30eec88c5d1307622c0ee6ce6f6d0cf8d"

SRC_URI[stratix10_gsrd_core.sha256sum] = "62ea76a9cd07709ec3265bf76742558d83a02f771d4a2196022a175ec97d38cc"
SRC_URI[stratix10_nand_core.sha256sum] = "fcbdf252eff178e1c4cb2ded52916e9a08d75fecfba7c46a203cdb8f3c284289"
SRC_URI[stratix10_pr_persona0.sha256sum] = "6d64fe3657f07a4b426a7f458a92ddc3fe81c19454a3aa43f80f1a290223df9f"
SRC_URI[stratix10_pr_persona1.sha256sum] = "75496cd3371b3c6d50648c66af43fd2754cafe97586fbb4a48c2cab04903d548"

SRC_URI[arria10_gsrd_core.sha256sum] = "e7a8cff3837317881194f4207175a78f69cbc1d6d511efa94d45ec1b0b0e565a"
SRC_URI[arria10_gsrd_periph.sha256sum] = "ff1404e1fe37eee750018bc3b77ea615bad300e9298c46076a6390e00edcdf6c"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "2efb26b81cb1eca96acd9c63500e0fe75e0fc8684f59b3326672926f46be4cff"
SRC_URI[arria10_nand_core.sha256sum] = "97e64e6699502c8a5e3e762b650a45e46b48aec4e7a1e369d63afd96aeb890a0"
SRC_URI[arria10_nand_periph.sha256sum] = "48c97580ccdc848657ad299fd9683160b5b79a20a17956092b463447ab39662b"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "df3d27673541a1452868ecc1e248eef6254887ef77f724b931a9533eb0aedd4d"
SRC_URI[arria10_pcie_core.sha256sum] = "57a2195ce2dbfde61264660225856b5eb10d8a1346fde91ee9e8e3dbbf0e961c"
SRC_URI[arria10_pcie_periph.sha256sum] = "bf21005e5c810d6095679e1f8bc4c454d3d4b68306c3144f1637131afea1cb28"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "ea5051876e67f6a1ae13b0366894880f3eccf728f9a7738f285b179a9cfcb3f1"
SRC_URI[arria10_pr_core.sha256sum] = "337c344a7ab51e7dccbc29a90260d597a6f2be721c19250169fc0643c6fdf052"
SRC_URI[arria10_pr_periph.sha256sum] = "421bc48f6ad9f231615fc8c65bab5d9464a34981f6ff72d45bf28fcbb93bcaf9"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "501bf52aeaf0a711e1c488aaa9598e97e6afe3c80d14a437851e4aaeef8034ab"
SRC_URI[arria10_pr_persona0.sha256sum] = "1875274047708a1bbf77632836e9ff65c3058c0bd525b634b2b9c2197ad7cd22"
SRC_URI[arria10_pr_persona1.sha256sum] = "35d15939dbfe093c6039bce88a2625214553c632033b2b286fe122100e60a04a"
SRC_URI[arria10_qspi_core.sha256sum] = "72eb21347cfec311ada7c730f2bbfaa808e8074c2b939fa1fcf2eaeb267c5b78"
SRC_URI[arria10_qspi_periph.sha256sum] = "4f3cb7a649d157e21a537c8c0c187ab39cb8aee9eea370488033e7d4bd766337"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "c8e84eaf0c92de6d984e60c194bb69b79fa3e9cbb892d94ec04308c65c013938"
SRC_URI[arria10_sgmii_core.sha256sum] = "a5af4a2e11376c52c869de9b0ab44e677558cceaeda76d1229d94e8cd4c51057"
SRC_URI[arria10_sgmii_periph.sha256sum] = "e5706bb64144fad5ce4e5ad8bcf08814250c175682107ed1b72ed4fa18bcf836"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "c00fb7377ca798ebb4b4dca6bcfa41ad74d1d81035ef5bc99882f5600241075b"
SRC_URI[arria10_tse_core.sha256sum] = "41f617ec499e2649a9651870640cf94c6d74e20ce3eee4680b8ce1a12ee6252c"
SRC_URI[arria10_tse_periph.sha256sum] = "fc9a4f19a4d46c9da2557bb678d99f9a65849d00c24ec2daa21c74488dbeec4e"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "ed7d812b54777159826bd953517dad5bc41dd4b5fc40e92a8ad4ddb983fd2f58"

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
	if [[ "${MACHINE}" == *"agilex"* ]]; then
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
	if [[ "${MACHINE}" == *"agilex"* ]]; then
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
