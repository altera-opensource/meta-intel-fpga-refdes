SUMMARY = "Altera SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2025.08"
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

SRC_URI[agilex3_gsrd_core.sha256sum] = "ad3d25cf2cf0e0c82d13fb7d6d78c638982318065d83dc6ec4f8ff48f0de5609"

SRC_URI[agilex5_dk_a5e065bb32aes1_gsrd_core.sha256sum] = "4fd55f84a01c3cb6264ad7f752b6e95ec4aa5c801cf62028bbff01ba6881e4f2"
SRC_URI[agilex5_dk_a5e065bb32aes1_emmc_core.sha256sum] = "528f92be2b9681e54e87bae88f6b8dbcf8e86be0a6e9f6c2f88449b3cf2ffbcd"
SRC_URI[agilex5_dk_a5e065bb32aes1_tsnconfig2_core.sha256sum] = "de7b3038b4a55ddb5adc48c9c68fa5acd5cf18a86ca49aeb3ee3f578381570b7"

SRC_URI[agilex5_mk_a5e065bb32aes1_gsrd_core.sha256sum] = "df6f5472325a804fb62925807076a839dc8b4835b936c36f37b9db45ab93ebc4"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "5a7e7602ca550ec13ff1c5dc14d65d2cb945acd73072164ee88684a89c8d8771"
SRC_URI[agilex7_dk_si_agf014eb_nand_core.sha256sum] = "10408263c2208d8115611e218632ba5648490791359f0cfc871aa21d4e490511"
SRC_URI[agilex7_dk_si_agf014eb_pr_core.sha256sum] = "4cf484134ab4ad7fdc6f765352dce03d27e94249246432b3586e94f2917aa44a"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona0.sha256sum] = "292ef266469da78e052605310d7f6aae68c32617fe286b3e264da0f108aef1d4"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona1.sha256sum] = "10b32d5fb693657699b7274fbc29dab8fe1ae47eb7378d3ea87ca58b4d81bdf2"

SRC_URI[agilex7_dk_si_agi027fc_gsrd_core.sha256sum] = "91b89d021aa087d82718be8cba3b0c964d5e84e69c86f9743960f357018c48ba"
SRC_URI[agilex7_dk_dev_agf023fa_gsrd_core.sha256sum] = "77f19a27a7f83666dcc4eb892701584ef9940620524ceefdb6e0938abefea42c"

SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "0c2d8f94b70e89ce58db3bf91d599d915a48c32accf8038f28071fe1a100e642"

SRC_URI[stratix10_htile_gsrd_core.sha256sum] = "bb2b3b9e630c217e915f09dba9f62c48ac279e96c25172752d5328b5b5a0da09"
SRC_URI[stratix10_htile_nand_core.sha256sum] = "480d246d6e7ca799d9bed6f33c8701bb7f211d9cc3bb16d6ab95871166739b80"
SRC_URI[stratix10_htile_pr_core.sha256sum] = "954c1769098df2102b3b4c4e53f267363ea8a4ecab2b459c88e05ea3b4f07715"
SRC_URI[stratix10_htile_pr_persona0.sha256sum] = "890272cdbee98d68567a490ac843ba4dced2f92be2941931e1aaab832203ef4a"
SRC_URI[stratix10_htile_pr_persona1.sha256sum] = "7611cf69b1816dbf38e1ece1a55a606d06b0a726126a2bff690999ef59fb4a32"

