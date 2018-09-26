@echo off
setlocal
cd /D %0\..
echo %cd%
py env.py
pause
