SUMMARY = "Additional iproute2 patch to support TSN use cases"

FILESEXTRAPATHS:prepend := "${THISDIR}/iproute2:"

SRC_URI:append = " file://0001-taprio-Add-support-for-preempt-parameter.patch \
                  file://0002-mqprio-Add-support-for-configuring-frame-preemption.patch \
                  file://0003-taprio-Add-support-for-the-SetAndHold-and-SetAndRele.patch \
                  file://0001-tc-Add-invalid-bit-message-for-frame-preemption.patch \
"
