require recipes-images/angstrom/extended-console-image.bb

IMAGE_INSTALL += "pciutils dmaxfer-altera \
			pcie-benchmark-altera-module fio \
			e2fsprogs \
"
#Removes black listed images
IMAGE_INSTALL_remove += "libdaemon libtirpc shadow udev-hwdb"
export IMAGE_BASENAME = "pcie-console-image"

