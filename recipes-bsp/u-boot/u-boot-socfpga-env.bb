SUMMARY = "U-boot boot environment for Intel SoCFPGA devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "u-boot-mkenvimage-native"

inherit deploy nopackages
PACKAGE_ARCH = "${MACHINE_ARCH}"

ENV_REPO = "https://releases.rocketboards.org/release/uboot-env"

SRC_URI_agilex = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk", "${ENV_REPO}/agilex-socdk/u-boot-env.txt;name=agilex-socdk-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-atf", "${ENV_REPO}/agilex-socdk-atf/u-boot-env.txt;name=agilex-socdk-atf-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-qspi", "${ENV_REPO}/agilex-socdk-qspi/u-boot-env.txt;name=agilex-socdk-qspi-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-qspi-atf", "${ENV_REPO}/agilex-socdk-qspi-atf/u-boot-env.txt;name=agilex-socdk-qspi-atf-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-n6000", "${ENV_REPO}/agilex-socdk/u-boot-env.txt;name=agilex-socdk-env", "", d)} \
			 "

SRC_URI_stratix10 = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk", "${ENV_REPO}/stratix10-socdk/u-boot-env.txt;name=stratix10-socdk-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-atf", "${ENV_REPO}/stratix10-socdk-atf/u-boot-env.txt;name=stratix10-socdk-atf-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-qspi", "${ENV_REPO}/stratix10-socdk-qspi/u-boot-env.txt;name=stratix10-socdk-qspi-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "stratix10-socdk-qspi-atf", "${ENV_REPO}/stratix10-socdk-qspi-atf/u-boot-env.txt;name=stratix10-socdk-qspi-atf-env", "", d)} \
			 "

SRC_URI_arria10 = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "arria10-socdk", "${ENV_REPO}/arria10-socdk/u-boot-env.txt;name=arria10-socdk-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "arria10-socdk-qspi", "${ENV_REPO}/arria10-socdk-qspi/u-boot-env.txt;name=arria10-socdk-qspi-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "arria10-socdk-nand", "${ENV_REPO}/arria10-socdk-nand/u-boot-env.txt;name=arria10-socdk-nand-env", "", d)} \
			 "

SRC_URI_n5x = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "n5x-socdk-atf", "${ENV_REPO}/n5x-socdk-atf/u-boot-env.txt;name=n5x-socdk-atf-env", "", d)} \
			 "

SRC_URI[agilex-socdk-env.sha256sum] = "4d8f41266272f003015f00eaac6c7727d7105149dd156db1dc04086b002d208b"
SRC_URI[agilex-socdk-atf-env.sha256sum] = "cc52aa9dfeda8f0ad88738a0651c345511fea6f4810981d8da36a2bb3cf2cd63"
SRC_URI[agilex-socdk-qspi-env.sha256sum] = "209a4a8dff2fe2be67e5b3baa8e7e5589d86dee24d134fc79be45102327049f6"
SRC_URI[agilex-socdk-qspi-atf-env.sha256sum] = "90a6a4f39d5fc520cd0c814cec6aa828add0b22e304f6257b6dd4d1a9920ad8e"

SRC_URI[stratix10-socdk-env.sha256sum] = "4370fbb52270bf55aad96c543f7a7bca5faf4771acf87993bd49a5d553f78a6c"
SRC_URI[stratix10-socdk-atf-env.sha256sum] = "087da6df03e571ea85b5c307cbfb37a069ce88c291bb380e1657654565342ec6"
SRC_URI[stratix10-socdk-qspi-env.sha256sum] = "0cde0badecb4dc4d87b7ab6b72cda6aaef8ce4973795a10384c90073bb06a6ff"
SRC_URI[stratix10-socdk-qspi-atf-env.sha256sum] = "777c5201f7ec3c69f4d40dd83127161a7fcc94d3b754c5a978bab8b473493eba"

SRC_URI[arria10-socdk-env.sha256sum] = "f2984505cb0c42dc375dcbc771423a6d6a0c4de6025368a20083cc34791c2cdc"
SRC_URI[arria10-socdk-qspi-env.sha256sum] = "b978a433399697db0e01323a7d6a8fad4afd8a90624cfcb85955c079ecab8700"
SRC_URI[arria10-socdk-nand-env.sha256sum] = "2a513277445fb424298dc26de5970469e5abed428cf7e27089a46163b5238351"

SRC_URI[n5x-socdk-atf-env.sha256sum] = "28686b6eb12ba42d065131e34a0e9a4a4752a7d16aa24f468adebfe6e68b1630"

do_configure[noexec] = "1"
do_install[noexec] = "1"

do_compile() {
	mkenvimage -s 0x2000 -o "${WORKDIR}/u-boot-env.bin" ${WORKDIR}/u-boot-env.txt
}

do_deploy() {
	install -d ${DEPLOYDIR}
		install -m 0755 ${WORKDIR}/u-boot-env.txt ${DEPLOYDIR}/u-boot-env.txt
		install -m 0644 ${WORKDIR}/u-boot-env.bin ${DEPLOYDIR}/u-boot-socfpga-${MACHINE}-${PV}-${PR}-env.bin
		ln -sf u-boot-socfpga-${MACHINE}-${PV}-${PR}-env.bin ${DEPLOYDIR}/u-boot-env.bin
}

addtask do_deploy after do_compile before do_build
