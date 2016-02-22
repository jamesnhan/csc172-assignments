main=Assignment2
args=

jc javac c compile:
	test -d bin || mkdir bin
	javac -d bin src/*.java

j java r run:
	java -classpath bin $(main) $(args)

cr: compile run

clean:
	-rm -f bin/*.class *~
