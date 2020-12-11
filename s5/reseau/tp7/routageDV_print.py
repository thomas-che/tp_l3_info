#!/usr/bin/env python
# -*- coding: utf-8 -*-

##
#
#   ToDo : Implementer 
#
#        - ajouter distance dans mmap
#        - alogo en emition(regade sur quel interface on emet, table routage passe ....) et reseption (si on recoit une info de notre prochain saut on doit se metre a jours)
##


"""
Exemple d'utilisation de msocket et simpleroute, ensemble.
Agrège les réseaux connus d'un bloc et les envoie périodiquement.
"""
from msocket import msocket
from socket import gethostname
from select import select
from simpleroute import *
from time import time

mgrp="239.0.0.54"
mport=5454
tempo=10
bloc="192.168.0.0/16"

# récupère le nom du routeur et les réseaux auxquels il est connecté
print('\n\nrecuperer les routeur voisin')
host=gethostname()
conet=[(net,eif) for (net,gw,eif) in getroutes() if gw is None]
print('fin recuperer routeur voisin')


# crée une msocket pour chaque réseau connecté et initialise mmap avec les réseaux de [bloc]
print('\n\ncree un msocket')
mmap={}
msock=[]
print(conet)
for (net, eif) in conet:
    mip=getaddr(eif)
    print('mip= '+mip)
    if addrinnet(mip,bloc):
        mmap[net]=set([host])
    print("mmmap net = ")
    print(mmap)
    print('#####\n')
    ms=msocket(mgrp, mport, mip, eif)
    print('ms= ')
    print(ms)
    print('#####\n')
    ms.ifname=eif
    msock.append(ms)

    print('dico mmap = ')
    print(mmap)
    print('#####\n')
    print('tab msock = ')
    print(msock)
    print('#####\n')

# fonctions de lecture/écriture de la mmap
def mastr():
    print('\n\nenter : mastr')
    l=[]
    for net in mmap:
        print('net ='+str(net))
        for host in mmap[net]:
            print('l.append: host ='+str(net))
            l.append("%s: %s " % (net, host))
    print('tab l = ')
    print(l)
    print('#####\n')
    print('\n fin : mastr ')
    return "\n".join(l)

def maparse(s):
    print('\n\nenter : maparse')
    ss=s.strip().split("\n")
    print("Parsing '%s'" % (ss[0],))
    for l in ss[1:]:
        [net,host]=l.strip().split(": ")
        if net not in mmap:
            print('IF: mmap['+str(net)+'] host='+str(host))
            mmap[net]=set([host])
        else:
            print('ELSE: mmap['+str(net)+'] add host='+str(host))
            mmap[net].add(host)
    print('dico mmap = ')
    print(mmap)
    print('#####\n')
    print('fin : maparse')

# message de bienvenue
print("Bonjour, j'ai %d interfaces et ma map courante est :" % (len(msock),))
print(mastr())

# émet périodiquement et met à jour la mmap
alarme=time()
while True:
    delta=alarme-time()
    while delta >= 0.0: 
        (rl,rw,rx)=select(msock,[],[],delta)
        print('delata>=0: rl=')
        print(rl)
        print('\nrw=')
        print(rw)
        print('\nrx=')
        print(rx)
        for ms in rl:
            print('for: ms='+str(ms))
            (data,qui)=ms.mrecv(32768)
            print("Reçu des données de %s via %s" % (qui[0],ms.ifname))
            maparse(data) 
            print('data='+str(data))
        delta=alarme-time()
        print(mastr())
    s=mastr()
    print('s='+s)
    for ms in msock:
        print('for2: ms='+str(ms))
        print("Envoi vers %s" % (ms.ifname,))
        ms.msend("de %s vers %s\n" % (host,ms.ifname) + s)
    alarme=time()+tempo
