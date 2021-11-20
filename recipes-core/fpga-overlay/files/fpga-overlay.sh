#!/bin/sh
#  Copyright (C) 2016 Intel Corporation
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
#
# This script loads a base FPGA device tree overlay to the kernel

# Checks to ensure that we have DT overlay support
if [ ! -e /sys/kernel/config/device-tree/overlays ]; then
        echo "Error: Device Tree Overlay not supported"
        exit -1
fi
