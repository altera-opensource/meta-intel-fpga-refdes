SUMMARY = "U-boot boot scripts for Intel SoCFPGA devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS = "u-boot-mkimage-native dtc-native"

inherit deploy nopackages
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI:agilex_fm61 = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex_fm87 = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex_fm87_linear = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex_fm86 = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex5 = "file://agilex5_uboot.txt file://agilex5_uboot_script.its"
SRC_URI:stratix10 = "file://uboot.txt file://uboot_script.its"
SRC_URI:arria10 = "file://arria10_u-boot.txt"
SRC_URI:cyclone5 = "file://cyclone5_u-boot.txt"
SRC_URI:n5x = "file://n5x_u-boot.txt"

do_configure[noexec] = "1"
do_install[noexec] = "1"

do_compile:n5x() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "N5X Script" -d "${WORKDIR}/${MACHINE}_u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile() {
	if [[ "${MACHINE}" == *"agilex_"* ]]; then
		mkimage -f "${WORKDIR}/uboot_script.its" ${WORKDIR}/boot.scr.uimg
	fi
}

do_compile:agilex5() {
	mkimage -f "${WORKDIR}/agilex5_uboot_script.its" ${WORKDIR}/boot.scr.uimg
}

do_compile:stratix10() {
	mkimage -f "${WORKDIR}/uboot_script.its" ${WORKDIR}/boot.scr.uimg
}

do_compile:cyclone5() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Cyclone5 Script" -d "${WORKDIR}/${MACHINE}_u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile:arria10() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Arria10 Script" -d "${WORKDIR}/${MACHINE}_u-boot.txt" ${WORKDIR}/boot.scr
}

do_deploy() {
	install -d ${DEPLOYDIR}
	if [[ "${MACHINE}" == "arria10" ]]; then
		install -m 0755 ${WORKDIR}/${MACHINE}_u-boot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/boot.scr ${DEPLOYDIR}/boot.scr
	elif [[ "${MACHINE}" == *"agilex_"* ]] || [[ "${MACHINE}" == "stratix10" ]]; then
		install -m 0755 ${WORKDIR}/uboot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/boot.scr.uimg ${DEPLOYDIR}/boot.scr.uimg
	elif [[ "${MACHINE}" == "agilex5" ]]; then
		install -m 0755 ${WORKDIR}/agilex5_uboot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/boot.scr.uimg ${DEPLOYDIR}/boot.scr.uimg
	elif [[ "${MACHINE}" == "n5x" ]] || [[ "${MACHINE}" == "cyclone5" ]]; then
		install -m 0755 ${WORKDIR}/${MACHINE}_u-boot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/u-boot.scr ${DEPLOYDIR}/u-boot.scr
	else
		:
	fi
}

addtask do_deploy after do_compile before do_build
