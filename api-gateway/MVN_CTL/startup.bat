@echo off
setlocal
cd /D %0\..\..\target
for /f "usebackq"  %%s in (`dir /b  *.jar *.war^|find /V /i "source" `) do (java -jar %%s )
pause
