DESCRIPTION = "List of packages that enable networking feature"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

PACKAGES = "packagegroup-network-essential"

RDEPENDS:packagegroup-network-essential = "\
	connman \
	net-tools \
	"