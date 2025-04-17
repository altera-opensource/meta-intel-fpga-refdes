SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2025.04"
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
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_tsnconfig2_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_tsnconfig2_core \
		"

SRC_URI:agilex5_dk_a5e013bb32aes_5s ?= "\
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_5s_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_5s_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_5s_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_5s_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_5s_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_5s_emmc_core \
		${GHRD_REPO}/agilex5_dk_a5e013bb32aes_5s_tsnconfig2_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aes_5s_tsnconfig2_core \
		"

SRC_URI:agilex5_mk_a5e065bb32aes1 ?= "\
		${GHRD_REPO}/agilex5_mk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_mk_a5e065bb32aes1_gsrd_core \
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

SRC_URI:agilex7_dk_dev_agm039fb ?= "\
		${GHRD_REPO}/agilex7_dk_dev_agm039fb_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_dev_agm039fb_gsrd_core \
		"

SRC_URI:agilex7_dk_dev_agf023fa ?= "\
		${GHRD_REPO}/agilex7_dk_dev_agf023fa_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_dev_agf023fa_gsrd_core \
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

SRC_URI:agilex3 ?= "\
		${GHRD_REPO}/agilex3_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex3_gsrd_core \
		"

SRC_URI:cyclone5 ?= "${GHRD_REPO}/cyclone5_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF};name=cyclone5_${IMAGE_TYPE}_core"

SRC_URI[agilex5_dk_a5e065bb32aes1_gsrd_core.sha256sum] = "4e1b175cd79af1edc05fa98f5e7cb4d7113da98e4cb1c02b8d1efb079695d5a7"
SRC_URI[agilex5_dk_a5e065bb32aes1_nand_core.sha256sum] = "e06048d20dddc1e1325cb42d830a9aaba169171f59495147ddc9ac070a42ebc0"
SRC_URI[agilex5_dk_a5e065bb32aes1_emmc_core.sha256sum] = "c052d9942b3e6162d908f8bab231495e442840310a47977c08dfe3c84f8d39cf"
SRC_URI[agilex5_dk_a5e065bb32aes1_tsnconfig2_core.sha256sum] = "63ba29f21ef573c1a14cfdf45fd3fa5e2c03ca5117bfa4dcdf20c244e6e20d42"

SRC_URI[agilex5_dk_a5e013bb32aesi0_gsrd_core.sha256sum] = "f138fb8a317d0e0b4c0cef259a98c024af79089a783024a59e5e6d6f49130c8b"
SRC_URI[agilex5_dk_a5e013bb32aesi0_nand_core.sha256sum] = "d4ec29fe65b1e856dece3b8eab983667b13cf87eb2fd8af01c82ed72c963024c"
SRC_URI[agilex5_dk_a5e013bb32aesi0_emmc_core.sha256sum] = "0632e3d5f1aa0876a5c9d402dbffe2b142c2689ecd82ac130fedaf070b7eb8ef"

SRC_URI[agilex5_mk_a5e065bb32aes1_gsrd_core.sha256sum] = "4750469fa98656ab1c9f3241a2c92c15603151206fa6229ef5972967a4d94c33"

SRC_URI[agilex7_dk_si_agf014ea_gsrd_core.sha256sum] = "01f79cff0d311332a41198df48f74d0c9b63081f5b403b7bbed0336f032ac9f7"
SRC_URI[agilex7_dk_si_agf014ea_nand_core.sha256sum] = "d05a7c8f21b529af09a9ba63a65049bb8e2c2109189af9be1cd8fe024a718927"
SRC_URI[agilex7_dk_si_agf014ea_pr_core.sha256sum] = "a1943611b9274d9033e0305381e1a0233142fe2dd81ac58a6d34b92e1855fa76"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona0.sha256sum] = "b03f4af553561629f67e55b7de5f0a3ea961251e258fc3955fc8e564f7f93e3c"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona1.sha256sum] = "0038ec9dd08a544bf845dd6579e1d4287db9b881b0f51186da1e7fcdcc6edbcd"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "392f4f36a9a4c41abd5295655be378a1b0dd5a16d1dcc54b65d20e724acac184"
SRC_URI[agilex7_dk_si_agf014eb_nand_core.sha256sum] = "02be9a62c7178b37dc364442fd2774b0ab58148d5e0b4aeb77ad79ded2916531"
SRC_URI[agilex7_dk_si_agf014eb_pr_core.sha256sum] = "95f3e4fda6bd102523552fa545572c6a348865e4f450ff8da0cc34bb7677fa8f"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona0.sha256sum] = "54b835d52b18b9f1a0d4f2699fa88d0073fadfdbaad26938144e94e2bee80cd4"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona1.sha256sum] = "dbc58c2110749f4489638b44438fd1497bc1ee57168083395b33861e948ffe73"

