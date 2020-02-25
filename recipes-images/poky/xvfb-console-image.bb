require recipes-core/images/core-image-base.bb
require gsrd-console-image.bb
require core-image-essential.inc

IMAGE_INSTALL += "\
	fbgrab fbset fb-test \
	imagemagick \
	packagegroup-core-x11-base \
	xinit xset xterm \
	"

export IMAGE_BASENAME = "xvfb-console-image"
