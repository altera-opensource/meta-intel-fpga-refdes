SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2023.09"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex7_dk_si_agf014ea ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_gsrd_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_nand_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_nand_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_pr_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_persona0.rbf;name=agilex7_dk_si_agf014ea_pr_persona0 \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_persona1.rbf;name=agilex7_dk_si_agf014ea_pr_persona1 \
		"

SRC_URI:agilex7_dk_si_agf014eb ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014eb_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014eb_gsrd_core \
		"

SRC_URI:agilex7_dk_si_agi027fb ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fb_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fb_gsrd_core \
		"

SRC_URI:agilex7_dk_si_agi027fa ?= "\
		${GHRD_REPO}/agilex7_dk_si_agi027fa_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agi027fa_gsrd_core \
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

SRC_URI:arria10 ?= "\
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_hps.xml;name=arria10_${IMAGE_TYPE}_hps_xml \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF};name=arria10_${IMAGE_TYPE}_core \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF};name=arria10_${IMAGE_TYPE}_periph \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona0.rbf;name=arria10_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona1.rbf;name=arria10_pr_persona1", "", d)} \
		"

SRC_URI:cyclone5 ?= "${GHRD_REPO}/cyclone5_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF};name=cyclone5_${IMAGE_TYPE}_core"

SRC_URI[agilex7_dk_si_agf014ea_gsrd_core.sha256sum] = "27fc4cfa2da31b1be46218d7c15edcf2bcc7936f6c771a682456c9d28b2640e2"
SRC_URI[agilex7_dk_si_agf014ea_nand_core.sha256sum] = "652eb0a8cbd880b17169f80c9ad1a73e2d2e6c67999255a2426e45a6cb3df358"
SRC_URI[agilex7_dk_si_agf014ea_pr_core.sha256sum] = "d65bfe291d67e0c5a559aafc2e01f99cd002298717d20a06122816d6f08d7c46"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona0.sha256sum] = "c802daaed1b95329ac1913c724631f0a2af8cb3f4af5867286d93c2ef6c64c2c"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona1.sha256sum] = "60c5ee3140ccbee5b8364b70646ba9e53be1f224522ce0e33b57da97d3785cc6"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "f4e544e8ebbb0ae2f040694c9edc42bc692968c54e9be685f291acdb2956dff6"

SRC_URI[agilex7_dk_si_agi027fb_gsrd_core.sha256sum] = "9c919b132ca7c59f6e40db2972161e16cfebb0c1b02d75e6ff0a5fa8222da7bd"
SRC_URI[agilex7_dk_si_agi027fa_gsrd_core.sha256sum] = "831c66c602f36ce71e4ad211f73a1210fbba1ba57cb67d147ab437c133be349c"
SRC_URI[agilex7_dk_dev_agf027f1es_gsrd_core.sha256sum] = "b218fcf079ee87d3f8580d349aace0f89a8a8f3e9839726a337dc12b78812617"
#TO DO: ADD FP82 HASH
#SRC_URI[agilex7_dk_dev_agm039fes_gsrd_core.sha256sum] = "40d7f31d6dec2dae9ea9ccd6120ac726064c97cfa376a855a02c3d016bee6e92"

SRC_URI[stratix10_gsrd_core.sha256sum] = "af948babd60c7e2fd102a7d84c44559b6378af8b3c9636b7711b30da4585757c"
SRC_URI[stratix10_nand_core.sha256sum] = "1225391c7c5d55a242e900d7618f784e281b19a202a7d5980398efee367e395b"
SRC_URI[stratix10_pr_persona0.sha256sum] = "8b155cff0058e74d0121c17217826456b7ccb52d4c82d1026d355b9c47ff5d9d"
SRC_URI[stratix10_pr_persona1.sha256sum] = "7101c92244d4082ade7fa60e78ce371d3ec9ddb45d47aa493cf8c579d5b16ec1"

