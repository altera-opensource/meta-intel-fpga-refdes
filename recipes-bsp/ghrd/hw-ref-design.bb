SUMMARY = "Intel SoCFPGA Golden Hardware Reference Design (GHRD)"
DESCRIPTION = "Prebuilt FPGA bitstream for SOC Development Kit"
SECTION = "bsp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit deploy

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

IMAGE_TYPE ?= "gsrd"

RBO_RELEASE_VER ?= "2022.03"
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

SRC_URI[agilex_gsrd_core.sha256sum] = "63d56d8c3e9926d5c422aa5255d63cf3ad34b2428884318725a074365db7a07e"
SRC_URI[agilex_nand_core.sha256sum] = "ecafbd99b6796664c0cee78269fa5cb6e0a0ce62ec09f61b032936bf0af10ab8"
SRC_URI[agilex_pr_core.sha256sum] = "e34b2ae820e68366799303eeb5a31d3971cf6d4745d88f0eab2bccbaca8312a7"
SRC_URI[agilex_pr_persona0.sha256sum] = "7341cdd97692af1bbe9b532be8631c8150a70275b8e20f44c4b1af99ed47c714"
SRC_URI[agilex_pr_persona1.sha256sum] = "b19b46981ce584bd23163b6d08e0ad4549f521ac5a0f45a8ae902b8b828a418a"

SRC_URI[stratix10_gsrd_core.sha256sum] = "b7a9fca5f1ec7f48d6b318d56469bf792ba010c4063ac0e0fe76eafe3bb896e9"
SRC_URI[stratix10_nand_core.sha256sum] = "b515a656ce3e712c9c8d61498696dd45a703ea3c1b7137e70d1f360e6c917409"
SRC_URI[stratix10_pr_persona0.sha256sum] = "aa2ce6569ee9b6005c3f35bc4a9ec8b4dd56182865a028f6519d1fc30a6a33b9"
SRC_URI[stratix10_pr_persona1.sha256sum] = "61184b6f3ad920df24c3d4ac69720e1b8bfa0e38fe235ea0b2bbb822c9df3f93"

SRC_URI[arria10_gsrd_core.sha256sum] = "75c4f42da14962adf480a156575b92cbfe8c22e73b0d5b6176f95c499daf70c9"
SRC_URI[arria10_gsrd_periph.sha256sum] = "db77d00e929ca1930925d48f1de745c54521c4bfe9003502977f03073f17f4f9"
SRC_URI[arria10_gsrd_hps_xml.sha256sum] = "1b0f97d815886ce343b3acfe5cb8965bc45389a5fa9bbdf212085a6259f6998b"
SRC_URI[arria10_nand_core.sha256sum] = "822c39581714e82a65fac3194acecaa8389144b364db61ced2d5c6fc37dc01e7"
SRC_URI[arria10_nand_periph.sha256sum] = "04549e9fb277f36e276ce7f3f179a370497ee8439573653919e617c5d81f50ab"
SRC_URI[arria10_nand_hps_xml.sha256sum] = "cd71971b184e7298de1eac5d7897a4d8aa41ccb766d48bf9cda91fb66824d74d"
SRC_URI[arria10_pcie_core.sha256sum] = "12099c18eda6bc335bf039c439d79ef0e4f938846740e0f73545705670bb086f"
SRC_URI[arria10_pcie_periph.sha256sum] = "1469fd62e758d3061afc611fdb5d686f3cda1e5f125e02e5fee82d355451ded6"
SRC_URI[arria10_pcie_hps_xml.sha256sum] = "b8bb60f640320a55a208bf5a6a53b3a2f30668150dc41930ddeadcf07220d81e"
SRC_URI[arria10_pr_core.sha256sum] = "157725940f4c80a8410d447b71cd40333bc9b837d4c64da247c0702f8e2bdae3"
SRC_URI[arria10_pr_periph.sha256sum] = "897508b76ae38b642a080c540fa9da81e0f5500b62ea6881e32a4272557202c2"
SRC_URI[arria10_pr_hps_xml.sha256sum] = "030e78f2b00f23782413d7c3a7d2602cb605676346e1fe11c236fcc51d6ea3be"
SRC_URI[arria10_pr_persona0.sha256sum] = "9908fb26fca8c268efd9ff579b9698cb052d4441e15b6c49bd11218e21752c5c"
SRC_URI[arria10_pr_persona1.sha256sum] = "1b3efbe0e482f258fc4aa632f643d427cdcebc4b7b78e0691e2b31c9612267a1"
SRC_URI[arria10_qspi_core.sha256sum] = "3f21d34c05633095ed8c545cd65eeadb87e4e00fe7cbf05924aa0b5e54c59103"
SRC_URI[arria10_qspi_periph.sha256sum] = "00f7d1d255656684b821b92d2fc03a90123b7890b64a8f6e0bd5e5a71ce77cc9"
SRC_URI[arria10_qspi_hps_xml.sha256sum] = "5347db5949b7337ec84799b7cbdc452b3d334cc8f699d5559024f968d28731cd"
SRC_URI[arria10_sgmii_core.sha256sum] = "884b8cb63d7f1fb722ffb7c06af43eb61f5d98691e9410fa8252ae49c15a3110"
SRC_URI[arria10_sgmii_periph.sha256sum] = "e5e216e8502dde04b17b6ab7813b5f9ac33e85de78e4e6e16e9765ef05c8c0aa"
SRC_URI[arria10_sgmii_hps_xml.sha256sum] = "718523ce4bf7c60e00c56c87273b708517d7f621f452a295926bd9ff7d57e45e"
SRC_URI[arria10_tse_core.sha256sum] = "fb02d3bd1b3dc7b6a1187a5d607699c69c8cdfa6476eb74d6c746e54951edb8f"
SRC_URI[arria10_tse_periph.sha256sum] = "2ccfb1eb2f21aa1834370dc79c8e9e3d15fae71b1eeae044dbfb92e3e87ed4c4"
SRC_URI[arria10_tse_hps_xml.sha256sum] = "04362753cdefb506423c50aa8de2e24e7716dfa8d19c02291383d5869b6a91ca"

SRC_URI[cyclone5_gsrd_core.sha256sum] = "6c3bc32e8f336846c6b4b40bb7785e76f7fc8210821e71dd017be76aa673551c"

S ?= "${WORKDIR}/${MACHINE}"

PROVIDES = "virtual/bitstream"

FILES:${PN} = " \
		/boot \
		/lib/firmware \
		"

PACKAGES = "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy[nostamp] = "1"

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
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/ghrd_pr.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_gsrd_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_gsrd_ghrd/${ARM64_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_nand_${ARM64_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/nand.core.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_pr_persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_hps.xml ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/hps.xml
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_CORE_RBF}
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${A10_GHRD_PERIPH_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${A10_GHRD_PERIPH_RBF}
	fi

	if ${@bb.utils.contains("MACHINE", "cyclone5", "true", "false", d)} ; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_${C5_GHRD_CORE_RBF} ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/${C5_GHRD_CORE_RBF}
	fi

	if ${@bb.utils.contains("IMAGE_TYPE", "pr", "true", "false", d)}; then
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona0.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona0.rbf
		install -D -m 0644 ${WORKDIR}/${MACHINE}_${IMAGE_TYPE}_persona1.rbf ${DEPLOY_DIR_IMAGE}/${MACHINE}_${IMAGE_TYPE}_ghrd/persona1.rbf
	fi
}

addtask install after do_configure before do_deploy
addtask deploy after do_install