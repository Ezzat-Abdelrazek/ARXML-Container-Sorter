@echo off
javac Main.java

echo Testing Normal Case...
echo.
echo input.arxml | java Main

echo.
echo Testing Not Valid Autosar File Case...
echo.
echo invalid.txt | java Main

echo.
echo Testing Empty File Case...
echo.
echo empty.arxml | java Main

pause
