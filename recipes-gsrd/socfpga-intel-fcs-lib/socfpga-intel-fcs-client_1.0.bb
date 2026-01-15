SUMMARY="Intel FPGA Crypto Service client"
LICENSE = "MIT-0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f25b4c3a6d23285f956387ab54830ad"

FCS_REPO ?= "git://github.com/altera-fpga/libfcs.git"
FCS_PROT ?= "https"
FCS_BRANCH ?= "main"
 
SRC_URI = "${FCS_REPO};protocol=${FCS_PROT};branch=${FCS_BRANCH}"
 
PV = "1.0+git${SRCPV}"
SRCREV="87b4b726f4981be102fc8f09feab051fe3578334"
DEPENDS = "socfpga-intel-fcs-lib"

FILES:${PN} = "/usr/bin/*"

inherit cmake

EXTRA_OECMAKE += "-DARCH=linux_aarch64"

do_install(){
    cmake --install ${B} --prefix=${D} --component FCS_client_Runtime
}
