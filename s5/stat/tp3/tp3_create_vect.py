#!/usr/local/bin/python3

r="c("

for i in range(0,43):
	r+="0, "

for i in range(0,58):
	r+="1, "

for i in range(0,49):
	r+="2, "

for i in range(0,25):
	r+="3, "

for i in range(0,13):
	r+="4, "

for i in range(0,8):
	r+="5, "

for i in range(0,4):
	r+="6, "


print(r+")")
