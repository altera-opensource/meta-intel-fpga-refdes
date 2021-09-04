SUMMARY = "Intel SoCFPGA GSRD customization"
DESCRIPTION = "Intel SoCFPGA GSRD lighttpd configuration customization to enable cgi and set 404 page"
AUTHOR = "Tien Hock Loh <tien.hock.loh@intel.com>"
SECTION = "gsrd"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

inherit allarch
ALLOW_EMPTY:${PN} = "1"

# Post process the lighttpd.conf file to enable cgi module, sets home page and update 404 page
pkg_postinst_ontarget_${PN}() {
#!/bin/sh
sed -ir 's:#\(.*mod_cgi\"\,\):\1:' $D/etc/lighttpd/lighttpd.conf
sed -ir 's:\(index-file.names *\=\).*\(,\):\1 ("\/cgi-bin\/index.sh"\2:' $D/etc/lighttpd/lighttpd.conf
echo 'server.error-handler-404   = "/not_found.html"' >> $D/etc/lighttpd/lighttpd.conf
echo 'cgi.assign = ( ".sh"  => "/bin/sh" )' >> $D/etc/lighttpd/lighttpd.conf
}

RDEPENDS:{PN} = "lighttpd-module-cgi"
