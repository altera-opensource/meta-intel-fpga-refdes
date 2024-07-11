PV = "9.8p1"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "http://ftp.openbsd.org/pub/OpenBSD/OpenSSH/portable/openssh-${PV}.tar.gz \
           file://sshd_config \
           file://ssh_config \
           file://init \
           ${@bb.utils.contains('DISTRO_FEATURES', 'pam', '${PAM_SRC_URI}', '', d)} \
           file://sshd.service \
           file://sshd.socket \
           file://sshd@.service \
           file://sshdgenkeys.service \
           file://volatiles.99_sshd \
           file://run-ptest \
           file://fix-potential-signed-overflow-in-pointer-arithmatic.patch \
           file://sshd_check_keys \
           file://0001-regress-banner.sh-log-input-and-output-files-on-erro.patch \
           file://0001-systemd-Add-optional-support-for-systemd-sd_notify.patch \
           "
SRC_URI[sha256sum] = "dd8bd002a379b5d499dfb050dd1fa9af8029e80461f4bb6c523c49973f5a39f3"

do_install:append () {
	install -D -m 0755 ${WORKDIR}/openssh-${PV}/sshd-session ${D}${libexecdir}/sshd-session
}

FILES:${PN}-sshd += "${libexecdir}/${BPN}/sshd_check_keys ${libexecdir}/sshd-session"

inherit autotools pkgconfig
