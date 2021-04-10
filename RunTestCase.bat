set ProjectPath=%~dp0
cd %ProjectPath%
mvn clean test -Denvironment=dev
pause