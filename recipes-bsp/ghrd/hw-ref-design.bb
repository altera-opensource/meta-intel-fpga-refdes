SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2025.01"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex5_dk_a5e065bb32aes1 ?= "\
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_emmc_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_tsnconfig2_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_tsnconfig2_core \
		file://agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf \
		file://agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex5_dk_a5e013bb32aesi0 ?= "\
		${GHRD_REPO}/agilex5_dk_a5e013bb32aesi0_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aesi0_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e013bb32aesi0_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aesi0_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e013bb32aesi0_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aesi0_emmc_core \
		"

SRC_URI:agilex5_dk_a5e013bb32aes ?= "\
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_emmc_core \
		"

SRC_URI:agilex5_dk_a5e013bb32aes_5s ?= "\
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_5s_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_5s_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_5s_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_5s_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_5s_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_5s_emmc_core \
		"

SRC_URI:agilex5_modular ?= "\
		${GHRD_REPO}/agilex5_modular_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_modular_gsrd_core \
		"

SRC_URI:agilex5_mudv_cvr ?= "\
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_emmc_core \
		file://agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf \
		file://agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex5_mucv ?= "\
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_emmc_core \
		file://agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf \
		file://agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex7_dk_si_agf014ea ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_gsrd_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_nand_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_nand_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_pr_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_persona0.rbf;name=agilex7_dk_si_agf014ea_pr_persona0 \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_persona1.rbf;name=agilex7_dk_si_agf014ea_pr_persona1 \
		"

SRC_URI:agilex7_dk_si_agf014eb ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014eb_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_gsrd_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_nand_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_nand_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_pr_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_pr_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_pr_persona0.rbf;name=agilex7_dk_si_agf014eb_pr_persona0 \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_pr_persona1.rbf;name=agilex7_dk_si_agf014eb_pr_persona1 \
		"

SRC_URI:agilex7_dk_si_agi027fb ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fb_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fb_gsrd_core \
		"

SRC_URI:agilex7_dk_si_agi027fa ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fa_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fa_gsrd_core \
		"

SRC_URI:agilex7_dk_si_agi027fc ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fc_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fc_gsrd_core \
		"

SRC_URI:agilex7_dk_dev_agf027f1es ?= "\
		${GHRD_REPO}/agilex7_dk_dev_agf027f1es_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_dev_agf027f1es_gsrd_core \
		"

SRC_URI:agilex7_dk_dev_agm039fes ?= "\
		${GHRD_REPO}/agilex7_dk_dev_agm039fes_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_dev_agm039fes_gsrd_core \
		"

SRC_URI:stratix10 ?= "\
		${GHRD_REPO}/stratix10_gsrd_${ARM64_GHRD_CORE_RBF};name=stratix10_gsrd_core \
		${GHRD_REPO}/stratix10_nand_${ARM64_GHRD_CORE_RBF};name=stratix10_nand_core \
		${GHRD_REPO}/stratix10_pr_${ARM64_GHRD_CORE_RBF};name=stratix10_pr_core \
		${GHRD_REPO}/stratix10_pr_persona0.rbf;name=stratix10_pr_persona0 \
		${GHRD_REPO}/stratix10_pr_persona1.rbf;name=stratix10_pr_persona1 \
		"

SRC_URI:stratix10_htile ?= "\
		${GHRD_REPO}/stratix10_htile_gsrd_${ARM64_GHRD_CORE_RBF};name=stratix10_htile_gsrd_core \
		${GHRD_REPO}/stratix10_htile_nand_${ARM64_GHRD_CORE_RBF};name=stratix10_htile_nand_core \
		${GHRD_REPO}/stratix10_htile_pr_${ARM64_GHRD_CORE_RBF};name=stratix10_htile_pr_core \
		${GHRD_REPO}/stratix10_htile_pr_persona0.rbf;name=stratix10_htile_pr_persona0 \
		${GHRD_REPO}/stratix10_htile_pr_persona1.rbf;name=stratix10_htile_pr_persona1 \
		"

SRC_URI:arria10 ?= "\
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_hps.xml;name=arria10_${IMAGE_TYPE}_hps_xml \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF};name=arria10_${IMAGE_TYPE}_core \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF};name=arria10_${IMAGE_TYPE}_periph \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona0.rbf;name=arria10_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona1.rbf;name=arria10_pr_persona1", "", d)} \
		"

SRC_URI:cyclone5 ?= "${GHRD_REPO}/cyclone5_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF};name=cyclone5_${IMAGE_TYPE}_core"

SRC_URI[agilex5_dk_a5e065bb32aes1_gsrd_core.sha256sum] = "490b357be98a8377b4aae8befbc7db97c4e332fb3f4ced74cc00df1a1a452db3"
SRC_URI[agilex5_dk_a5e065bb32aes1_nand_core.sha256sum] = "adce9818cd9301970c6853d3d00357733c146607ef83a75801fbf7e0be3d2dc7"
SRC_URI[agilex5_dk_a5e065bb32aes1_emmc_core.sha256sum] = "1cf6d070a28dc5507e3ec6ae4b5f1e37d9a167b8c521ccf39301be7befe24741"
SRC_URI[agilex5_dk_a5e065bb32aes1_tsnconfig2_core.sha256sum] = "f2520125f8e95a99735186ae5e8c853b174a7d7d294617b1331c8794434364ea"