SRC_URI[agilex7_dk_si_agi027fb_gsrd_core.sha256sum] = "0900866e66ace3bf22b77accc0b41aafc5ca32f80634de03f79d286b6326bd85"
SRC_URI[agilex7_dk_si_agi027fa_gsrd_core.sha256sum] = "d46e632b36589e3ef267c5df650a653a22fc511309664fa241fcee1e16768162"
SRC_URI[agilex7_dk_si_agi027fc_gsrd_core.sha256sum] = "385b1859389c24d586515ddd82729ec2df8c999a5b2d5895b1a80a40a87a04aa"
SRC_URI[agilex7_dk_dev_agf027f1es_gsrd_core.sha256sum] = "1f08ad8793cde52a3e4e9678f99522008fd768046c84af30083f8c48fd37f346"

SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "3b25a5dc15101bab86a48cdde388e8ca96530fb2334079140956bb60beb084ef"

SRC_URI[stratix10_gsrd_core.sha256sum] = "c43c9726f605016778694e8caa34a52223774e3b0db5c842f24a72df36bcafab"
SRC_URI[stratix10_nand_core.sha256sum] = "18b9cb459cc056b5324744b36f8f4a12aee771c361106ce574615eed8dae819c"
SRC_URI[stratix10_pr_core.sha256sum] = "03e174fc6848e51f07f0e905704b1bf83047b9e9b29c115669cdc0d63dc2364b"
SRC_URI[stratix10_pr_persona0.sha256sum] = "362a5c74e13c1c08671dcb66bbc8668455beddd0a530cb86502ad6dd2df9eb1c"
SRC_URI[stratix10_pr_persona1.sha256sum] = "f3c8f60ef802497bf038e2f22ebd3942a365ffea302f3041ecae7feb2be26229"

SRC_URI[stratix10_htile_gsrd_core.sha256sum] = "35d9a9f9b4549c5e9e73be13ab67dcca104b5abc21378a201130250d89c27935"
SRC_URI[stratix10_htile_nand_core.sha256sum] = "c8734ce95e4722e88401e87c1ade3997c3e5b51342e2ee3c2db8d7942670c307"
SRC_URI[stratix10_htile_pr_core.sha256sum] = "ac0fa1077bee3fa9a3eb0a2fd5cc2cbf0b1b7a8c05591b651104137bfda593ee"
SRC_URI[stratix10_htile_pr_persona0.sha256sum] = "c11bd2d6301f3a8b71ef58d08b4311c4ba000af9c4dc96c4c40d5acf1963a2f9"
SRC_URI[stratix10_htile_pr_persona1.sha256sum] = "0032b37380a4d34b8be6d9240a9287187b5ce520b803a4bb691b2303d7b84fe5"

