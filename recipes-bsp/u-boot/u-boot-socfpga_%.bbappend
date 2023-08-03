FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS:append:agilex7_dk_si_agf014ea = " arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:agilex7_dk_si_agf014eb = " arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:agilex7_dk_si_agi027fb = " arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:agilex7_dk_si_agi027fa = " arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:agilex7_dk_dev_agf027f1es = " arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:agilex7_dk_dev_agm039fes = " arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:agilex5 = " arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:stratix10 = " arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:arria10 = " hw-ref-design"
DEPENDS:append:n5x = " arm-trusted-firmware bash u-boot-socfpga-scr"

SRC_URI:append = " \
             file://0001-arm-Add-dwarf-4-to-compilation-flag.patch \
             file://0001-arm-agilex-add-board-configuration.patch \
             file://0001-arm-stratix10-add-board-configuration.patch \
           "

inherit deploy

do_compile[deptask] = "do_deploy"

do_configure:prepend:agilex5() {
	sed -i -e '$aCONFIG_LEGACY_IMAGE_FORMAT=y' ${S}/configs/socfpga_agilex5_defconfig
}

do_compile:prepend:arria10() {
	cp -r ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/hps.xml ${S}/.
	${S}/arch/arm/mach-socfpga/qts-filter-a10.sh ${S}/hps.xml ${S}/arch/arm/dts/socfpga_arria10_socdk_sdmmc_handoff.h
}

do_compile:append:arria10() {
	cp ${DEPLOY_DIR_IMAGE}/Image ${S}/Image

	if ${@bb.utils.contains("IMAGE_TYPE", "nand", "true", "false", d)} || ${@bb.utils.contains("IMAGE_TYPE", "qspi", "true", "false", d)}; then
		# A10 NAND Variant
		cp ${B}/socfpga_${MACHINE}_${IMAGE_TYPE}_defconfig/u-boot-nodtb.bin ${S}/u-boot-nodtb.bin
		cp ${B}/socfpga_${MACHINE}_${IMAGE_TYPE}_defconfig/u-boot.dtb ${S}/u-boot.dtb
		cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_10as066n2.core.rbf ${S}/ghrd_10as066n2.core.rbf
		cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_10as066n2.periph.rbf ${S}/ghrd_10as066n2.periph.rbf
		cp ${DEPLOY_DIR_IMAGE}/socfpga_arria10_socdk_${IMAGE_TYPE}.dtb ${S}/socfpga_arria10_socdk_${IMAGE_TYPE}.dtb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_uboot.its ${B}/fit_uboot_${IMAGE_TYPE}.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_spl_fpga.its ${B}/fit_spl_fpga_${IMAGE_TYPE}.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_kernel_${IMAGE_TYPE}.its ${B}/kernel_${IMAGE_TYPE}.itb
	else
		cp ${B}/socfpga_${MACHINE}_defconfig/u-boot-nodtb.bin ${S}/u-boot-nodtb.bin
		cp ${B}/socfpga_${MACHINE}_defconfig/u-boot.dtb ${S}/u-boot.dtb
		cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_10as066n2.core.rbf ${S}/ghrd_10as066n2.core.rbf
		cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_10as066n2.periph.rbf ${S}/ghrd_10as066n2.periph.rbf
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_uboot.its ${B}/fit_uboot_${IMAGE_TYPE}.itb
		mkimage -E -f ${S}/board/altera/${MACHINE}-socdk/fit_spl_fpga_periph_only.its ${B}/fit_spl_fpga_${IMAGE_TYPE}.itb
	fi
}

do_deploy:append:arria10() {
	install -d ${DEPLOYDIR}
	if ${@bb.utils.contains("IMAGE_TYPE", "nand", "true", "false", d)} || ${@bb.utils.contains("IMAGE_TYPE", "qspi", "true", "false", d)}; then
		install -m 744 ${B}/kernel_${IMAGE_TYPE}.itb ${DEPLOYDIR}/kernel_${IMAGE_TYPE}.itb
		install -m 744 ${B}/fit_uboot_${IMAGE_TYPE}.itb ${DEPLOYDIR}/fit_uboot_${IMAGE_TYPE}.itb
		install -m 744 ${B}/fit_spl_fpga_${IMAGE_TYPE}.itb ${DEPLOYDIR}/fit_spl_fpga_${IMAGE_TYPE}.itb
	else
		install -m 744 ${B}/*.itb ${DEPLOYDIR}/
		install -m 644 ${B}/${config}/spl/u-boot-splx4.sfp ${DEPLOYDIR}/u-boot-splx4.sfp
	fi
}

do_deploy:append:cyclone5() {
	install -d ${DEPLOYDIR}
	install -m 644 ${B}/${config}/u-boot-with-spl.sfp ${DEPLOYDIR}/u-boot-with-spl.sfp
	install -m 644 ${B}/${config}/spl/u-boot-spl.sfp ${DEPLOYDIR}/u-boot-spl.sfp
	install -m 644 ${B}/${config}/spl/u-boot-splx4.sfp ${DEPLOYDIR}/u-boot-splx4.sfp
}
