#!/bin/sh
#  Copyright (C) 2016 Intel Corporation
#
#  This program is free software; you can redistribute it and/or modify it
#  under the terms and conditions of the GNU General Public License,
#  version 2, as published by the Free Software Foundation.
#
#  This program is distributed in the hope it will be useful, but WITHOUT
#  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
#  FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
#  more details.
#
#  You should have received a copy of the GNU General Public License along with
#  this program.  If not, see <http://www.gnu.org/licenses/>.

MACHINE=`cat /etc/hostname`

case $MACHINE in
cyclone5)
	DEVKIT_NAME="Cyclone V SoC Development Kit"
	;;
arria5)
	DEVKIT_NAME="Arria V SoC Development Kit"
	;;
arria10)
	DEVKIT_NAME="Arria 10 SoC Development Kit"
	;;
stratix10)
	DEVKIT_NAME="Stratix 10 SoC Development Kit"
	;;
agilex_fm61)
	DEVKIT_NAME="Agilex FM61 SoC Development Kit"
	;;
agilex_fm86)
	DEVKIT_NAME="Agilex FM86 SoC Development Kit"
	;;
agilex_fm87)
	DEVKIT_NAME="Agilex FM87 SoC Development Kit"
	;;
agilex5)
	DEVKIT_NAME="Agilex5 SoC Development Kit"
	;;
undef)
	DEVKIT_NAME="Unknown Development Kit"
	exit -1
	;;
esac

echo -e "Content-type: text/html"
echo ""
echo -e "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \".w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
echo -e "<html xmlns=\".w3.org/1999/xhtml\" xmlns:mso=\"urn:schemas-microsoft-com:office:office\" xmlns:msdt=\"uuid:C2F41010-65B3-11d1-A29F-00AA00C14882\">"
echo -e "<head>"
echo -e "<title>Board Web Server: $DEVKIT_NAME</title>"
echo -e "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
echo -e "<link rel=\"stylesheet\" media=\"all\" type=\"text/css\" href=\"../style.css\" />"
echo -e "<script src=\"../progress.js\" type=\"text/javascript\"></script>"
echo -e "<script src=\"../helper_script.js\" type=\"text/javascript\"></script>"
echo -e "<script src=\"../validation_script.js\" type=\"text/javascript\"></script>"



echo -e "<!--[if gte mso 9]><xml>"
echo -e "<mso:CustomDocumentProperties>"
echo -e "<mso:ContentType msdt:dt=\"string\">Document</mso:ContentType>"
echo -e "</mso:CustomDocumentProperties>"
echo -e "</xml><![endif]-->"

echo -e "</head>"

echo -e "<body class=\"body-container\" onload=\"start()\">"
echo -e "<div class=\"bup-header\">"
echo -e "<img src=\"../intel-logo.jpg\" alt=\"Intel Logo\" style=\"float:left; padding:15px 0px 15px 10px;\"/>"
echo -e "<div class=\"bup-header-right\"><span>Board Web Server</span><br/>"
echo -e $DEVKIT_NAME
echo -e "</div>"
echo -e "</div>"
echo -e "<div class=\"bup-content\">"
echo -e "<div class=\"bup-form\">"
echo -e "<span><strong><h1>Overview</h1></strong><br/>"
echo -e "</span>"
echo -e "<p>This Board Web Server web page is being served by the web server application running on the Hard Processor System (HPS) of your development board. This web page provides links to useful information on Intel FPGA<sup>®</sup> website. Please refer to the side bar for the reference links."
echo -e "</div>"

if [ "$MACHINE" == "cyclone5" ]; then
echo -e "<div class=\"bup-links\">"
echo -e "<h4>Developer Resources</h4>"
echo -e "<ul>"	
	echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/products/details/fpga/cyclone/v/sx/products.html\" target=\"_blank\">Cyclone 5 SoC Quick Start Guide</a></li> "
	echo -e "<li><a href=\"http://www.rocketboards.org\" target=\"_blank\">Rocketboards.org</a></li> "
