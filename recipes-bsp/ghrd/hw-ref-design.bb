SUMMARY = "Altera SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2026.01"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex5_dk_a5e065bb32aes1 ?= "\
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_emmc_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_tsnconfig2_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_tsnconfig2_core \
		file://agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf \
		file://agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex5_dk_a5e065bb32aes1_b0 ?= "\
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_b0_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_b0_gsrd_core \
		"

SRC_URI:agilex5_dk_a5e013bm16aea ?= "\
		${GHRD_REPO}/agilex5_dk_a5e013bm16aea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bm16aea_gsrd_core \
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

SRC_URI:agilex7_dk_si_agf014eb ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014eb_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_gsrd_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_nand_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_nand_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_pr_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_pr_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_pr_persona0.rbf;name=agilex7_dk_si_agf014eb_pr_persona0 \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_pr_persona1.rbf;name=agilex7_dk_si_agf014eb_pr_persona1 \
		"

SRC_URI:agilex7_dk_si_agi027fc ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fc_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fc_gsrd_core \
		"

SRC_URI:agilex7_dk_dev_agm039fes ?= "\
		${GHRD_REPO}/agilex7_dk_dev_agm039fes_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_dev_agm039fes_gsrd_core \
		"

SRC_URI:agilex7_dk_dev_agm039ea ?= "\
		${GHRD_REPO}/agilex7_dk_dev_agm039ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_dev_agm039ea_gsrd_core \
		"

SRC_URI:agilex7_dk_dev_agf023fa ?= "\
		${GHRD_REPO}/agilex7_dk_dev_agf023fa_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_dev_agf023fa_gsrd_core \
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

SRC_URI[agilex3_gsrd_core.sha256sum] = "0e50347d41c92e5f657f0aa91ed67faf766b7fc48729c36f404e7d9bbaa129ad"

SRC_URI[agilex5_dk_a5e013bm16aea_gsrd_core.sha256sum] = "5b61749b9a9d55c056db52e6f6b1f56bae4a51f0e7efd6c31a18696355425911"

SRC_URI[agilex5_dk_a5e065bb32aes1_gsrd_core.sha256sum] = "62dc15c996a15ee2d721da389f402e8eb1bdb8fae04bba4220a100254f269b6c"
SRC_URI[agilex5_dk_a5e065bb32aes1_emmc_core.sha256sum] = "ec287621e26bf904c5b532e6d7ba32cd2602533d952a76c83af84e423c358c74"
SRC_URI[agilex5_dk_a5e065bb32aes1_tsnconfig2_core.sha256sum] = "74ce4ee62a389f6d3acdc9bb525c98809fc7b1d1e97a32288391e3344c77d785"

SRC_URI[agilex5_mk_a5e065bb32aes1_gsrd_core.sha256sum] = "1727f3bc3b74ce3fdad61f4fca6aa88b33bffa8cb998c15693e5f05671926fc3"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "8007768419a12760bf9aa32911817f9e8471c8a3df755e93b92fcc444bdfff8c"
SRC_URI[agilex7_dk_si_agf014eb_nand_core.sha256sum] = "fb00692e383c998f62c9a3aa18bc53a3416cf125ba5cdce19eeaa8b4bf89dd2c"
SRC_URI[agilex7_dk_si_agf014eb_pr_core.sha256sum] = "9ef719c486f396ee070558de02d1e7d337a48c144f5a91f5fee6d49db8b93ada"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona0.sha256sum] = "c319ed6d7632ade9e5eb4936fcd12fe055369ee439d6d17e811b27795a49fdb3"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona1.sha256sum] = "3a318c9d3ddde734e6897adcccb946a5a3b58d7a1197bdf833c59b8d8918324e"

SRC_URI[agilex7_dk_si_agi027fc_gsrd_core.sha256sum] = "933372a000b3750f9933b1d4bcff201b3c37b3ed1f9a591c2a00da14bfd39633"
SRC_URI[agilex7_dk_dev_agf023fa_gsrd_core.sha256sum] = "5447f5455603b5bed8fac8aeb79f09c15180a4a68169fd4a7188f7d1efa5b15b"

SRC_URI[agilex7_dk_dev_agm039ea_gsrd_core.sha256sum] = "c763a80beb43f9c64393b601714e1ee106fde240a4a33300e89e90123e5dcd1c"
SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "7a90dd52943ffac72ab397bd0f539b2d825af793dfdc5dd6caeac1c2edaaf7fc"

SRC_URI[stratix10_htile_gsrd_core.sha256sum] = "48207b3955d63c16d43957d14573da9fcab703736eb0fd63333742896aad7968"
SRC_URI[stratix10_htile_nand_core.sha256sum] = "bc9845886809d1fae328ab00f3a59eeaf8d589024b0feccfcf07ed982b6a2cd4"
SRC_URI[stratix10_htile_pr_core.sha256sum] = "a4d776c05d39ddf5b580b010990eae547eb5f3f52fb33dd25bfa6fd6cf9b2d06"
SRC_URI[stratix10_htile_pr_persona0.sha256sum] = "b97b161b8b9cd9719d88144173716305c363819bc856abe7444b2c9c21e33448"
SRC_URI[stratix10_htile_pr_persona1.sha256sum] = "246d159a9d334321d676c01425ce20810bd8e2b637a925bd58fd4986efc17582"

