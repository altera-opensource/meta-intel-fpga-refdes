SUMMARY = "U-boot boot scripts for Altera SoCFPGA devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS = "u-boot-mkimage-native dtc-native"

inherit deploy nopackages
PACKAGE_ARCH = "${MACHINE_ARCH}"

HYP_BUILD ??= "0"

SRC_URI:agilex7_dk_si_agf014eb = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex7_dk_si_agi027fc = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex7_dk_dev_agm039fes = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex7_dk_dev_agm039ea = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex7_dk_dev_agf023fa = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex5 = "file://agilex5_uboot.txt file://agilex5_uboot_script.its"
SRC_URI:agilex5_dk_a5e065bb32aes1 = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex5_dk_a5e013bm16aea = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex5_dk_a5e013bb32aes = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex5_dk_a5e013bb32aes_5s = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex5_mk_a5e065bb32aes1 = "file://uboot.txt file://uboot_script.its"
SRC_URI:agilex3 = "file://agilex3_uboot.txt file://agilex3_uboot_script.its"
SRC_URI:stratix10_htile = "file://uboot.txt file://uboot_script.its"
SRC_URI:arria10 = "file://arria10_u-boot.txt"
SRC_URI:cyclone5 = "file://cyclone5_u-boot.txt"
SRC_URI:n5x = "file://n5x_u-boot.txt"

SRC_URI:append:agilex3 = " ${@bb.utils.contains('HYP_BUILD', '1', 'file://agilex3_uboot_xen.txt file://agilex3_uboot_script_xen.its', '', d)}"
SRC_URI:append:agilex5_dk_a5e065bb32aes1 = " ${@bb.utils.contains('HYP_BUILD', '1', 'file://agilex5_uboot_xen.txt file://agilex5_uboot_script_xen.its file://agilex5_uboot_xen_emmc.txt file://agilex5_uboot_script_xen_emmc.its file://agilex5_uboot_xen_debug.txt file://agilex5_uboot_script_xen_debug.its', '', d)}"
SRC_URI:append:agilex5_dk_a5e013bm16aea = " ${@bb.utils.contains('HYP_BUILD', '1', 'file://agilex5_013b_uboot_xen.txt file://agilex5_013b_uboot_script_xen.its', '', d)}"
SRC_URI:append:agilex5_dk_a5e013bb32aes = " ${@bb.utils.contains('HYP_BUILD', '1', 'file://agilex5_uboot_xen.txt file://agilex5_uboot_script_xen.its file://agilex5_uboot_xen_emmc.txt file://agilex5_uboot_script_xen_emmc.its file://agilex5_uboot_xen_debug.txt file://agilex5_uboot_script_xen_debug.its', '', d)}"
SRC_URI:append:agilex5_dk_a5e013bb32aes_5s = " ${@bb.utils.contains('HYP_BUILD', '1', 'file://agilex5_uboot_xen.txt file://agilex5_uboot_script_xen.its file://agilex5_uboot_xen_emmc.txt file://agilex5_uboot_script_xen_emmc.its file://agilex5_uboot_xen_debug.txt file://agilex5_uboot_script_xen_debug.its', '', d)}"
SRC_URI:append:agilex5_mk_a5e065bb32aes1 = " ${@bb.utils.contains('HYP_BUILD', '1', 'file://agilex5_uboot_xen.txt file://agilex5_uboot_script_xen.its file://agilex5_uboot_xen_emmc.txt file://agilex5_uboot_script_xen_emmc.its file://agilex5_uboot_xen_debug.txt file://agilex5_uboot_script_xen_debug.its', '', d)}"
SRC_URI:append:agilex7_dk_si_agf014eb = " ${@bb.utils.contains('HYP_BUILD', '1', 'file://agilex7_uboot_xen.txt file://agilex7_uboot_script_xen.its', '', d)}"

S = "${WORKDIR}/sources-unpack"

do_configure[noexec] = "1"
do_install[noexec] = "1"

do_compile:n5x() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "N5X Script" -d "${WORKDIR}/sources-unpack/${MACHINE}_u-boot.txt" ${WORKDIR}/sources-unpack/u-boot.scr
}

do_compile() {
	if [[ "${MACHINE}" == *"agilex7_"* ]]; then
		mkimage -f "${WORKDIR}/sources-unpack/uboot_script.its" ${WORKDIR}/sources-unpack/boot.scr.uimg
		export HYP_BUILD="${@bb.utils.contains('HYP_BUILD', '1', '1', '0', d)}"
		if [[ "${HYP_BUILD}" = "1" ]]; then
			mkimage -f "${WORKDIR}/sources-unpack/agilex7_uboot_script_xen.its" ${WORKDIR}/sources-unpack/boot.scr.xen.uimg
		fi
	fi
}

