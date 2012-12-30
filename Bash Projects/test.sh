#!/bin/bash
read x   # initialize x to 5
read y   # initialize y to 3
add=$(($x + $y))   # add the values of x and y and assign it to variable add
sub=$(($x - $y))   # subtract the values of x and y and assign it to variable sub
mul=$(($x * $y))   # multiply the values of x and y and assign it to variable mul
div=$(($x / $y))   # divide the values of x and y and assign it to variable div
mod=$(($x % $y))   # get the remainder of x / y and assign it to variable mod


# print out the answers:
echo "Sum: $add"
echo "Difference: $sub"
echo "Product: $mul"
echo "Quotient: $div"
echo "Remainder: $mod"