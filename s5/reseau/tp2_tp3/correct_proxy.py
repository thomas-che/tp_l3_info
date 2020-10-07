#!/usr/bin/python
##
# TCP chat server
# port 1664
##
from socket import *
from select import select
from sys import argv 

#if len(argv) <> 4 :
#  print ("erreur")
#  exit(1)

# les 3 parametres enter
port=1663 #port=int(argv[1])
rhost='10.0.0.3' #rhost=gethostbyname...
rport=1664 #rport=int(argv[3])

# la socket 1 
s=socket(AF_INET, SOCK_STREAM)
s.bind(('0.0.0.0', port))
s.listen(3)
print "PROXY : Listening on port %s " % (port) 


# list of currently open sockets, 2 list : 1 cote client ; 1 cote serveur
clients=[]
serveurs=[]

while True:
  # wait for an incoming message

  # ajout dans le select les 2 autre list : client et serv 
  lin, lout, lex=select([s]+clients+serveurs, [], [])  
  print "PROXY : select got %d read events" % (len(lin))

  for t in lin:
    if t==s: # this is an incoming connection
	(c, addr)=s.accept()
	clients.append(c)

	# cree new sock, connect avec le serveur, add a la list des socket serveur
	r=socket()
	r.connect((rhost,rport))
	serveurs.append(r)
	print ("PROXY : mon msg")

    else: # someone is speaking
      data=t.recv(1024)
      if t in clients :
	y=serveurs[clients.index(t)]
	hd="<-"
      else:
	y=clients[serveurs.index(t)]
        hd="->"
	# on recoit un msg de t, on veut envoier sur y

      if data:
	y.send(data)
      else: # pas de data
	if t in clients:
	  clients.remove(t)
	  serveurs.remove(y)
	else:
	  y.close()
	  t.close()
	  clients.remove(y)
	  serveurs.remove(t)

      who=t.getpeername()[0]
      msg= hd + "%s: %s\n" % (who, data.strip())
      print msg	

      #else: # connection closed
      #  socks.remove(t)
      #  msg="Goodbye %s!\n" % (who,)
      #print msg
      #for c in socks[1:]:
      #  c.send(msg)
