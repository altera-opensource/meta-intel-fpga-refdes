SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2023.04"
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

SRC_URI:agilex_fm87_linear ?= "\
		${GHRD_REPO}/agilex_fm87_linear_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex_fm87_linear_gsrd_core \
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

SRC_URI[agilex_fm61_gsrd_core.sha256sum] = "08ac352acca207d76efe787e21b60378042332ab612573cf8bb5dee4e31d0471"
SRC_URI[agilex_fm61_nand_core.sha256sum] = "e48226c5cd98c6412a5aecdf3bdf8ebd5fdd461e1d22b8579bcf8e7181ecbe2a"
SRC_URI[agilex_fm61_pr_core.sha256sum] = "2d62ccb27bfe7eff51896ce486351c1cb881f2a97f9f601bcc112fec52b43b51"
SRC_URI[agilex_fm61_pr_persona0.sha256sum] = "956e2d985337514f54a8b19cfdf59e53e3686f43390c6fd134d56673f93bf22b"
SRC_URI[agilex_fm61_pr_persona1.sha256sum] = "6e4005b6b1ed68739e38213fc57ad3b51df9ed65c234b1bef5c889863bacf651"

SRC_URI[agilex_fm87_gsrd_core.sha256sum] = "bb26748f0de309db4ee636c76f492dcef1850c81f0772954bff6d39fde9dad73"
SRC_URI[agilex_fm87_linear_gsrd_core.sha256sum] = "27cf4861f2cc379ab9b4bd8891aff0fe41c00f9e7f96f297b3c4596e62f5db32"
SRC_URI[agilex_fm86_gsrd_core.sha256sum] = "f992e23972e95f2e919d959394bc0842af42534686b8cb03419e0a9c9922affd"

SRC_URI[stratix10_gsrd_core.sha256sum] = "e9a18df8bc59e25434121048ab11594f3ce2cd889ab35ebeb0d3df5dd0416ada"
SRC_URI[stratix10_nand_core.sha256sum] = "6cbce6a0c839b7b8245d33b339325d95f865fbb801051a6859cd295be4de0664"
SRC_URI[stratix10_pr_persona0.sha256sum] = "c9daea4e9f99047e525f3a094c10c70cddca32dbfccadebc3811c24f9c8c875a"
SRC_URI[stratix10_pr_persona1.sha256sum] = "f86aa5723d4e5b9135c2703d290334a0f1a1396a5337ff3bacade0dcc84c57a1"

SRC_URI[arria10_gsrd_core.sha256sum] = "63e3fffac792f15008ff9cd1787f8b025f0fbe36a0e8e342f5a28afa41af29cb"
SRC_URI[arria10_gsrd_periph.sha256sum] = "101ba0232842f6728aeaa9dd03d16126a839ce82581a2b137d51091a903d4c0a"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "ff6f1462c119daeadab7a1627023dac063e25d1937dd7228c8c873c70ffe6741"
SRC_URI[arria10_nand_core.sha256sum] = "68dfea1dac1b91cb2b91fee5026f47170ee5ea672bcba5df2ddc608f62287954"
SRC_URI[arria10_nand_periph.sha256sum] = "c805052d70b7dfc55d8be4003d685d227757660d4a207253b7490fb76dea6f22"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "968545493034f5b2df982f9d2984e1f4ec7c625461da2035336867309e8e02e1"
SRC_URI[arria10_pcie_core.sha256sum] = "729b939d112abba740a92aee7c3fdadb930e1bd49bac9a947d8ef25f8534ae78"
SRC_URI[arria10_pcie_periph.sha256sum] = "71ee530185eafe6bc726d2ffb5d2d7902c3e8a97d77b189d2d287b61a58106ab"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "86d9d2f58a7aab7e4cfd04ac79c71dc5dda9664683df8a7b6b1b8f1aeab05684"
SRC_URI[arria10_pr_core.sha256sum] = "f854b21faac6d90b401f1a03a87798eeac896d1d7446afd1b4c67d7c7c79ab1a"
SRC_URI[arria10_pr_periph.sha256sum] = "fc6f9a6346b2270d36161b6a9bb4d1e24d65e11c63dd6f080c83f4c187dd2660"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "60299acbeee4c8440e644fe3c65d67f12b5073aaf78fcaa202e0b377d2c3ddb8"
SRC_URI[arria10_pr_persona0.sha256sum] = "bc14a8e6039c36c4ddcaf5194c8716e82447d2c5dcfa670fbb452d07d7c38bf7"
SRC_URI[arria10_pr_persona1.sha256sum] = "6af77ea4cf9d2392d53c64fc844d78f6542917a42b7124fe256b886656d76265"
SRC_URI[arria10_qspi_core.sha256sum] = "518770f349c4a04ac8e1ce9b2405b908698c66aa958374480ef36fffaafa6cf0"
SRC_URI[arria10_qspi_periph.sha256sum] = "46c71e832c6af0a30bfa171e57d34d3c83586d55b723ac724b231d1301f600b2"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "d643468f7b1e6e1bf0697dba97e4283bb2e8c8174e88ac382e72ce6fc4ac58c7"
SRC_URI[arria10_sgmii_core.sha256sum] = "cef9f05bbf08bc56105098439ebe5242a85cb3b09f05190a848de4a4d26df980"
SRC_URI[arria10_sgmii_periph.sha256sum] = "a466ea9ef35eccad4e19cd420ec5fe9358f50673c4e246ac0737294f0dda38d9"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "6f3c44faa3069b72d932ac3468cc08b1d97ea4ccb4372cb7b718e7e1a59f3a96"
SRC_URI[arria10_tse_core.sha256sum] = "41585d37162782230791daccb4ba2ae82e18cf2d19f127d181ecfb8b5f403c18"
SRC_URI[arria10_tse_periph.sha256sum] = "a8affa0e9577979c53065bfee57e31c27355f97c95bd3763c18b66535d729f19"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "3193be87dba6a72f719e4e3479b94be9d1d5c316666c1118c558a54dcbd92fc0"

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
