@echo off
setlocal
cd /D %0\..\..

call mvn clean -Dmaven.test.skip=true -f pom.xml
call mvn compile org.apache.maven.plugins:maven-war-plugin:war -Dmaven.test.skip=true -f pom.xml

pause