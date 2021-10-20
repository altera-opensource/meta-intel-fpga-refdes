# Append GSRD SoCFPGA device tree source include files
# As this is custom to Intel SoCFPGA GSRD, hence it is not suitable to be upstreamed to meta-intel-fpga

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-socfpga-lts:"

RBO_RELEASE_VER ?= "2021.11"

DTS_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/dts-source"

SRC_URI:append:agilex += "\
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "${DTS_REPO}/agilex/gsrd/0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch;name=agilex_gsrd_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "${DTS_REPO}/agilex/pr/0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch;name=agilex_gsrd_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "${DTS_REPO}/agilex/pr/5.10/0001-dts-arm64-intel-enable-FPGA-PR-DTBs-for-Agilex.patch;name=agilex_pr_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "sgmii", "${DTS_REPO}/agilex/sgmii/0001-dts-arm64-intel-enable-Agilex-SGMII-support.patch;name=agilex_sgmii_dts", "", d)} \
			 "

SRC_URI:append:stratix10 += "${DTS_REPO}/stratix10/combined/0001-socfpga_stratix10_socdk-include-combined-reference-d.patch;name=s10_combined_dts"

SRC_URI:append:arria10 += "\
			${@bb.utils.contains("IMAGE_TYPE", "gsrd", "${DTS_REPO}/arria10/gsrd/0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch;name=a10_gsrd_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pr", "${DTS_REPO}/arria10/pr/0001-dts-arm-enable-FPGA-PR-DTBs-for-Arria10.patch;name=a10_pr_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "nand", "${DTS_REPO}/arria10/nand/0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch;name=a10_gsrd_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "qspi", "${DTS_REPO}/arria10/qspi/0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch;name=a10_gsrd_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pcie", "${DTS_REPO}/arria10/pcie/0001-socfpga_arria10_socdk-pcie-include-reference-design-.patch;name=a10_pcie_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "sgmii", "${DTS_REPO}/arria10/sgmii/0001-socfpga_arria10_socdk-sgmii-include-reference-design.patch;name=a10_sgmii_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "tse", "${DTS_REPO}/arria10/tse/0001-socfpga_arria10_socdk-tse-include-reference-design-d.patch;name=a10_tse_dts", "", d)} \
			"

SRC_URI:append:cyclone5 += "${DTS_REPO}/cyclone5/gsrd/0001-socfpga_cyclone5_socdk-include-reference-design-dtsi.patch;name=cyclone5_dts"

SRC_URI[agilex_gsrd_dts.sha256sum] = "c8ea92c0b3e4e65ab23ee8f50ce25aaa39d51c01f1af8cafda3ab50c725afcee"
SRC_URI[agilex_pr_dts.sha256sum] = "ae178279ba565061efdfae314ee5978c03a1cbf3f0034cd9472bf670aee119b7"
SRC_URI[agilex_sgmii_dts.sha256sum] = "8e79c13f188d09c93425830cddcdbecb39d63a0538a2a75e6d21c0af0b2f336c"

SRC_URI[s10_combined_dts.sha256sum] = "14ccbe50102de204af6211a227b403e0b1c7cd174d6ac756fd954e2e779bafe5"

SRC_URI[a10_gsrd_dts.sha256sum] = "8e55aa38bd9fb7b25a5c2482a0afc6d8241194e44f6c0f3510829e58e242e034"
SRC_URI[a10_pcie_dts.sha256sum] = "1abd2b27bbcd9af296ce6c5ccb21cee98c34e634e5e7e49bf901b51a13835329"
SRC_URI[a10_pr_dts.sha256sum] = "46e6de6e81bb15ad410fc55a173819798771de4b995a2652a6f176a0edc9956d"
SRC_URI[a10_sgmii_dts.sha256sum] = "6c1ed6765e858e44e530b389843524f3b38997aa5d266de85198ecdf3a6ee64f"
SRC_URI[a10_tse_dts.sha256sum] = "9915abc65271a36ac019f1f99047bb72303d0007b23f66b911a2249255ec30e0"

SRC_URI[cyclone5_dts.sha256sum] = "52f629affd6cffc11bb40bbdad62149c20d56d5392bc2646e05310ad64e39a72"

# Append GSRD specific kernel config fragments
SRC_URI += "file://ubifs.scc"
SRC_URI:append:agilex += "file://sgmii.scc"
SRC_URI:append:stratix10 += "file://sgmii.scc"
SRC_URI:append:arria10 += "file://tse.scc"
SRC_URI:append:cyclone5 += "file://tse.scc"

do_install:append() {
	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} || ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)} ; then
		install -D -m 0644 ${D}/boot/fpga_static_region.dtb ${D}/boot/fpga_static_region.dtbo
		install -D -m 0644 ${D}/boot/persona1.dtb ${D}/boot/persona1.dtbo
		install -D -m 0644 ${D}/boot/persona0.dtb ${D}/boot/persona0.dtbo
	fi
}
