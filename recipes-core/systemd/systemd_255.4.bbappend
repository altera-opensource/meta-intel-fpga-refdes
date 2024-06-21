SUMMARY = "Fix networkd segmentation fault in 255.4"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-network-tc-Avoid-concurrent-set-modification-in-tcla.patch"
