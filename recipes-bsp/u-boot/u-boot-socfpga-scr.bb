SUMMARY = "U-boot boot scripts for Intel SoCFPGA devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "u-boot-mkimage-native"

inherit deploy nopackages
PACKAGE_ARCH = "${MACHINE_ARCH}"

RBO_RELEASE_VER ?= "2021.11"

SCRIPT_REPO ?= "https://releases.rocketboards.org/release/${RBO_RELEASE_VER}/uboot-script"

SRC_URI:agilex = "${SCRIPT_REPO}/agilex/u-boot.txt;name=agilex_scr"
SRC_URI:stratix10 = "${SCRIPT_REPO}/stratix10/u-boot.txt;name=stratix10_scr"
SRC_URI:arria10 = "${SCRIPT_REPO}/arria10/u-boot.txt;name=arria10_scr"
SRC_URI:cyclone5 = "${SCRIPT_REPO}/cyclone5/u-boot.txt;name=cyclone5_scr"
SRC_URI:n5x = "${SCRIPT_REPO}/n5x/u-boot.txt;name=n5x_scr"

SRC_URI[agilex_scr.sha256sum] = "ea9475878de5b42d943e0c394f064bc3e2907a8b8a577b7ebc9706e7c97aefa5"
SRC_URI[stratix10_scr.sha256sum] = "991b871937f72138d5d4d2470c36d6483ec37e4ec3de8adc9f21e4faf618d976"
SRC_URI[arria10_scr.sha256sum] = "f3b9861eb12696d1f3e3fe1ada6b0dc100201cbb12170731e3c0dcd7ee1ae042"
SRC_URI[cyclone5_scr.sha256sum] = "687d5205c1ec54809d0de263d0a0abd33e05cdbe859dc87f3b7ca0196bdb9b6e"
SRC_URI[n5x_scr.sha256sum] = "ac4419a6226574df2e11206e59cc4eadf34b08b107c1237b002717548ffaa311"

do_configure[noexec] = "1"
do_install[noexec] = "1"

do_compile:n5x() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "N5X Script" -d "${WORKDIR}/u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile:agilex() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Agilex Script" -d "${WORKDIR}/u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile:stratix10() {
        mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Stratix10 Script" -d "${WORKDIR}/u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile:cyclone5() {
        mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Cyclone5 Script" -d "${WORKDIR}/u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile:arria10() {
        mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Arria10 Script" -d "${WORKDIR}/u-boot.txt" ${WORKDIR}/boot.scr
}

do_deploy() {
	install -d ${DEPLOYDIR}

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)}; then
		install -m 0644 ${WORKDIR}/boot.scr ${DEPLOYDIR}/u-boot-socfpga-${MACHINE}-${PV}-${PR}.scr
		ln -sf u-boot-socfpga-${MACHINE}-${PV}-${PR}.scr ${DEPLOYDIR}/boot.scr
	else
		install -m 0755 ${WORKDIR}/u-boot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/u-boot.scr ${DEPLOYDIR}/u-boot-socfpga-${MACHINE}-${PV}-${PR}.scr
		ln -sf u-boot-socfpga-${MACHINE}-${PV}-${PR}.scr ${DEPLOYDIR}/u-boot.scr
	fi
}

addtask do_deploy after do_compile before do_build
