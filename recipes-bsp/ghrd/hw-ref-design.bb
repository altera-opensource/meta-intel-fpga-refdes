SUMMARY = "Altera SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2026.04"
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
		${GHRD_REPO}/agilex7_dk_si_agf014eb_emmc_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_emmc_core \
		${GHRD_REPO}/agilex7_dk_si_agf014eb_sgmii_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_sgmii_core \
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
		${GHRD_REPO}/stratix10_htile_emmc_${ARM64_GHRD_CORE_RBF};name=stratix10_htile_emmc_core \
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

SRC_URI[agilex3_gsrd_core.sha256sum] = "5d85db6b8e220371b76ef45d9c9e5b52031df53929a4d0f8fc723c91ada26a82"

SRC_URI[agilex5_dk_a5e013bm16aea_gsrd_core.sha256sum] = "384ca31826449daea13653a388cfb7955d509a4209e57523553835403fab0c72"

SRC_URI[agilex5_dk_a5e065bb32aes1_gsrd_core.sha256sum] = "6a49ab5fd77fc871a3f590ad427381caf9673e95319543045b3c5ff2e01d952a"
SRC_URI[agilex5_dk_a5e065bb32aes1_emmc_core.sha256sum] = "6459555f05b842ecd1848199e7c3e28e429d62ba1fc8e623ef13dd976f1383f3"
SRC_URI[agilex5_dk_a5e065bb32aes1_tsnconfig2_core.sha256sum] = "9d166eadca4e73bc5b9a5df9ac087b6b2183edda3fb2e65a47e7be9be3f8c709"

SRC_URI[agilex5_mk_a5e065bb32aes1_gsrd_core.sha256sum] = "73377e5bb4d4aa459c0760e5b253c2fc5d6440b926612350bb19aa78df0c20fe"

SRC_URI[agilex7_dk_si_agf014eb_emmc_core.sha256sum] = "2073f371a7b359e285c46a76b27d88036adb769ce174588dcc8261484bf604f4"
SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "ac6ad02751d2e3527a79e1811b11e283fa807a7e9f4a4f07955e6ea12e8b33bf"
SRC_URI[agilex7_dk_si_agf014eb_nand_core.sha256sum] = "472cba520d2c770cd4621104d30f35f898f71f9a72808617569d4081d58290eb"
SRC_URI[agilex7_dk_si_agf014eb_pr_core.sha256sum] = "9031fd817bae56e174c4864744403a30414b7603b3055072c181d17a9f23d260"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona0.sha256sum] = "98c1db0c1ceea5327abfc69bde2fb324bdb1cfb0199c00dcd2f78d04a0c37bf1"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona1.sha256sum] = "46cb5cfe1f2947127e7a3ae518d804207289b69f3438dace0af7337e09cad97c"
SRC_URI[agilex7_dk_si_agf014eb_sgmii_core.sha256sum] = "ac6ad02751d2e3527a79e1811b11e283fa807a7e9f4a4f07955e6ea12e8b33bf"

SRC_URI[agilex7_dk_si_agi027fc_gsrd_core.sha256sum] = "f1aa10d250466779700464ee300cb8c57af4b325ef7a741f1d30e843b396a630"
SRC_URI[agilex7_dk_dev_agf023fa_gsrd_core.sha256sum] = "f9009f21296f76777913a7b018b8cf119f1ddb4ab13b5634096bc48a37d996e3"

SRC_URI[agilex7_dk_dev_agm039ea_gsrd_core.sha256sum] = "f40a2e73972c510bac966632de8c435574274dcf1ebfa7dc0e6086f3e49998b2"
SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "5b764b70318c31daf811d805cac66eaac665ce863ede665909d2ba3ec0bea689"

SRC_URI[stratix10_htile_emmc_core.sha256sum] = "7a1d5fd938fb9610bd28f44063e353dc09f1cf5cb1bc769ebfd8de4d85370121"
SRC_URI[stratix10_htile_gsrd_core.sha256sum] = "6efdd7b6323a703845735fa5583e63646ece8b84e48195d07903c7b178f08872"
SRC_URI[stratix10_htile_nand_core.sha256sum] = "1f1666771fe141a42767d9a9c229d7faf78dfc06c900df0ef43267c7850e8f5a"
SRC_URI[stratix10_htile_pr_core.sha256sum] = "a709f16b8f2ed4aebc1e5bfb8f3b8e51f24d8bd1fc1380c74cd5be15d8d480a3"
SRC_URI[stratix10_htile_pr_persona0.sha256sum] = "d4242f1ac7ae2665684e90c69ded33687582f599b67ad58dc1113ee3c98a29da"
SRC_URI[stratix10_htile_pr_persona1.sha256sum] = "a4e675d4636934252f8ffef7fba4151b1ef27ac6f7744b0a5369cecdbf72ee5d"

