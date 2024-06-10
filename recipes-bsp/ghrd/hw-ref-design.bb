SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2024.06"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex5_dk_a5e065bb32aes1 ?= "\
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_gsrd_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_nand_core \
		${GHRD_REPO}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e065bb32aes1_emmc_core \
		file://agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf \
		file://agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf \
		"

SRC_URI:agilex5_dk_a5e013bb32aesi0 ?= "\
		${GHRD_REPO}/agilex5_dk_a5e013bb32aesi0_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_dk_a5e013bb32aesi0_gsrd_core \
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
		${GHRD_REPO}/stratix10_pr_persona0.rbf;name=stratix10_pr_persona0 \
		${GHRD_REPO}/stratix10_pr_persona1.rbf;name=stratix10_pr_persona1 \
		"

SRC_URI:stratix10_htile ?= "\
		${GHRD_REPO}/stratix10_htile_gsrd_${ARM64_GHRD_CORE_RBF};name=stratix10_htile_gsrd_core \
		${GHRD_REPO}/stratix10_htile_nand_${ARM64_GHRD_CORE_RBF};name=stratix10_htile_nand_core \
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

SRC_URI[agilex5_dk_a5e065bb32aes1_gsrd_core.sha256sum] = "c844995425120a6cd5e52f727e10f72113ef85645b2c63cd0f243d168e87433f"
SRC_URI[agilex5_dk_a5e065bb32aes1_nand_core.sha256sum] = "10de43a5c2a480fb020d9ca1f6a2da8ba4b3845b112edb99f1e629c6fac9d82e"
SRC_URI[agilex5_dk_a5e065bb32aes1_emmc_core.sha256sum] = "2172953235d75002cc47e7cd11742ce63da5c034ee9e13e5d54e026694430a41"

SRC_URI[agilex5_dk_a5e013bb32aesi0_gsrd_core.sha256sum] = "a522268f06984a75f25ee7012b30035454122e0cb8beb5918ecc9363d83e6f12"

SRC_URI[agilex5_modular_gsrd_core.sha256sum] = "f7a9c311eafcf0e83220d9e6eeaf05aa7780b6e1fe436b97ac6d38aa39a2b078"

SRC_URI[agilex7_dk_si_agf014ea_gsrd_core.sha256sum] = "3cbbdcdce3454813dc62f9fefd9f7ad64ea672bf8234545d454c2bfa13ee2de6"
SRC_URI[agilex7_dk_si_agf014ea_nand_core.sha256sum] = "9c01a0f759950bcd1a6c710e90dd5f334a13bc28f68e0342c79777dfd4baa851"
SRC_URI[agilex7_dk_si_agf014ea_pr_core.sha256sum] = "85050fc3aff91b3ca960f63c9314e48038820721e645df1ca26e8a25d50c3777"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona0.sha256sum] = "48071a9550a6213895e94503d50993c830ebd7535c65679e8c2f65ad85f046f3"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona1.sha256sum] = "e6d1c3342c361eaaf55c9df8b414bdd2c6397c8f7c120ceab7f94d669c800c71"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "b0daa8057fd1c43a04540a2c3e0bb10fea302445f2c4dfdcd4174a60e07aa401"
SRC_URI[agilex7_dk_si_agf014eb_nand_core.sha256sum] = "f8b9253d65bfe4afc7f4eadd428fab8f9ecb73c1be63ed83c7654cba2402cf7c"
SRC_URI[agilex7_dk_si_agf014eb_pr_core.sha256sum] = "59a7c8cef001d3d94f9123146bdabaf99b6b0aef7020b90ed1a1fa1898a624ed"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona0.sha256sum] = "b98964bd908ce09a036f3cdb056d604e96e03c54bcef307ebd25d809e0e6964c"
SRC_URI[agilex7_dk_si_agf014eb_pr_persona1.sha256sum] = "71cbc33713d11938226c7cde6e331981b389e6c18eec52e8fb8ec0196f527408"

SRC_URI[agilex7_dk_si_agi027fb_gsrd_core.sha256sum] = "7cfe6778b6f14a58b7e326851b2097b6fd7cf276c19a47593fb46b46663b4b86"
SRC_URI[agilex7_dk_si_agi027fa_gsrd_core.sha256sum] = "703c9c2c4bdc2fafc2bd634b9acd85e9c3848c23a5ea99f9e484b4703adc4d91"
SRC_URI[agilex7_dk_si_agi027fc_gsrd_core.sha256sum] = "7365acbb6e167fd5257b9d12931d3a6beb24f2bc3de40fc60d70b87c52abfa87"
SRC_URI[agilex7_dk_dev_agf027f1es_gsrd_core.sha256sum] = "949e652fcf381cecf5af9f5746db0946dd691c71e7e2eaa66c24c669cc3ef337"

SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "567da52243958d4e1cf773bcb9a7a9017b95ecf99fc2963d336b0bbeac790466"

SRC_URI[stratix10_gsrd_core.sha256sum] = "e1ce2420a5586f424dc522b047612c59f037e777ef33c6119b131cf2b16129ca"
SRC_URI[stratix10_nand_core.sha256sum] = "316f4230522ae5d7288add5b4b1098e97a002e4479ed525c97a1a25cf7f31066"
SRC_URI[stratix10_pr_persona0.sha256sum] = "ced3a3d4b1c606891dacbdf43291dc214f34a849883121ea725a202ad8927881"
SRC_URI[stratix10_pr_persona1.sha256sum] = "7d9acb8eff1f50c0b576dda4dc21c497f62805de722bd972191693f87263ca4e"