SRC_URI[arria10_gsrd_core.sha256sum] = "f384bc4e6abc3ce033fb30091464948dbf2b8687ea11127b0d2f8fb04284b58e"
SRC_URI[arria10_gsrd_periph.sha256sum] = "4f0f116f7f2c7e81c1fbe50714f3cd88824dfe0d6fb3cc888280331b9f575273"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "4b74ff2ae4b673806074fe1640485a72607c0b67c0e99a6dea801d9736e46526"
SRC_URI[arria10_nand_core.sha256sum] = "5423974f59c4d5cded891cd2fee7ce099c6552835cae89364a3f83a2a3f728eb"
SRC_URI[arria10_nand_periph.sha256sum] = "6f1efd2737ea8f253c54cd13a4b878b195b8a517ff966cea90c7a180bdd666e1"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "a9f1c11af9f14c4a6bbe93bec16a3599b4d1e321db7709a45eb59c18e2a202ee"
SRC_URI[arria10_pcie_core.sha256sum] = "3db4a9888ffca189e43689ef844b35b276919c2ac6a4ab73f01fe5b71c69b8ad"
SRC_URI[arria10_pcie_periph.sha256sum] = "4f95a79a14d8deec09866411adf637c7935c7ada0783ae2e60d17c9ec59940be"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "d2108c5b1232ca8f6bac968573faa007429396e7293a26f3cbb603d025f1628f"
SRC_URI[arria10_pr_core.sha256sum] = "364b1c270655be975416de753fa33489e3a6a3badc43eb1dd9fba9837ce2431d"
SRC_URI[arria10_pr_periph.sha256sum] = "a2d8cd88b219e4206ee4db1d289851950d69858212dad55d2d68045112695fb1"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "351394f2cca50da3a4a5b1bb5eaa44e543fec8c74e1ea84444d6393f4aebe1cd"
SRC_URI[arria10_pr_persona0.sha256sum] = "b453656a242cd482ed3f9a8b8744175c981f603ae120be0c8f96012abc5e130c"
SRC_URI[arria10_pr_persona1.sha256sum] = "920bc914c1ffd7a81771dd2f2a6fdf027e1cb85fd6cf9d110f4d50ed23e303c7"
SRC_URI[arria10_qspi_core.sha256sum] = "b4dcfb7378a485eb6ff1e1b2b32df51c6385cd1b39a659ceb9ab6788f0d220cd"
SRC_URI[arria10_qspi_periph.sha256sum] = "6695981036a3f4ee4532430232d56982ab3ad3a7fe970d19db7230f36a6f50ca"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "a8c9c4d7b3cf81a5779c450c0c47a783f151d4665bf2b4f4fec09181b3608bbc"
SRC_URI[arria10_sgmii_core.sha256sum] = "9b741fe6966da705d2b163013086344b3f69285576fe66dcc961677d0f6318c7"
SRC_URI[arria10_sgmii_periph.sha256sum] = "2b6861db7fd0d5d81b2e2be23de0fca17aa1cae762696e89240e0c4a9e90569b"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "cd1f737541fead5a269c9672ff6d65ae217b306a7ff7b18d2b7634fe42317409"
SRC_URI[arria10_tse_core.sha256sum] = "0a8a89eed7da30fadf423bbed37dd5706c08d29849740927213f96f35935fb21"
SRC_URI[arria10_tse_periph.sha256sum] = "b5d150f3fcecad2f8172b997c45ff288ea98ec3492e3335173bea085b79b881a"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "4b7b546e25f8664a35719d8155687de396af2c9b81534fc1ae51f32f5331c6e6"

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
	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
    #TODO
    if [[ "${MACHINE}" == "agilex7_dk_si_agf014eb" ]]; then 
		   install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
    else
		   install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	  fi

		if [[ "${MACHINE}" == "agilex7_dk_si_agf014ea" ]]; then
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
	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		#TODO
    if [[ "${MACHINE}" == "agilex7_dk_si_agf014eb" ]]; then 
		   install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
    else
		   install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
	  fi

		if [[ "${MACHINE}" == "agilex7_dk_si_agf014ea" ]]; then
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
