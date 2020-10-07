#!/usr/bin/python

# client ftp

from socket import *

serveur='10.0.1.1' #ip du serveur server.iiia.net

s=socket()
s.connect((serveur,21))
#data=s.recv(512)

#print "data 1 = %s" % (data)

def get_msg():
  return s.recv(512)

i=0
def print_data (data):
  print "data "+str(i)+" = %s" % (data)
  i+=1

data=get_msg()
print_data(data)
