awk '
BEGIN {(NR < 1)
	 
	divisor = $2
     print divisor
}
{
	count += ($1 % divisor == 0)
}
END {
	print count
}' $1 