@echo off
setlocal
cd /D %0\..\..
call mvn org.apache.maven.plugins:maven-dependency-plugin:purge-local-repository -DreResolve=false -DsnapshotsOnly=true
call mvn org.apache.maven.plugins:maven-eclipse-plugin:2.10:clean
call mvn org.apache.maven.plugins:maven-eclipse-plugin:2.10:eclipse -DdownloadSources=true
pause
