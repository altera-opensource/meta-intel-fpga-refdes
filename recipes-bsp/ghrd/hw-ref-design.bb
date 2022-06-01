SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2022.06"
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

SRC_URI[agilex_gsrd_core.sha256sum] = "6fc2b0dce182a8fa212cfe58d08a4f2dab1a22a12c87e87df4e3859f9397966a"
SRC_URI[agilex_nand_core.sha256sum] = "bdd1d0ab421990938424a3c30283efd3b69dc11a49a9d12f50750b340148fd4b"
SRC_URI[agilex_pr_core.sha256sum] = "573311ed82e22774d7f0c5462b416e694e15c8f2a88c6ad932a5b7224642cc53"
SRC_URI[agilex_pr_persona0.sha256sum] = "6f3af6fe0496e3776039c91e2bbf6d271d651755451fc90e2855079407c31498"
SRC_URI[agilex_pr_persona1.sha256sum] = "d6c164897069d594173c2864ac813a7bcabb060767b2f60882a2e346c270d28a"

SRC_URI[stratix10_gsrd_core.sha256sum] = "c62afdb083090f05730bedf2512e2a7c41e7a305c50ecbb86bbc1bde2edb31b0"
SRC_URI[stratix10_nand_core.sha256sum] = "b21e0e3b8cf36d918ef8be1027d4f74e39f4e3d1ba5813a98c9a24127b2fa35d"
SRC_URI[stratix10_pr_persona0.sha256sum] = "6ff51a1d52d3d035f4af47435da03120b20d96fc3dc1072889408a672a42a7f1"
SRC_URI[stratix10_pr_persona1.sha256sum] = "4a92be7f033312dd1fc402bc85ee73bed449d6477068eabdc7f52287f84c1379"

SRC_URI[arria10_gsrd_core.sha256sum] = "6fa0a52dceb838fc285ab771caba1ee80e5a88619534ed88617a1bae0dbd9fbb"
SRC_URI[arria10_gsrd_periph.sha256sum] = "dab0530158cae35ed9b2e5e775e2b9d1fc8127569ceb030d3355b8d8195b89fb"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "4747a8872fc5bb3f5c631c19ed679b953108a2196e8e5ccf7b3301f00a77ed56"
SRC_URI[arria10_nand_core.sha256sum] = "bd76978a03d4aa8b6f90e16584909b4ec4c060d71c99679a6af39372cdf5b733"
SRC_URI[arria10_nand_periph.sha256sum] = "32ba86211d2f002ba1926e46a2fa81526505132344d941a7aaeada3c002d37c7"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "33dfe8df65491217d34cc4cae1d63acd921754139f92419f64b902e821d02760"
SRC_URI[arria10_pcie_core.sha256sum] = "6c1cfe9d80643e89d20669e60b48674e7ac136302995017ea7f02e8e8ab2c353"
SRC_URI[arria10_pcie_periph.sha256sum] = "4f5c259c406603155a28cd9df1e4a8998ae5836faa248f2c544f921b39b7ec06"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "2a734a49327f22525d5a40cd126027b1115fe4e84730e1a79d0485fc003d97e8"
SRC_URI[arria10_pr_core.sha256sum] = "f5bac6ff1dccf8e37556ad411fcbbf094d6c5d77599dc9d9974c66024450173c"
SRC_URI[arria10_pr_periph.sha256sum] = "f553cbfc0877f9cbf8b6fc22c46a5f9d7f626d4dae823aee2b2460bfbddb5b42"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "0e2f65f505a6a4ec12371abf776a76589961fcec88922b77a25aea841c7fe8ee"
SRC_URI[arria10_pr_persona0.sha256sum] = "ca8920d040d35a797427914c27a5d34591b0db4aba41a15738a25dcc8bb77af2"
SRC_URI[arria10_pr_persona1.sha256sum] = "d51e21e4c31e396f204eee2009fee01751a5de9f701441149dde6576cea149f7"
SRC_URI[arria10_qspi_core.sha256sum] = "9ce2ef81e0b4d3d9b2402e0c3792cc72de50317980ecef94581485397ca269d6"
SRC_URI[arria10_qspi_periph.sha256sum] = "9c7d5d5343bae36887f2c094a742232251f4928ae6bd8a3b2471f2191865486d"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "3179c161af2b0c274654335bb0d1579818291e18914605fed06a21efa4b1ed68"
SRC_URI[arria10_sgmii_core.sha256sum] = "e1346becbdb642b0e10bdc1d5d965a3e3c70afe318bd38db1f69e094832b3242"
SRC_URI[arria10_sgmii_periph.sha256sum] = "227f0b1a93020993abcc27256475b7e457b9e1a6ffb98ecc2e5ee66774c4ded2"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "0073b674ad754adf44c82f9b6e3f98fdfca0099a22058c27056c3aaa47a4914f"
SRC_URI[arria10_tse_core.sha256sum] = "0d11503a8900ea40c3ef18bba30d33c8f96cf0045634af8285b83d8ce6672039"
SRC_URI[arria10_tse_periph.sha256sum] = "56132714dc08fdfb173f4e079b7a99ffc2c61dbfad77439affe84678eefe8283"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "a82459c200903e6d7316c816f8c370198f68c386bc4b42693f70b19f33bf18df"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "6c3bc32e8f336846c6b4b40bb7785e76f7fc8210821e71dd017be76aa673551c"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES:${PN} = " \
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