#! /bin/bash

cd Number\ Sense/src
javac -d Number\ Sense/classes GenRunner.java
cd ../classes
java GenRunner
mv NS* ../output
cd ../..
