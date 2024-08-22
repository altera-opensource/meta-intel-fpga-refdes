SUMMARY = "SOC FPGA Xen passthrough example"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "${AUTOREV}"
XEN_DTB_BRANCH ?= "master"
XEN_DTB_REPO ?= "git://github.com/intel-innersource/applications.fpga.soc.xen-passthrough-examples.git"
XEN_DTB_PROT ?= "http"

SRC_URI = "${XEN_DTB_REPO};protocol=${XEN_DTB_PROT};branch=${XEN_DTB_BRANCH}"

S = "${WORKDIR}/git"

# Add dtc-native to the build dependencies
DEPENDS += "dtc-native"

do_compile() {
    if [[ "${MACHINE}" == *"agilex5_"* ]]; then
	for dts_file in ${S}/agilex5/*.dts; do
		dtc -O dtb -I dts -o ${B}/$(basename ${dts_file} .dts).dtb ${dts_file}
	done
    else
	for dts_file in ${S}/agilex7/*.dts; do
		dtc -O dtb -I dts -o ${B}/$(basename ${dts_file} .dts).dtb ${dts_file}
	done
    fi
}

FILES:${PN} = "/home/root/xen/*"

do_install() {
    install -d ${D}/home/root/xen
    for dtb_file in ${B}/*.dtb; do
        install -m 0644 ${dtb_file} ${D}/home/root/xen/$(basename ${dtb_file})
    done

    if [[ "${MACHINE}" == *"agilex5_"* ]]; then
	for cfg_file in ${S}/agilex5/*.cfg; do
		install -m 0644 ${cfg_file} ${D}/home/root/xen/$(basename ${cfg_file})
	done
    else
	for cfg_file in ${S}/agilex7/*.cfg; do
		install -m 0644 ${cfg_file} ${D}/home/root/xen/$(basename ${cfg_file})
	done
    fi
}


