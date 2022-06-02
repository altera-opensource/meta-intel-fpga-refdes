# Append GSRD SoCFPGA device tree source include files
# As this is custom to Intel SoCFPGA GSRD, hence it is not suitable to be upstreamed to meta-intel-fpga

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-socfpga-lts:"

DEPENDS = "u-boot-mkimage-native dtc-native"

SRC_URI:append:agilex += "\
			 file://0001-socfpga_agilex_socdk-include-combined-ghrd-design.patch \
			 file://socfpga_agilex_socdk_pr.dtb \
			 file://fit_kernel_agilex.its \
			 file://agilex_pr_fpga_static_region.dtb \
			 file://agilex_pr_persona0.dtb \
			 file://agilex_pr_persona1.dtb \
			 "

SRC_URI:append:stratix10 += "\
			 file://0001-socfpga_stratix10_socdk-include-combined-ghrd-design.patch \
			 file://fit_kernel_stratix10.its \
			 file://stratix10_pr_fpga_static_region.dtb \
			 file://stratix10_pr_persona0.dtb \
			 file://stratix10_pr_persona1.dtb \
			 "

SRC_URI:append:arria10 += "\
			${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-dts-arm-enable-FPGA-PR-DTBs-for-Arria10.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "nand", "file://0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "qspi", "file://0001-socfpga_arria10_socdk-include-reference-design-dtsi.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "pcie", "file://0001-socfpga_arria10_socdk-pcie-include-reference-design-.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "sgmii", "file://0001-socfpga_arria10_socdk-sgmii-include-reference-design.patch", "", d)} \
			${@bb.utils.contains("IMAGE_TYPE", "tse", "file://0001-socfpga_arria10_socdk-tse-include-reference-design-d.patch", "", d)} \
			"

SRC_URI:append:cyclone5 += "file://0001-socfpga_cyclone5_socdk-include-reference-design-dtsi.patch"

# Append GSRD specific kernel config fragments
SRC_URI += "file://ubifs.scc"
SRC_URI:append:agilex += "file://sgmii.scc"
SRC_URI:append:stratix10 += "file://sgmii.scc"
SRC_URI:append:arria10 += "file://tse.scc"
SRC_URI:append:cyclone5 += "file://tse.scc"

inherit deploy

LINUXDEPLOYDIR = "${WORKDIR}/deploy-${PN}"

do_deploy:append() {
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		# linux.dtb
		cp ${LINUXDEPLOYDIR}/socfpga_${MACHINE}_socdk.dtb ${B}/socfpga_${MACHINE}_socdk.dtb
		cp ${LINUXDEPLOYDIR}/socfpga_${MACHINE}_socdk_nand.dtb ${B}/socfpga_${MACHINE}_socdk_nand.dtb
		if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} ; then
			cp ${WORKDIR}/socfpga_${MACHINE}_socdk_pr.dtb ${B}/socfpga_${MACHINE}_socdk_pr.dtb
		fi

		# core.rbf
		cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd.core.rbf ${B}/ghrd.core.rbf
		cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf ${B}/nand.core.rbf
		if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} ; then
			cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf ${B}/ghrd_pr.core.rbf
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
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_fpga_static_region.dtb ${D}/boot/fpga_static_region.dtbo
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.dtb ${D}/boot/persona1.dtbo
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.dtb ${D}/boot/persona0.dtbo
	fi
}
