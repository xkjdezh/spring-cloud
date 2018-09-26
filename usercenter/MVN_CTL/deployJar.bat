@echo off
setlocal
cd /D %0\..\..

if exist client.pom.xml (
	call mvn  clean compile -Dmaven.test.skip=true -f client.pom.xml
	call mvn compile package deploy -Dmaven.test.skip=true -f client.pom.xml
) else (
	if exist pom.xml (
		call mvn clean compile -Dmaven.test.skip=true -f pom.xml
		call mvn compile package deploy -Dmaven.test.skip=true -f pom.xml
	)
)

pause