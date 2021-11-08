SUMMARY = "U-boot boot environment for Intel SoCFPGA devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "u-boot-socfpga u-boot-mkenvimage-native"

inherit deploy nopackages
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_configure[noexec] = "1"
do_install[noexec] = "1"

do_compile() {
	cp ${DEPLOY_DIR_IMAGE}/u-boot-socfpga-initial-env-${UBOOT_CONFIG} ${WORKDIR}/u-boot-env.txt
	mkenvimage -s 0x2000 -o "${WORKDIR}/u-boot-env.bin" ${WORKDIR}/u-boot-env.txt
}

do_deploy() {
	install -d ${DEPLOYDIR}
		install -m 0755 ${WORKDIR}/u-boot-env.txt ${DEPLOYDIR}/u-boot-env.txt
		install -m 0644 ${WORKDIR}/u-boot-env.bin ${DEPLOYDIR}/u-boot-socfpga-${MACHINE}-${PV}-${PR}-env.bin
		ln -sf u-boot-socfpga-${MACHINE}-${PV}-${PR}-env.bin ${DEPLOYDIR}/u-boot-env.bin
}

addtask do_deploy after do_compile before do_build

