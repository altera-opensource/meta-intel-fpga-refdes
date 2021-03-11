# Append GSRD SoCFPGA device tree source include files
# As this is custom to GSRD, hence it is not suitable to be upstreamed to meta-altera

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-socfpga-lts:"

S10_DTS_REPO = "https://pg-arc.altera.com/tools/socfpga_refdes/s10_soc_devkit_ghrd/socfpga-5.4.13-lts_files"
A10_DTS_REPO = "https://pg-arc.altera.com/tools/socfpga_refdes/a10_soc_devkit_ghrd/5.4-lts"

SRC_URI_append_agilex += "\
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "https://releases.rocketboards.org/release/2020.11/gsrd/agilex_gsrd/0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch;name=agilex_dts", "", d)} \
			 "

#rename ghrd folder to gsrd folder internally
SRC_URI_append_stratix10 += "\
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "${S10_DTS_REPO}/ghrd/0001-socfpga_stratix10_socdk-include-reference-design-dts.patch;name=s10_gsrd_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "${S10_DTS_REPO}/ghrd/0001-socfpga_stratix10_socdk-include-reference-design-dts.patch;name=s10_gsrd_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "https://pg-arc.altera.com/tools/socfpga_refdes/s10_soc_devkit_ghrd/5.4-lts/pr/0001-enable-PR-from-Linux-Device-Tree-for-Base-Persona0-a.patch;name=s10_pr_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pcie", "${S10_DTS_REPO}/pcie/0001-socfpga_stratix10_socdk-pcie-include-reference-desig.patch;name=s10_pcie_dts", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "sgmii", "${S10_DTS_REPO}/sgmii/0001-socfpga_stratix10_socdk-sgmii-include-reference-desi.patch;name=s10_sgmii_dts", "", d)} \
			 "
SRC_URI_append_arria10 += "\
			${@bb.utils.contains("IMAGE_TYPE", "gsrd", "${A10_DTS_REPO}/ghrd/0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch;name=a10_gsrd_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pr", "https://pg-arc.altera.com/tools/socfpga_refdes/a10_soc_devkit_ghrd/5.4-lts/pr/0001-boot-dts-a10-add-Arria10-PR-overlays.patch;name=a10_pr_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "nand", "${A10_DTS_REPO}/ghrd/0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch;name=a10_gsrd_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "qspi", "${A10_DTS_REPO}/ghrd/0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch;name=a10_gsrd_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pcie", "${A10_DTS_REPO}/pcie/0001-socfpga_arria10_socdk-pcie-include-reference-design-.patch;name=a10_pcie_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "sgmii", "${A10_DTS_REPO}/sgmii/0001-socfpga_arria10_socdk-sgmii-include-reference-design.patch;name=a10_sgmii_dts", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "tse", "${A10_DTS_REPO}/tse/0001-socfpga_arria10_socdk-tse-include-reference-design-d.patch;name=a10_tse_dts", "", d)} \
			"

SRC_URI_append_cyclone5 += "https://pg-arc.altera.com/tools/socfpga_refdes/c5_soc_devkit_ghrd/5.4-lts/0001-socfpga_cyclone5_socdk-include-reference-design-dtsi.patch;name=cyclone5_dts"

SRC_URI[agilex_dts.sha256sum] = "c8ea92c0b3e4e65ab23ee8f50ce25aaa39d51c01f1af8cafda3ab50c725afcee"

SRC_URI[s10_gsrd_dts.sha256sum] = "3fd509458e90bc231a09073e22ddde53a5b2132eb4a5c8b2eab2d4aae651294b"
SRC_URI[s10_pr_dts.sha256sum] = "3cf86ecfb476a935bb1949e8d0ca7638e59ad08210d9fd9ab9327a8b62be8e66"
SRC_URI[s10_pcie_dts.sha256sum] = "b58d0ad88f674c4e0ea1e01860603e5be7f479499fcbda1ad9a7c282ab98266d"
SRC_URI[s10_sgmii_dts.sha256sum] = "3a19f186ede5d74d4649b6fe949c8049cc1b06bf028f994e1c09f80ae9ad1a7c"

SRC_URI[a10_gsrd_dts.sha256sum] = "8e55aa38bd9fb7b25a5c2482a0afc6d8241194e44f6c0f3510829e58e242e034"
SRC_URI[a10_pr_dts.sha256sum] = "dc1d42938791e200cd3089a670257d2bbb2c2469e330ec1493b0aaa27fbea04f"
SRC_URI[a10_pcie_dts.sha256sum] = "1abd2b27bbcd9af296ce6c5ccb21cee98c34e634e5e7e49bf901b51a13835329"
SRC_URI[a10_sgmii_dts.sha256sum] = "6c1ed6765e858e44e530b389843524f3b38997aa5d266de85198ecdf3a6ee64f"
SRC_URI[a10_tse_dts.sha256sum] = "9915abc65271a36ac019f1f99047bb72303d0007b23f66b911a2249255ec30e0"

SRC_URI[cyclone5_dts.sha256sum] = "52f629affd6cffc11bb40bbdad62149c20d56d5392bc2646e05310ad64e39a72"

# Append kernel config fragments to enable UBIFS
SRC_URI += "file://ubifs.scc"
SRC_URI_append_arria10 += "file://tse.scc"
SRC_URI_append_cyclone5 += "file://tse.scc"

do_install_append_arria10() {
	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)} ; then
		install -D -m 0644 ${D}/boot/fpga_region.dtb ${D}/boot/fpga_static_region.dtbo
		install -D -m 0644 ${D}/boot/persona1.dtb ${D}/boot/persona1.dtbo
		install -D -m 0644 ${D}/boot/persona0.dtb ${D}/boot/persona0.dtbo
	fi
}

do_install_append_stratix10() {

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)} ; then
		install -D -m 0644 ${D}/boot/base.dtb ${D}/boot/base.dtbo
		install -D -m 0644 ${D}/boot/persona1.dtb ${D}/boot/persona1.dtbo
		install -D -m 0644 ${D}/boot/persona0.dtb ${D}/boot/persona0.dtbo
	fi
}
