# Image Root Filesystem Configuration

DISTRO_FEATURES:append += "systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"

IMAGE_FSTYPES += "jffs2 tar.gz ubifs"

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

IMAGE_FEATURES += "allow-empty-password empty-root-password"

IMAGE_INSTALL += "mtd-utils"
