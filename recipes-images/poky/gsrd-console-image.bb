require recipes-core/images/core-image-base.bb
require core-image-essential.inc

DEPENDS += "bash perl gcc i2c-tools"

IMAGE_INSTALL += "packagegroup-common-essential"
IMAGE_INSTALL += "packagegroup-dev-tools-essential"
IMAGE_INSTALL += "packagegroup-network-essential"
IMAGE_INSTALL += "packagegroup-core-ssh-openssh"
IMAGE_INSTALL += "packagegroup-web-server-essential"
IMAGE_INSTALL += "fio fpga-overlay nfs-utils-client perl"
IMAGE_INSTALL += "remote-debug-app"

export IMAGE_BASENAME = "gsrd-console-image"

# NFS workaround
ROOTFS_POSTPROCESS_COMMAND += "nfs_rootfs ; lighttpd_rootfs ;"
nfs_rootfs(){
        cd ${IMAGE_ROOTFS}/lib/systemd/system/; sed -i '/Wants/a ConditionKernelCommandLine=!root=/dev/nfs' connman.service
}

lighttpd_rootfs(){
	rm ${IMAGE_ROOTFS}/var/log; mkdir -p ${IMAGE_ROOTFS}/var/log; touch ${IMAGE_ROOTFS}/var/log/lighttpd
}

