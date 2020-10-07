#!/usr/bin/python
##
# TCP chat server
# port 1664
##
from socket import *
from select import select
from sys import argv
if len(argv)<>4:
  print "usage: invalide"
  exit(1)

port = int(argv[1])
rhost = argv[2]
rport = int(argv[3])

s=socket(AF_INET, SOCK_STREAM)
s.setsockopt(SOL_SOCKET,SO_REUSEADDR,1)
s.bind(('0.0.0.0',port))


s.listen(3)

retour = socket()
retour.connect((rhost,rport))
retour.send("")
print retour.recv(50)
socks=[s]
while True:
	print"lancement du proxy"
	lin, lout, lex=select(socks, [], [])
	print "select got %d read events" % (len(lin))
	for t in lin:
		if t==s: # this is an incoming connection
     			(c, addr)=s.accept()
     			msg="Hello %s\n" % (addr[0],)
      			print msg
      			socks.append(c)
      			c.send(msg)
		else:		
			data=t.recv(1024)
			print"data :"+data
			if data:
				retour.send(data)
				msg = retour.recv(1024)
				t.send(msg)
			else:
				t.close()
				socks.remove(t)