do_compile:agilex5() {
	mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script.its" ${WORKDIR}/sources-unpack/boot.scr.uimg
}

do_compile:agilex5_dk_a5e065bb32aes1() {
	mkimage -f "${WORKDIR}/sources-unpack/uboot_script.its" ${WORKDIR}/sources-unpack/boot.scr.uimg
	export HYP_BUILD="${@bb.utils.contains('HYP_BUILD', '1', '1', '0', d)}"
	if [[ "${HYP_BUILD}" = "1" ]]; then
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen.its" ${WORKDIR}/sources-unpack/boot.scr.xen.uimg
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen_emmc.its" ${WORKDIR}/sources-unpack/boot.scr.xen.emmc.uimg
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen_debug.its" ${WORKDIR}/sources-unpack/boot.scr.xen.debug.uimg
	fi
}

do_compile:agilex5_dk_a5e013bm16aea() {
	mkimage -f "${WORKDIR}/sources-unpack/uboot_script.its" ${WORKDIR}/sources-unpack/boot.scr.uimg
	export HYP_BUILD="${@bb.utils.contains('HYP_BUILD', '1', '1', '0', d)}"
	if [[ "${HYP_BUILD}" = "1" ]]; then
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_013b_uboot_script_xen.its" ${WORKDIR}/sources-unpack/boot.scr.xen.uimg
	fi
}

do_compile:agilex5_dk_a5e013bb32aes() {
	mkimage -f "${WORKDIR}/sources-unpack/uboot_script.its" ${WORKDIR}/sources-unpack/boot.scr.uimg
	export HYP_BUILD="${@bb.utils.contains('HYP_BUILD', '1', '1', '0', d)}"
	if [[ "${HYP_BUILD}" = "1" ]]; then
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen.its" ${WORKDIR}/sources-unpack/boot.scr.xen.uimg
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen_emmc.its" ${WORKDIR}/sources-unpack/boot.scr.xen.emmc.uimg
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen_debug.its" ${WORKDIR}/sources-unpack/boot.scr.xen.debug.uimg
	fi
}

do_compile:agilex5_dk_a5e013bb32aes_5s() {
	mkimage -f "${WORKDIR}/sources-unpack/uboot_script.its" ${WORKDIR}/sources-unpack/boot.scr.uimg
	export HYP_BUILD="${@bb.utils.contains('HYP_BUILD', '1', '1', '0', d)}"
	if [[ "${HYP_BUILD}" = "1" ]]; then
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen.its" ${WORKDIR}/sources-unpack/boot.scr.xen.uimg
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen_emmc.its" ${WORKDIR}/sources-unpack/boot.scr.xen.emmc.uimg
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen_debug.its" ${WORKDIR}/sources-unpack/boot.scr.xen.debug.uimg
	fi
}

do_compile:agilex5_mk_a5e065bb32aes1() {
	mkimage -f "${WORKDIR}/sources-unpack/uboot_script.its" ${WORKDIR}/sources-unpack/boot.scr.uimg
        export HYP_BUILD="${@bb.utils.contains('HYP_BUILD', '1', '1', '0', d)}"
        if [[ "${HYP_BUILD}" = "1" ]]; then
                mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen.its" ${WORKDIR}/sources-unpack/boot.scr.xen.uimg
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen_emmc.its" ${WORKDIR}/sources-unpack/boot.scr.xen.emmc.uimg
		mkimage -f "${WORKDIR}/sources-unpack/agilex5_uboot_script_xen_debug.its" ${WORKDIR}/sources-unpack/boot.scr.xen.debug.uimg
        fi
}

do_compile:agilex3() {
	mkimage -f "${WORKDIR}/sources-unpack/agilex3_uboot_script.its" ${WORKDIR}/sources-unpack/boot.scr.uimg
	export HYP_BUILD="${@bb.utils.contains('HYP_BUILD', '1', '1', '0', d)}"
	if [[ "${HYP_BUILD}" = "1" ]]; then
		mkimage -f "${WORKDIR}/sources-unpack/agilex3_uboot_script_xen.its" ${WORKDIR}/sources-unpack/boot.scr.xen.uimg
	fi
}

do_compile:stratix10_htile() {
	mkimage -f "${WORKDIR}/sources-unpack/uboot_script.its" ${WORKDIR}/sources-unpack/boot.scr.uimg
}

