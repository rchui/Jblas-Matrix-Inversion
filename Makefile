all:
	make clean
	make build

clean:
	rm -rf *.class

build:
	javac ScalingTest.java
