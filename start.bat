@echo off

:: Nombre del JAR
set JAR_NAME=target\crud-0.0.1-SNAPSHOT.jar

:: Construir el proyecto usando Maven
echo Construyendo el proyecto con Maven...
mvn clean package

:: Verificar si el JAR se ha construido correctamente
if not exist "target\%JAR_NAME%" (
  echo Error: JAR no encontrado en el directorio target
  exit /b 1
)

:: Iniciar la aplicación Spring Boot
echo Iniciando la aplicación Spring Boot...
java -jar target\%JAR_NAME%
