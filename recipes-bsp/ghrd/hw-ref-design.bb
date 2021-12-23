SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2021.11"
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

SRC_URI[agilex_gsrd_core.sha256sum] = "5d633ee561d5cc8c22b51211a144654fdc0be47ee14b07ac134074cbff84eb8b"
SRC_URI[agilex_nand_core.sha256sum] = "bf51d78f6eb404812c01fcbd95ac1f22acc94d6a4e36d55c397ec2390d60dd5e"
SRC_URI[agilex_pr_core.sha256sum] = "073a52b9cdeca7752a77ffccad02ae27df0b666b9f3fe37cd08688f7cf653719"
SRC_URI[agilex_pr_persona0.sha256sum] = "4f945871e57ab264fe3836385829b3016fb7917e4dee6e5a3a5f2c5469a68771"
SRC_URI[agilex_pr_persona1.sha256sum] = "8257fccc4ce6514eb45c40b390513361d44d1c547252065ff7ed3b7212c4e4a3"

SRC_URI[stratix10_gsrd_core.sha256sum] = "1309d705729b5f47fa4bdef7757399f178ea553ba753fcc5e9e7e4d965f41db3"
SRC_URI[stratix10_nand_core.sha256sum] = "d782c05085f8f13cb792b687fd002773e0897e4d7ecf5451994b1823d62cdc92"
SRC_URI[stratix10_pr_persona0.sha256sum] = "60af20604f8756b251d3bff23ceaf8c4edec6d37cf4558ed763e1e311ab4c81e"
SRC_URI[stratix10_pr_persona1.sha256sum] = "c555e432574431ec0d2596fe7dc3f4ace86899add91599023d26127a9d78293b"

SRC_URI[arria10_gsrd_core.sha256sum] = "2f777d991527ca7b4fd27488bbdb8286c60942628e6c3614c917840574d4a10b"
SRC_URI[arria10_gsrd_periph.sha256sum] = "2bdc776fc33c7e277785e1c054227297beb3afca5eb5228d4209d256964e4464"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "7a977bb69db241666cd06509eea63f2b726b064ccf0461e95fb6f524ca7efa3d"
SRC_URI[arria10_nand_core.sha256sum] = "555903ac44986d17eae3e664c90de12479367873cdb6ba5b4b8794545b0efd26"
SRC_URI[arria10_nand_periph.sha256sum] = "ff1fbebf8c1efa24f0bce2582ad26d023def0f788bd9e0445a74419d716d1a2e"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "62465334c0caab5d674d161a06c301cdbede62ee2924afb4bb2610fc40502530"
SRC_URI[arria10_pcie_core.sha256sum] = "94b0e8ff0b6ddfa42e5b61b5f153471b30fad7c4387c920a2677b977d2b8bdcd"
SRC_URI[arria10_pcie_periph.sha256sum] = "46bf96583918c715df9ba9244a67c45f9aa0a184625c5a7c27b25abdebd47a3a"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "7c726c0287f4207ab7ff0b69e5b29459a07fd0ca853363b99be14bc904184fd7"
SRC_URI[arria10_pr_core.sha256sum] = "c8a11dd31b86f51b8d0660fd27815da6b931f51826e7a1e6989cc68e9122c7d8"
SRC_URI[arria10_pr_periph.sha256sum] = "3b12d02aca3dff0cea2a6d06c780f301e7da3993bc9de4e06b313716cdeecd2d"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "ad119cfcdaa1b6512e2624245a0a41f1482df2176e8d92da31c9674101e09593"
SRC_URI[arria10_pr_persona0.sha256sum] = "4859a4837c3aa6ab4866b97159f98a8dc0882997be3a4f2359ddce7b9970c42c"
SRC_URI[arria10_pr_persona1.sha256sum] = "7ee3a605926a85c30009b2d813571871bf8fe70d64916bef4a57bf4c9f614768"
SRC_URI[arria10_qspi_core.sha256sum] = "b2ab5ec57305e456d29a9220b85b243a5aa782c9fe5b7fec5f13c48b2fe5ff37"
SRC_URI[arria10_qspi_periph.sha256sum] = "e971695576fed9df696030244137cd4318e4e9e8589d60bbfe2c9b3f3352c398"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "806039a71d8069c0d922a9ffee4941891f9baca68b4689eb50813317a5c0ca8c"
SRC_URI[arria10_sgmii_core.sha256sum] = "5c017db1b10eb8d0b19c8860f533c77cd902960a6e06b6cff8ff458d67a3ff00"
SRC_URI[arria10_sgmii_periph.sha256sum] = "51ac7ec386e269127938d467c4f81731196861005323e4f1104b92a4b21c7163"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "be5d89c96416c72bfaf02637b74f24063a0efafc63f7d8b3472f9dc34a746b7c"
SRC_URI[arria10_tse_core.sha256sum] = "2f0ad713dd59395501c39987125a114b281efb5656358347c57d4f25db117003"
SRC_URI[arria10_tse_periph.sha256sum] = "fa6633a77895f2d37cb1a2044de681f81f601f7dd07f4914dd04e684aa161925"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "41cf2cab7486ac7a2acd81eb3d6bc48c39062c0199aa810d416cf9c88a484a53"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "6c3bc32e8f336846c6b4b40bb7785e76f7fc8210821e71dd017be76aa673551c"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES:${PN} += " \
		/boot \
		/lib/firmware \
		"

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy[nostamp] = "1"

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
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_hps.xml ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/hps.xml
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_PERIPH_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi
}

addtask install after do_configure before do_deploy
addtask deploy after do_install