SRC_URI[agilex5_dk_a5e013bb32aesi0_gsrd_core.sha256sum] = "86d5f729a391bf0088d659efbe0315f3a5bf8df4717d07466708c29ebc8ddb25"
SRC_URI[agilex5_dk_a5e013bb32aesi0_nand_core.sha256sum] = "a19baf58fcaeacc210508480b14ccc8dc3889be74c8f43da535a11e37a61a6dd"
SRC_URI[agilex5_dk_a5e013bb32aesi0_emmc_core.sha256sum] = "70d1aab9bf5e567246176cbda3513e644b11e2a54c01375d730dfbd3fb8ebc46"

SRC_URI[agilex5_modular_gsrd_core.sha256sum] = "0b329eee22c0ffe23365753c830e6561f68f27317ede29b86c707be0339d569a"

SRC_URI[agilex7_dk_si_agf014ea_gsrd_core.sha256sum] = "01f79cff0d311332a41198df48f74d0c9b63081f5b403b7bbed0336f032ac9f7"
SRC_URI[agilex7_dk_si_agf014ea_nand_core.sha256sum] = "d05a7c8f21b529af09a9ba63a65049bb8e2c2109189af9be1cd8fe024a718927"
SRC_URI[agilex7_dk_si_agf014ea_pr_core.sha256sum] = "a1943611b9274d9033e0305381e1a0233142fe2dd81ac58a6d34b92e1855fa76"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona0.sha256sum] = "b03f4af553561629f67e55b7de5f0a3ea961251e258fc3955fc8e564f7f93e3c"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona1.sha256sum] = "0038ec9dd08a544bf845dd6579e1d4287db9b881b0f51186da1e7fcdcc6edbcd"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "dcd026d8156c245f8e3582b406c421492a882c2e231caad3711e3fbd9ee83092"
SRC_URI[agilex7_dk_si_agf014eb_nand_core.sha256sum] = "272513e971a8d210a918f088d845eff4c53a30e7b62bd718062f86a8696e2ba2"
SRC_URI[agilex7_dk_si_agf014eb_pr_core.sha256sum] = "ec5b10028ad15f44c7f711bd70e9fb736f03588b4a37222a6995e11ccef38f2a"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona0.sha256sum] = "435517a95e62a45e04a31bcd1f603d8eff05a0f71819964454471b4daeeab826"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona1.sha256sum] = "b1755707e99803bce4a6d6572fe3c44b368af7ccee062d5d0b9ec5380f1ac6cc"

SRC_URI[agilex7_dk_si_agi027fb_gsrd_core.sha256sum] = "f6b92a4212effc8f924585881b231a3c2fbd612ac27bb2c96f96c2b33e3666a4"
SRC_URI[agilex7_dk_si_agi027fa_gsrd_core.sha256sum] = "e848226b8fb34ecf5075c4da98c88e0b16c96837014a26fed1a9f6eebd5d31bb"
SRC_URI[agilex7_dk_si_agi027fc_gsrd_core.sha256sum] = "c471925996f5328a39a4c16cfc87bb54629fa89eff19d549fd9ee19d1512eef7"
SRC_URI[agilex7_dk_dev_agf027f1es_gsrd_core.sha256sum] = "7d024b6c0c3ad1a3faf83b2d6818523dd2322ee2f3952424f97ea2a30b4bf496"

SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "54c9ec7ed39f2cbdc920dbdc0dd27e6916f17c96b8804d2aea0f262289a5caf3"

SRC_URI[stratix10_gsrd_core.sha256sum] = "c43c9726f605016778694e8caa34a52223774e3b0db5c842f24a72df36bcafab"
SRC_URI[stratix10_nand_core.sha256sum] = "18b9cb459cc056b5324744b36f8f4a12aee771c361106ce574615eed8dae819c"
SRC_URI[stratix10_pr_core.sha256sum] = "03e174fc6848e51f07f0e905704b1bf83047b9e9b29c115669cdc0d63dc2364b"
SRC_URI[stratix10_pr_persona0.sha256sum] = "362a5c74e13c1c08671dcb66bbc8668455beddd0a530cb86502ad6dd2df9eb1c"
SRC_URI[stratix10_pr_persona1.sha256sum] = "f3c8f60ef802497bf038e2f22ebd3942a365ffea302f3041ecae7feb2be26229"

SRC_URI[stratix10_htile_gsrd_core.sha256sum] = "6a7e4b9ed6146fa02ad6f37896d7d7a34ed14a0895e9e7ef92e2d6e442c8fd62"
SRC_URI[stratix10_htile_nand_core.sha256sum] = "3ea5efca3cb223e150d0600742881daf7b1f1c364498d60d20dd952d5150e3ef"
SRC_URI[stratix10_htile_pr_core.sha256sum] = "a10931cbb11efb091d8794f9e87cfec65b5a53067926d212449a914bab411b88"
SRC_URI[stratix10_htile_pr_persona0.sha256sum] = "150c60bb1d6abd5b8998599bd244d2a687a3d5e6433d0edc2f8035dea7c9311f"
SRC_URI[stratix10_htile_pr_persona1.sha256sum] = "80ba157a813a2db2fdbd03d05735f85a4ecde37553a26ebdf27eb07bdc259bc6"

