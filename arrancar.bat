@echo off
echo Arrancando Backend (Spring Boot)...

set JAVA_HOME=C:\Users\Administrador\.jdks\ms-21.0.10
set PATH=%JAVA_HOME%\bin;%PATH%

start "Spring Boot" cmd /k "cd /d C:\Users\Administrador\Desktop\TFG\TFG && mvn spring-boot:run"

echo Arrancando Frontend (React + Vite)...
start "React Frontend" cmd /k "cd /d C:\Users\Administrador\Desktop\TFG\PaginaWeb && npm run dev"

echo Ambos servicios arrancando en ventanas separadas.
pause
