my($linesToRead, $divisor) = split(/ /, <>);

$count = 0;
for($line = 0; $line < $linesToRead; ++$line)
{
  $currentValue = <>;
  if($currentValue % $divisor == 0)
  {   
    ++$count;  
  }
}

print "$count\n";