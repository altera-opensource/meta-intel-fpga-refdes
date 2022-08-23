SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2022.09"
GHRD_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/rbf-source"

ARM64_GHRD_CORE_RBF = "ghrd.core.rbf"
A10_GHRD_CORE_RBF = "ghrd_10as066n2.core.rbf"
A10_GHRD_PERIPH_RBF = "ghrd_10as066n2.periph.rbf"
C5_GHRD_CORE_RBF = "soc_system.rbf"

SRC_URI:agilex ?= "\
		${GHRD_REPO}/agilex_gsrd_${ARM64_GHRD_CORE_RBF};name=agilex_gsrd_core \
		${GHRD_REPO}/agilex_nand_${ARM64_GHRD_CORE_RBF};name=agilex_nand_core \
		${GHRD_REPO}/agilex_pr_${ARM64_GHRD_CORE_RBF};name=agilex_pr_core \
		${GHRD_REPO}/agilex_pr_persona0.rbf;name=agilex_pr_persona0 \
		${GHRD_REPO}/agilex_pr_persona1.rbf;name=agilex_pr_persona1 \
		"

SRC_URI:stratix10 ?= "\
		${GHRD_REPO}/stratix10_gsrd_${ARM64_GHRD_CORE_RBF};name=stratix10_gsrd_core \
		${GHRD_REPO}/stratix10_nand_${ARM64_GHRD_CORE_RBF};name=stratix10_nand_core \
		${GHRD_REPO}/stratix10_pr_persona0.rbf;name=stratix10_pr_persona0 \
		${GHRD_REPO}/stratix10_pr_persona1.rbf;name=stratix10_pr_persona1 \
		"

SRC_URI:arria10 ?= "\
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_hps.xml;name=arria10_${IMAGE_TYPE}_hps_xml \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF};name=arria10_${IMAGE_TYPE}_core \
		${GHRD_REPO}/arria10_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF};name=arria10_${IMAGE_TYPE}_periph \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona0.rbf;name=arria10_pr_persona0", "", d)} \
		${@bb.utils.contains("IMAGE_TYPE", "pr", "${GHRD_REPO}/arria10_${IMAGE_TYPE}_persona1.rbf;name=arria10_pr_persona1", "", d)} \
		"

SRC_URI:cyclone5 ?= "${GHRD_REPO}/cyclone5_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF};name=cyclone5_${IMAGE_TYPE}_core"

SRC_URI[agilex_gsrd_core.sha256sum] = "a9c4f0c26bdfd1c970838b571820830e73106d3e02fc9e3f45fb3365224b8004"
SRC_URI[agilex_nand_core.sha256sum] = "9cb07db5a9deca22d02e71c1a7caa38acd86deb858db3581062d5d477484f4eb"
SRC_URI[agilex_pr_core.sha256sum] = "acd86b37c6a5f3a9b11d92f21abe21d3b5546d74bbdf7bd66ede795c6560892b"
SRC_URI[agilex_pr_persona0.sha256sum] = "7ba69196258ef23ea9733140948c437e6b92f7006bec266530228a43b803da2a"
SRC_URI[agilex_pr_persona1.sha256sum] = "1a73797243a450be6bb4abfaa063795a109cebf66e391bc3b69d4b73971c7660"

SRC_URI[stratix10_gsrd_core.sha256sum] = "d91d812fff76fd0e2ac813510350ec236126ed1a74cfe60359fbfd801e2047ca"
SRC_URI[stratix10_nand_core.sha256sum] = "4fc65f0da161cf6fe065de576496d22ebbf26c509850b852f8d2a37ec1c0c87c"
SRC_URI[stratix10_pr_persona0.sha256sum] = "07019426f14cc1e6b7fcc99fd984bf3d5c57ecf6eb117fa84a8c04774f183dda"
SRC_URI[stratix10_pr_persona1.sha256sum] = "bc58db2f5461d982a1676a420144d16235c6625a0e7a23cab968a0567d82fc82"

