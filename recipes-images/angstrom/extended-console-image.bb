require recipes-images/angstrom/core-image-minimal.bb

DEPENDS += "bash perl gcc i2c-tools \
"

IMAGE_FEATURES += "allow-empty-password empty-root-password"

IMAGE_INSTALL += "bash perl gcc i2c-tools openssh connman ethtool iperf3 git \
	net-tools nfs-utils-client tcpdump gdbserver e2fsprogs fio \
	packagegroup-core-ssh-openssh openssh-sftp-server pciutils linuxptp devmem2 \
"

export IMAGE_BASENAME = "extended-console-image"

