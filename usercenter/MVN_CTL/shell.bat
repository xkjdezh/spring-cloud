@echo off
setlocal
cd /D %0\..
echo %cd%
py shell.py
pause
