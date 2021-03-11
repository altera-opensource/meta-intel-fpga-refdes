SUMMARY = "Intel socfpga Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

RBO_RELEASE_VER ?= "2020.11"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"
ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"

SRC_URI_cyclone5 ?= "\
		 https://pg-arc.altera.com/tools/socfpga_refdes/hw/cv/ghrd_oobe/21.1std/801/2/soc_system.rbf;name=c5_ghrd_core \
		 "

SRC_URI_arria10 ?= "\
		${GHRD_REPO}/${IMAGE_TYPE}/a10_${IMAGE_TYPE}/${A10_GHRD_CORE_RBF};name=a10_${IMAGE_TYPE}_core \
		${GHRD_REPO}/${IMAGE_TYPE}/a10_${IMAGE_TYPE}/${A10_GHRD_PERIPH_RBF};name=a10_${IMAGE_TYPE}_periph \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/a10_${IMAGE_TYPE}/persona0.rbf;name=a10_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/a10_${IMAGE_TYPE}/persona1.rbf;name=a10_pr_persona1", "", d)} \
		"

SRC_URI_stratix10 ?= "\
		${GHRD_REPO}/${IMAGE_TYPE}/s10_${IMAGE_TYPE}/${ARM64_GHRD_CORE_RBF};name=stratix10_${IMAGE_TYPE}_core \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/s10_${IMAGE_TYPE}/persona0.rbf;name=stratix10_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/${IMAGE_TYPE}/s10_${IMAGE_TYPE}/persona1.rbf;name=stratix10_pr_persona1", "", d)} \
		"

SRC_URI_agilex ?= "\
		${GHRD_REPO}/${IMAGE_TYPE}/agilex_${IMAGE_TYPE}/${ARM64_GHRD_CORE_RBF};name=agilex_${IMAGE_TYPE}_core  \
		"

SRC_URI[c5_ghrd_core.sha256sum] = "aaf2c880f95d7428a178ecf4c24c5c5a0d5ee2eb664b2894e363d834c47a184a"

SRC_URI[a10_gsrd_core.sha256sum] = "2dbe18340e064f97f4c7cf42094665bc9d7b57a0612aed00247170fae980a2a1"
SRC_URI[a10_gsrd_periph.sha256sum] = "6551c7961cd5f5224d78eb9df855f733a14ec047e4d3bc72d3cfc2a5052c1996"
SRC_URI[a10_nand_core.sha256sum] = "49a9020637042807d4035a29cb4ff30ea019913ac83285af4d9eada5b1a66d48"
SRC_URI[a10_nand_periph.sha256sum] = "43e2d66e1d04f80a214a0ce28fbb1838d82eb2d118c2733f9d2b81fa55dde444"
SRC_URI[a10_pcie_core.sha256sum] = "de8b682aa100cc52c21ee0d87319664e032edacffb7403330e657e2430e43eeb"
SRC_URI[a10_pcie_periph.sha256sum] = "dc4a3c419ad42a5c210471f2514217d90b1cea992e9c052d591717bf88b5e4cd"
SRC_URI[a10_qspi_core.sha256sum] = "ac0be9473b0fe0822fc0413ed5c6b73f987dfee308377b995ac45c91adfad2d0"
SRC_URI[a10_qspi_periph.sha256sum] = "758205ab2e424d25fdc9dc9fb1ddbb18103412a92dd1b3af4d7cd179f81c2c66"
SRC_URI[a10_tse_core.sha256sum] = "0c8adb820d52da09cfe7f07e76add050563aae8261a799d45a19cbd6c930f832"
SRC_URI[a10_tse_periph.sha256sum] = "d1ca5da218cf326ab5150ddc32406e693e69011f06077eae9d64b56c5ec49cfd"
SRC_URI[a10_pr_core.sha256sum] = "6f49214baedb6cc0b9ed58cd8b27003027694137f01cf198b4411da2df6e0273"
SRC_URI[a10_pr_periph.sha256sum] = "bade42a40d27a6b8f377abd4d0054d6cd53a4bebc37a9d4a42bb7d787e6e5d09"
SRC_URI[a10_pr_persona0.sha256sum] = "d7974d0fceff7bc052db6c349825a26c6bd8bbbee62ce15dcdf026fbff5065b5"
SRC_URI[a10_pr_persona1.sha256sum] = "46eb7f19b85a743235c620f3bc73ddd38b5feae12a29f6a5d62eef6cba2245b2"

SRC_URI[stratix10_gsrd_core.sha256sum] = "35fc101e4f8bafa40d4b0620e3886a0982c7cd3cab36d831a64795da16247ad6"
SRC_URI[stratix10_pcie_core.sha256sum] = "f428d197f4e292c15853e8272190652b44a253eee6b7cc831d96127e14126d23"
SRC_URI[stratix10_sgmii_core.sha256sum] = "a2ed1a8acf9088be44469ac8a04f62d90b1dc3c47ed0cfa58461df6aa25a376e"
SRC_URI[stratix10_qspi_core.sha256sum] = "47e9ae722b2afd2729c37033cdbda3e984894754c730b8622b7b42e94dc3018c"
SRC_URI[stratix10_pr_core.sha256sum] = "a084f390c97fc3be5c682d3bcd679eb1ced0590385ec126fbf4500b038736112"
SRC_URI[stratix10_pr_persona0.sha256sum] = "09d46fc1c3108df7c2dc499440583816cd66611b6b0586e111f13dc1dea49fc3"
SRC_URI[stratix10_pr_persona1.sha256sum] = "af4043de7171616d25676f3b93e72217bb316c7fa5657eb8312731d656a24179"

SRC_URI[agilex_gsrd_core.sha256sum] = "5d0289954cc5905ca52337fafa4f107dc1f87760096ef307fb94344a180d54b4"

PV = "${RBO_RELEASE_VER}"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES_${PN} += " \
		 /boot \
		 /lib/firmware \
                "

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy[nostamp] = "1"

do_install () {
	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${C5_GHRD_CORE_RBF} ${D}/boot/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi
}

do_deploy () {

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${C5_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}/${A10_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}/${A10_GHRD_PERIPH_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
                install -D -m 0644 ${WORKDIR}/${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}/${ARM64_GHRD_CORE_RBF}
        fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}/persona0.rbf
		install -D -m 0644 ${WORKDIR}/persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}/persona1.rbf
	fi

}

addtask install after do_configure before do_deploy
addtask deploy after do_install
