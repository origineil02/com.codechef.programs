#!/bin/bash
read counter;

while [ $counter -gt 0 ]
do
   read number;
   factorial=1;
   while [ $number -gt 0 ]
   do
     #integer arithmetic can't handle the big numbers
     factorial="$factorial*$number"
     number=$(( $number - 1 ))
   done
  echo $factorial | bc | tr -d '\n' | sed 's/\\//g'
  counter=$(( $counter - 1 ))
done

