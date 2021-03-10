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
		${@bb.utils.contains("A10_IMAGE_TYPE", "", "", "${GHRD_REPO}/gsrd/a10_gsrd/${A10_GHRD_CORE_RBF};name=a10_gsrd_core", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "", "", "${GHRD_REPO}/gsrd/a10_gsrd/${A10_GHRD_PERIPH_RBF};name=a10_gsrd_periph", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "nand", "${GHRD_REPO}/nand/a10_nand/${A10_GHRD_CORE_RBF};name=a10_nand_core", "", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "nand", "${GHRD_REPO}/nand/a10_nand/${A10_GHRD_PERIPH_RBF};name=a10_nand_periph", "", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "pcie", "${GHRD_REPO}/pcie/a10_pcie_gen2x8/${A10_GHRD_CORE_RBF};name=a10_pcie_core", "", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "pcie", "${GHRD_REPO}/pcie/a10_pcie_gen2x8/${A10_GHRD_PERIPH_RBF};name=a10_pcie_periph", "", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "qspi", "${GHRD_REPO}/qspi/a10_qspi/${A10_GHRD_CORE_RBF};name=a10_qspi_core", "", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "qspi", "${GHRD_REPO}/qspi/a10_qspi/${A10_GHRD_PERIPH_RBF};name=a10_qspi_periph", "", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "tse", "${GHRD_REPO}/tse/a10_tse/${A10_GHRD_CORE_RBF};name=a10_tse_core", "", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "tse", "${GHRD_REPO}/tse/a10_tse/${A10_GHRD_PERIPH_RBF};name=a10_tse_periph", "", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "pr", "${GHRD_REPO}/pr/a10_pr/${A10_GHRD_CORE_RBF};name=a10_pr_core", "", d)} \
		${@bb.utils.contains("A10_IMAGE_TYPE", "pr", "${GHRD_REPO}/pr/a10_pr/${A10_GHRD_PERIPH_RBF};name=a10_pr_periph", "", d)} \
		"

SRC_URI_stratix10 ?= "\
		${@bb.utils.contains("S10_IMAGE_TYPE", "", "", "${GHRD_REPO}/gsrd/s10_gsrd/${ARM64_GHRD_CORE_RBF};name=stratix10_gsrd_core", d)} \
		${@bb.utils.contains("S10_IMAGE_TYPE", "pcie", "${GHRD_REPO}/pcie/s10_pcie_gen3x8/${ARM64_GHRD_CORE_RBF};name=stratix10_pcie_core", "", d)} \
		${@bb.utils.contains("S10_IMAGE_TYPE", "sgmii", "${GHRD_REPO}/sgmii/s10_sgmii/${ARM64_GHRD_CORE_RBF};name=stratix10_sgmii_core", "", d)} \
		${@bb.utils.contains("S10_IMAGE_TYPE", "qspi", "https://pg-arc.altera.com/tools/socfpga_refdes/mainline/98/designs/s10_soc_devkit_ghrd_qspi/ghrd.core.rbf;name=stratix10_qspi_core", "", d)} \
		"

SRC_URI_agilex ?= "\
		${GHRD_REPO}/gsrd/agilex_gsrd/${ARM64_GHRD_CORE_RBF};name=agilex_gsrd_core  \
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
SRC_URI[stratix10_gsrd_core.sha256sum] = "35fc101e4f8bafa40d4b0620e3886a0982c7cd3cab36d831a64795da16247ad6"
SRC_URI[stratix10_pcie_core.sha256sum] = "f428d197f4e292c15853e8272190652b44a253eee6b7cc831d96127e14126d23"
SRC_URI[stratix10_sgmii_core.sha256sum] = "a2ed1a8acf9088be44469ac8a04f62d90b1dc3c47ed0cfa58461df6aa25a376e"
SRC_URI[stratix10_qspi_core.sha256sum] = "47e9ae722b2afd2729c37033cdbda3e984894754c730b8622b7b42e94dc3018c"
SRC_URI[agilex_gsrd_core.sha256sum] = "5d0289954cc5905ca52337fafa4f107dc1f87760096ef307fb94344a180d54b4"

PV = "${RBO_RELEASE_VER}"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES_${PN}-bitstream += " \
		 /boot \
                "
PACKAGES = "${PN}-bitstream"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy[nostamp] = "1"

do_install () {
	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${C5_GHRD_CORE_RBF} ${D}/boot/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
	fi
}

do_deploy () {

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${C5_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)} ; then
		if ${@bb.utils.contains("A10_IMAGE_TYPE", "nand", "true", "false", d)}; then
			install -D -m 0644 ${WORKDIR}/${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/a10_nand/${A10_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/a10_nand/${A10_GHRD_PERIPH_RBF}
		elif ${@bb.utils.contains("A10_IMAGE_TYPE", "qspi", "true", "false", d)}; then
			install -D -m 0644 ${WORKDIR}/${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/a10_qspi/${A10_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/a10_qspi/${A10_GHRD_PERIPH_RBF}
		else

			install -D -m 0644 ${WORKDIR}/${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${A10_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/${A10_GHRD_PERIPH_RBF}
		fi
	fi

	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
                install -D -m 0644 ${WORKDIR}/${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${ARM64_GHRD_CORE_RBF}
        fi

}

addtask install after do_configure before do_deploy
addtask deploy after do_install
