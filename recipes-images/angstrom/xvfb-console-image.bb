require recipes-images/angstrom/gsrd-console-image.bb

IMAGE_INSTALL += "packagegroup-core-x11-xserver \
        packagegroup-core-x11-base xinit xterm xset \
        fb-test fbgrab imagemagick \
"
export IMAGE_BASENAME = "xvfb-console-image"

