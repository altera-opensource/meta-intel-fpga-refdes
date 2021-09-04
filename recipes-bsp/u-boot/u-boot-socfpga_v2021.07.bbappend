FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS:append:n5x += "arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:agilex += "arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:stratix10 += "arm-trusted-firmware bash u-boot-socfpga-scr"
DEPENDS:append:arria10 += "hw-ref-design"

inherit deploy

do_compile[deptask] = "do_deploy"

do_compile:prepend() {
	if ${@bb.utils.contains("MACHINE", "n5x", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		cp ${DEPLOY_DIR_IMAGE}/bl31.bin ${B}/${config}/bl31.bin
		cp ${DEPLOY_DIR_IMAGE}/bl31.bin ${S}/bl31.bin
		cp ${DEPLOY_DIR_IMAGE}/Image ${B}/${config}/Image
		cp ${DEPLOY_DIR_IMAGE}/Image ${S}/Image
		cp ${DEPLOY_DIR_IMAGE}/socfpga_${MACHINE}_socdk.dtb ${B}/${config}/linux.dtb
		cp ${DEPLOY_DIR_IMAGE}/socfpga_${MACHINE}_socdk.dtb ${S}/linux.dtb
		cp ${DEPLOY_DIR_IMAGE}/u-boot.txt ${B}/${config}/u-boot.txt
		cp ${DEPLOY_DIR_IMAGE}/u-boot.txt ${S}/u-boot.txt
	fi
}

do_install:append() {
	if ${@bb.utils.contains("MACHINE", "n5x", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		cp ${B}/${config}/u-boot.itb ${B}/${config}/u-boot-${UBOOT_CONFIG}.itb
		install -D -m 644 ${B}/${config}/u-boot-${UBOOT_CONFIG}.itb ${D}/boot/u-boot-${UBOOT_CONFIG}-${PV}-${PR}.itb
		ln -sf u-boot-${UBOOT_CONFIG}-${PV}-${PR}.itb ${D}/boot/u-boot.itb-${UBOOT_CONFIG}
		ln -sf u-boot-${UBOOT_CONFIG}-${PV}-${PR}.itb ${D}/boot/u-boot.itb
		rm -rf  ${D}/boot/*.img*
	fi
}

do_deploy:append() {
	install -d ${DEPLOYDIR}
	install -m 755 ${B}/${config}/u-boot ${DEPLOYDIR}/u-boot
	install -m 755 ${B}/${config}/u-boot-nodtb.bin ${DEPLOYDIR}/u-boot-nodtb.bin
	install -m 744 ${B}/${config}/u-boot.img ${DEPLOYDIR}/u-boot.img
	install -m 644 ${B}/${config}/u-boot.dtb ${DEPLOYDIR}/u-boot.dtb
	install -m 644 ${B}/${config}/u-boot-dtb.bin ${DEPLOYDIR}/u-boot-dtb.bin
	install -m 644 ${B}/${config}/u-boot-dtb.img ${DEPLOYDIR}/u-boot-dtb.img
	install -m 644 ${B}/${config}/u-boot.map ${DEPLOYDIR}/u-boot.map
	install -m 755 ${B}/${config}/spl/u-boot-spl ${DEPLOYDIR}/u-boot-spl
	install -m 644 ${B}/${config}/spl/u-boot-spl.dtb ${DEPLOYDIR}/u-boot-spl.dtb
	install -m 644 ${B}/${config}/spl/u-boot-spl-dtb.bin ${DEPLOYDIR}/u-boot-spl-dtb.bin
	install -m 644 ${B}/${config}/spl/u-boot-spl.map ${DEPLOYDIR}/u-boot-spl.map

	if ${@bb.utils.contains("MACHINE", "n5x", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -m 744 ${B}/${config}/u-boot.fit.fit ${DEPLOYDIR}/u-boot.fit.fit
		install -m 744 ${B}/${config}/u-boot.fit.itb ${DEPLOYDIR}/u-boot.fit.itb
		install -m 744 ${B}/${config}/u-boot.itb ${DEPLOYDIR}/u-boot.itb
		install -m 644 ${B}/${config}/spl/u-boot-spl-dtb.hex ${DEPLOYDIR}/u-boot-spl-dtb.hex

		install -m 744 ${B}/${config}/kernel.fit.fit ${DEPLOYDIR}/kernel.fit.fit
		install -m 744 ${B}/${config}/kernel.fit.itb ${DEPLOYDIR}/kernel.fit.itb
		install -m 744 ${B}/${config}/kernel.itb ${DEPLOYDIR}/kernel.itb

		install -m 744 ${B}/${config}/u-boot.scr ${DEPLOYDIR}/u-boot.scr
	fi
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
