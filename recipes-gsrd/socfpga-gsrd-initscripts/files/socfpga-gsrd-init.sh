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
# This script loads the gpio-altera module and the LED scrolling application,
# updates the LCD with IP address obtained

CONST_IP_CHECK_RETRIES=70

if [ "$(cat /sys/class/fpga_manager/fpga0/state)" == "operating" ]; then
	/www/pages/cgi-bin/scroll_server &

	modprobe altera_sysid
	if [ $? != 0 ]; then
		echo "WARNING: Failed to load Altera Sys ID module."
	fi
elif [ "`cat /etc/hostname`" == "stratix10" ]; then
	/www/pages/cgi-bin/scroll_server &

elif [ "`cat /etc/hostname`" == "agilex" ]; then
	/www/pages/cgi-bin/scroll_server &
else
	echo "machine not found"

fi

# Loads the PMBUS module on Arria10
if [ "`cat /sys/devices/soc0/machine`" == "Altera SOCFPGA Arria 10" ]; then
	echo pmbus 0x10 > /sys/bus/i2c/devices/i2c-0/new_device
fi

RETRY_COUNT=1
while [ $RETRY_COUNT -le ${CONST_IP_CHECK_RETRIES} ]
do
	IP=`ip -o -4 addr show eth0 | awk '{print $4}' | cut -d/ -f 1`
	if [ "$IP" == "" ]; then
		IP="No IP obtained"
		sleep 1
	else
		IP_CHECK=`echo $IP | sed 's/\(\([0-9]\{1,3\}\)\.\)\{3\}\([0-9]\{1,3\}\)//g'`
		if [ "$IP_CHECK" != "" ]; then
			IP="No IP obtained"
			sleep 1
		else
			RETRY_COUNT=$((${CONST_IP_CHECK_RETRIES} + 1))
		fi
	fi
	RETRY_COUNT=$((${RETRY_COUNT} + 1))
done

printf '\e[2J' > /dev/ttyLCD0
printf "$IP" > /dev/ttyLCD0
printf "\n" > /dev/ttyLCD0
printf "ALTERA.COM/SOCQS" > /dev/ttyLCD0
