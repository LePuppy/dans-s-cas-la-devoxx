@REM SBT launcher script
@REM 
@REM Environment:
@REM JAVA_HOME - location of a JDK home dir (mandatory)
@REM SBT_OPTS  - JVM options (optional)

@setlocal

set SBT_HOME=%~dp0

@echo off
set /p REPONSE="Premiere fois(P)/Reprendre(R): "

if %REPONSE% == P (
    start sublime.exe "%SBT_HOME%\src\test\scala\partie1-1\e0_vars_vals.scala"
    echo Sublime Text s'ouvre avec le dernier fichier edite. Ouvrez les prochains exercices lorsque vous avancez.
    echo               --------
    echo Vous pouvez fermer l'autre invite de commandes.
    echo               --------
    echo Executer go pour lancer le projet. Lorsque vous avez effectue vos changements de code sur Sublime Text, enregistrez les et verifiez les resultas ci-dessous.
    echo               --------
    echo Rappel :
    echo TEST FAILED : au moins un des tests de l'exercice en cours est faux. Des indications sont affichees plus bas.
    echo TEST PENDING : Vous n'avez pas modifie les '_' de l'exercice OU les tests de l'exercice en cours sont tous justes et vous pouvez passer a la suite.
    echo               --------
    echo Le premier exercice devrait s'ouvrir dans Sublime Text.
    echo               --------
) else (
	echo cas 2
    start sublime.exe
    echo Sublime Text s'ouvre avec le dernier fichier edite. Ouvrez les prochains exercices lorsque vous avancez.
    echo               --------
    echo Vous pouvez fermer l'autre invite de commandes.
    echo               --------
    echo Executer go pour lancer le projet. Lorsque vous avez effectue vos changements de code sur Sublime Text, enregistrez les et verifiez les resultas ci-dessous.
    echo               --------
    echo Rappel :
    echo TEST FAILED : au moins un des tests de l'exercice en cours est faux. Des indications sont affichees plus bas.
    echo TEST PENDING : Vous n'avez pas modifie les '_' de l'exercice OU les tests de l'exercice en cours sont tous justes et vous pouvez passer a la suite.
    echo               --------
)

@echo off

REM Check if Sublime Text is already in PATH and add it if not

set SBT_HOME=%~dp0
set ERROR_CODE=0

chcp 65001

rem We use the value of the JAVACMD environment variable if defined
set _JAVACMD=%JAVACMD%

if "%_JAVACMD%"=="" (
  if not "%JAVA_HOME%"=="" (
    if exist "%JAVA_HOME%\bin\java.exe" set "_JAVACMD=%JAVA_HOME%\bin\java.exe"
  )
)

if "%_JAVACMD%"=="" set _JAVACMD=java

rem We use the value of the JAVA_OPTS environment variable if defined
set _JAVA_OPTS=%JAVA_OPTS%
if "%_JAVA_OPTS%"=="" set _JAVA_OPTS=-Xmx512M -XX:MaxPermSize=256m -XX:ReservedCodeCacheSize=128m -Dfile.encoding=UTF8 -Dsbt.log.format=true

set SBT_OPTS=-Dsbt.ivy.home=.\sbt\repository -Dsbt.boot.directory=.\sbt\boot -Dsbt.boot.properties=sbt/sbt.boot.properties  -Xss1M -XX:+CMSClassUnloadingEnabled

:run

"%_JAVACMD%" %_JAVA_OPTS% %SBT_OPTS% -cp .\sbt\jansi.jar;.\sbt\sbt-launch.jar;.\sbt SbtJansiLaunch %*
if ERRORLEVEL 1 goto error
goto end

:error
set ERROR_CODE=1

:end

@endlocal

exit /B %ERROR_CODE%

rem set SCRIPT_DIR=%~dp0

rem set SBT=sbt-launch-0.12.2.jar

rem java -Dsbt.ivy.home=.\ivyrepo -Dsbt.boot.directory=.\sbtboot -Xmx512M -jar -Dfile.encoding=UTF8 -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256m "%SCRIPT_DIR%\%SBT%" %*