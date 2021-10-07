SUMMARY = "U-boot boot environment for Intel SoCFPGA devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "u-boot-mkenvimage-native"

inherit deploy nopackages
PACKAGE_ARCH = "${MACHINE_ARCH}"

ENV_REPO = "https://psg-png-arc.png.intel.com/p/psg/swip/etools/socfpga_refdes/uboot-env"

SRC_URI_agilex = "\
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk", "${ENV_REPO}/agilex-socdk/u-boot-env.txt;name=agilex-socdk-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-atf", "${ENV_REPO}/agilex-socdk-atf/u-boot-env.txt;name=agilex-socdk-atf-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-qspi", "${ENV_REPO}/agilex-socdk-qspi/u-boot-env.txt;name=agilex-socdk-qspi-env", "", d)} \
			 ${@bb.utils.contains("UBOOT_CONFIG", "agilex-socdk-qspi-atf", "${ENV_REPO}/agilex-socdk-qspi-atf/u-boot-env.txt;name=agilex-socdk-qspi-atf-env", "", d)} \
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

SRC_URI[agilex-socdk-env.sha256sum] = "aa7042f2304dbfeaa0d0dac6b717fc55e8d289896858b808c03d257f53b3e8ae"
SRC_URI[agilex-socdk-atf-env.sha256sum] = "713558574cf796b2bf774457e8d4e55ff2b949e18f4e59b68340bb1ae1b9bcc0"
SRC_URI[agilex-socdk-qspi-env.sha256sum] = "389ec3cf5f15ba75cf6afeae0c8e1f2ea79b4a9d6fabdcbf636c85318fa9addc"
SRC_URI[agilex-socdk-qspi-atf-env.sha256sum] = "6b09921f4877a03dec2a1ec71743cac90a58a71b771ed028c079f7331ce311ee"

SRC_URI[stratix10-socdk-env.sha256sum] = "460f3bdebeff681b56040faa0786191b0489897848c991b00e18cbcc956012f4"
SRC_URI[stratix10-socdk-atf-env.sha256sum] = "c7c0f05d931831118bdd870e69c999149f896e8e9384479be5da64709c7725ab"
SRC_URI[stratix10-socdk-qspi-env.sha256sum] = "94a0a6c7c9e1e2a74f10a249a6ee79f38881f6272da8db85c0dc2d18262d14e2"
SRC_URI[stratix10-socdk-qspi-atf-env.sha256sum] = "031132593a9137dcac43fb0f36acf5a29d61a775c17f88211ca2ab23caf4b7cf"

SRC_URI[arria10-socdk-env.sha256sum] = "f055937cc3ab7a60f180191ea1db78c99a647c894b81618921fc2e025ab40f8b"
SRC_URI[arria10-socdk-qspi-env.sha256sum] = "ec4b14d7bb6a524221055818bc6fab696ea7208903c92719105632880d05b0d3"
SRC_URI[arria10-socdk-nand-env.sha256sum] = "e07442cc22a06c16d236e8364b6778095aea2a29016e154378d04c2fc9f63498"

SRC_URI[n5x-socdk-atf-env.sha256sum] = "ac09342632b753afae4f20a1c5581379dbf7d9f0fe525733a90158a55b0d8363"

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
