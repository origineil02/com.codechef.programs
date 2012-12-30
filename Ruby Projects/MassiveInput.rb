linesToRead = gets
array = linesToRead.split(/ /);

count = 0;
for i in 0..array.first.to_i - 1

  result = gets.to_i % array.last.to_i;

  if result == 0
    count+=1;
  end

end

puts count