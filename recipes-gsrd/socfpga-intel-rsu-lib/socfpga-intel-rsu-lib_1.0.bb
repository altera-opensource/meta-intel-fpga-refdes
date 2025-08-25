SUMMARY="Altera RSU (Remote System Update) library"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://license.txt;md5=7005039580caaa9ee46ed0edec5ea222"

SRC_URI = "git://github.com/altera-fpga/intel-rsu.git;protocol=https;branch=master; \
           file://0001-Add-missing-soname-to-library-make-symlink-relative.patch \
           file://0002-Add-header-install.patch \
           file://0003-Add-link-dependency-on-libz.patch \
           file://0004-Adapt-makefile-for-Yocto-recipe.patch \
           file://0005-Adapt-the-rsu_client-makefile-for-Yocto.patch \
          "

PV = "1.0+git${SRCPV}"
SRCREV = "f6e0f1e15e8e77c0c1150e2df34a13d9a5bd9771"
DEPENDS += "zlib"

S = "${WORKDIR}/git"
LIBRSU_VER = "0"

FILES:${PN} = "/usr/lib/* \
	        /include/* \
	       "

do_compile () {
    export EXTRA_LDFLAGS="${LDFLAGS}"
    oe_runmake -C lib
}

do_install () {
    cd ${S}
    export INSTALL_PATH="${D}/usr/lib"
    export INSTALL_HDR_PATH="${D}/include"
    install -d ${INSTALL_PATH}
    install -d ${INSTALL_HDR_PATH}
    install -m 0755 lib/librsu.so ${INSTALL_PATH}/librsu.so.${LIBRSU_VER}
    install -m 0755 include/librsu.h ${INSTALL_HDR_PATH}/librsu.h
    cd ${INSTALL_PATH}
    ln -s librsu.so.${LIBRSU_VER} librsu.so
}
