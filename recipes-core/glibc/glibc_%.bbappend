SUMMARY = "CVE-2023-6246"

FILESEXTRAPATHS:prepend := "${THISDIR}/glibc:"

SRC_URI:append = " file://0001-syslog-Fix-heap-buffer-overflow-in-__vsyslog_interna.patch \
"
