#!usr/bin/python

#
#   creat sc envoie mail avec a chaque une reponse du serveur
# 


from socket import *
from sys import argv

# if len(argv) <>2:
#     print "dans le 1er if : ussage: %s serveur" % argv[0]
#     exit(1)

# pas bessoin de cette partie car on connait deja l ip du serveur qui recoit : 10.0.1.1
# sname=argv[1]
# serveur=gethostbyname(sname)
# print "=> %s <= addr de cette ip: %s" % (sname,serveur)

# ducoup ecrit direct var=serveur avec string de l ip
serveur="10.0.1.1"

# par default : socket()=socket(AFINET, SOCK_STREAM)
s=socket()
s.connect((serveur,25))
data=s.recv(512)
print "data 1 = %s " % (data)

if "220" in data:
    s.send('HELO Chao\n')
    data=s.recv(512)
    print "data 2 = %s " % (data)

    if "250" in data:
        s.send('MAIL FROM: martin.delacourt@univ-orleans.fr\n')
        data=s.recv(512)
        print "data 3 = %s " % (data)

        if "250" in data:
            s.send('RCPT TO: guest@iiia.net\n')
            data=s.recv(512)
            print "data 4 = %s " % (data)

            if "250" in data:
                s.send('DATA\n')
                data=s.recv(512)
                print "data 5 = %s " % (data)

                if "354" in data:
                    s.send('From: martin <addr de martin>\nTo: guest <addr de guest>\nDate: 20-12-2020\nSubject: <nom du sujet>\n<corp du message>\n.') # bien pesser au . a la fin du corp du message
                    data=s.recv(512)
                    print "data 6 = %s " % (data)

                    if "250" in data:
                        s.send('QUIT\n')
                        data=s.recv(512)
                        print "data 7 = %s " % (data) #Fin


