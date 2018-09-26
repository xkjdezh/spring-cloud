@echo off
setlocal
cd /D %0\..\..\target
for /f "usebackq"  %%s in (`dir /b  *.jar *.war^|find /V /i "source" `) do (java -Dloader.path="lib/,common/" -jar %%s  --spring.config.location="config/")
pause
