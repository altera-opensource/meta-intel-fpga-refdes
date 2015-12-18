require recipes-images/angstrom/extended-console-image.bb

IMAGE_INSTALL += "iperf pciutils dmaxfer-altera \
			pcie-benchmark-altera-module fio \
"

export IMAGE_BASENAME = "pcie-console-image"

