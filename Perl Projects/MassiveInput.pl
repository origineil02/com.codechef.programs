my($linesToRead, $divisor) = split(/ /, <>);

$count = 0;
for(0..$linesToRead - 1)
{
  if(<> % $divisor == 0)
  {   
    ++$count;  
  }
}

print "$count\n";