#!/bin/bash

files=*

for i in $files
do
	if [ -f $i ]
	then
		echo "-- -- -- -- --"
		echo $i
		echo "-- -- -- -- --"
		sleep 1
	fi
done
