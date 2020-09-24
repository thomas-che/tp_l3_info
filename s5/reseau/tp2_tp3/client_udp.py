#!usr/bin/python

#
#   creation script client udp sur pc1 qui envoie msg a pc2 et recupere la reponse
#
# machine virtuel utilise le python 2

from socket import *

s=socket(AF_INET, SOCK_DGRAM)

s.sendto("envoie msg to pc2",('10.0.0.2',7777))
(data,addr)=s.recvfrom(512)
print "msg recu: %s: %d %s" % (data, len(data), repr(data))
print "msg bien recu"

