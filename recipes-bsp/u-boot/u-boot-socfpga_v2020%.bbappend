DEPENDS += "coreutils-native u-boot-tools virtual/kernel"
DEPENDS_append_agilex += "arm-trusted-firmware bash"
DEPENDS_append_stratix10 += "arm-trusted-firmware bash"

inherit deploy

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_arria10 += "\
		file://socfpga_arria10_socdk_nand.dtb \
		file://socfpga_arria10_socdk_qspi.dtb \
		file://a10_ghrd/ghrd_10as066n2.core.rbf \
		file://a10_ghrd/ghrd_10as066n2.periph.rbf \
		file://a10_nand/ghrd_10as066n2.core.rbf \
		file://a10_nand/ghrd_10as066n2.periph.rbf \
		file://a10_pcie/ghrd_10as066n2.core.rbf \
		file://a10_pcie/ghrd_10as066n2.periph.rbf \
		file://a10_pr/ghrd_10as066n2.core.rbf \
		file://a10_pr/ghrd_10as066n2.periph.rbf \
		file://a10_qspi/ghrd_10as066n2.core.rbf \
		file://a10_qspi/ghrd_10as066n2.periph.rbf \
		file://a10_sgmii/ghrd_10as066n2.core.rbf \
		file://a10_sgmii/ghrd_10as066n2.periph.rbf \
		file://a10_tse/ghrd_10as066n2.core.rbf \
		file://a10_tse/ghrd_10as066n2.periph.rbf \
		"

do_compile[deptask] = "do_deploy"

do_compile_append() {
	if ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-atf", "true", "false", d)} || ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-atf", "true", "false", d)} ; then
		cp ${DEPLOY_DIR_IMAGE}/bl31.bin ${B}/${config}/bl31.bin
		oe_runmake -C ${S} O=${B}/${config} u-boot.itb
	fi
}

do_deploy_append() {
	install -d ${DEPLOYDIR}
	install -m 644 ${B}/${config}/u-boot.dtb ${DEPLOYDIR}/u-boot.dtb
	install -m 755 ${B}/${config}/u-boot-nodtb.bin ${DEPLOYDIR}/u-boot-nodtb.bin

	if ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-atf", "true", "false", d)} || ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-atf", "true", "false", d)} ; then
		install -m 644 ${B}/${config}/u-boot.itb ${DEPLOYDIR}/u-boot.itb
	fi

}

