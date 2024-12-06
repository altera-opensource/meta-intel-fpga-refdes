# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

DESCRIPTION = "Coremark: CPU performance benchmarking tool"
HOMEPAGE = "https://www.eembc.org/coremark/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"
AUTHOR = "Vuggu Maheswarudu <vuggu.maheswarudu@intel.com>"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
 
SRC_URI = "git://github.com/eembc/coremark.git;protocol=https;branch=main \
	   file://0001-compile-coremark-for-linux-with-gnu-hash-style.patch \
	  "

PV = "1.0+git"
SRCREV = "d5fad6bd094899101a4e5fd53af7298160ced6ab"

S = "${WORKDIR}/git"

do_compile () {
	export CC="${CC}"
	oe_runmake compile link
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 coremark.exe ${D}${bindir}/coremark.exe
	ln -s coremark.exe ${D}${bindir}/coremark
}

