SUMMARY = "U-boot boot environment for Intel SoCFPGA devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/env:"

DEPENDS = "u-boot-mkenvimage-native"

inherit deploy nopackages
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI:agilex7_dk_si_agf014ea = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk", "file://agilex-socdk_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-atf", "file://agilex-socdk-atf_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-qspi", "file://agilex-socdk-qspi_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-qspi-atf", "file://agilex-socdk-qspi-atf_u-boot-env.txt", "", d)} \
			 "

SRC_URI:agilex7_dk_si_agf014eb = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk", "file://agilex-socdk_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-atf", "file://agilex-socdk-atf_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-qspi", "file://agilex-socdk-qspi_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-qspi-atf", "file://agilex-socdk-qspi-atf_u-boot-env.txt", "", d)} \
			 "

SRC_URI:stratix10 = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk", "file://stratix10-socdk_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-atf", "file://stratix10-socdk-atf_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-qspi", "file://stratix10-socdk-qspi_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-qspi-atf", "file://stratix10-socdk-qspi-atf_u-boot-env.txt", "", d)} \
			 "

SRC_URI:stratix10_htile = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk", "file://stratix10-socdk_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-atf", "file://stratix10-socdk-atf_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-qspi", "file://stratix10-socdk-qspi_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-qspi-atf", "file://stratix10-socdk-qspi-atf_u-boot-env.txt", "", d)} \
			 "

SRC_URI:arria10 = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "arria10-socdk", "file://arria10-socdk_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "arria10-socdk-qspi", "file://arria10-socdk-qspi_u-boot-env.txt", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "arria10-socdk-nand", "file://arria10-socdk-nand_u-boot-env.txt", "", d)} \
			 "

SRC_URI:n5x = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "n5x-socdk-atf", "file://n5x-socdk-atf_u-boot-env.txt", "", d)} \
			 "


do_configure[noexec] = "1"
do_install[noexec] = "1"

do_compile() {
	mkenvimage -s 0x2000 -o "${WORKDIR}/uboot.env" ${WORKDIR}/${UBOOT_CONFIG}_u-boot-env.txt
}

do_deploy() {
	install -d ${DEPLOYDIR}
		install -m 0755 ${WORKDIR}/${UBOOT_CONFIG}_u-boot-env.txt ${DEPLOYDIR}/u-boot-env.txt
		install -m 0644 ${WORKDIR}/uboot.env ${DEPLOYDIR}/u-boot-socfpga-${MACHINE}-${PV}-${PR}.env
		ln -sf u-boot-socfpga-${MACHINE}-${PV}-${PR}.env ${DEPLOYDIR}/uboot.env
}

addtask do_deploy after do_compile before do_build

