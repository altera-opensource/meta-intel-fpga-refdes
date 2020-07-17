# Append GSRD SoCFPGA device tree source include files
# As this is custom to GSRD, hence it is not suitable to be upstreamed to meta-altera

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-altera-lts:"

SRC_URI_append_agilex = "file://0001-socfpga_agilex_socdk-include-reference-design-dtsi.patch"
SRC_URI_append_stratix10 = "file://0001-socfpga_stratix10_socdk-include-reference-design-dts.patch"
