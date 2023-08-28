SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2023.06"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex5_mudv_bbr ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_gsrd_core \
		"

SRC_URI:agilex5_mudv_cvr ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_gsrd_core \
		"

SRC_URI:agilex5_mudv_pcr ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_gsrd_core \
		"

SRC_URI:agilex5_mudv_mod ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_gsrd_core \
		"

SRC_URI:agilex5_mucv ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_gsrd_core \
		"

SRC_URI:agilex5_devkit ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex5_gsrd_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_nand_${ARM64_GHRD_CORE_RBF};name=agilex5_nand_core \
		"

SRC_URI:agilex7_dk_si_agf014ea ?= "\
		${GHRD_REPO}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_gsrd_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_nand_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_nand_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_${ARM64_GHRD_CORE_RBF};name=agilex7_dk_si_agf014ea_pr_core \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_persona0.rbf;name=agilex7_dk_si_agf014ea_pr_persona0 \
		${GHRD_REPO}/agilex7_dk_si_agf014ea_pr_persona1.rbf;name=agilex7_dk_si_agf014ea_pr_persona1 \
		"
#TODO
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

SRC_URI[agilex5_gsrd_core.sha256sum] = "adb614fe00eadcaa2d56a04801ac7890b097639f7fdafab76203bcbe5707b39d"
SRC_URI[agilex5_nand_core.sha256sum] = "5ab342a09fee670713a2d62add50d680a8b113cd6ed6552fd04bb3990078b8f6"

SRC_URI[agilex7_dk_si_agf014ea_gsrd_core.sha256sum] = "adb614fe00eadcaa2d56a04801ac7890b097639f7fdafab76203bcbe5707b39d"
SRC_URI[agilex7_dk_si_agf014ea_nand_core.sha256sum] = "5ab342a09fee670713a2d62add50d680a8b113cd6ed6552fd04bb3990078b8f6"
SRC_URI[agilex7_dk_si_agf014ea_pr_core.sha256sum] = "e8f52b61992f299ac9d44789c6086f52e61ffc30f97f37fc934e553285240caf"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona0.sha256sum] = "069a9c4bcb9b38b3796c3ad1b37b9436699766f39614c8dee3f6c6e92ecc13d5"
SRC_URI[agilex7_dk_si_agf014ea_pr_persona1.sha256sum] = "118daa70dfd82c0689b5811d9a973eecd67bc3d6840b1a6fc5454ac6afa9c05e"

SRC_URI[agilex7_dk_si_agf014eb_gsrd_core.sha256sum] = "00f1fb17a628051fefaf2986818e7ee3a2727d8e5ac670a302c4023d8a03dea5"

SRC_URI[agilex7_dk_si_agi027fb_gsrd_core.sha256sum] = "a750404a6aa24cfcc7713ab714656f50b9e00c1d4ca41c671ade050e5d24df8d"
SRC_URI[agilex7_dk_si_agi027fa_gsrd_core.sha256sum] = "603d31c52ecea11a179dbdbdd3281873c4d222066b707af6ed9515557bbc29a8"
SRC_URI[agilex7_dk_dev_agf027f1es_gsrd_core.sha256sum] = "40d7f31d6dec2dae9ea9ccd6120ac726064c97cfa376a855a02c3d016bee6e92"

SRC_URI[stratix10_gsrd_core.sha256sum] = "29894dc542880d10a14af9b1ae925458c5f60c9f7979d7194989b14fa0be1380"
SRC_URI[stratix10_nand_core.sha256sum] = "068fb0ad75e54b9c3ac25ebfb87927e99444de8f4964dc22b2a40cd036a8fae7"
SRC_URI[stratix10_pr_persona0.sha256sum] = "60797a554903a46ea0efd447bdf27ad097166fe3dde172641d0f6433e479c9e6"
SRC_URI[stratix10_pr_persona1.sha256sum] = "974e02e79ee0c016249cfec226eddcc7d2498ae490f74958c46903caaace1267"

