require recipes-images/angstrom/extended-console-image.bb


IMAGE_INSTALL += "altera-gsrd-apps altera-gsrd-pio-interrupt 	\
	altera-gsrd-initscripts lighttpd altera-gsrd-webcontent \
	lighttpd-module-cgi altera-lighttpd-conf pciutils	\
"
#Removes black listed images
IMAGE_INSTALL_remove += "libdaemon libtirpc shadow udev-hwdb"

export IMAGE_BASENAME = "gsrd-console-image"

