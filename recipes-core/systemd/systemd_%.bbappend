FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = "file://Downgrade-a-couple-of-warnings-to-debug.patch"

# Disable OSC 3008 context signalling (introduced in systemd 259 / Wrynose 6.0).
# Commit https://github.com/systemd/systemd/commit/dadbb34919
# Serial consoles (e.g. minicom) that do not support OSC 3008 render the
# ESC+\ string terminator as a literal \ on every prompt line.
# The systemd recipe removes /etc/profile.d/80-systemd-osc-context.sh when
# 'osc-context' is absent from PACKAGECONFIG.
PACKAGECONFIG:remove = "osc-context"
