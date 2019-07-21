@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  perfectnumbers startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and PERFECTNUMBERS_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\perfectnumbers-1.0-SNAPSHOT.jar;%APP_HOME%\lib\cxf-rt-frontend-jaxrs-3.3.2.jar;%APP_HOME%\lib\cxf-rt-transports-http-jetty-3.3.2.jar;%APP_HOME%\lib\httpclient-4.5.4.jar;%APP_HOME%\lib\log4j-core-2.12.0.jar;%APP_HOME%\lib\log4j-api-2.12.0.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.9.8.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.9.8.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.9.8.jar;%APP_HOME%\lib\jackson-databind-2.9.8.jar;%APP_HOME%\lib\junit-4.12.jar;%APP_HOME%\lib\cxf-rt-transports-http-3.3.2.jar;%APP_HOME%\lib\cxf-rt-security-3.3.2.jar;%APP_HOME%\lib\cxf-core-3.3.2.jar;%APP_HOME%\lib\jakarta.ws.rs-api-2.1.5.jar;%APP_HOME%\lib\javax.annotation-api-1.3.1.jar;%APP_HOME%\lib\jetty-security-9.4.18.v20190429.jar;%APP_HOME%\lib\jetty-server-9.4.18.v20190429.jar;%APP_HOME%\lib\jetty-http-9.4.18.v20190429.jar;%APP_HOME%\lib\jetty-io-9.4.18.v20190429.jar;%APP_HOME%\lib\jetty-util-9.4.18.v20190429.jar;%APP_HOME%\lib\jetty-continuation-9.4.18.v20190429.jar;%APP_HOME%\lib\slf4j-api-1.7.26.jar;%APP_HOME%\lib\httpcore-4.4.7.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-codec-1.10.jar;%APP_HOME%\lib\jackson-annotations-2.9.0.jar;%APP_HOME%\lib\jackson-core-2.9.8.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\jaxb-xjc-2.3.2.jar;%APP_HOME%\lib\jaxb-runtime-2.3.2.jar;%APP_HOME%\lib\woodstox-core-5.0.3.jar;%APP_HOME%\lib\xmlschema-core-2.2.4.jar;%APP_HOME%\lib\stax-ex-1.8.1.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.2.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\txw2-2.3.2.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.8.jar;%APP_HOME%\lib\FastInfoset-1.2.16.jar;%APP_HOME%\lib\jakarta.activation-api-1.2.1.jar;%APP_HOME%\lib\stax2-api-3.1.4.jar;%APP_HOME%\lib\xsom-2.3.2.jar;%APP_HOME%\lib\codemodel-2.3.2.jar;%APP_HOME%\lib\rngom-2.3.2.jar;%APP_HOME%\lib\dtd-parser-1.4.1.jar;%APP_HOME%\lib\istack-commons-tools-3.0.8.jar;%APP_HOME%\lib\relaxng-datatype-2.3.2.jar;%APP_HOME%\lib\ant-1.10.5.jar;%APP_HOME%\lib\ant-launcher-1.10.5.jar

@rem Execute perfectnumbers
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %PERFECTNUMBERS_OPTS%  -classpath "%CLASSPATH%" codechallange.perfectnumbers.ApplicationMain %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable PERFECTNUMBERS_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%PERFECTNUMBERS_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