SRC_URI[arria10_gsrd_core.sha256sum] = "d2e43eef22201d3b6fee663e0ef1ef2074a5f83a391d2fc91d2d376bf1996018"
SRC_URI[arria10_gsrd_periph.sha256sum] = "ea5417f22da85361f0c7b8a79c611395356a95b1bf175b8c60443f8c2475ba16"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "5bfb658293f83b30ab7136cf4875625f0602da4e86bd2873bb05692655996f95"
SRC_URI[arria10_nand_core.sha256sum] = "467e78ee961cc734f53ca94cdeafbcc3ef3e2cf286356dd1b78e2fb6773f9078"
SRC_URI[arria10_nand_periph.sha256sum] = "06ee0147738861ae944dda8b9bdf8f1313831ff85f408d0357c6d3207ffa18c2"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "ba655fae59524db405f8d7fa3554322fbdbfbeaaa43406304fbc2d6bcbec7bc8"
SRC_URI[arria10_pcie_core.sha256sum] = "61a8fe2e26cb22006b4e2f2eb66fca9f3b6a60446f5214286d98df6d45efc8e5"
SRC_URI[arria10_pcie_periph.sha256sum] = "3e91d174f6e511b27629ca600406b4a375e67023d91e7fd851e6e4ecdc2a633f"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "d1b9e92dd0f1b7a38105ddd9ce647988d8fd1a30b195624ce3445d7a9569908c"
SRC_URI[arria10_pr_core.sha256sum] = "df36018dcdeac1b09637fd8f54509d9b3bb32e62d4b9b0baefd17ba24a64267e"
SRC_URI[arria10_pr_periph.sha256sum] = "95c26068cf203554ba22a740587fb0f6b864382ec71fe1fb6c22ebaf00c7c3ad"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "0a4be831aa65f79a76a3dac37e77c9590f9667dc1f182f13a66f124f28278ba8"
SRC_URI[arria10_pr_persona0.sha256sum] = "21094f8112677b72ab5fa052184ffe714c7530d6f0af370647bbe895e7df78f1"
SRC_URI[arria10_pr_persona1.sha256sum] = "d89057ab6ecd184aa1bf2b1de1b9d63cf36d8f9a2bc497139fc3a95ba2bf76b9"
SRC_URI[arria10_qspi_core.sha256sum] = "a607d2d5717c272d22692c954f0b35a675279755e23ce3c09f80a3049ca62d5e"
SRC_URI[arria10_qspi_periph.sha256sum] = "ad61ae6d1a05b1890398eecb7781cf8844afd145339d7dc1b759c0c0f8605a9e"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "50f6764caff40e4daf5b6ac12a4bdc5c5699e63eaa5ec65ce29f2135835f3d0a"
SRC_URI[arria10_sgmii_core.sha256sum] = "1ceaedde57363023e02fef45123fe55f092c5e54e4f03415706d6479c47ed72e"
SRC_URI[arria10_sgmii_periph.sha256sum] = "07f42aa7ab440dae5f100716e4168fb29147bddd220f6cff91947598175ab88d"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "3468385903964f17eda85d983059090dac788668dd8861f52b9fe11bb8cc58e4"
SRC_URI[arria10_tse_core.sha256sum] = "26dfd4461317f78065a60cb28a1256fec3fc266ac0c4c1a02dc5d9bf63d97292"
SRC_URI[arria10_tse_periph.sha256sum] = "efbaf890806af28c8954a2f5d7753e937f9b7e0bfaeb53439a455ea6148fea64"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "08c2ce9fd0d965a188bb6c28b5c3c65c75d90de4cf803045f8cb08df2b51ca16"

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

	#TODO: no GHRD yet, just use agilex7 dummy ghrd for now
	if [[ "${MACHINE}" == "agilex5_devkit"* ]]; then
		install -D -m 0644 ${WORKDIR}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/agilex7_dk_si_agf014ea_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf

	fi

	if [[ "${MACHINE}" == *"agilex5"* ]]; then
		install -D -m 0644 ${WORKDIR}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	fi
}

do_deploy () {
	if [[ "${MACHINE}" == "agilex5_devkit"* ]]; then
		install -D -m 0644 ${WORKDIR}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/agilex7_dk_si_agf014ea_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/nand.core.rbf
	fi

	if [[ "${MACHINE}" == *"agilex5"* ]]; then
		install -D -m 0644 ${WORKDIR}/agilex7_dk_si_agf014ea_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
	fi

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
