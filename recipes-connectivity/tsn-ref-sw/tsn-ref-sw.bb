SUMMARY = "TSN Reference Software"
DESCRIPTION = "Time-Sensitive Networking Reference Software"
HOMEPAGE = "https://github.com/intel/iotg_tsn_ref_sw"
AUTHOR = "Swee Leong Ching"
LICENSE = "BSD-3-Clause"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=665202835d998903d52afcb9c30ad9f5"

SRC_URI = "git://github.com/intel/iotg_tsn_ref_sw.git;protocol=https;branch=master \
           file://0001-Fix-for-agilex5-6.1.20-lts-kernel.patch \
           file://0001-run-Fix-for-unsupported-utils.patch \
           file://0001-set-linking-libraries.patch \
           "

SRCREV = "d03a8f751ce7206a91ad4c597dead6b324460e48"
PV = "1.0-git${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

DEPENDS += " elfutils json-c xdp-tools"

RDEPENDS:${PN} += "\
                    iperf3 \
                    bash \
                    "
prefix="/home/root/tsn"

EXTRA_OECONF:append = " --enable-xdp --enable-xdptbs"
# EXTRA_OECONF:append = " --enable-xdp"

FILES:${PN} = "/home/root/tsn/* \
"

# use custom libbpf library and header
LDFLAGS += "-L${STAGING_DIR_TARGET}/usr/lib/custom_bpf/lib"
CFLAGS += "-I${STAGING_DIR_TARGET}/usr/lib/custom_bpf/include"

do_install:append(){
	cd ${S}
	install -d ${D}/home/root/tsn/shell/agilex5
	install -d ${D}/home/root/tsn/common
	install -m 0755 shell/agilex5/* ${D}/home/root/tsn/shell/agilex5/
	install -m 0755 shell/*sh ${D}/home/root/tsn/shell/
	install -m 0755 ./run.sh ${D}/home/root/tsn/run.sh
	install -m 0775 common/* ${D}/home/root/tsn/common/
	install -m 0775 ${D}/home/root/tsn/bin/* ${D}/home/root/tsn/
}

RRECOMMENDS:${PN}-src = "\
                        libbpf-dev \
                        "

