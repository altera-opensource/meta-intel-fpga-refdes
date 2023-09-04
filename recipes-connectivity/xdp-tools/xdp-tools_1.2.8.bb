SUMMARY = "Utilities and example programs for use with XDP"
HOMEPAGE = "https://github.com/xdp-project/xdp-tools"
LICENSE = "GPL-2.0-or-later & LGPL-2.1-or-later & BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9ee53f8d06bbdb4c11b1557ecc4f8cd5 \
                    file://LICENSES/GPL-2.0;md5=994331978b428511800bfbd17eea3001 \
                    file://LICENSES/LGPL-2.1;md5=b370887980db5dd40659b50909238dbd \
                    file://LICENSES/BSD-2-Clause;md5=5d6306d1b08f8df623178dfd81880927"

DEPENDS += " clang-native zlib elfutils libpcap"
RUNTIME = "llvm"

SRC_URI = "gitsm://github.com/xdp-project/xdp-tools.git;branch=v1.2;protocol=https \
           file://0001-configure-skip-toolchain-checks.patch \
           file://0001-workaround-for-clang-compiler-with-predefined-macro-.patch \
           file://0001-workaround-skip-pcap-test.patch \
           file://0002-Makefile-It-does-not-detect-libbpf-header-from-sysro.patch \
           file://0003-Makefile-fix-KeyError-failure.patch \
           file://0004-Makefile-fix-libxdp.pc-error.patch \
           file://0001-Backport-patch-to-resolve-section-name-issue.patch \
           file://0001-change-dir-to-install-libbpf-locally.patch \
           file://0001-add-txtime-into-headers-folder-if_xdp.h.patch \
           file://0001-workaround-the-install-libbpf-header-to-local \
           file://0001-add-txtime-in-if_xdp.h-for-libbpf-library \
           "

SRCREV = "d4ff1f9bcf8b03556b625ab6e16958598482e861"

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/bpf/* \
                ${libdir}/custom_bpf/* \
	    "

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

inherit pkgconfig
EXTRA_OEMAKE += "-I${STAGING_INCDIR} PREFIX=${D}${prefix} LIBDIR=${D}${libdir}"

CFLAGS += "-fPIC"
INSANE_SKIP:${PN} = "dev-so staticdev"
export STAGING_INCDIR
CFLAGS += "-I${STAGING_INCDIR} -I${D}${libdir}"

do_configure:append() {
    # workaround to patch libbpf submodule
    cp ${WORKDIR}/0001-workaround-the-install-libbpf-header-to-local ${S}/lib/libbpf/0001-workaround-the-install-libbpf-header-to-local.patch
    cp ${WORKDIR}/0001-add-txtime-in-if_xdp.h-for-libbpf-library ${S}/lib/libbpf/0001-add-txtime-in-if_xdp.h-for-libbpf-library.patch
    pushd ${S}/lib/libbpf
    git am 0001-workaround-the-install-libbpf-header-to-local.patch
    git am 0001-add-txtime-in-if_xdp.h-for-libbpf-library.patch
    popd
}

do_install () {
     oe_runmake install

    # Remove object files *.o
    rm -rf ${D}/${libdir}/bpf
    install -d ${D}/${libdir}/bpf
    install -d ${D}/usr/lib/custom_bpf/

    install -m 0755 lib/libxdp/xdp-dispatcher.o ${D}/${libdir}/bpf/
    install -m 0755 lib/libxdp/xsk_def_xdp_prog.o ${D}/${libdir}/bpf/
    install -m 0755 lib/libxdp/xsk_def_xdp_prog_5.3.o ${D}/${libdir}/bpf/
    cp -r lib/libbpf/bpf_headers/* ${D}/usr/lib/custom_bpf/
    cp -r ${D}/usr/lib/custom_bpf/lib/libbpf.so* ${D}/usr/lib/ 
    rm -rf ${D}/usr/lib/custom_bpf/lib/libbpf.so*
}

RDEPENDS:${PN} += "bash"