SRC_URI[arria10_gsrd_core.sha256sum] = "f9601eb1700ca72f0b82699287f854d1b75af37814da9aec8352295c7ce0ef96"
SRC_URI[arria10_gsrd_periph.sha256sum] = "3586dc115cf94d2dcfa087ef6cf06b9f4aba906a54154e01bb500dd0450b96b5"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "5b24ac2d3e772a8476878e3b3fe8f76f95db279ac589133af76b12bcb1380e99"
SRC_URI[arria10_nand_core.sha256sum] = "4ff433c7cf8442a034dc8a0c2c70ef7c7120d51e2883b0cf1e03b49109a75c4c"
SRC_URI[arria10_nand_periph.sha256sum] = "73cf0f86a33cb798a7fbb1d09f7fa40d8808d8f90c46f69e0efbc842569f273d"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "bfe7a95fa3fb0de844a0ef1f5ae64358e0b4e5b585419796a03740f20b96de56"
SRC_URI[arria10_pcie_core.sha256sum] = "6ab72e6c256b9c2ab88a6a7b1fdc5d7b9e1f7a71644fbd3dbd483aa789cf14f6"
SRC_URI[arria10_pcie_periph.sha256sum] = "5ef0af3de9003c1058baff9f89f5631cf003e3c8a2296f560962214894f885db"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "37d6ce958c2cd341baac2141c6c5c4bc1488c7266bb7ad250d5f46cf6d968063"
SRC_URI[arria10_pr_core.sha256sum] = "ce9c12ec0d9808898d22b341f49f825c7e39d2d496aa094636c8315b4dd768ed"
SRC_URI[arria10_pr_periph.sha256sum] = "9510e8cb0db541421ace469f759d2392ef181295cdf7df1d1773477dd8b87478"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "30b9347a23972d90cb40ee9fd97272999d74e6c105e350d986172275e12f92c6"
SRC_URI[arria10_pr_persona0.sha256sum] = "6809732e913231f5e7d60c325f0c846e0cc8038acc2f531a492676ed562405a5"
SRC_URI[arria10_pr_persona1.sha256sum] = "b5d72a5e2d7dad1601eeaee7c78dfc1fb6ea2feed9382a5cda64a8154c00fe51"
SRC_URI[arria10_qspi_core.sha256sum] = "6b8a799628c9905ed0b019b93e3b8dd200941da67d293e372bbfb661233bf7c6"
SRC_URI[arria10_qspi_periph.sha256sum] = "8955111965b9976f383dd520fcf3f459755e3c69829d37deb19b32d6d12336ee"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "8c47f4a11fa272a0d90019760e4c33014b531721c7b79947655657a92f72b040"
SRC_URI[arria10_sgmii_core.sha256sum] = "8714c2855722550ecc29082141eeaf73accf787571f4ed71eb262afbcfc17570"
SRC_URI[arria10_sgmii_periph.sha256sum] = "28262993ad3122fd77c2eaa0e8dbd4057a4b774f14bef033dd30539062909e0f"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "90199cfd9f8f5c5bbeca557a248f5333c81aad0e5915817592332515ad2e26a7"
SRC_URI[arria10_tse_core.sha256sum] = "32909a6a79c8e68f21e30acec706281a7abf0cd830bec5e61b4e52696ed3fa75"
SRC_URI[arria10_tse_periph.sha256sum] = "e8a5c207fea306f7cfc60e7743c638d83a73d112d839540786e4ad940a89c2e7"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "d03baf90a1b50fe7c50324aa96d7098fa4656cd5d095c8f1559c13a11d68076e"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "63dae5a869244e25f492f2d6499b12b89bc1f1c367419d2081689ea2d60da124"

S = "${UNPACKDIR}/sources"

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
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_sgmii_${ARM64_GHRD_CORE_RBF} ${D}/boot/sgmii.core.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
		else
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)}; then
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${D}/boot/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi
	
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [ "${MACHINE}" == "agilex5_mk_a5e065bb32aes1" ]; then
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e"* ]]; then
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			if [[ "${MACHINE}" != "agilex5_dk_a5e013bm16aea" && "${MACHINE}" != "agilex5_dk_a5e065bb32aes1_b0" ]]; then
				if [ "${IMAGE_TYPE}" == "nand" ]; then
					install -D -m 0644 ${UNPACKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
				fi
				install -D -m 0644 ${UNPACKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
				install -D -m 0644 ${UNPACKDIR}/${MACHINE}_tsnconfig2_ghrd.core.rbf ${D}/boot/tsnconfig2.core.rbf
				if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
					install -D -m 0644 ${UNPACKDIR}/${MACHINE}_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
					install -D -m 0644 ${UNPACKDIR}/${MACHINE}_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
				fi
			fi
		fi
	fi

	if [[ "${MACHINE}" == *"agilex3"* ]]; then
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex3"* ]]; then
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
	fi

	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [ "${MACHINE}" == "agilex5_mk_a5e065bb32aes1" ]; then
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
		elif [[ "${MACHINE}" == *"agilex5_dk_a5e"* ]]; then
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
			if [[ "${MACHINE}" != "agilex5_dk_a5e013bm16aea" && "${MACHINE}" != "agilex5_dk_a5e065bb32aes1_b0" ]]; then
				if [ "${IMAGE_TYPE}" == "nand" ]; then
					install -D -m 0644 ${UNPACKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
				fi
				install -D -m 0644 ${UNPACKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
				install -D -m 0644 ${UNPACKDIR}/${MACHINE}_tsnconfig2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/tsnconfig2.core.rbf
				if [ "${MACHINE}" == "agilex5_dk_a5e065bb32aes1" ]; then
					install -D -m 0644 ${UNPACKDIR}/${MACHINE}_aic0_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/aic0.core.rbf
					install -D -m 0644 ${UNPACKDIR}/${MACHINE}_debug2_ghrd.core.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/debug2.core.rbf
				fi
			fi
		fi
	fi

	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		if [[ "${MACHINE}" == *"agilex7_dk_si_agf014e"* ]]; then
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_sgmii_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/sgmii.core.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
		else
			install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_emmc_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/emmc.core.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)}; then
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_hps.xml ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/hps.xml
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_CORE_RBF}
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_PERIPH_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${UNPACKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi
}

addtask install after do_configure before do_deploy
addtask deploy after do_install
