require recipes-images/angstrom/core-image-minimal.bb

IMAGE_FEATURES += "allow-empty-password empty-root-password"

IMAGE_INSTALL += " altera-gsrd-initscripts lighttpd altera-gsrd-webcontent \
	lighttpd-module-cgi altera-lighttpd-conf packagegroup-core-ssh-openssh openssh-sftp-server \
	altera-gsrd-apps altera-gsrd-pio-interrupt pciutils \
	bash gcc i2c-tools openssh ethtool iperf3 tcpdump gdbserver fpga-overlay \
"
export IMAGE_BASENAME = "rel-console-image"