echo -e "</ul>"
echo -e "</div>"
elif [ "$MACHINE" == "arria5" ]; then
echo -e "<div class=\"bup-links\">"
echo -e "<h4>Developer Resources</h4>"
echo -e "<ul>"
	echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/products/details/fpga/development-kits/arria/v-st.html\" target=\"_blank\">Arria 5 SoC Quick Start Guide</a></li> "
    echo -e "<li><a href=\"https://www.intel.com/content/dam/www/programmable/us/en/pdfs/literature/ug/ug_av_soc_dev_kit.pdf\" target=\"_blank\">User Guide</a></li> "
	echo -e "<li><a href=\"http://www.rocketboards.org\" target=\"_blank\">Rocketboards.org</a></li> "
echo -e "</ul>"
echo -e "</div>"
elif [ "$MACHINE" == "arria10" ]; then
echo -e "<div class=\"bup-links\">"
echo -e "<h4>Developer Resources</h4>"
echo -e "<ul>"
	echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/products/details/fpga/development-kits/arria/10-sx.html\" target=\"_blank\">Arria 10 SoC Quick Start Guide</a></li> "
    echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/programmable/documentation/iga1434736665480.html\" target=\"_blank\">User Guide</a></li> "
	echo -e "<li><a href=\"http://www.rocketboards.org\" target=\"_blank\">Rocketboards.org</a></li> "
echo -e "</ul>"
echo -e "</div>"
elif [ "$MACHINE" == "stratix10" ]; then
echo -e "<div class=\"bup-links\">"
echo -e "<h4>Developer Resources</h4>"
echo -e "<ul>"
        echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/products/details/fpga/development-kits/stratix/10-sx.html\" target=\"_blank\">Stratix 10 SoC Quick Start Guide</a></li> "
        echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/programmable/documentation/sbe1494623766556.html\" target=\"_blank\">User Guide</a></li> "
        echo -e "<li><a href=\"http://www.rocketboards.org\" target=\"_blank\">Rocketboards.org</a></li> "
echo -e "</ul>"
echo -e "</div>"
elif [[ "$MACHINE" == "agilex_fm61" ]]; then
echo -e "<div class=\"bup-links\">"
echo -e "<h4>Developer Resources</h4>"
echo -e "<ul>"
        echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/products/details/fpga/development-kits/agilex/f-series-transceiver/si-agf014.html\" target=\"_blank\">Agilex FM61 SoC Quick Start Guide</a></li> "
        echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/docs/programmable/683752/current/overview.html\" target=\"_blank\">User Guide</a></li> "
        echo -e "<li><a href=\"http://www.rocketboards.org\" target=\"_blank\">Rocketboards.org</a></li> "
echo -e "</ul>"
echo -e "</div>"
elif [[ "$MACHINE" == "agilex_fm86" ]]; then
echo -e "<div class=\"bup-links\">"
echo -e "<h4>Developer Resources</h4>"
echo -e "<ul>"
        echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/products/details/fpga/development-kits/agilex/f-series/dev-agf027-and-agf023.html\" target=\"_blank\">Agilex FM86 SoC Quick Start Guide</a></li> "
        echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/docs/programmable/739942/current/overview.html\" target=\"_blank\">User Guide</a></li> "
        echo -e "<li><a href=\"http://www.rocketboards.org\" target=\"_blank\">Rocketboards.org</a></li> "
echo -e "</ul>"
echo -e "</div>"
elif [[ "$MACHINE" == "agilex_fm87" ]]; then
echo -e "<div class=\"bup-links\">"
echo -e "<h4>Developer Resources</h4>"
echo -e "<ul>"
        echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/products/details/fpga/development-kits/agilex/i-series-transceiver/si-agi027.html\" target=\"_blank\">Agilex FM87 SoC Quick Start Guide</a></li> "
        echo -e "<li><a href=\"https://www.intel.com/content/www/us/en/docs/programmable/721605/current/overview.html\" target=\"_blank\">User Guide</a></li> "
        echo -e "<li><a href=\"http://www.rocketboards.org\" target=\"_blank\">Rocketboards.org</a></li> "
