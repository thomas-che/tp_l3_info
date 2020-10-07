#!/usr/bin/python
##
# TCP chat server
# port 1664
##
from socket import *
from select import select
from sys import argv

rhost = argv[1]
s=socket(AF_INET, SOCK_STREAM)
s.connect((rhost,21))
print s.recv(4001)

username = raw_input("->\nuser :")
s.send("USER "+username+"\r\n")
print s.recv(4001)
pwd = raw_input("->\npwd :")
s.send("PASS "+pwd+"\r\n")
print s.recv(4001)
command=""
while command != "exit":
	command = raw_input("\n\nFTP>>>")
	if command == "exit":
		s.send("QUIT\r\n")
		print s.recv(4001)
	elif command == "dir":
		s.send("PASV\r\n")
		data = s.recv(4001)
		print data
		dataconnect = data[data.find("(")+1:data.find(")")].split (",")
		port = int(dataconnect[4])*256+int(dataconnect[5])
		sockdata = socket(AF_INET, SOCK_STREAM)
		sockdata.connect((rhost,port))
		s.send("LIST\r\n")
		r=""
		while True:
  			dato=s.recv(4096)
			if (dato.find("\r\n")<=0):
				r=r+data
			else:
				print r
				break

		print sockdata.recv(4001)
		sockdata.close()
		print s.recv(4001)
	elif command.find("get") == 0:
		s.send("PASV\r\n")
		data = s.recv(4001)
		print data
		dataconnect = data[data.find("(")+1:data.find(")")].split (",")
		port = int(dataconnect[4])*256+int(dataconnect[5])
		sockdata = socket(AF_INET, SOCK_STREAM)
		sockdata.connect((rhost,port))
		rec = command.split(" ")[1]
		s.send("RETR "+rec)
		
