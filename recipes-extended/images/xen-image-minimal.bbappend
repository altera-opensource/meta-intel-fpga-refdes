
# meta-intel-fpga-refdes/recipes-extended/images/xen-image-minimal.bbappend

# Exclude unnecessary packages and features
PACKAGE_EXCLUDE += "qemu"

# Remove unnecessary packages from IMAGE_INSTALL
IMAGE_INSTALL:remove = " \
    packagegroup-core-x11 \
    packagegroup-core-graphics \
    packagegroup-core-multimedia \
"

# Optimize the image by minimizing installed packages and features

# Add mtdutils to the image
IMAGE_INSTALL:append = " \
	mtd-utils \
	devmem2 \
	linuxptp \
	iperf3 \
"

# Add to IMAGE_FEATURES to exclude debug symbols and other non-essential features
IMAGE_FEATURES:remove = " \
    dbg-pkgs \
    dev-pkgs \
    tools-sdk \
    tools-debug \
    tools-profile \
    eclipse-debug \
    tools-testapps \
"

# Ensure unnecessary locales and docs are not included
IMAGE_LINGUAS = " "
DISTRO_FEATURES:remove = " \
    opengl \
    x11 \
    wayland \
"
