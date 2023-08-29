FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = "file://Downgrade-a-couple-of-warnings-to-debug.patch \
                  file://0001-This-is-a-backport-patch-to-resolve-systemd-issue.patch \
                 "
