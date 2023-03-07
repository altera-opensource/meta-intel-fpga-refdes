DESCRIPTION = "List of packages that are commonly used in all image types"
LICENSE = "MIT"
PR = "r1"
inherit packagegroup

PACKAGES = "packagegroup-common-essential"

RDEPENDS:packagegroup-common-essential = "\
	socfpga-gsrd-apps \
	socfpga-gsrd-initscripts \
	socfpga-gsrd-pio-interrupt \
	i2c-tools \
	mtd-utils \
	mtd-utils-ubifs \
	libgpiod-tools \
	dosfstools \
	"
