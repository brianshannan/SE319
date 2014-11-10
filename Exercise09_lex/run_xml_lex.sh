#!/bin/sh

lex xml_lex.l
cc lex.yy.c -o xml_exec
./xml_exec $1