echo -e "</ul>"
echo -e "</div>"
elif [ "$MACHINE" == "agilex5" ]; then
echo -e "<div class=\"bup-links\">"
echo -e "<h4>Developer Resources</h4>"
echo -e "<ul>"
        echo -e "<li><a href=\"http://www.rocketboards.org\" target=\"_blank\">Rocketboards.org</a></li> "
echo -e "</ul>"
echo -e "</div>"
fi

echo -e "<div class=\"bup-form\">"
echo "<hr style=\"border: 1px solid; color:#06c\"><br>"

if [ "$MACHINE" == "cyclone5" ]; then
	echo -e "<span><strong><h1>$DEVKIT_NAME Features</h1></strong><br/>"
        echo -e "<div><img src=\"../cyclonev-board-image.jpg\" style=\"width:640px;height:478px;\"></div>"
elif [ "$MACHINE" == "arria5" ]; then
	echo -e "<span><strong><h1>$DEVKIT_NAME Features</h1></strong><br/>"
        echo -e "<div><img src=\"../arriav-board-image.jpg\" style=\"width:640px;height:478px;\"></div>"
elif [ "$MACHINE" == "arria10" ]; then
	echo -e "<span><strong><h1>$DEVKIT_NAME Features</h1></strong><br/>"
        echo -e "<div><img src=\"../arria10-board-image.jpg\" style=\"width:640px;height:478px;\"></div>"
elif [ "$MACHINE" == "stratix10" ]; then
	echo -e "<span><strong><h1>$DEVKIT_NAME Features</h1></strong><br/></span>"
        echo -e "<div><img src=\"../stratix10-board-image.jpg\" style=\"width:640px;height:478px;\"></div>"
elif [[ "$MACHINE" == "agilex_fm61" ]]; then
	echo -e "<span><strong><h1>$DEVKIT_NAME Features</h1></strong><br/></span>"
        echo -e "<div><img src=\"../agilex_fm61-board-image.jpg\" style=\"width:640px;height:478px;\"></div>"
elif [[ "$MACHINE" == "agilex_fm86" ]]; then
	echo -e "<span><strong><h1>$DEVKIT_NAME Features</h1></strong><br/></span>"
        echo -e "<div><img src=\"../agilex_fm86-board-image.jpg\" style=\"width:640px;height:478px;\"></div>"
elif [[ "$MACHINE" == "agilex_fm87" ]]; then
	echo -e "<span><strong><h1>$DEVKIT_NAME Features</h1></strong><br/></span>"
        echo -e "<div><img src=\"../agilex_fm87-board-image.jpg\" style=\"width:640px;height:478px;\"></div>"
fi

 echo -e "<br> <hr style=\"border: 1px solid; color:#06c\"> <br>"
 echo -e "<span><strong><h1>Connect to Linux Console on board over SSH Connection</h1></strong><br>"
 echo -e "<p>You would need to access the UART console and type ifconfig to obtain the IP Address. In your host system terminal, type the following:<br><br> <font face="courier, arial" size="3">ssh root@[IP address].</font></p>"
 echo -e "<p>You must have SSH client installed in your host system. If SSH is not available, install the openssh package.</p>"
 echo -e "<p>When the SSH connection is established, you may find the Readme material in /home/root to obtain instructions on how to run SoC Linux example applications.</p>"

echo -e "</div>"

echo -e "</div>"

echo -e "<div class=\"footer-gutter\"></div>"

echo -e "<div class=\"footer-container-blur\">"
echo -e "<div class=\"footer-container-shadow\">"
echo -e "<div id=\"footer\" class=\"footer-container\">"

	echo -e "<div id=\"footerCopyright\" class=\"footer-copyright\">"
	echo -e "<p align=\"center\" style=\"width:900px; font-size:9px;\">Copyright &copy; 2018 Intel Corporation. All Rights Reserved.<br/>"
	echo -e "INTEL, STRATIX, ARRIA, CYCLONE, HARDCOPY, MAX, MEGACORE, NIOS, QUARTUS &amp; STRATIX are Reg. U.S. Pat. &amp; Tm. Off. and Intel FPGA marks in and outside the U.S.</p></div>"
echo -e "</div>"
echo -e "</div>"
echo -e "</div>"

echo -e "</body>"
echo -e "</html>"

