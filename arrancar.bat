@echo off
echo Arrancando Backend (Spring Boot)...

set JAVA_HOME=C:\Users\Administrador\.jdks\ms-21.0.10
set PATH=%JAVA_HOME%\bin;%PATH%

start "Spring Boot" cmd /k "cd /d C:\Users\Administrador\Desktop\TFG\TFG && mvn spring-boot:run"

echo Arrancando Frontend (React + Vite)...
start "React Frontend" cmd /k "cd /d C:\Users\Administrador\Desktop\TFG\PaginaWeb && npm run dev"

echo Esperando unos segundos para que los servicios esten listos...
timeout /t 5 /nobreak > NUL

echo Abriendo el navegador...
:: Reemplaza el 5173 por el puerto exacto que use tu proyecto de Vite si es diferente
start http://localhost:5173

echo Servicios arrancando en ventanas separadas y navegador abierto.
exit