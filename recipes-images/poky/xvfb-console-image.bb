require gsrd-console-image.bb

IMAGE_INSTALL:append = " \
	fbgrab fbset fb-test \
	imagemagick \
	packagegroup-core-x11-base \
	xinit xset xterm \
	"

export IMAGE_BASENAME = "xvfb-console-image"
