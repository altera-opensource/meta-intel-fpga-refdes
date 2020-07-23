# Append u-boot boot script (u-boot.scr) specific to SoCFPGA GSRD
# As this is custom to GSRD, hence it is not suitable to be upstreamed to meta-altera

FILESEXTRAPATHS_prepend := "${THISDIR}/script:"

UBOOT_ENV_SUFFIX[agilex] = "scr"
UBOOT_ENV[agilex] = "u-boot"

# Agilex
SRC_URI_append_agilex = "file://agilex/u-boot.scr"
