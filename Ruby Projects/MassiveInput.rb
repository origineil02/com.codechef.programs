array = gets.split(/ /).map(&:to_i);

count = 0;
linesToRead = array.first - 1
divisor = array.last 

ARGF.each{|line|
  if line.to_i % divisor == 0
   count += 1 
  end
}

puts count