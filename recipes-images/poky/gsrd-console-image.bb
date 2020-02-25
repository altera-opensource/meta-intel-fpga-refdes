require recipes-core/images/core-image-base.bb
require core-image-essential.inc

DEPENDS += "bash perl gcc i2c-tools"

IMAGE_INSTALL += "packagegroup-common-essential"
IMAGE_INSTALL += "packagegroup-network-essential"
IMAGE_INSTALL += "packagegroup-core-ssh-openssh"
IMAGE_INSTALL += "packagegroup-web-server-essential"
IMAGE_INSTALL += "fio fpga-overlay nfs-utils-client perl"

export IMAGE_BASENAME = "gsrd-console-image"

# NFS workaround
ROOTFS_POSTPROCESS_COMMAND += "nfs_rootfs ;"
nfs_rootfs(){
        cd ${IMAGE_ROOTFS}/lib/systemd/system/; sed -i '/Wants/a ConditionKernelCommandLine=!root=/dev/nfs' connman.service
}
