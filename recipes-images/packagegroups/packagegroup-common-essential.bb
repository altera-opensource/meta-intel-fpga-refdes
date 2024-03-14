DESCRIPTION = "List of packages that are commonly used in all image types"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${TUNE_PKGARCH}"
inherit packagegroup

PACKAGES = "packagegroup-common-essential"

RDEPENDS:packagegroup-common-essential = "\
	socfpga-intel-rsu-lib \
	socfpga-intel-rsu-client \
	socfpga-gsrd-apps \
	socfpga-gsrd-initscripts \
	socfpga-gsrd-pio-interrupt \
	socfpga-gsrd-pio-ilc-demo \
	i2c-tools \
	mtd-utils \
	mtd-utils-ubifs \
	libgpiod-tools \
	dosfstools \
	init-ifupdown \
	"
