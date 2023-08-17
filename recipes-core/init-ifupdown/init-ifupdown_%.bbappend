SUMMARY = "Change usb0 from static to dhcp"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"


SRC_URI:append = " file://interfaces" 


do_install:append () {
    install -m 0644 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
}
