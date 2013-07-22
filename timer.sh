#!/bin/bash
echo "seconds?"
read time

for i in $(seq 1 $time)
do
	echo $((i))
	sleep 0.5

done
echo 
echo 
echo 
echo 
