# Remove unnecessary packages from IMAGE_INSTALL
IMAGE_INSTALL:remove = " \
    packagegroup-core-x11 \
    packagegroup-core-graphics \
    packagegroup-core-multimedia \
    kernel-module-xt-comment \
"

# Optimize the image by minimizing installed packages and features
IMAGE_INSTALL:append = " \
    mtd-utils \
    devmem2 \
    linuxptp \
    iperf3 \
    ethtool \
    stress \
    sysbench \
    perf \
    fio \
    coremark \
    xen-tools \
"

PACKAGE_EXCLUDE += " \
    libx11 \
    libxcb \
    libwayland \
    libdrm \
    libepoxy \
    libpulse \
    libasound \
    libFLAC \
    libvorbis \
    libsndfile \
    qemu \
"

BAD_RECOMMENDATIONS += " \
    libx11 libxcb libwayland libdrm libpulse libvorbis libasound \
"

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

ROOTFS_POSTPROCESS_COMMAND += "cleanup_image_postprocess;"
python cleanup_image_postprocess () {
    import os, shutil
    rootfs = d.getVar('IMAGE_ROOTFS')
    for path in [
        "/usr/share/man",
        "/usr/share/doc",
        "/usr/share/info",
        "/usr/share/locale",
        "/usr/lib/locale"
    ]:
        full = os.path.join(rootfs, path[1:])
        if os.path.exists(full):
            shutil.rmtree(full, ignore_errors=True)
}

RDEPENDS:${PN}:remove = "qemu-system-i386"

PACKAGE_EXCLUDE += " \
    qemu \
    qemu-system-i386 \
    libpulse \
    libvorbis \
    libasound \
    libsndfile \
"

