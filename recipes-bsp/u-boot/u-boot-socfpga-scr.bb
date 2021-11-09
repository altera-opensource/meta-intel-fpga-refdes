SUMMARY = "U-boot boot scripts for Intel SoCFPGA devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS = "u-boot-mkimage-native"

inherit deploy nopackages
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI:agilex = "${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://agilex_uboot.txt", "file://agilex_u-boot.txt", d)}"
SRC_URI:stratix10 = "${@bb.utils.contains("IMAGE_TYPE", "gsrd", "file://stratix10_uboot.txt", "file://stratix10_u-boot.txt", d)}"
SRC_URI:arria10 = "file://arria10_u-boot.txt"
SRC_URI:cyclone5 = "file://cyclone5_u-boot.txt"
SRC_URI:n5x = "file://n5x_u-boot.txt"

do_configure[noexec] = "1"
do_install[noexec] = "1"

do_compile:n5x() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "N5X Script" -d "${WORKDIR}/${MACHINE}_u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile:agilex() {
	if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
		mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Agilex Script" -d "${WORKDIR}/${MACHINE}_uboot.txt" ${WORKDIR}/boot.scr
	else
		mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Agilex Script" -d "${WORKDIR}/${MACHINE}_u-boot.txt" ${WORKDIR}/u-boot.scr
	fi
}

do_compile:stratix10() {
	if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
		mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Stratix10 Script" -d "${WORKDIR}/${MACHINE}_uboot.txt" ${WORKDIR}/boot.scr
	else
		mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Stratix10 Script" -d "${WORKDIR}/${MACHINE}_u-boot.txt" ${WORKDIR}/u-boot.scr
	fi
}

do_compile:cyclone5() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Cyclone5 Script" -d "${WORKDIR}/${MACHINE}_u-boot.txt" ${WORKDIR}/u-boot.scr
}

do_compile:arria10() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Arria10 Script" -d "${WORKDIR}/${MACHINE}_u-boot.txt" ${WORKDIR}/boot.scr
}

do_deploy() {
	install -d ${DEPLOYDIR}

	if ${@bb.utils.contains("MACHINE", "arria10", "true", "false", d)}; then
		install -m 0644 ${WORKDIR}/boot.scr ${DEPLOYDIR}/boot.scr
	else
		if ${@bb.utils.contains("MACHINE", "agilex", "true", "false", d)} || ${@bb.utils.contains("MACHINE", "stratix10", "true", "false", d)} ; then
			if ${@bb.utils.contains("IMAGE_TYPE", "gsrd", "true", "false", d)} ; then
				install -m 0755 ${WORKDIR}/${MACHINE}_uboot.txt ${DEPLOYDIR}/uboot.txt
				install -m 0644 ${WORKDIR}/boot.scr ${DEPLOYDIR}/boot.scr
			else
				install -m 0755 ${WORKDIR}/${MACHINE}_u-boot.txt ${DEPLOYDIR}/u-boot.txt
				install -m 0644 ${WORKDIR}/u-boot.scr ${DEPLOYDIR}/u-boot.scr
			fi
		else
			install -m 0755 ${WORKDIR}/${MACHINE}_u-boot.txt ${DEPLOYDIR}/u-boot.txt
			install -m 0644 ${WORKDIR}/u-boot.scr ${DEPLOYDIR}/u-boot.scr
		fi
	fi
}

addtask do_deploy after do_compile before do_build
