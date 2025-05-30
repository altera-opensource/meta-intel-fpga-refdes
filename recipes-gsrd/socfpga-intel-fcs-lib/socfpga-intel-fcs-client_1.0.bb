SUMMARY="Intel FPGA Crypto Service client"
LICENSE = "MIT-0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f25b4c3a6d23285f956387ab54830ad"

SRC_URI = "git://github.com/intel-innersource/libraries.fpga.libfcs.git;protocol=https;branch=main;"

PV = "1.0+git${SRCPV}"
SRCREV="537200c779b6763d61b7b5e06a7771589869f9b9"
DEPENDS = "socfpga-intel-fcs-lib"

FILES:${PN} = "/usr/bin/*"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DARCH=linux_aarch64"

do_install(){
    cmake --install ${B} --prefix=${D} --component FCS_client_Runtime
}