do_compile:cyclone5() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Cyclone5 Script" -d "${WORKDIR}/sources-unpack/${MACHINE}_u-boot.txt" ${WORKDIR}/sources-unpack/u-boot.scr
}

do_compile:arria10() {
	mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Arria10 Script" -d "${WORKDIR}/sources-unpack/${MACHINE}_u-boot.txt" ${WORKDIR}/sources-unpack/boot.scr
}

do_deploy() {
	export HYP_BUILD="${@bb.utils.contains('HYP_BUILD', '1', '1', '0', d)}"
	install -d ${DEPLOYDIR}
	if [[ "${MACHINE}" == "arria10" ]]; then
		install -m 0755 ${WORKDIR}/sources-unpack/${MACHINE}_u-boot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/sources-unpack/boot.scr ${DEPLOYDIR}/boot.scr
	elif [[ "${MACHINE}" == *"agilex7_"* ]] || [[ "${MACHINE}" == *"stratix10"* ]]; then
		install -m 0755 ${WORKDIR}/sources-unpack/uboot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/sources-unpack/boot.scr.uimg ${DEPLOYDIR}/boot.scr.uimg
		if [[ "${HYP_BUILD}" = "1" ]]; then
			install -m 0755 ${WORKDIR}/sources-unpack/agilex7_uboot_xen.txt ${DEPLOYDIR}/u-boot_xen.txt
			install -m 0644 ${WORKDIR}/sources-unpack/boot.scr.xen.uimg ${DEPLOYDIR}/boot.scr.xen.uimg
		fi
	elif [[ "${MACHINE}" == "agilex5" ]]; then
		install -m 0755 ${WORKDIR}/sources-unpack/agilex5_uboot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/sources-unpack/boot.scr.uimg ${DEPLOYDIR}/boot.scr.uimg
	elif [[ "${MACHINE}" == *"agilex5_"* ]]; then
		install -m 0755 ${WORKDIR}/sources-unpack/uboot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/sources-unpack/boot.scr.uimg ${DEPLOYDIR}/boot.scr.uimg
		if [[ "${HYP_BUILD}" = "1" ]]; then
			install -m 0644 ${WORKDIR}/sources-unpack/boot.scr.xen.uimg ${DEPLOYDIR}/boot.scr.xen.uimg
			if [[ "${MACHINE}" == "agilex5_dk_a5e013bm16aea" ]]; then
				install -m 0755 ${WORKDIR}/sources-unpack/agilex5_013b_uboot_xen.txt ${DEPLOYDIR}/u-boot_xen.txt
			else
				install -m 0755 ${WORKDIR}/sources-unpack/agilex5_uboot_xen.txt ${DEPLOYDIR}/u-boot_xen.txt
				install -m 0755 ${WORKDIR}/sources-unpack/agilex5_uboot_xen_emmc.txt ${DEPLOYDIR}/u-boot_xen_emmc.txt
				install -m 0644 ${WORKDIR}/sources-unpack/boot.scr.xen.emmc.uimg ${DEPLOYDIR}/boot.scr.xen.emmc.uimg
				install -m 0755 ${WORKDIR}/sources-unpack/agilex5_uboot_xen_debug.txt ${DEPLOYDIR}/u-boot_xen_debug.txt
				install -m 0644 ${WORKDIR}/sources-unpack/boot.scr.xen.debug.uimg ${DEPLOYDIR}/boot.scr.xen.debug.uimg
			fi
		fi
	elif [[ "${MACHINE}" == *"agilex3"* ]]; then
		install -m 0755 ${WORKDIR}/sources-unpack/agilex3_uboot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/sources-unpack/boot.scr.uimg ${DEPLOYDIR}/boot.scr.uimg
		if [[ "${HYP_BUILD}" = "1" ]]; then
			install -m 0755 ${WORKDIR}/sources-unpack/agilex3_uboot_xen.txt ${DEPLOYDIR}/u-boot_xen.txt
			install -m 0644 ${WORKDIR}/sources-unpack/boot.scr.xen.uimg ${DEPLOYDIR}/boot.scr.xen.uimg
		fi
	elif [[ "${MACHINE}" == "n5x" ]] || [[ "${MACHINE}" == "cyclone5" ]]; then
		install -m 0755 ${WORKDIR}/sources-unpack/${MACHINE}_u-boot.txt ${DEPLOYDIR}/u-boot.txt
		install -m 0644 ${WORKDIR}/sources-unpack/u-boot.scr ${DEPLOYDIR}/u-boot.scr
	else
		:
	fi
}

addtask do_deploy after do_compile before do_build
