#!/bin/sh

java -jar antlr-4.4-complete.jar $1.g4
javac *.java
java org.antlr.v4.runtime.misc.TestRig $1 start < $1.in
