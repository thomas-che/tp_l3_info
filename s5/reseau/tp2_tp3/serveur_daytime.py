#!usr/bin/python

#
#   crat sc srveur pr renvoit datetime
# 

from socket import *
from datetime import datetime

date=datetime.now().strftime('%c')

s=socket(AF_INET, SOCK_DGRAM)
s.bind(('0.0.0.0',7777))

print "demande moi heure"
while True:
    (data,addr)=s.recvfrom(512)
    s.sendto(date,addr)