SRC_URI[arria10_gsrd_core.sha256sum] = "3150d4f068740f0144e822f046844fb58db5c1ed290bbc6d8d0878cd21b1c4a0"
SRC_URI[arria10_gsrd_periph.sha256sum] = "f84988806c9a40c6cfd00ef4c2f9273e8b9b52ba14a2fc14500cae4521055b7c"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "65b05cd6027c6e198f78dc3aeb7c83913901a1daffa6d7a9ba6a2ddbb89cdb18"
SRC_URI[arria10_nand_core.sha256sum] = "ae19bd8b3afb600a07ee6ed5c6ec32daa1b2049455a364c3ee6219662984c57b"
SRC_URI[arria10_nand_periph.sha256sum] = "227de94154633cc8648db7057892adfe29a7c395006a7c82ee0ee46203c01d79"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "fb9daa40f08351acf0ca1f2a8d0179a8c45b7b62aff742333229f022d829f080"
SRC_URI[arria10_pcie_core.sha256sum] = "4b578261f5ba14e933dc8fd0f6f0ec4febb2c2de3a6ef90546eff866e4fd65b9"
SRC_URI[arria10_pcie_periph.sha256sum] = "6832457a6edb3416608f462b3aee49d892ce0a35914cd2127ab27769415a0c2d"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "f96da7aed1f31d873bfa2a49316662baceb90c43eb2b6c1ec866de2047b84220"
SRC_URI[arria10_pr_core.sha256sum] = "3f788f364f5cdf44d9b262c842097e19edd50f4e62b1515d71241b4ae948c28d"
SRC_URI[arria10_pr_periph.sha256sum] = "1f052f6d262fe996fa46f3b0162aa9acb9c973e1d8950f53ae78de7979aaa637"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "532404497c4e528881a4948818a7e1272bc2a102dd45c4ff25402eb2e816cffe"
SRC_URI[arria10_pr_persona0.sha256sum] = "fefe831caf3106e5e7c00b33db373d0a0e3c7a9152f0240738b188efba0df3dc"
SRC_URI[arria10_pr_persona1.sha256sum] = "9125f5a94af366ccba1a0c8649e415d68e3dcb445ba6b2bb5b8c41bcc813b342"
SRC_URI[arria10_qspi_core.sha256sum] = "e0e5443b67a76d027f56f42fc4a830a285599b68534e95e64492496f13174156"
SRC_URI[arria10_qspi_periph.sha256sum] = "d82afb8aec8f1e7cdc8f89c95832773ae5e6a89f6bbf9a2adb3ca8ef4e872858"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "9e93b0f6083faf4704cacf0e30e881615ad499d2f6d8e2eda239224599763213"
SRC_URI[arria10_sgmii_core.sha256sum] = "fd8ebd651d997cf5c7ce7c106dd47c3f00638df509f0e78caacfd825b65d04ce"
SRC_URI[arria10_sgmii_periph.sha256sum] = "9e9f2f32a9d6f86cef5ddf8428fe7ada3806dafd01b1b91750d21c51b73c8b07"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "d5b1235d9d9b9d445cfa9c9367f4488421d9703202830037f0edd7f9cca7dd51"
SRC_URI[arria10_tse_core.sha256sum] = "75a64cd7a378d7dfcf95c83fcad91d64bb624c3abaadfab3904d30718022d4c9"
SRC_URI[arria10_tse_periph.sha256sum] = "bfee2b9ff40f2b74a4696c6f43b69ef9d571d1e2059c54833aaef29e6072fff9"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "78e474c306052838154de2a5f2140d6f99280f004a5cc3c2604ab8ba9a4216f9"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "6c3bc32e8f336846c6b4b40bb7785e76f7fc8210821e71dd017be76aa673551c"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES:${PN} = " \
		/boot \
		/lib/firmware \
		"

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install () {
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${D}/boot/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${D}/boot/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${D}/boot/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${D}/boot/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${D}${base_libdir}/firmware/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${D}${base_libdir}/firmware/persona1.rbf
	fi
}

do_deploy () {
	if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_hps.xml ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/hps.xml
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_PERIPH_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${DEPLOYDIR}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi
}

addtask install after do_configure before do_deploy
addtask deploy after do_install
