BonkData - Gestión de Activos para "Megabonk" (TFG)
Este proyecto es un sistema Full-Stack desarrollado como Trabajo de Fin de Grado (TFG). Se trata de una plataforma web diseñada para gestionar y visualizar una base de datos completa de elementos de un videojuego (presumiblemente llamado "Megabonk"), incluyendo personajes, armas, objetos, tomos y estadísticas.

🚀 Tecnologías Utilizadas
Backend
Java 17+: Lenguaje de programación principal.

Spring Boot 3: Framework para la creación de la API REST.

Maven: Gestión de dependencias y construcción del proyecto.

PostgreSQL: Base de datos relacional para el almacenamiento de información.

Spring Data JPA / Hibernate: Para la persistencia de datos.

OpenAPI / Swagger: Documentación interactiva de la API.

Frontend
React: Biblioteca de JavaScript para construir la interfaz de usuario.

Vite: Herramienta de construcción rápida para el frontend.

Axios: Cliente HTTP para realizar peticiones a la API del backend.

CSS3: Estilos personalizados (incluyendo componentes como modales y tablas genéricas).

📋 Estructura del Proyecto
El repositorio se divide en dos grandes bloques:

/TFG: Contiene todo el código del servidor (Backend).

src/main/java/BonkData/controller: Endpoints de la API para Armas, Personajes, Objetos, etc.

src/main/resources/creacionBBDD.sql: Scripts de creación de tablas.

src/main/resources/insertarDatos.sql: Scripts para poblar la base de datos con información inicial.

/PaginaWeb: Contiene la aplicación cliente (Frontend).

src/Pages: Vistas principales (Home, Armas, Personajes, Objetos, Tomos).

src/img: Extensa galería de imágenes de los activos del juego.

src/Service: Lógica de conexión con los servicios del backend.

🛠️ Instalación y Configuración
Requisitos Previos
Java JDK 17 o superior.

Node.js y npm.

PostgreSQL instalado y en ejecución.

Configuración de la Base de Datos
Crea una base de datos llamada TFG en tu instancia de PostgreSQL.

Ejecuta el script TFG/src/main/resources/creacionBBDD.sql para crear las tablas necesarias (Armas, Personajes, Objetos, Tomos y Estadísticas).

Opcionalmente, ejecuta insertarDatos.sql para cargar datos de prueba.

Asegúrate de que las credenciales en TFG/src/main/resources/application.properties coincidan con tu configuración local.

Ejecución
Puedes utilizar el archivo arrancar.bat incluido en la raíz para iniciar ambos servicios simultáneamente (en Windows), o seguir estos pasos manualmente:

Backend:

Bash
cd TFG
mvn spring-boot:run
Frontend:

Bash
cd PaginaWeb
npm install
npm run dev
📸 Características Principales
Enciclopedia de Juego: Visualización detallada de cada elemento con su descripción, afinidad y método de obtención.

Interfaz Dinámica: Uso de tablas genéricas y modales para una navegación fluida.

Sistema de Estadísticas: Seguimiento de atributos específicos para cada entidad.

Gestión Centralizada: API robusta que permite la escalabilidad del contenido.

Este proyecto ha sido desarrollado como parte del Trabajo de Fin de Grado de dav1ch1n.
