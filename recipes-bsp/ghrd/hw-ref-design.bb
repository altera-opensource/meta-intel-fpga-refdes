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

SRC_URI_arria10 = "\
		${GHRD_REPO}/gsrd/a10_gsrd/${A10_GHRD_CORE_RBF};name=a10_gsrd_core;downloadfilename=gsrd.${A10_GHRD_CORE_RBF} \
		${GHRD_REPO}/gsrd/a10_gsrd/${A10_GHRD_PERIPH_RBF};name=a10_gsrd_periph;downloadfilename=gsrd.${A10_GHRD_PERIPH_RBF} \
		${GHRD_REPO}/nand/a10_nand/${A10_GHRD_CORE_RBF};name=a10_nand_core;downloadfilename=nand.${A10_GHRD_CORE_RBF} \
		${GHRD_REPO}/nand/a10_nand/${A10_GHRD_PERIPH_RBF};name=a10_nand_periph;downloadfilename=nand.${A10_GHRD_PERIPH_RBF} \
		${GHRD_REPO}/pcie/a10_pcie_gen2x8/${A10_GHRD_CORE_RBF};name=a10_pcie_core;downloadfilename=pcie.${A10_GHRD_CORE_RBF} \
		${GHRD_REPO}/pcie/a10_pcie_gen2x8/${A10_GHRD_PERIPH_RBF};name=a10_pcie_periph;downloadfilename=pcie.${A10_GHRD_PERIPH_RBF} \
		${GHRD_REPO}/qspi/a10_qspi/${A10_GHRD_CORE_RBF};name=a10_qspi_core;downloadfilename=qspi.${A10_GHRD_CORE_RBF} \
		${GHRD_REPO}/qspi/a10_qspi/${A10_GHRD_PERIPH_RBF};name=a10_qspi_periph;downloadfilename=qspi.${A10_GHRD_PERIPH_RBF} \
		${GHRD_REPO}/tse/a10_tse/${A10_GHRD_CORE_RBF};name=a10_tse_core;downloadfilename=tse.${A10_GHRD_CORE_RBF} \
		${GHRD_REPO}/tse/a10_tse/${A10_GHRD_PERIPH_RBF};name=a10_tse_periph;downloadfilename=tse.${A10_GHRD_PERIPH_RBF} \
		${GHRD_REPO}/pr/a10_pr/${A10_GHRD_CORE_RBF};name=a10_pr_core;downloadfilename=pr.${A10_GHRD_CORE_RBF} \
		${GHRD_REPO}/pr/a10_pr/${A10_GHRD_PERIPH_RBF};name=a10_pr_periph;downloadfilename=pr.${A10_GHRD_PERIPH_RBF} \
		"

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

PV = "${RBO_RELEASE_VER}"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES_${PN}-bitstream += " \
		 /boot \
                "
PACKAGES = "${PN}-bitstream"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install[noexec] = "1"
do_deploy[nostamp] = "1"

do_deploy () {

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)} ; then
		if ${@bb.utils.contains("A10_IMAGE_TYPE", "NAND", "true", "false", d)}; then
			install -D -m 0644 ${WORKDIR}/nand.${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/a10_nand/${A10_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/nand.${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/a10_nand/${A10_GHRD_PERIPH_RBF}
		elif ${@bb.utils.contains("A10_IMAGE_TYPE", "QSPI", "true", "false", d)}; then
			install -D -m 0644 ${WORKDIR}/qspi.${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/a10_qspi/${A10_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/qspi.${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/a10_qspi/${A10_GHRD_PERIPH_RBF}
		else
			install -D -m 0644 ${WORKDIR}/gsrd.${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/a10_gsrd/${A10_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/gsrd.${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/a10_gsrd/${A10_GHRD_PERIPH_RBF}

			install -D -m 0644 ${WORKDIR}/pcie.${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/a10_pcie/${A10_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/pcie.${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/a10_pcie/${A10_GHRD_PERIPH_RBF}

			install -D -m 0644 ${WORKDIR}/tse.${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/a10_tse/${A10_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/tse.${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/a10_tse/${A10_GHRD_PERIPH_RBF}

			install -D -m 0644 ${WORKDIR}/pr.${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/a10_pr/${A10_GHRD_CORE_RBF}
			install -D -m 0644 ${WORKDIR}/pr.${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/a10_pr/${A10_GHRD_PERIPH_RBF}

		fi
	fi
}

addtask deploy after do_configure
