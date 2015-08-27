require recipes-images/angstrom/console-image.bb

IMAGE_INSTALL += "mtd-utils openssh \
"

export IMAGE_BASENAME = "console-image-minimal"

