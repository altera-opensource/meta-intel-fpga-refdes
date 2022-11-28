# Append GSRD SoCFPGA device tree source include files
# As this is custom to Intel SoCFPGA GSRD, hence it is not suitable to be upstreamed to meta-intel-fpga

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-socfpga-lts:"

DEPENDS = "u-boot-mkimage-native dtc-native"

SRC_URI:append:agilex_fm61 = " file://fit_kernel_agilex_fm61.its"
SRC_URI:append:agilex_fm87 = " file://fit_kernel_agilex_fm87.its"
SRC_URI:append:agilex_fm86 = " file://fit_kernel_agilex_fm86.its"

SRC_URI:append:stratix10 = " file://fit_kernel_stratix10.its"

SRC_URI:append:arria10 = " \
			${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-dts-arm-enable-FPGA-PR-DTBs-for-Arria10.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "nand", "file://0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "qspi", "file://0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pcie", "file://0001-socfpga_arria10_socdk-pcie-include-reference-design-.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "sgmii", "file://0001-socfpga_arria10_socdk-sgmii-include-reference-design.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "tse", "file://0001-socfpga_arria10_socdk-tse-include-reference-design-d.patch", "", d)} \
			"

SRC_URI:append:cyclone5 = " file://0001-socfpga_cyclone5_socdk-include-reference-design-dtsi.patch"

# Append GSRD specific kernel config fragments
SRC_URI:append = " file://ubifs.scc"
SRC_URI:append:agilex = " file://sgmii.scc"
SRC_URI:append:stratix10 = " file://sgmii.scc"
SRC_URI:append:arria10 = " file://tse.scc"
SRC_URI:append:cyclone5 = " file://tse.scc"

inherit deploy

LINUXDEPLOYDIR = "${WORKDIR}/deploy-${PN}"
DTBDEPLOYDIR = "${DEPLOY_DIR_IMAGE}/devicetree"

do_deploy:append() {
	if [[ "${MACHINE}" == *"agilex"* ]] || [[ "${MACHINE}" == "stratix10" ]]; then
		# linux.dtb
		cp ${DTBDEPLOYDIR}/socfpga_${MACHINE}_socdk.dtb ${B}/socfpga_${MACHINE}_socdk.dtb
		cp ${DTBDEPLOYDIR}/socfpga_${MACHINE}_vanilla.dtb ${B}/socfpga_${MACHINE}_vanilla.dtb
		if [[ "${MACHINE}" == "agilex_fm61" ]]; then
			cp ${DTBDEPLOYDIR}/socfpga_${MACHINE}_socdk_nand.dtb ${B}/socfpga_${MACHINE}_socdk_nand.dtb
			cp ${DTBDEPLOYDIR}/socfpga_${MACHINE}_socdk_pr.dtb ${B}/socfpga_${MACHINE}_socdk_pr.dtb
		elif [[ "${MACHINE}" == "stratix10" ]]; then
			cp ${DTBDEPLOYDIR}/socfpga_${MACHINE}_socdk_nand.dtb ${B}/socfpga_${MACHINE}_socdk_nand.dtb
		fi

		# core.rbf
		cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd.core.rbf ${B}/ghrd.core.rbf
		if [ "${MACHINE}" = "agilex_fm61" ]; then
			cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf ${B}/nand.core.rbf
			cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf ${B}/ghrd_pr.core.rbf
		elif [ "${MACHINE}" == "stratix10" ]; then
			cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf ${B}/nand.core.rbf
		fi

		# kernel.its
		cp ${WORKDIR}/fit_kernel_${MACHINE}.its ${B}/fit_kernel_${MACHINE}.its

		# Image
		cp ${LINUXDEPLOYDIR}/Image ${B}/Image

		# Compress Image to lzma format
		xz --format=lzma ${B}/Image

		# Generate kernel.itb
		mkimage -f ${B}/fit_kernel_${MACHINE}.its ${B}/kernel.itb

		# Deploy kernel.its, kernel.itb and Image.lzma
		install -m 744 ${B}/fit_kernel_${MACHINE}.its ${DEPLOYDIR}/fit_kernel_${MACHINE}.its
		install -m 744 ${B}/kernel.itb ${DEPLOYDIR}/kernel.itb
		install -m 744 ${B}/Image.lzma ${DEPLOYDIR}/Image.lzma
	fi
}

do_install:append() {
	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)} ; then
		install -D -m 0644 ${D}/boot/fpga_static_region.dtb ${D}/boot/fpga_static_region.dtbo
		install -D -m 0644 ${D}/boot/persona1.dtb ${D}/boot/persona1.dtbo
		install -D -m 0644 ${D}/boot/persona0.dtb ${D}/boot/persona0.dtbo
	fi
}
