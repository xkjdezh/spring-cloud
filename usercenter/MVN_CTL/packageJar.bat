@echo off
setlocal
cd /D %0\..\..
echo "%cd%"
if exist client.pom.xml (
	call mvn  clean compile -Dmaven.test.skip=true -f client.pom.xml
	call mvn compile package -Dmaven.test.skip=true -f client.pom.xml
)

call mvn  clean compile -Dmaven.test.skip=true -f pom.xml
call mvn  compile package install -Dmaven.test.skip=true -f pom.xml

pause