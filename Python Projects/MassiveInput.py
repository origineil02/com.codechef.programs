import sys
  
n,divisor = map(int,sys.stdin.readline().split())
 
count = 0
for i in sys.stdin:
  if int(i)%divisor==0:count+=1
print str(count)