# Image Root Filesystem Configuration

IMAGE_FSTYPES:append = " jffs2 tar.gz ubifs cpio cpio.gz cpio.gz.u-boot"

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = " ${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

IMAGE_FEATURES:append = " allow-empty-password empty-root-password"

IMAGE_INSTALL:append = " mtd-utils"
