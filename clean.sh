#/bin/sh

find . -name "*.class" -exec rm -rf {} \;
javac mytool/Stdin.java;
