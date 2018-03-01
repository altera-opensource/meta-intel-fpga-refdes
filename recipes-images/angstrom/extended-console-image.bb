require recipes-images/angstrom/console-image.bb

DEPENDS += "bash perl gcc i2c-tools \
"

IMAGE_FEATURES += "allow-empty-password empty-root-password"

IMAGE_INSTALL += "bash perl gcc i2c-tools ethtool iperf3 \
	net-tools nfs-utils-client portmap tcpdump gdbserver fpga-overlay \
"

export IMAGE_BASENAME = "extended-console-image"

