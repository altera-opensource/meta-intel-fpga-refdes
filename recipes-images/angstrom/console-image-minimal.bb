require recipes-images/angstrom/console-image.bb

IMAGE_FEATURES += "allow-empty-password empty-root-password"

IMAGE_INSTALL += "mtd-utils openssh altera-gsrd-apps altera-gsrd-pio-interrupt	\
	altera-gsrd-initscripts lighttpd altera-gsrd-webcontent	\
	lighttpd-module-cgi altera-lighttpd-conf net-tools i2c-tools\
"

export IMAGE_BASENAME = "console-image-minimal"

