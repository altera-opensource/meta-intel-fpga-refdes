#!/bin/sh
#  Copyright (C) 2016 Intel Corporation
#  This program is free software; you can redistribute it and/or modify it
#  under the terms and conditions of the GNU General Public License,
#  version 2, as published by the Free Software Foundation.
#
#  This program is distributed in the hope it will be useful, but WITHOUT
#  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY ors
#  FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
#  more details.
#
#  You should have received a copy of the GNU General Public License along with
#  this program.  If not, see <http://www.gnu.org/licenses/>.
#
# This script loads a base FPGA device tree overlay to the kernel

# Checks to ensure that we have DT overlay support
MACHINE=`cat /etc/hostname`

if [ ! -e /sys/kernel/config/device-tree/overlays ]; then
        echo "Error: Device Tree Overlay not supported"
        exit -1
fi

# fpga_static_region
if [ "$1" == "fpga_static_region.dtbo" ]; then
        if [ "$MACHINE" == "arria10" ]; then
                if [ "$2" == "start" ]; then
                        dtbt -p /boot -a fpga_static_region.dtbo
                elif [ "$2" == "stop" ]; then
                        dtbt -p /boot -r fpga_static_region.dtbo
                else
                        :
                fi
        else
                if [ "$2" == "start" ]; then
                        dtbt -p /boot/devicetree -a ${MACHINE}_pr_fpga_static_region.dtbo
                elif [ "$2" == "stop" ]; then
                        dtbt -p /boot/devicetree -r ${MACHINE}_pr_fpga_static_region.dtbo
                else
                        :
                fi
        fi
fi

# persona0
if [ "$1" == "persona0.dtbo" ]; then
        if [ "$MACHINE" == "arria10" ]; then
                if [ "$2" == "start" ]; then
                        dtbt -p /boot -a persona0.dtbo
                elif [ "$2" == "stop" ]; then
                        dtbt -p /boot -r persona0.dtbo
                else
                        :
                fi
        else
                if [ "$2" == "start" ]; then
                        dtbt -p /boot/devicetree -a ${MACHINE}_pr_persona0.dtbo
                elif [ "$2" == "stop" ]; then
                        dtbt -p /boot/devicetree -r ${MACHINE}_pr_persona0.dtbo
                else
                        :
                fi
        fi
fi

# persona1
if [ "$1" == "persona1.dtbo" ]; then
        if [ "$MACHINE" == "arria10" ]; then
                if [ "$2" == "start" ]; then
                        dtbt -p /boot -a persona1.dtbo
                elif [ "$2" == "stop" ]; then
                        dtbt -p /boot -r persona1.dtbo
                else
                        :
                fi
        else
                if [ "$2" == "start" ]; then
                        dtbt -p /boot/devicetree -a ${MACHINE}_pr_persona1.dtbo
                elif [ "$2" == "stop" ]; then
                        dtbt -p /boot/devicetree -r ${MACHINE}_pr_persona1.dtbo
                else
                        :
                fi
        fi
fi
