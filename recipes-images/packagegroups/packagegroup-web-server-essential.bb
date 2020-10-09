DESCRIPTION = "List of packages that enable web server feature"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

PACKAGES = "packagegroup-web-server-essential"

RDEPENDS_packagegroup-web-server-essential = "\
	socfpga-gsrd-webcontent \
	socfpga-lighttpd-conf \
	lighttpd \
	lighttpd-module-cgi \
	"
