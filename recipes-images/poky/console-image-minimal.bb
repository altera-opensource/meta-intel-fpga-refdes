require recipes-core/images/core-image-base.bb

include core-image-essential.inc

IMAGE_INSTALL += "packagegroup-common-essential"
IMAGE_INSTALL += "packagegroup-network-essential"
IMAGE_INSTALL += "mtd-utils"

export IMAGE_BASENAME = "console-image-minimal"