do_compile_append_arria10() {
	cp ${DEPLOY_DIR_IMAGE}/Image ${S}/Image

	if ${@bb.utils.contains("A10_IMAGE_TYPE", "NAND", "true", "false", d)}; then
		# A10 NAND Variant
		cp ${B}/socfpga_${MACHINE}_nand_defconfig/u-boot-nodtb.bin ${S}/u-boot-nodtb.bin
		cp ${B}/socfpga_${MACHINE}_nand_defconfig/u-boot.dtb ${S}/u-boot.dtb
		cp ${WORKDIR}/a10_nand/ghrd_10as066n2.core.rbf ${S}/ghrd_10as066n2.core.rbf
		cp ${WORKDIR}/a10_nand/ghrd_10as066n2.periph.rbf ${S}/ghrd_10as066n2.periph.rbf
		cp ${WORKDIR}/socfpga_arria10_socdk_nand.dtb ${S}/socfpga_arria10_socdk_nand.dtb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_uboot.its ${B}/fit_uboot_nand.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_spl_fpga.its ${B}/fit_spl_fpga_nand.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_kernel_nand.its ${B}/kernel_nand.itb
	elif ${@bb.utils.contains("A10_IMAGE_TYPE", "QSPI", "true", "false", d)}; then
		# A10 QSPI Variant
		cp ${B}/socfpga_${MACHINE}_qspi_defconfig/u-boot-nodtb.bin ${S}/u-boot-nodtb.bin
		cp ${B}/socfpga_${MACHINE}_qspi_defconfig/u-boot.dtb ${S}/u-boot.dtb
		cp ${WORKDIR}/a10_qspi/ghrd_10as066n2.core.rbf ${S}/ghrd_10as066n2.core.rbf
		cp ${WORKDIR}/a10_qspi//ghrd_10as066n2.periph.rbf ${S}/ghrd_10as066n2.periph.rbf
		cp ${WORKDIR}/socfpga_arria10_socdk_qspi.dtb ${S}/socfpga_arria10_socdk_qspi.dtb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_uboot.its ${B}/fit_uboot_qspi.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_spl_fpga.its ${B}/fit_spl_fpga_qspi.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_kernel_qspi.its ${B}/kernel_qspi.itb
	else
		# A10 Basic GHRD
		cp ${B}/socfpga_${MACHINE}_defconfig/u-boot-nodtb.bin ${S}/u-boot-nodtb.bin
		cp ${B}/socfpga_${MACHINE}_defconfig/u-boot.dtb ${S}/u-boot.dtb
		cp ${WORKDIR}/a10_ghrd/ghrd_10as066n2.core.rbf ${S}/ghrd_10as066n2.core.rbf
		cp ${WORKDIR}/a10_ghrd/ghrd_10as066n2.periph.rbf ${S}/ghrd_10as066n2.periph.rbf
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_uboot.its ${B}/fit_uboot.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_spl_fpga_periph_only.its ${B}/fit_spl_fpga.itb

		# A10 PCIE Gen2x8 Variant
		cp ${WORKDIR}/a10_pcie/ghrd_10as066n2.core.rbf ${S}/ghrd_10as066n2.core.rbf
		cp ${WORKDIR}/a10_pcie/ghrd_10as066n2.periph.rbf ${S}/ghrd_10as066n2.periph.rbf
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_uboot.its ${B}/fit_uboot_pcie.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_spl_fpga_periph_only.its ${B}/fit_spl_fpga_pcie.itb

		# A10 PR Variant
		cp ${WORKDIR}/a10_pr/ghrd_10as066n2.core.rbf ${S}/ghrd_10as066n2.core.rbf
		cp ${WORKDIR}/a10_pr/ghrd_10as066n2.periph.rbf ${S}/ghrd_10as066n2.periph.rbf
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_uboot.its ${B}/fit_uboot_pr.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_spl_fpga_periph_only.its ${B}/fit_spl_fpga_pr.itb

		# A10 SGMII Variant
		cp ${WORKDIR}/a10_sgmii/ghrd_10as066n2.core.rbf ${S}/ghrd_10as066n2.core.rbf
		cp ${WORKDIR}/a10_sgmii/ghrd_10as066n2.periph.rbf ${S}/ghrd_10as066n2.periph.rbf
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_uboot.its ${B}/fit_uboot_sgmii.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_spl_fpga_periph_only.its ${B}/fit_spl_fpga_sgmii.itb

		# A10 TSE Variant
		cp ${WORKDIR}/a10_tse/ghrd_10as066n2.core.rbf ${S}/ghrd_10as066n2.core.rbf
		cp ${WORKDIR}/a10_tse/ghrd_10as066n2.periph.rbf ${S}/ghrd_10as066n2.periph.rbf
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_uboot.its ${B}/fit_uboot_tse.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_spl_fpga_periph_only.its ${B}/fit_spl_fpga_tse.itb
	fi
}

do_deploy_append_arria10() {
	install -d ${DEPLOYDIR}
	if ${@bb.utils.contains("A10_IMAGE_TYPE", "NAND", "true", "false", d)}; then
		install -m 644 ${WORKDIR}/socfpga_arria10_socdk_nand.dtb ${DEPLOYDIR}/socfpga_arria10_socdk_nand.dtb
		install -m 644 ${B}/kernel_nand.itb ${DEPLOYDIR}/kernel_nand.itb
		install -m 644 ${B}/fit_uboot_nand.itb ${DEPLOYDIR}/fit_uboot_nand.itb
		install -m 644 ${B}/fit_spl_fpga_nand.itb ${DEPLOYDIR}/fit_spl_fpga_nand.itb
	elif ${@bb.utils.contains("A10_IMAGE_TYPE", "QSPI", "true", "false", d)}; then
		install -m 644 ${WORKDIR}/socfpga_arria10_socdk_qspi.dtb ${DEPLOYDIR}/socfpga_arria10_socdk_qspi.dtb
		install -m 644 ${B}/kernel_qspi.itb ${DEPLOYDIR}/kernel_qspi.itb
		install -m 644 ${B}/fit_uboot_qspi.itb ${DEPLOYDIR}/fit_uboot_qspi.itb
		install -m 644 ${B}/fit_spl_fpga_qspi.itb ${DEPLOYDIR}/fit_spl_fpga_qspi.itb
	else
		install -m 644 ${B}/*.itb ${DEPLOYDIR}/
	fi
}
