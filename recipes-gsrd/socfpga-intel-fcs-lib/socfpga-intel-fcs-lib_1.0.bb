SUMMARY="Intel FPGA Crypto Service library"
LICENSE = "MIT-0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f25b4c3a6d23285f956387ab54830ad"

FCS_REPO ?= "git://github.com/altera-fpga/libfcs.git"
FCS_PROT ?= "https"
FCS_BRANCH ?= "main"
 
SRC_URI = "${FCS_REPO};protocol=${FCS_PROT};branch=${FCS_BRANCH}"
 
PV = "1.0+git${SRCPV}"
SRCREV="8376964331cb220c3b4b6c436463d880e35a6032"
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
