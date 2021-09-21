LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ffdc9513cf50bcd13342db84911931b8"

inherit pkgconfig cmake

REMOTE_DBG_REPO ?= "git://gitlab.devtools.intel.com/psg-opensource/remote-debug-for-intel-fpga.git"
REMOTE_DBG_PROT ?= "https"

SRC_URI = "${REMOTE_DBG_REPO};protocol=${REMOTE_DBG_PROT}"

SRCREV = "${AUTOREV}"
PV_append = "+git${SRCPV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ' -DCROSS_COMPILE="${TARGET_PREFIX}"'

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/etherlink ${D}${bindir}
}

FILES_${PN} = "/usr/bin/etherlink"
