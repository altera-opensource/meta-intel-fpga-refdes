# Append GSRD SoCFPGA device tree source include files
# As this is custom to GSRD, hence it is not suitable to be upstreamed to meta-altera

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-socfpga-lts:"

DTS_REPO ?= "https://releases.rocketboards.org/release/dts-source"

SRC_URI_append_agilex += "\
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "${DTS_REPO}/agilex/gsrd/0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch;name=agilex_gsrd_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "${DTS_REPO}/agilex/pr/0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch;name=agilex_gsrd_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "${DTS_REPO}/agilex/pr/0001-dts-arm64-intel-enable-FPGA-PR-DTBs-for-Agilex.patch;name=agilex_pr_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "sgmii", "${DTS_REPO}/agilex/sgmii/0001-dts-arm64-intel-enable-Agilex-SGMII-support.patch;name=agilex_sgmii_dts", "", d)} \
			 "

#rename ghrd folder to gsrd folder internally
SRC_URI_append_stratix10 += "\
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "${DTS_REPO}/stratix10/gsrd/0001-socfpga_stratix10_socdk-include-reference-design-dts.patch;name=s10_gsrd_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "${DTS_REPO}/stratix10/pr/0001-socfpga_stratix10_socdk-include-reference-design-dts.patch;name=s10_gsrd_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "${DTS_REPO}/stratix10/pr/0001-dts-arm64-altera-enable-FPGA-PR-DTBs-for-Stratix10.patch;name=s10_pr_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pcie", "${DTS_REPO}/stratix10/pcie/0001-socfpga_stratix10_socdk-pcie-include-reference-desig.patch;name=s10_pcie_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "sgmii", "${DTS_REPO}/stratix10/sgmii/0001-socfpga_stratix10_socdk-sgmii-include-reference-desi.patch;name=s10_sgmii_dts", "", d)} \
			 "
SRC_URI_append_arria10 += "\
			${@bb.utils.contains("IMAGE_TYPE", "gsrd", "${DTS_REPO}/arria10/gsrd/0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch;name=a10_gsrd_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pr", "${DTS_REPO}/arria10/pr/0001-dts-arm-enable-FPGA-PR-DTBs-for-Arria10.patch;name=a10_pr_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "nand", "${DTS_REPO}/arria10/nand/0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch;name=a10_gsrd_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "qspi", "${DTS_REPO}/arria10/qspi/0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch;name=a10_gsrd_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pcie", "${DTS_REPO}/arria10/pcie/0001-socfpga_arria10_socdk-pcie-include-reference-design-.patch;name=a10_pcie_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "sgmii", "${DTS_REPO}/arria10/sgmii/0001-socfpga_arria10_socdk-sgmii-include-reference-design.patch;name=a10_sgmii_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "tse", "${DTS_REPO}/arria10/tse/0001-socfpga_arria10_socdk-tse-include-reference-design-d.patch;name=a10_tse_dts", "", d)} \
			"

SRC_URI_append_cyclone5 += "${DTS_REPO}/cyclone5/gsrd/0001-socfpga_cyclone5_socdk-include-reference-design-dtsi.patch;name=cyclone5_dts"

SRC_URI[agilex_gsrd_dts.sha256sum] = "c8ea92c0b3e4e65ab23ee8f50ce25aaa39d51c01f1af8cafda3ab50c725afcee"
SRC_URI[agilex_pr_dts.sha256sum] = "86ac18cc37c41c96a74865a514cce1b83d6a1e726c54ecb1ba3a45b2ea22b86e"
SRC_URI[agilex_sgmii_dts.sha256sum] = "8e79c13f188d09c93425830cddcdbecb39d63a0538a2a75e6d21c0af0b2f336c"

SRC_URI[s10_gsrd_dts.sha256sum] = "e23bf00aae0bcbd8d77ad335f6da610fee4de7ab4a07d43e4eecf8005236649f"
SRC_URI[s10_pr_dts.sha256sum] = "34603f525ac9d06a0f52721f379c0dca369f8e5621e983b31cf5c1b5157155ba"
SRC_URI[s10_pcie_dts.sha256sum] = "4feee2b82ee18bf5bcfa7ca4dd62f520a49cb7ae1471a6d493c52c5b017012d5"
SRC_URI[s10_sgmii_dts.sha256sum] = "fbea77621c504f04ce005193d38383695087efc5bd8c647defd6a69e636d9a2b"

SRC_URI[a10_gsrd_dts.sha256sum] = "8e55aa38bd9fb7b25a5c2482a0afc6d8241194e44f6c0f3510829e58e242e034"
SRC_URI[a10_pr_dts.sha256sum] = "46e6de6e81bb15ad410fc55a173819798771de4b995a2652a6f176a0edc9956d"
SRC_URI[a10_pcie_dts.sha256sum] = "1abd2b27bbcd9af296ce6c5ccb21cee98c34e634e5e7e49bf901b51a13835329"
SRC_URI[a10_sgmii_dts.sha256sum] = "6c1ed6765e858e44e530b389843524f3b38997aa5d266de85198ecdf3a6ee64f"
SRC_URI[a10_tse_dts.sha256sum] = "9915abc65271a36ac019f1f99047bb72303d0007b23f66b911a2249255ec30e0"

SRC_URI[cyclone5_dts.sha256sum] = "52f629affd6cffc11bb40bbdad62149c20d56d5392bc2646e05310ad64e39a72"

# Append GSRD specific kernel config fragments
SRC_URI += "file://ubifs.scc"
SRC_URI_append_agilex += "file://sgmii.scc"
SRC_URI_append_stratix10 += "file://sgmii.scc"
SRC_URI_append_arria10 += "file://tse.scc"
SRC_URI_append_cyclone5 += "file://tse.scc"

do_install_append() {

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)} ; then
		install -D -m 0644 ${D}/boot/fpga_static_region.dtb ${D}/boot/fpga_static_region.dtbo
		install -D -m 0644 ${D}/boot/persona1.dtb ${D}/boot/persona1.dtbo
		install -D -m 0644 ${D}/boot/persona0.dtb ${D}/boot/persona0.dtbo
	fi
}
