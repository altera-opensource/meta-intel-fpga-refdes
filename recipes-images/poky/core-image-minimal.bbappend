ROOTFS_POSTPROCESS_COMMAND:append = " remove_hwclock_init_script; "

remove_hwclock_init_script () {
    rm -f ${IMAGE_ROOTFS}/etc/init.d/hwclock.sh || true
}

