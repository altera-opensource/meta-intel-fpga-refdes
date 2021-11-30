LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ffdc9513cf50bcd13342db84911931b8"

inherit pkgconfig cmake

REMOTE_DBG_REPO ?= "git://github.com/altera-opensource/remote-debug-for-intel-fpga.git"
REMOTE_DBG_PROT ?= "https"
REMOTE_DBG_BRANCH ?= "master"

SRC_URI = "${REMOTE_DBG_REPO};protocol=${REMOTE_DBG_PROT};branch=${REMOTE_DBG_BRANCH}"

SRCREV = "${AUTOREV}"
PV:append = "+git${SRCPV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/git"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ' -DCROSS_COMPILE="${TARGET_PREFIX}"'

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/etherlink ${D}${bindir}
}

FILES:${PN} = "/usr/bin/etherlink"
