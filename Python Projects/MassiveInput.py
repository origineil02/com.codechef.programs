import fileinput

lineCount = 0
count = 0
divisor = 1
for line in fileinput.input():
  
  if lineCount == 0:
    divisor = line.split()[1]
  else:
    if int(line) % int(divisor) == 0:
     count = count + 1
  
  lineCount = lineCount + 1

print str(count)