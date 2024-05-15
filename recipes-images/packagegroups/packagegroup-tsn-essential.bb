DESCRIPTION = "List of packages that are needed for TSN reference application demo"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

PACKAGES = "packagegroup-tsn-essential"

RDEPENDS:packagegroup-tsn-essential = "\
	util-linux-taskset \
	util-linux-chrt \
	util-linux-lscpu \
	util-linux-column \
	grep \
	procps \
	xdp-tools \
	tsn-ref-sw \
	"