SRC_URI[stratix10_htile_gsrd_core.sha256sum] = "e8900eb749afb2024b236e6391c8fe4b1ffabf7f3bbc8379465f0b5dce31883f"
SRC_URI[stratix10_htile_nand_core.sha256sum] = "d1d74f66bbe53537a31bfdcf001988e2d770029a25d07d386bf26f9e1f379ea2"
SRC_URI[stratix10_htile_pr_persona0.sha256sum] = "1943f818c749b93ca8d528150c109e4adb95a623fa592432388b24140b08082c"
SRC_URI[stratix10_htile_pr_persona1.sha256sum] = "989203936d54e364c1898e8eb9b728fe543e6b9afccf8a959770e795b2eae008"

SRC_URI[arria10_gsrd_core.sha256sum] = "5f155049669bcb4061a9c29426912bb8969ff6ece0387905fa977910f8b0ae23"
SRC_URI[arria10_gsrd_periph.sha256sum] = "19527b6adbc626225518f7c821691419a523802ae541efa7fbe6f0e97beafc2d"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "a583ce9b880b32d62e1d6139da399b7e56223ba48c8f5eb6993a025f473e8604"
SRC_URI[arria10_nand_core.sha256sum] = "f953d293925502c926c4e3cea2b65e22e55a076341a5d48f4b51cbfc8fbc0f68"
SRC_URI[arria10_nand_periph.sha256sum] = "f13516580384f10c0406357beae1a18e97b617a2d67d4ba8dabed24ad4cd6bfa"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "5bdb08d29427c8d5ed6e839497218f39ed00cc9fa7c3aab0810ad7c0873962da"
SRC_URI[arria10_pcie_core.sha256sum] = "e9363bcba2a7492baef7093286b22ad6e06fc8e5d9069bc8edc9076ba175fca1"
SRC_URI[arria10_pcie_periph.sha256sum] = "71c2e025bd12cc3558e5ee2a711628220116c46dab64250b817ee1eae854a60f"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "f8ba4085634e82cf60ad04e525b56b4f89707775b84bc456860c6e520988d847"
SRC_URI[arria10_pr_core.sha256sum] = "fd9feb3a8a6bd77783b8d6c07f134e6984c3a559ae6dbabfb5b3db98cc449a97"
SRC_URI[arria10_pr_periph.sha256sum] = "fe686b553e1be4e32c596828935d82a8b64dbe4a83d1feb791d754f395bcfd68"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "db4819bb44f21dc7dcdc31533bc0eef5a54ab00c7803dd7863386225c21f7820"
SRC_URI[arria10_pr_persona0.sha256sum] = "d92b646be197a37c5c32c59731a3a91b774b0b616103189865f613542039eff8"
SRC_URI[arria10_pr_persona1.sha256sum] = "5bb0c093ee441a78715f2935cc9ab4c3b814e660536d40598ad38c8913818103"
SRC_URI[arria10_qspi_core.sha256sum] = "98b0794d06ff5bd690907ca7a0201a6e6d6a7c9156fb0e40e357b3017efb5466"
SRC_URI[arria10_qspi_periph.sha256sum] = "1c1f0d590a8ae62a7363b076c3bd93ea73842b2bf5f410873fe9d41072ed15f8"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "274f519148c07220f9f7cb4a601a9eb4abdb2641ebe67f609d07072dead42b84"
SRC_URI[arria10_sgmii_core.sha256sum] = "b35f7ae5dbf5eb5f597ce23e9e4143ae448f144d61b7da358c860984bf66a932"
SRC_URI[arria10_sgmii_periph.sha256sum] = "93a6ee0a618142ed00f48c487235340005fd64ee546315244234ec6ec6d899e0"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "01b76134e8e7f4560db8ea86dc4d746c761385aba7e72ac6ca4d3b501ac9777f"
SRC_URI[arria10_tse_core.sha256sum] = "f3557736d2ea918321efbe9acbd21bd4434d35528640a3b23b4dd5b5866c4a0b"
SRC_URI[arria10_tse_periph.sha256sum] = "d3124465e6554f07f6c098067a3382c1bcd9cac5115e716555150bfe4f54229e"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "c0388e096ac00fee6ed839afe4225d00bd25295f2ff7a46963d76b8565de960f"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "0498c9c97e48e2e6de97410b998d6f9d751c630e233071234b146d2ee399f268"

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
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
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
	
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [[ "${MACHINE}" == "agilex5_modular" || "${MACHINE}" == "agilex5_dk_a5e013bb32aesi0" ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		else
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_emmc_${ARM64_GHRD_CORE_RBF} ${D}/boot/emmc.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_aic0_ghrd.core.rbf ${D}/boot/aic0.core.rbf
			install -D -m 0644 ${WORKDIR}/agilex5_dk_a5e065bb32aes1_debug2_ghrd.core.rbf ${D}/boot/debug2.core.rbf
		fi
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == *"agilex5_"* ]]; then
		if [[ "${MACHINE}" == "agilex5_modular" || "${MACHINE}" == "agilex5_dk_a5e013bb32aesi0" ]]; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${ARM64_GHRD_CORE_RBF}
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
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10_htile", "true", "false", d)}; then
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
