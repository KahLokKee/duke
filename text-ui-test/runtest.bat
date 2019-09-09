@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del ACTUAL.TXT output.txt

REM compile the code into the bin folder
javac  ..\src\main\java\duke.command\*.java ..\src\main\java\duke.exception\*.java ..\src\main\java\duke.parser\*.java ..\src\main\java\duke.storage\*.java ..\src\main\java\duke.task\*.java ..\src\main\java\duke.task\*.java ..\src\main\java\duke.tasklist\*.java ..\src\main\java\duke.ui\*.java -Xlint:none -d ..\bin ..\src\main\java\duke.Duke.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin duke.Duke < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT