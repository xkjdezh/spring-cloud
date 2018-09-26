@echo off
setlocal
cd /D %0\..\..

call mvn  clean compile -Dmaven.test.skip=true -f pom.xml


pause