SRC_URI[arria10_gsrd_core.sha256sum] = "cc51c7452ada2e6b4fea232bcc419f2b153bab24169596b1df96b5a166ccd81e"
SRC_URI[arria10_gsrd_periph.sha256sum] = "b08eed769e48ac0f0d157dcaa0c6c6eb881294ae19365684bacec5df31eefcb5"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "831278d75c6cddac5d13e48e3328ece057d207914790e75ce3aa24674b6fcd11"
SRC_URI[arria10_nand_core.sha256sum] = "28920894c365a9f01518430b3bb3ebb2b5345a5b5298e65b794c49645c054a1b"
SRC_URI[arria10_nand_periph.sha256sum] = "b06f371cfa25aade8488e8dfbe12ad0873fd54228eec8b2f751c995d80411a28"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "ee55c79cba91fd9848e47e120d381961031b4e729b52472049ee76f31375b588"
SRC_URI[arria10_pcie_core.sha256sum] = "e0bd7bfa84ea8b6a5efc194cd614fdec29a4de3c645db568db78e992b2bb194a"
SRC_URI[arria10_pcie_periph.sha256sum] = "5bf9948fd46b9efc8efb66e9dfddbf3943338e9228cf95a389c3d30ad7c7fdd5"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "19763b0ffc6092d112df8caa8df4f7d85a29d14981bc80c347dfb77da037abf3"
SRC_URI[arria10_pr_core.sha256sum] = "43e3ae9387b23ed16777001ec56e062177b4d29e42759696010d6e50f5e3012b"
SRC_URI[arria10_pr_periph.sha256sum] = "fcff909faf3a9770f32b574253c15178356639b9bae0a62b859e9f314b3041d4"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "719ba89722cd4a84da70f57214ddc63b4c326f22586f74f8a744ac5544861e07"
SRC_URI[arria10_pr_persona0.sha256sum] = "6af48c9d3ab4902acaab2a76b69e4811626367b13808cd9fd89a16c9861d66c5"
SRC_URI[arria10_pr_persona1.sha256sum] = "83dfd575607d299626bdb423777b35a383ba099941f8edd16f2722dedd202516"
SRC_URI[arria10_qspi_core.sha256sum] = "c5aba534a650bdc376295ecb5d908f8a7c2e880f0fa9eca977f2637a278dda64"
SRC_URI[arria10_qspi_periph.sha256sum] = "aebb159aef1eb9ec3da0eed78ce7d193f42fe35fa6ad44e1c193098338c8b0c9"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "b890c8c0ab05b1928a9eb21fdca4a1fa4138171aa3c41779c58bbed17d50311c"
SRC_URI[arria10_sgmii_core.sha256sum] = "9ef309b7ef4157ddfdb4d26b411d96abd9547a09f657b11e28a2590de81e0047"
SRC_URI[arria10_sgmii_periph.sha256sum] = "a38bfcfdd4983f70171a130efe150df311e3ecfdc0c3f4b0b13d1e54a0b97b87"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "b3cc773f38d7207b22508d939a25a9be7df060a349e4403ca0cb876aa55bd3df"
SRC_URI[arria10_tse_core.sha256sum] = "2d044fe6fa067ab6ef7a9f1f947047703d91ce73faadbb736bb1cbd5de2313ef"
SRC_URI[arria10_tse_periph.sha256sum] = "de3116a62c89fd9fdf896ea220c739fa5fa002803f9c5edcab29481ef1fc44da"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "76314d8c4feab5cd1f5386ead444477270bd41bd6f9fc0859d26ace140933a1e"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "63dae5a869244e25f492f2d6499b12b89bc1f1c367419d2081689ea2d60da124"

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
			if [[ "${MACHINE}" != "agilex5_dk_a5e013bm16aea" && "${MACHINE}" != "agilex5_dk_a5e065bb32aes1_b0" ]]; then
				if [ "${IMAGE_TYPE}" == "nand" ]; then
					install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
				fi
				install -D -m 0644 ${WORKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
				install -D -m 0644 ${WORKDIR}/${MACHINE}_tsnconfig2_ghrd.core.rbf ${D}/boot/tsnconfig2.core.rbf
				if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
					install -D -m 0644 ${WORKDIR}/${MACHINE}_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
					install -D -m 0644 ${WORKDIR}/${MACHINE}_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
				fi
			fi
		fi
	fi

	if [[ "${MACHINE}" == *"agilex3"* ]]; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex3"* ]]; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
	fi

	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [ "${MACHINE}" == "agilex5_mk_a5e065bb32aes1" ]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e"* ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
			if [[ "${MACHINE}" != "agilex5_dk_a5e013bm16aea" && "${MACHINE}" != "agilex5_dk_a5e065bb32aes1_b0" ]]; then
				if [ "${IMAGE_TYPE}" == "nand" ]; then
					install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
				fi
				install -D -m 0644 ${WORKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
				install -D -m 0644 ${WORKDIR}/${MACHINE}_tsnconfig2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/tsnconfig2.core.rbf
				if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
					install -D -m 0644 ${WORKDIR}/${MACHINE}_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/aic0.core.rbf
					install -D -m 0644 ${WORKDIR}/${MACHINE}_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/debug2.core.rbf
				fi
			fi
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
