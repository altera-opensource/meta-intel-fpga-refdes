DESCRIPTION = "Linux Unit tests"
AUTHOR = "yvanderv@altera.com"
SECTION = "Tests"
LICENSE = "GPLv2"

S="${WORKDIR}/linux-test"
BP="${BPN}"
DEPENDS = "virtual/kernel"

# git:/git.linaro.org/git-ro/arm/ds5/gator.git;protocol=http
# This variable points to rocketboards by default. It can be overridden
# by setting it in the shell env and by adding it to BB_WHITE_ENV
#LINUX_TEST_REPO?="http://git.rocketboards.org/linux-test"
LINUX_TEST_REPO?="git://at-git/linux-test"
LINUX_TEST_BRANCH?="master"
LINUX_TEST_TAG?="${AUTOREV}"

S = "${WORKDIR}/git"
SRC_URI = "${LINUX_TEST_REPO}"
SRCREV_pn-${PN} = "${LINUX_TEST_TAG}"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=a2c916c096f4cf1974df39bedd5cb1bf"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_STRIP-dev = "1"

do_compile() {

	cd ${S}
	make ARCH="arm" CROSS_COMPILE=${TARGET_PREFIX} clean
	make ARCH="arm" CROSS_COMPILE=${TARGET_PREFIX}
}

do_install() {
	
        echo "-------------${D}/unit-tests"
	install -d ${D}/unit-tests
	make ARCH="arm" CROSS_COMPILE=${TARGET_PREFIX} INSTALLPATH=${D}/unit-tests/ install
}

FILES_${PN} = "/unit-tests/*"
