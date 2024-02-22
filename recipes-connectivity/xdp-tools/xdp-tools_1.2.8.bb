SUMMARY = "Utilities and example programs for use with XDP"
HOMEPAGE = "https://github.com/xdp-project/xdp-tools"
LICENSE = "GPL-2.0-or-later & LGPL-2.1-or-later & BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9ee53f8d06bbdb4c11b1557ecc4f8cd5 \
                    file://LICENSES/GPL-2.0;md5=994331978b428511800bfbd17eea3001 \
                    file://LICENSES/LGPL-2.1;md5=b370887980db5dd40659b50909238dbd \
                    file://LICENSES/BSD-2-Clause;md5=5d6306d1b08f8df623178dfd81880927"

DEPENDS += " libbpf clang-native zlib elfutils libpcap"
RUNTIME = "llvm"

SRC_URI = "gitsm://github.com/xdp-project/xdp-tools.git;branch=v1.2;protocol=https \
            file://0001-configure-skip-toolchain-checks.patch \
            file://0001-workaround-for-clang-compiler-with-predefined-macro-.patch \
            file://0001-workaround-skip-pcap-test.patch \
            file://0002-Makefile-It-does-not-detect-libbpf-header-from-sysro.patch \
            file://0003-Makefile-fix-KeyError-failure.patch \
            file://0004-Makefile-fix-libxdp.pc-error.patch \
          "

SRCREV = "d4ff1f9bcf8b03556b625ab6e16958598482e861"

S = "${WORKDIR}/git"

inherit pkgconfig

EXTRA_OEMAKE += "PREFIX=${D}${prefix} LIBDIR=${D}${libdir} BUILD_STATIC_ONLY=1 PRODUCTION=1"

CFLAGS += "-fPIC"

export STAGING_INCDIR
CFLAGS += "-I${STAGING_INCDIR} -I${D}${libdir}"
do_install () {
    oe_runmake install

    # Remove object files *.o
    rm -rf ${D}/${libdir}/bpf
}

RDEPENDS:${PN} += "bash"
