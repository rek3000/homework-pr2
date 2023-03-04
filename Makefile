
package=
proj=
curdir=$(shell pwd)
$(proj).class:
	javac $(proj).java	

run: $(proj).class
	java $(proj)

source := $(wildcard *.java)
class= $(subst .java,.class, $(source))

#this will clean .class in bin/
clean:
	cd ../../bin/$(package) && rm $(class) && cd $(curdir)
