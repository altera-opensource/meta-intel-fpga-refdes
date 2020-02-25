require recipes-core/images/core-image-base.bb

include core-image-essential.inc

IMAGE_INSTALL += "packagegroup-common-essential"
IMAGE_INSTALL += "packagegroup-core-ssh-openssh"
IMAGE_INSTALL += "packagegroup-dev-tools-essential"
IMAGE_INSTALL += "packagegroup-web-server-essential"

export IMAGE_BASENAME = "rel-console-image"
