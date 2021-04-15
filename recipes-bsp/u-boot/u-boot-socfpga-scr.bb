SUMMARY = "U-boot boot scripts for Intel SoCFPGA devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "u-boot-mkimage-native"

inherit deploy nopackages
PACKAGE_ARCH = "${MACHINE_ARCH}"

SCRIPT_REPO ?= "https://releases.rocketboards.org/release/uboot-script"

SRC_URI_agilex = "${SCRIPT_REPO}/agilex/u-boot.txt;name=agilex_scr"

SRC_URI_stratix10 = "${SCRIPT_REPO}/stratix10/u-boot.txt;name=stratix10_scr"

SRC_URI_arria10 = "${SCRIPT_REPO}/arria10/u-boot.txt;name=arria10_scr"

SRC_URI_cyclone5 = "${SCRIPT_REPO}/cyclone5/u-boot.txt;name=cyclone5_scr"

SRC_URI[agilex_scr.sha256sum] = "ea9475878de5b42d943e0c394f064bc3e2907a8b8a577b7ebc9706e7c97aefa5"
SRC_URI[stratix10_scr.sha256sum] = "ea9475878de5b42d943e0c394f064bc3e2907a8b8a577b7ebc9706e7c97aefa5"
SRC_URI[arria10_scr.sha256sum] = "f3b9861eb12696d1f3e3fe1ada6b0dc100201cbb12170731e3c0dcd7ee1ae042"
SRC_URI[cyclone5_scr.sha256sum] = "687d5205c1ec54809d0de263d0a0abd33e05cdbe859dc87f3b7ca0196bdb9b6e"

do_configure[noexec] = "1"
do_install[noexec] = "1"

do_compile_agilex() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Agilex Script" -d "${WORKDIR}/u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile_stratix10() {
        mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Stratix10 Script" -d "${WORKDIR}/u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile_cyclone5() {
        mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Cyclone5 Script" -d "${WORKDIR}/cyclone5/u-boot.txt" ${WORKDIR}/u-boot.scr
}

# U-boot script for Arria10 PR variant
do_compile_arria10() {
        mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Arria10 Script" -d "${WORKDIR}/arria10/u-boot.txt" ${WORKDIR}/boot.scr
}

do_deploy() {
	install -d ${DEPLOYDIR}

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)}; then
		install -m 0644 ${WORKDIR}/boot.scr ${DEPLOYDIR}/u-boot-socfpga-${MACHINE}-${PV}-${PR}.scr
		ln -sf u-boot-socfpga-${MACHINE}-${PV}-${PR}.scr ${DEPLOYDIR}/boot.scr
	else
		install -m 0644 ${WORKDIR}/u-boot.scr ${DEPLOYDIR}/u-boot-socfpga-${MACHINE}-${PV}-${PR}.scr
		ln -sf u-boot-socfpga-${MACHINE}-${PV}-${PR}.scr ${DEPLOYDIR}/u-boot.scr
	fi
}

addtask do_deploy after do_compile before do_build
