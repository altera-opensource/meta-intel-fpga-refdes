require recipes-core/images/core-image-base.bb
require core-image-essential.inc

DEPENDS += "bash perl gcc i2c-tools"

IMAGE_INSTALL += "packagegroup-common-essential"
IMAGE_INSTALL += "packagegroup-dev-tools-essential"
IMAGE_INSTALL += "packagegroup-network-essential"
IMAGE_INSTALL += "packagegroup-core-ssh-openssh"
IMAGE_INSTALL += "packagegroup-web-server-essential"
IMAGE_INSTALL += "fio fpga-overlay nfs-utils-client perl"
IMAGE_INSTALL += "remote-debug-app fpgaconfig"

export IMAGE_BASENAME = "gsrd-console-image"

# NFS workaround
ROOTFS_POSTPROCESS_COMMAND += "nfs_rootfs ; lighttpd_rootfs ; "
nfs_rootfs(){
        cd ${IMAGE_ROOTFS}/lib/systemd/system/; sed -i '/Wants/a ConditionKernelCommandLine=!root=/dev/nfs' connman.service
}

lighttpd_rootfs(){
	rm ${IMAGE_ROOTFS}/var/log; mkdir -p ${IMAGE_ROOTFS}/var/log; touch ${IMAGE_ROOTFS}/var/log/lighttpd
}

# UBIFS and UBI Image generation for Agilex QSPI Boot
IMAGE_POSTPROCESS_COMMAND += "${@bb.utils.contains("MACHINE", "agilex", "mkfs_ubi ; ", "", d)}"

mkfs_ubi() {
	# Settings for ubifs
	MKUBIFS_ARGS="--leb-size 126976 --min-io-size 2048 --max-leb-cnt 3600"
	UBINIZE_ARGS="--peb-size 128KiB --min-io-size 2048 --sub-page-size 2048"
	vname=""
	flash="qspi"
    # Added prompt error message for ubi and ubifs image creation.
    if [ -z "$MKUBIFS_ARGS" ] || [ -z "$UBINIZE_ARGS" ]; then
        bbfatal "MKUBIFS_ARGS and UBINIZE_ARGS have to be set, see http://www.linux-mtd.infradead.org/faq/ubifs.html for details"
    fi

	cd ${IMGDEPLOYDIR}

	# env
	echo \[env\] > ubinize${vname}-${IMAGE_NAME}.cfg
	echo mode=ubi >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_id=0 >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_name=env >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_size=256KiB >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_type=dynamic >> ubinize${vname}-${IMAGE_NAME}.cfg
	# script
	echo \[script\] >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo mode=ubi >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo image=${DEPLOY_DIR_IMAGE}/boot.scr.uimg >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_id=1 >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_name=script >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_size=128KiB >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_type=dynamic >> ubinize${vname}-${IMAGE_NAME}.cfg
	# kernel
	echo \[kernel\] >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo mode=ubi >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo image=${DEPLOY_DIR_IMAGE}/kernel.itb >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_id=2 >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_name=kernel >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_size=64MiB >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_type=dynamic >> ubinize${vname}-${IMAGE_NAME}.cfg
	# dtb
	echo \[dtb\] >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo mode=ubi >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo image=${DEPLOY_DIR_IMAGE}/socfpga_${MACHINE}_socdk.dtb >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_id=3 >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_name=dtb >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_size=256KiB >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_type=dynamic >> ubinize${vname}-${IMAGE_NAME}.cfg
	# rootfs
	echo \[rootfs\] >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo mode=ubi >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo image=${IMGDEPLOYDIR}/${IMAGE_NAME}${vname}${IMAGE_NAME_SUFFIX}.ubifs >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_id=4 >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_name=rootfs >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_size=500MiB >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_type=dynamic >> ubinize${vname}-${IMAGE_NAME}.cfg
	echo vol_flag=autoresize >> ubinize${vname}-${IMAGE_NAME}.cfg

	# generate ubifs
	mkfs.ubifs -r ${IMAGE_ROOTFS} -o ${IMGDEPLOYDIR}/${IMAGE_NAME}${vname}${IMAGE_NAME_SUFFIX}.ubifs ${MKUBIFS_ARGS}

	# generate ubi image
	ubinize -o ${IMGDEPLOYDIR}/${IMAGE_NAME}${vname}${IMAGE_NAME_SUFFIX}.ubi ${UBINIZE_ARGS} ubinize${vname}-${IMAGE_NAME}.cfg

	# Create own symlinks for 'named' volumes
	ln -sf ubinize${vname}-${IMAGE_NAME}.cfg \
		ubinize-${flash}-${IMAGE_NAME}.cfg

	if [ -e ${IMAGE_NAME}${vname}${IMAGE_NAME_SUFFIX}.ubifs ]; then
		ln -sf ${IMAGE_NAME}${vname}${IMAGE_NAME_SUFFIX}.ubifs \
			${IMAGE_LINK_NAME}${vname}.ubifs
	fi
	if [ -e ${IMAGE_NAME}${vname}${IMAGE_NAME_SUFFIX}.ubi ]; then
		ln -sf ${IMAGE_NAME}${vname}${IMAGE_NAME_SUFFIX}.ubi \
			${IMAGE_LINK_NAME}-${flash}.ubi
	fi
	cd -
}