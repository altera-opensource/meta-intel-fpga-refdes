SUMMARY = "open62541 aka OPC UA implementation"
HOMEPAGE = "http://open62541.org"
LICENSE = "MPL-2.0"
AUTHOR = "Teoh, Ji Sheng"
LIC_FILES_CHKSUM = "file://LICENSE-CC0;md5=6888abe69dbc6330301f0467e21c0317 \
                    file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad \
                    file://deps/mdnsd/LICENSE;md5=3bb4047dc4095cd7336de3e2a9be94f0 \
                    file://deps/jsmn/LICENSE;md5=5adc94605a1f7a797a9a834adbe335e3 \
                    file://tools/packaging/debian/copyright;md5=e7ea4c34f4b21b0976f472dacd58c952"

SRC_URI = "gitsm://github.com/open62541/open62541.git;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "5f5214427b62e96e066270f4c2798f68b1375213"

S = "${WORKDIR}/git"

DEPENDS = "openssl"

inherit cmake python3native

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

