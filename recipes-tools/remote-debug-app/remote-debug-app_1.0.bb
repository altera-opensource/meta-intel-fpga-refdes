LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ffdc9513cf50bcd13342db84911931b8"

inherit pkgconfig cmake

REMOTE_DBG_REPO ?= "git://github.com/altera-fpga/remote-debug-for-intel-fpga.git"
REMOTE_DBG_PROT ?= "https"
REMOTE_DBG_BRANCH ?= "main"

SRC_URI = "${REMOTE_DBG_REPO};protocol=${REMOTE_DBG_PROT};branch=${REMOTE_DBG_BRANCH} \
           git://github.com/altera-fpga/fpga-ip-access.git;protocol=https;branch=main;name=fpga-ip-access;subdir=git/fpga-ip-access \
          "

SRCREV_default = "b6a13b03fe7e9566063eae65d99bd8bc1190ce62"
SRCREV_fpga-ip-access = "df3fb3a7224aac2e55bf0af71a6c611c3cd46a8a"
SRCREV_FORMAT = "default_fpga-ip-access"
PV:append = "+git${SRCPV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/git"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ' -DCROSS_COMPILE="${TARGET_PREFIX}" -DFETCHCONTENT_FULLY_DISCONNECTED=OFF -DIP_ACCESS_API_LIB_GIT_URL="${S}/fpga-ip-access"'

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/etherlink ${D}${bindir}
}

FILES:${PN} = "/usr/bin/etherlink"
