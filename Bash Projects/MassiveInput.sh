#!/bin/bash

read parameters;

a=( $parameters )
linesToRead=${a[0]}
divisor=${a[1]}
 
lineNumber=1
count=0
while [ $lineNumber -le $linesToRead ]
do
 read value;
 mod=$((value % divisor)) 
 lineNumber=$(($lineNumber + 1))

 if [ $mod -eq 0 ]; then
  count=$(( $count + 1 ))
 fi
done
 
echo $count
