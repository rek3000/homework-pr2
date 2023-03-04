package=Ex1
proj=Arrays
curdir=$(shell pwd)
$(proj).class:
	javac $(proj).java	

run: $(proj).class
	java $(proj)

source := $(wildcard *.java)
class= $(subst .java,.class, $(source))
clean:
	rm $(class)
