#!/bin/sh
# This script loads the gpio-altera module and the LED scrolling application,
# updates the LCD with IP address obtained

if [ "`cat /sys/class/fpga/fpga0/status`" == "user mode" ]; then
	modprobe gpio-altera
	if [ $? != 0 ]; then
		echo "WARNING: Failed to load Altera GPIO module. \
Web server and application for FPGA LED control will not work"
	else
		/www/pages/cgi-bin/scroll_server &
	fi

	modprobe altera_sysid
	if [ $? != 0 ]; then
		echo "WARNING: Failed to load Altera Sys ID module."
	fi
fi

# Loads the PMBUS module on Arria10
if [ "`cat /sys/devices/soc0/machine`" == "Altera SOCFPGA Arria 10" ]; then
	echo pmbus 0x10 > /sys/bus/i2c/devices/i2c-0/new_device
fi

COUNTER=1
while [ $COUNTER -le 10 ]
do
	IP=`ifconfig eth0 | head -n 2 | tail -n 1 | sed s/inet\ addr:// | sed s/\ Bcast.*// | sed s/\ *//g`
	IP_CHECK=`echo $IP | sed 's/\(\([0-9]\{1,3\}\)\.\)\{3\}\([0-9]\{1,3\}\)//g'`
	if [ "$IP_CHECK" != "" ]; then
		IP="No IP obtained"
		sleep 1
	else
		COUNTER=11
	fi
	COUNTER=`expr $COUNTER + 1`
done

printf '\e[2J' > /dev/ttyLCD0
printf "$IP" > /dev/ttyLCD0
printf "\n" > /dev/ttyLCD0
printf "ALTERA.COM/SOCQS" > /dev/ttyLCD0

