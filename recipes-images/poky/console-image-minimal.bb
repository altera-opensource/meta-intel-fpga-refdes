require recipes-core/images/core-image-base.bb
require core-image-essential.inc

IMAGE_INSTALL:append = " packagegroup-common-essential"
IMAGE_INSTALL:append = " packagegroup-network-essential"
IMAGE_INSTALL:append = " packagegroup-core-ssh-openssh"

export IMAGE_BASENAME = "console-image-minimal"

# NFS workaround
ROOTFS_POSTPROCESS_COMMAND:append = " nfs_rootfs ; lighttpd_rootfs ;"
nfs_rootfs(){
	cd ${IMAGE_ROOTFS}/lib/systemd/system/; sed -i '/Wants/a ConditionKernelCommandLine=!root=/dev/nfs' connman.service
}

lighttpd_rootfs(){
	rm ${IMAGE_ROOTFS}/var/log; mkdir -p ${IMAGE_ROOTFS}/var/log; touch ${IMAGE_ROOTFS}/var/log/lighttpd
}