SRC_URI[arria10_gsrd_core.sha256sum] = "76126a754e6b34c7424f381b6acf29cae500e5d15489cedc5dcc2d2e1ef57862"
SRC_URI[arria10_gsrd_periph.sha256sum] = "d1631724927459999cd8f2577dc0adfd567302df9283f8e795ce53f28a8a886c"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "e7433ea15e1cf5276d4fc215f60f955a4d04cf8b5f9b5ec0b7edb91cf36a68ea"
SRC_URI[arria10_nand_core.sha256sum] = "55d2a4d34d60469b77045c92acac44d84399ba775fd0100304de3462cc4d9bcb"
SRC_URI[arria10_nand_periph.sha256sum] = "533f23962efc021e8d87ce954d89eeb5f4a5e86d6953d0ed82a9538f9bf78421"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "3d2aa95398bccf1ef6d692af97329a7badf35bbcf40f6e1e2131e0b4601cdd5c"
SRC_URI[arria10_pcie_core.sha256sum] = "796b337aac8f1f57c347ab4c89a6ddf07e50ebaa561c55374aa78ebb7eeebef5"
SRC_URI[arria10_pcie_periph.sha256sum] = "275881cd0024da662b7830f1c436bf4438e2db71c974017bc728e25a218f4683"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "f589d96f7547a99910608acb940bf45ebd81ba350c0590cbb263117e0cd15d6d"
SRC_URI[arria10_pr_core.sha256sum] = "93e10a191e3ac7b8b5cbac4e3ba3e66679f7767b29a240cfd73755d9f2d296a9"
SRC_URI[arria10_pr_periph.sha256sum] = "43ec18a49db3f3b24017cc3879f0ecb74656c31d35d48b4054f3dcc1e2f4ff28"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "939de9039bda25d7b02da20110f6dfd0581f5256f574c118c221cd3157ac5ee7"
SRC_URI[arria10_pr_persona0.sha256sum] = "bca9642458d858fa4a86f5658352d190941b62965ee60e0b53b918baca98344c"
SRC_URI[arria10_pr_persona1.sha256sum] = "9123995ae3e3369e9e905ec540b3f1fd9d3195e1d22d99de65bac446633642a6"
SRC_URI[arria10_qspi_core.sha256sum] = "66be8d209fd1f3715f711561dabcd437c0b9e3ff92d68d01b92160cfb4add5a6"
SRC_URI[arria10_qspi_periph.sha256sum] = "083dae6882941b37348c1cacfa24e61b7060baeae90246a8da3ce79511700a58"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "ca134ef87c1909af3308e08ef1e747d6492580d5a0c84a78415b7ba2c4e2ae62"
SRC_URI[arria10_sgmii_core.sha256sum] = "9d5d3179d49eba0d92d3b5dd907500f82e3b3f2ab9d0439dc049e14aa00277cd"
SRC_URI[arria10_sgmii_periph.sha256sum] = "23b6c0faa68e3099fbce383cd286359ee852fdddbaa070af59eb4a3766a77cc9"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "78351855209b9ca87f2fecdb1f4ad256c4cc8722ea6574cd1a398065c2da03ef"
SRC_URI[arria10_tse_core.sha256sum] = "0ee4b377ef6e4d95486329200c033ed93744dcfcd14970c0a59976c54fe9b4e0"
SRC_URI[arria10_tse_periph.sha256sum] = "d3f7f915bbd75ff82d3bae671c9e202322530cd561a347534de2c97f3f0e32b5"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "6f8e5cc7bb2d7aadefea07febfa9e8cc0ee0edabcc538e268418990df05c4d1d"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "3decce7cfeff2b33882d96fcceeb7f48d99140815cfe083bf3d65a86f71f7548"

S ?= "${WORKDIR}/${MACHINE}"

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
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
		else
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
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
	
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [ "${MACHINE}" == "agilex5_mk_a5e065bb32aes1" ]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e"* ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
			if [ "${MACHINE}" != "agilex5_dk_a5e013bb32aesi0" ]; then
				install -D -m 0644 ${WORKDIR}/${MACHINE}_tsnconfig2_ghrd.core.rbf ${D}/boot/tsnconfig2.core.rbf
				if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
					install -D -m 0644 ${WORKDIR}/${MACHINE}_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
					install -D -m 0644 ${WORKDIR}/${MACHINE}_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
				fi
			fi
		else
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
		fi
	fi

	if [[ "${MACHINE}" == *"agilex3"* ]]; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex3"* ]]; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
	fi

	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [ "${MACHINE}" == "agilex5_mk_a5e065bb32aes1" ]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e"* ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
			if [ "${MACHINE}" != "agilex5_dk_a5e013bb32aesi0" ]; then
				install -D -m 0644 ${WORKDIR}/${MACHINE}_tsnconfig2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/tsnconfig2.core.rbf
				if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
					install -D -m 0644 ${WORKDIR}/${MACHINE}_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/aic0.core.rbf
					install -D -m 0644 ${WORKDIR}/${MACHINE}_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/debug2.core.rbf
				fi
			fi
		else
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/aic0.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/debug2.core.rbf
		fi
	fi

	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		if [[ "${MACHINE}" == *"agilex7_dk_si_agf014e"* ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
		else
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
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
