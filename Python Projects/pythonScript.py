import subprocess
import sys

COMMAND="'uname -s; uname -r; uname -m; uname -p; uname -v'"
result = []

for i in sys.stdin:
  HOST=i

  if not "@" in HOST : 
     
     #missing the user
     username = ""

     #check parameters for a user to have been passed in
     if len(sys.argv) > 1 :
       username = sys.argv[1]
     else :
       processResult = subprocess.Popen("whoami", stdout=subprocess.PIPE)
       username =  processResult.stdout.readline().rstrip("\n")

     HOST =  str(username) + "@" + HOST

  HOST = HOST.rstrip("\n")

  #Established our connection info. Lets use it!
  
  sshString = 'ssh ' + HOST + ' ' + COMMAND
  
  #print sshString

  ssh = subprocess.Popen(sshString,
                       shell=True,
                       stdout=subprocess.PIPE,
                       stderr=subprocess.PIPE)


  result = ssh.stdout.readlines()
    
  if result == []:
      error = ssh.stderr.readlines()
      print >>sys.stderr, "ERROR: %s" % error
  else:
      print result
