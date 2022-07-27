require recipes-core/images/core-image-base.bb
require core-image-essential.inc

IMAGE_INSTALL += "packagegroup-common-essential"
IMAGE_INSTALL += "packagegroup-network-essential"
IMAGE_INSTALL += "packagegroup-core-ssh-openssh"

IMAGE_INSTALL += "copy-engine-0.1"
IMAGE_INSTALL += "linuxptp"
IMAGE_INSTALL += "minicom"
IMAGE_INSTALL += "ppp"

export IMAGE_BASENAME = "n6000-image-minimal"

ROOTFS_POSTPROCESS_COMMAND += "remove_image; "
remove_image() {
	rm ${IMAGE_ROOTFS}/boot/Image*
	echo "cpio: ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.cpio" >> ${DEPLOY_DIR_IMAGE}/uboot-cfg.yaml
}
