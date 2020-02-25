DESCRIPTION = "List of packages that are commonly used in all image types"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

PACKAGES = "packagegroup-common-essential"

RDEPENDS_packagegroup-common-essential = "\
	altera-gsrd-apps \
	altera-gsrd-initscripts \
	altera-gsrd-pio-interrupt \
	i2c-tools \
	openssh \
	"
