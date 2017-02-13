require recipes-images/angstrom/gsrd-console-image.bb
require recipes-graphics/fbgrab/fbgrab_1.2.bb
require recipes-support/fbtest/fb-test_git.bb
require recipes-support/imagemagick/imagemagick_6.9.2.bb

IMAGE_INSTALL += "packagegroup-core-x11-xserver \
        packagegroup-core-x11-base xinit xterm xset \
        fb-test fbgrab imagemagick \
"

export IMAGE_BASENAME = "xvfb-console-image"

