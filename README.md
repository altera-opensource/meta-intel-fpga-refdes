The official Yocto Project BSP layer for Intel SoCFPGA Golden Software Reference Design (GSRD)

This layer works with Yocto Project Poky layer

Dependencies
============
* poky (git://git.yoctoproject.org/poky)
* meta-openembedded (https://github.com/openembedded/meta-openembedded.git)
    * meta-networking
    * meta-oe
    * meta-python
* meta-intel-fpga (https://git.yoctoproject.org/git/meta-intel-fpga)

Supported U-Boot and Linux Kernels
==================================
It is important to understand the support and release of u-boot-socfpga
and linux-socfpga in the github.com/altera-opensource repositories.  Only
currently supported and maintained releases/branches are available in the
repository. As such, supported kernel and u-boot releases are updated regularly
in currently supported meta-altera branches.  Kernel and u-boot releases
which are no longer supported are removed.

Supported Image Types
=====================
* console-image-minimal

    Consists of basic boot up essentials packages for Intel SoCFPGA platforms.

* gsrd-console-image

    Consists of reference designs application to show case the platform capabilities.

* xvfb-console-image

    Based on gsrd-console-image with additional support on X virtual framebuffer and its applications.

Contribution
============
Submit patches via github pull requests, Use github issues to report problems or to send comments

Maintainer(s): Rebecca Chang Swee Fun <rebecca.swee.fun.chang@intel.com>

