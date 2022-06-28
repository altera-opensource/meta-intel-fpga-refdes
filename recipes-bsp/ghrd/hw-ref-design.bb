SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2022.06"
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

SRC_URI[agilex_gsrd_core.sha256sum] = "ce54cc6a5dfa0c72b69a38c1e0fef2b536641f7e139f7385f9018299e1709c54"
SRC_URI[agilex_nand_core.sha256sum] = "8975bcf2d8700fed1303af7231e059f77b87c61ce6442aa52a44581547d82c08"
SRC_URI[agilex_pr_core.sha256sum] = "d199f6947921f2c5da15b02443630235d07c5d854457c09d23ecc63682bf7022"
SRC_URI[agilex_pr_persona0.sha256sum] = "f2b8ce4ffcd6bdddd685e4951fb07ed9039752d60d7954479a6e456871f0bde0"
SRC_URI[agilex_pr_persona1.sha256sum] = "35946bb5b36b5f16435ce6c9e0d7a7fdf6d5218be0bb17a83b5d1b1066f4f923"

SRC_URI[stratix10_gsrd_core.sha256sum] = "a97963573b746b91ba45bdcaee194179fdfbc4e180b15aad67da92ae4c1563da"
SRC_URI[stratix10_nand_core.sha256sum] = "d29c2e2fb1052ea316d585b21b55b517f61665cffdc9e8cc767fcc00b201930e"
SRC_URI[stratix10_pr_persona0.sha256sum] = "0c6e4c9edd210fcc2d7e15c5a58ec2b8b4f953f715074d49ca99a2712578c5fa"
SRC_URI[stratix10_pr_persona1.sha256sum] = "8f566114082427ccd96e4b89d5d262d58b06374ade3821587cf0c7a1b0ec10d8"

SRC_URI[arria10_gsrd_core.sha256sum] = "1c30cf4325133dfaaf9f1b4f3d143cee54fca2f3a8bd1f5d3639d269ba450c3e"
SRC_URI[arria10_gsrd_periph.sha256sum] = "c2db24a5f79cd25a899528dd6dad147f68acd3cff3e29132f8b894354454ee36"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "8f5acdb724aa5314778bc740c8aa8d93f0117b837896497ea0d280ccf09f2e2d"
SRC_URI[arria10_nand_core.sha256sum] = "f1e8fcb86c38c14afcf8dc893eaebde63e61de91be8e5280fd8dc05582be9574"
SRC_URI[arria10_nand_periph.sha256sum] = "c6d36cd75471dd3085f3d4cf3ec8548d7ed720fe539dfbb4e4c45236a92ed509"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "5050b3abaa36601c4fd0f5b51da3176fa237f7d837ceee8bcbca37ffb7ff2e43"
SRC_URI[arria10_pcie_core.sha256sum] = "d248b72bae8bf231e2f5861e6b3922b84d58cc5298e2e34c993001a4f289db32"
SRC_URI[arria10_pcie_periph.sha256sum] = "0167f06997b6052ccaa093487c24f033759ea0db76a98fcfc5ac6cc74c2b1956"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "0e95c588d51450effe8b1c4dd4390ce3eb982101b16ad512aab76e71b21efa82"
SRC_URI[arria10_pr_core.sha256sum] = "45eb1da5faf00482c31280fec2380295e15aa5f53f59c2be2bcc96bb3da45552"
SRC_URI[arria10_pr_periph.sha256sum] = "cbbf2d89f3682c17bc5f69df14e1b32433deac733666ef0f0d4df8d6883e28fc"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "c8e955a42ea62f4cda7d5b9ad7fa19feda123b5c1a225c5aa242fa79e99afa13"
SRC_URI[arria10_pr_persona0.sha256sum] = "41bc25617f7c8531726200b0b50ac4ad0c630addacf271979a705969c75d4a37"
SRC_URI[arria10_pr_persona1.sha256sum] = "6a58521f7713250c859bbd6479790109a86421b771a7e69cc8fa4b7849c005eb"
SRC_URI[arria10_qspi_core.sha256sum] = "56d5059db42a4c03350106ab8f2ed5d39a571c29ded86aba1ace13a5e3cb3021"
SRC_URI[arria10_qspi_periph.sha256sum] = "0a6cb5d7e48d6f282c6ca09212b626f941c422edf06d47d4e42fde3ccd00da2c"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "34b39db3526b9fccee925069d2a07af0b69bab19589111bdb55bb533f4e9029b"
SRC_URI[arria10_sgmii_core.sha256sum] = "7cf5b7e286bec403f085141cef0799815f4670fe2a49178da182d5d661341bba"
SRC_URI[arria10_sgmii_periph.sha256sum] = "48465234d3a3949a7998293849ce1b9d362b92914c1d8ec7c16d0758d3ad88c9"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "e94795441b6f89e1e62f2b5c8997ddab722aee5ce8614776ebc58d14bd5b6b7b"
SRC_URI[arria10_tse_core.sha256sum] = "0505505a375313dafed5ea343b72e8c355c57e37c1150bff5918e4f171749013"
SRC_URI[arria10_tse_periph.sha256sum] = "dbff7817388f05f1cc9b0973fcdc768a3f7c13021da463543b2cfe4862a380d3"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "ba793553878b50ca438643df4c288e7d8088124cea48e538679120a8d4877db4"

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
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)} ; then
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
