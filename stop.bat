@echo off

:: Nombre del proceso de la aplicación Spring Boot
set PROCESS_NAME=java

:: Buscar y matar el proceso que corresponde a la aplicación Spring Boot
taskkill /f /im %PROCESS_NAME%.exe

:: Informar al usuario que la aplicación ha sido detenida
echo La aplicacion Spring Boot ha sido detenida.
