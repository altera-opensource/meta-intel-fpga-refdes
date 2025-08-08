SUMMARY="Intel FPGA Crypto Service library"
LICENSE = "MIT-0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f25b4c3a6d23285f956387ab54830ad"

SRC_URI = "git://github.com/altera-fpga/libfcs.git;protocol=https;branch=main;"

PV = "1.0+git${SRCPV}"
SRCREV="9668a692a27026bfb39b7717cc33b89c097e69f1"
DEPENDS = "dtc"

FILES:${PN} = " /usr/lib/* \
                /usr/include/* "

INSANE_SKIP:${PN} = "libdir"
INSANE_SKIP:${PN}-dbg = "libdir"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DARCH=linux_aarch64"

do_install(){
    cmake --install ${B} --prefix=${D} --component FCS_lib_Runtime
}