SRC_URI[arria10_gsrd_core.sha256sum] = "d7677d4603eeb151b6b1bc26e385349c95d85d12a0b5d533c4bebaf43b868ed2"
SRC_URI[arria10_gsrd_periph.sha256sum] = "487be8fb45adc7810e509bf6c31af3fdcd89819847c10cd53d13b373f7d1dd8c"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "47abd77400cc0efc03874f5dca67cd111335e398cb383155454c0deaf172f545"
SRC_URI[arria10_nand_core.sha256sum] = "14d56dacda6f884f5061173c513e931a77bfcad1de15a7e8b908037b7d3c0905"
SRC_URI[arria10_nand_periph.sha256sum] = "3294b4131627d90e69303e8ef599eee2f9f5cab236172f36aedea15b275de796"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "13942d2292e44a5107468fd8a0caa48ef89dd708b2791818df31e739dddc468b"
SRC_URI[arria10_pcie_core.sha256sum] = "4a7537a74a3efca182e5335b840e53b100531433812c8c0c06412510dcfbdb61"
SRC_URI[arria10_pcie_periph.sha256sum] = "4f08c042244316c7c8c6e140bb085c178113beebad56ca6a4cbf5acca5ed60ad"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "b702323993b5bbd2d9e46d6c172069f8fe1981c73536272df3cefe420ccc594a"
SRC_URI[arria10_pr_core.sha256sum] = "c50ef5011ae9435fc08263f85bdd9851a12c7e5d20ad49782dfcfbc9a5bb6506"
SRC_URI[arria10_pr_periph.sha256sum] = "06a803d905373b919e2bd7b366a1e239e75a15a15fa1258e7e86a36149920016"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "23bfe13835a213f9f323c7859954a03eeba3f8f4664a0cf88809370894804c5f"
SRC_URI[arria10_pr_persona0.sha256sum] = "92b13a7018c63b9d7ae3e8968fbce47b2a045220311867517694e30475290fcc"
SRC_URI[arria10_pr_persona1.sha256sum] = "a510a9b6f523d25e5481413a45d15fd201e48704ef9cd1893d2ac9ef141abc3b"
SRC_URI[arria10_qspi_core.sha256sum] = "c294b57806d649998a1121b13e21fb39a6dd42640c9a321929ca28a0d68077f9"
SRC_URI[arria10_qspi_periph.sha256sum] = "0cf554743e3179e70a8f0f60331d3fbcc18d072faa13b5a6e5f51dc36da0d30c"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "4de613fbda648a4bcae5362f587db9ae98814f20b5a1c64543a2c11e51ef282c"
SRC_URI[arria10_sgmii_core.sha256sum] = "35b0a367403703a64269aca49f7a0f45e7f7b460a7d8cd5a9b9f040a8d66ad68"
SRC_URI[arria10_sgmii_periph.sha256sum] = "4f0672ec5b07c2c0e6f164915b3c7cc82a58fcef8409dce4aa5a5c8c69779e47"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "5846d22e082b9898ef25cf468e8d31c1e756c9c6d6dd240051af4ab94c9593ce"
SRC_URI[arria10_tse_core.sha256sum] = "6b28ab55b27395cbf0b4888b6b2ea565d01c3ddc5ad8b60b6adfc6435735fddc"
SRC_URI[arria10_tse_periph.sha256sum] = "c1b2bf868a8fe7e263e4ccca2c04d32d12745cbf71f28855a841468f88fd8916"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "f53d966dbe2e16065e402904918acbcf94e60f6fec3651a881c55d206a2f06d9"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "3decce7cfeff2b33882d96fcceeb7f48d99140815cfe083bf3d65a86f71f7548"

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
		if [ "${MACHINE}" == "agilex5_mk_a5e065bb32aes1" ]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e"* ]]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			if [ "${IMAGE_TYPE}" == "nand" ]; then
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			fi
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_tsnconfig2_ghrd.core.rbf ${D}/boot/tsnconfig2.core.rbf
			if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
			fi
		fi
	fi

	if [[ "${MACHINE}" == *"agilex3"* ]]; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex3"* ]]; then
		install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
	fi

	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [ "${MACHINE}" == "agilex5_mk_a5e065bb32aes1" ]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_${IMAGE_TYPE}_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e"* ]]; then
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
			if [ "${IMAGE_TYPE}" == "nand" ]; then
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			fi
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_tsnconfig2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/tsnconfig2.core.rbf
			if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/aic0.core.rbf
				install -D -m 0644 ${WORKDIR}/sources/${MACHINE}_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/debug2.core.rbf
			fi
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
