SUMMARY="Intel RSU (Remote System Update) library"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://license.txt;md5=7005039580caaa9ee46ed0edec5ea222"

SRC_URI = "git://github.com/altera-opensource/intel-rsu.git;protocol=https;branch=master; \
           file://0001-Add-missing-soname-to-library-make-symlink-relative.patch \
           file://0002-Add-header-install.patch \
           file://0003-Add-link-dependency-on-libz.patch \
           file://0004-Adapt-makefile-for-Yocto-recipe.patch \
           file://0005-Adapt-the-rsu_client-makefile-for-Yocto.patch \
          "

PV = "1.0+git${SRCPV}"
SRCREV = "91ce86efca46d6b819428ff7769fb458478556e7"
DEPENDS += "zlib socfpga-intel-rsu-lib"

S = "${WORKDIR}/git"

FILES:${PN} = "/home/root /etc"
FILES:${PN}-dbg = "/home/root/.debug /etc/.debug"

do_compile () {
    export EXTRA_LDFLAGS="${LDFLAGS}"
    oe_runmake -C example
}

do_install () {
    export INSTALL_BIN_PATH="${D}/home/root"
    export INSTALL_ETC_PATH="${D}/etc"
    export INSTALL_HDR_PATH="${D}${includedir}"
    install -d ${INSTALL_BIN_PATH}
    install -d ${INSTALL_ETC_PATH}
    install -d ${INSTALL_HDR_PATH}
	oe_runmake -C ${S}/example install
    install -m 0755 ${S}/etc/qspi.rc ${D}/etc/librsu.rc
    install -m 0755 ${S}/example/rsu_client ${INSTALL_BIN_PATH}/rsu_client
}
