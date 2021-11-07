# Append GSRD SoCFPGA device tree source include files
# As this is custom to Intel SoCFPGA GSRD, hence it is not suitable to be upstreamed to meta-intel-fpga

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-socfpga-lts:"

DEPENDS:"u-boot-mkimage-native"

SRC_URI:append:agilex += "\
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://socfpga_agilex_socdk_pr.dtb", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://fit_kernel_agilex.its", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://agilex_pr_fpga_static_region.dtb", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://agilex_pr_persona0.dtb", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://agilex_pr_persona1.dtb", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-dts-arm64-intel-enable-FPGA-PR-DTBs-for-Agilex.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "sgmii", "file://0001-dts-arm64-intel-enable-Agilex-SGMII-support.patch", "", d)} \
			 "

SRC_URI:append:stratix10 += "\
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://0001-socfpga_stratix10_socdk-include-reference-design-dts.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://fit_kernel_stratix10.its", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://stratix10_pr_fpga_static_region.dtb", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://stratix10_pr_persona0.dtb", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://stratix10_pr_persona1.dtb", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://socfpga_stratix10_ghrd.dtbo", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://socfpga_stratix10_pcie.dtbo", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://socfpga_stratix10_qse.dtbo", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://socfpga_stratix10_sgmii.dtbo", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-socfpga_stratix10_socdk-include-reference-design-dts.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pr", "file://0001-dts-arm64-altera-enable-FPGA-PR-DTBs-for-Stratix10.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "pcie", "file://0001-socfpga_stratix10_socdk-pcie-include-reference-desig.patch", "", d)} \
			 ${@bb.utils.contains("IMAGE_TYPE", "sgmii", "file://0001-socfpga_stratix10_socdk-sgmii-include-reference-desi.patch", "", d)} \
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

do_compile[deptask] = "do_deploy"

COMPILE_PREPEND_FILES:agilex = "Image linux.dtb core.rbf kernel.its"
COMPILE_PREPEND_FILES:stratix10 = "Image linux.dtb core.rbf kernel.its"

do_compile:append() {
	if [ -n "${COMPILE_PREPEND_FILES}" ]; then
		for file in ${COMPILE_PREPEND_FILES}; do
			if [ "${file}" = "linux.dtb" ]; then
				if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
					if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
						cp ${DEPLOY_DIR_IMAGE}/socfpga_${MACHINE}_socdk.dtb ${B}/socfpga_${MACHINE}_socdk.dtb
						cp ${DEPLOY_DIR_IMAGE}/socfpga_${MACHINE}_socdk.dtb ${S}/socfpga_${MACHINE}_socdk.dtb
						cp ${DEPLOY_DIR_IMAGE}/socfpga_${MACHINE}_socdk_nand.dtb ${B}/socfpga_${MACHINE}_socdk_nand.dtb
						cp ${DEPLOY_DIR_IMAGE}/socfpga_${MACHINE}_socdk_nand.dtb ${S}/socfpga_${MACHINE}_socdk_nand.dtb
						if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} ; then
							cp ${WORKDIR}/socfpga_${MACHINE}_socdk_pr.dtb ${B}/socfpga_${MACHINE}_socdk_pr.dtb
							cp ${WORKDIR}/socfpga_${MACHINE}_socdk_pr.dtb ${S}/socfpga_${MACHINE}_socdk_pr.dtb
						fi
					fi
			elif [ "${file}" = "core.rbf" ]; then
				if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
					if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
						cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd.core.rbf ${B}/ghrd.core.rbf
						cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd.core.rbf ${S}/ghrd.core.rbf
						cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf ${B}/nand.core.rbf
						cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf ${S}/nand.core.rbf
						if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} ; then
							cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf ${B}/ghrd_pr.core.rbf
							cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf ${S}/ghrd_pr.core.rbf
						fi
					fi
				fi
			elif [ "${file}" = "kernel.its" ]; then
				if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
					if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
						cp ${WORKDIR}/fit_kernel_${MACHINE}.its ${B}/fit_kernel_${MACHINE}.its
						cp ${WORKDIR}/fit_kernel_${MACHINE}.its ${S}/fit_kernel_${MACHINE}.its
					fi
				fi
			else
				if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
					if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
						cp ${DEPLOY_DIR_IMAGE}/${file} ${B}/${file}
						cp ${DEPLOY_DIR_IMAGE}/${file} ${S}/${file}
					fi
				fi
			fi
		done
	fi
	
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
			mkimage -E -f ${B}/fit_kernel_${MACHINE}.its ${B}/kernel.itb
		fi
	fi
}

do_deploy:append() {
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
			install -m 744 ${B}/kernel.itb ${DEPLOYDIR}/kernel.itb
		fi
	fi
}


do_install:append() {
	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)} ; then
		install -D -m 0644 ${D}/boot/fpga_static_region.dtb ${D}/boot/fpga_static_region.dtbo
		install -D -m 0644 ${D}/boot/persona1.dtb ${D}/boot/persona1.dtbo
		install -D -m 0644 ${D}/boot/persona0.dtb ${D}/boot/persona0.dtbo
	fi
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_fpga_static_region.dtb ${D}/boot/fpga_static_region.dtbo
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.dtb ${D}/boot/persona1.dtbo
			install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.dtb ${D}/boot/persona0.dtbo
			if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
				install -D -m 0644 ${WORKDIR}/socfpga_stratix10_ghrd.dtbo ${D}/boot/socfpga_stratix10_ghrd.dtbo
				install -D -m 0644 ${WORKDIR}/socfpga_stratix10_pcie.dtbo ${D}/boot/socfpga_stratix10_pcie.dtbo
				install -D -m 0644 ${WORKDIR}/socfpga_stratix10_qse.dtbo ${D}/boot/socfpga_stratix10_qse.dtbo
				install -D -m 0644 ${WORKDIR}/socfpga_stratix10_sgmii.dtbo ${D}/boot/socfpga_stratix10_sgmii.dtbo
			fi
		fi
	fi
}
