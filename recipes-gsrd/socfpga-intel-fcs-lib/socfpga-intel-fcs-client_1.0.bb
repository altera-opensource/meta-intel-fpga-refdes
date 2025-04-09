SUMMARY="Intel FPGA Crypto Service client"
LICENSE = "MIT-0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=08e5b346f14e1877a2c2a2de82d2d4a1"

SRC_URI = "git://github.com/intel-innersource/libraries.fpga.libfcs.git;protocol=https;branch=main;"

PV = "1.0+git${SRCPV}"
SRCREV="041edd39dfc1bb5750e348cfab62f71844c6990a"
DEPENDS = "socfpga-intel-fcs-lib"

FILES:${PN} = "/usr/bin/*"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DARCH=linux_aarch64"

do_install(){
    cmake --install ${B} --prefix=${D} --component FCS_client_Runtime
}
