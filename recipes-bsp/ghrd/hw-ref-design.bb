SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2022.07"
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

SRC_URI[agilex_gsrd_core.sha256sum] = "184f5e8c9e2fe34e52eb1ea0f95b809f845543ba1d3dc61b258d948565c7797e"
SRC_URI[agilex_nand_core.sha256sum] = "170fba78f7eacd84c5a3c8090d9a86b0606d65041228605140fac1ced2446685"
SRC_URI[agilex_pr_core.sha256sum] = "8a7dacf5be326f47fa14d1a2e50d15b4e9140db46139b607f9f19b0e68cb260b"
SRC_URI[agilex_pr_persona0.sha256sum] = "41dee627816d2a341888e20cac58189d5ec32a9f984dc2d1f0ea0f185746610b"
SRC_URI[agilex_pr_persona1.sha256sum] = "cd4e5db281a5ce171e9f5ad005a625e709d4fa71aeb4a71e88c7df7f5e7561eb"

SRC_URI[stratix10_gsrd_core.sha256sum] = "637f8134ec99dadea0beeacfe48eb9072835ee2210ee65b1c180e4c1c9cf7116"
SRC_URI[stratix10_nand_core.sha256sum] = "9b191fd17348221078981e2361d85a4fb86969e77a9cf1630acee0ce74965730"
SRC_URI[stratix10_pr_persona0.sha256sum] = "a7f88ae4f8f53788a78ad578aa2b38c8aa0db335156091c3a0c311c091918025"
SRC_URI[stratix10_pr_persona1.sha256sum] = "adcf94bf5fc4ec2f17a004669b5641098a6f8798a5dcc8ab83875e104fe19c9f"

SRC_URI[arria10_gsrd_core.sha256sum] = "d0cb48a23a753d70269046c05c0b6b26db2720a9844fb5b1a514d26065acf53b"
SRC_URI[arria10_gsrd_periph.sha256sum] = "9b0dd5275df1e943165a0ba7c111b17b7465690bcc9fc74b8aae361f5b41437b"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "dc08b94991ef1d30efa84d1d5196ef3c6bcfc3c9e369d9a8333f6ebe8eebea34"
SRC_URI[arria10_nand_core.sha256sum] = "0a9b98b52b36078c8e16536cb4e999e1306e24fac48df3bc780916869e19abff"
SRC_URI[arria10_nand_periph.sha256sum] = "8b64e3d4264c18c3e8e22ff190d06b9004dd174f17b2fbdf32dc976376e1eadf"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "4533d8f3e5663ae134d4f399be8d8950b617647dde77509995abd1c949b68c13"
SRC_URI[arria10_pcie_core.sha256sum] = "94727fff28f2ea06b3d825f6d1e44a7dfa514d872b1c6ed6f22efe4004fdd080"
SRC_URI[arria10_pcie_periph.sha256sum] = "f7c3a04c45ab1da36d03e3246b72fd96580699414935ecb7573ac4098fbdf7a7"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "90007426f68e06447b31d1ae70128c4af4476b0cabbe2fdb290ab632ebd1e467"
SRC_URI[arria10_pr_core.sha256sum] = "fbbd304604d955ca88c2f362f85e14a18463571c20b6e1eecab61ccd2f162f20"
SRC_URI[arria10_pr_periph.sha256sum] = "7fe4586880b3ceb8a728e477725ec45761fcade40550942e4bb8e3b4ff4e9365"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "de37cbe409d0ed271a9662037636d98a886f2e6b184f7796bdbc5d7e3e1f0337"
SRC_URI[arria10_pr_persona0.sha256sum] = "884a4c3a40f51fe4d8e7aa4df1f58156da48563383ede80b3c16d01b2b30250a"
SRC_URI[arria10_pr_persona1.sha256sum] = "87735cf7f975d1bbf148962c76a6451236b7a1750d44ccf87a8bb1e8bdd713a5"
SRC_URI[arria10_qspi_core.sha256sum] = "69001d64a9c78cbd0b663500252a4774e34555f8bb431e6532c76d1ef322a31d"
SRC_URI[arria10_qspi_periph.sha256sum] = "10a4d42df2e21ba60d50599c177030c3de61d9040f8d9fe4e17dd478f4e2c24c"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "6ded05361a07ca2fa666b9cf1dce651d0e9632beb40bce986b6cf977a2fe2af5"
SRC_URI[arria10_sgmii_core.sha256sum] = "b1fbf9c7e690d5e0866ff21960f975ea9a20b59250f4644d9872c657930affab"
SRC_URI[arria10_sgmii_periph.sha256sum] = "50c737b1f59d908770e466ba78a6f6d54a547d926da6442437a9579c33946c40"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "81e9edffcf2fbcabf2f5320b32ac21a30c8c22b9651014b0ff019b8447c7e863"
SRC_URI[arria10_tse_core.sha256sum] = "e90f4a14b4f85267d7a2e9490db156273c3659335ff328408bcfb3a810aa350a"
SRC_URI[arria10_tse_periph.sha256sum] = "a5a78393a667c55bcb9b9a7af6a5a9e76960914fd7444b67c69e8e923a452ac0"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "275194b25028f2134908993b604ef8d751fbd3e70f53545e4152aff911962705"

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
