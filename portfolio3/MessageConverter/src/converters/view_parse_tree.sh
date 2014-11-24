#!/bin/sh

java -jar /Users/brianshannan/workspaces/hw/SE319/portfolio3/antlr-4.4-complete.jar XmlToJsonLexer.g4
java -jar /Users/brianshannan/workspaces/hw/SE319/portfolio3/antlr-4.4-complete.jar XmlToJsonParser.g4
javac XmlToJsonLexer.java XmlToJsonParser.java XmlToJsonParserBaseListener.java XmlToJsonParserListener.java
java org.antlr.v4.runtime.misc.TestRig XmlToJson start < testXml.xml -gui