SRC_URI[arria10_gsrd_core.sha256sum] = "e4d5f7ba95a374c975850cfa94e1a4c5d3284c6e8e30ba2c2c6493d9dd4f9202"
SRC_URI[arria10_gsrd_periph.sha256sum] = "09fab8657241fe3b1b33dafd1003cc5699c407362ac436e2c6af0afe38d92f25"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "11f66b4fb9f82dfa18d84bc10e99cf2a2e4ed9f560e40a07d3cf6c3edfe48206"
SRC_URI[arria10_nand_core.sha256sum] = "500c1a5b3339725e85f6a43894249805de40aa71100ec0641bf47436a0e1782e"
SRC_URI[arria10_nand_periph.sha256sum] = "d56008a3bfc9c418f10e663540d538968d9aa44befff62d7b2dddcf1018aa8b4"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "b28963943131fe47453862153a642972fa98a2a5c70b9aac9c85de2af835ecd1"
SRC_URI[arria10_pcie_core.sha256sum] = "aa9fa88d1cbedbb5a3467054fd73b9e6156cfe48771181e5bc9cc788ad354488"
SRC_URI[arria10_pcie_periph.sha256sum] = "aaef13a5904ba1b72428412e0ccb0243916f68a34eb817b1826dde0d569976ea"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "40ff113cd3a91a02372a6280cbd32186d2a8f7d0aaac217c38775687f90853d4"
SRC_URI[arria10_pr_core.sha256sum] = "6a35680c31422e48e6bf9e9df86107ff135abd0fbefeb4d52fec85dd9bc8fcd7"
SRC_URI[arria10_pr_periph.sha256sum] = "bbcb4112883613da63ce644e81ab86cccd243811d494529087f8919febbf2265"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "d5d7477ad532a9f28f947d5afc1d8d6a153febf40d886e7e569bc24e4374145f"
SRC_URI[arria10_pr_persona0.sha256sum] = "99ae35da6e20cd384deaa8cb02ffcaff02cb5527c7b59c1699fe09f1841591fe"
SRC_URI[arria10_pr_persona1.sha256sum] = "3b1cc0d9b9be16c470641f74b2e28500c95324a41a4dd8ab30977105443273f2"
SRC_URI[arria10_qspi_core.sha256sum] = "f35b2be141e43a74d1bfb8dfce6e9faab7d202cbeab898fc7ba562f3bded2db8"
SRC_URI[arria10_qspi_periph.sha256sum] = "67f2f89290f32cd2f091767b7c00e29fbb7c8835e9a0054f1cd4afc2154833f0"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "fa5916e726ad3007ea42194c57741bc70ccd6cc17890cacfc027965cbe679359"
SRC_URI[arria10_sgmii_core.sha256sum] = "b083edbde3171ce98060a63158c75c9f5880fe711b168adb00611c1c97a4835e"
SRC_URI[arria10_sgmii_periph.sha256sum] = "ed5e96daa6c3cddfd30963d507ec23ce98bc1b2cbfe318484a93180b4cfa3feb"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "43d74c69ac91912ba5092359f9d300769089753b5db55c18a254694c45ef30ad"
SRC_URI[arria10_tse_core.sha256sum] = "4f14d2265adb85e21a71a84d98700bd2968f6ca0fdf9782d082304090ed25f70"
SRC_URI[arria10_tse_periph.sha256sum] = "f6a35d6303c375f41d7ca0efb2a12aadf0b4f535a3a77efa5a4c5ae0e6df8704"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "c321a42f188789c1d68ccf30e54dc6a91d0db4fb33771f7102088093c7467cf8"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "0498c9c97e48e2e6de97410b998d6f9d751c630e233071234b146d2ee399f268"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

PROVIDES = "virtual/bitstream"

FILES:${PN} = " \
		/boot \
		/usr/lib/firmware \
		"

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install () {
	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		if [[ "${MACHINE}" == *"agilex7_dk_si_agf014e"* ]]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
		else
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${D}/boot/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi
	
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [ "${MACHINE}" == "agilex5_modular" ]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e"* ]]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
			if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_tsnconfig2_ghrd.core.rbf ${D}/boot/tsnconfig2.core.rbf
			fi
		else
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
		fi
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [ "${MACHINE}" == "agilex5_modular" ]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e"* ]]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
			if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/aic0.core.rbf
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/debug2.core.rbf
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_tsnconfig2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/tsnconfig2.core.rbf
			fi
		else
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/aic0.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/debug2.core.rbf
		fi
	fi

	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		if [[ "${MACHINE}" == *"agilex7_dk_si_agf014e"* ]]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
		else
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_hps.xml ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/hps.xml
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_PERIPH_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi
}

addtask install after do_configure before do_deploy
addtask deploy after do_install
