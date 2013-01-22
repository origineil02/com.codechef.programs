import subprocess
import sys

def func_addDataElement(currentNode, dataValue, ipAddress, childrenTag):
   node = {}
   children = currentNode["Next"]
 
   if dataValue not in children :
      list = []
      link = {}
      list.append(ipAddress)
      node["IPs"] = list
      node["Next"] = link
      node["Tag"] = childrenTag
      children[dataValue] = node
   else :
      node = children[dataValue]
      node["IPs"].append(ipAddress)

   return node

def func_printData(node):

    children = node["Next"]
    print "Found " + str(len(children)) + " different " + node["Tag"] 
  
    for child in children:
      print child 
      if len(node["Next"][child]["Next"]) > 0: 
          print " containing "
          func_printData(node["Next"][child])
  
  

COMMAND="'uname -s; uname -r; uname -m; uname -p;'"
result = []
ipAddressToData = {}
head = {}
head["Next"] = {}
head["Tag"] = "Operating System / Distribution Name"

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
    ipAddress = i.rstrip("\n");
    ipAddressToData[ipAddress] = result;
    
    distro = result[0].rstrip("\n");
    node = func_addDataElement(head, distro, ipAddress, "Version")
    
    version = result[1].rstrip("\n");
    node = func_addDataElement(node, version, ipAddress, "Hardware Name")

    hardwareName = result[2].rstrip("\n");
    node = func_addDataElement(node, hardwareName, ipAddress, "Architecture")

    arch = result[3].rstrip("\n");
    node = func_addDataElement(node, arch, ipAddress, "")


func_printData(head)

