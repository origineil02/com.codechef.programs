#!/bin/bash

zero=0;
read a;
linesToRead=`echo $a | awk '{print $1}'`
divisor=`echo $a | awk '{print $2}'`
 
count=0
for (( line=1; line<=$linesToRead-1; line++ ))
do
read a;
declare -i tmp=$a
  
  echo $tmp
  #echo $(expr $tmp + 1)
  #echo $divisor
  #echo $(expr $temp % $divisor)

 #mod=$(expr $temp % $divisor);
echo test
 echo $mod
# if [ "$mod" == "$zero" ]; then
#  echo $a
#  count=$(( $count + 1 ))
# fi
done
 
echo $count