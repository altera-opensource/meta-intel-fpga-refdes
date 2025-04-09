DESCRIPTION = "List of packages that are commonly used in all image types"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${TUNE_PKGARCH}"
inherit packagegroup

PACKAGES = "packagegroup-common-essential"

RDEPENDS:packagegroup-common-essential = "\
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

RDEPENDS:packagegroup-common-essential:append= "\
	${@'socfpga-intel-unilibrsu-lib socfpga-intel-unilibrsu-client' if d.getVar('MACHINE', True).startswith('agilex5') else 'socfpga-intel-rsu-client socfpga-intel-rsu-lib'}"

RDEPENDS:packagegroup-common-essential:append= "\
	${@'socfpga-intel-fcs-lib socfpga-intel-fcs-client' if d.getVar('MACHINE', True).startswith('agilex') else ''}"
