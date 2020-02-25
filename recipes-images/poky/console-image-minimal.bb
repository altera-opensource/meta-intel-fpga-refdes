require recipes-core/images/core-image-base.bb
require core-image-essential.inc

IMAGE_INSTALL += "packagegroup-common-essential"
IMAGE_INSTALL += "packagegroup-network-essential"
IMAGE_INSTALL += "packagegroup-core-ssh-openssh"
IMAGE_INSTALL += "mtd-utils"

export IMAGE_BASENAME = "console-image-minimal"

# NFS workaround
ROOTFS_POSTPROCESS_COMMAND += "nfs_rootfs ;"
nfs_rootfs(){
	cd ${IMAGE_ROOTFS}/lib/systemd/system/; sed -i '/Wants/a ConditionKernelCommandLine=!root=/dev/nfs' connman.service
}
