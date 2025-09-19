FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = " file://0001-Correct-out-of-bounds-read-of-a-single-byte.patch \
                   file://fix-for-cve-2025-53101.patch \
                   file://fix-for-cve-2025-57807.patch \
                   "