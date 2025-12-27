FORO HUB - CHALLENGE ALURA LATAM

ESTE PROYECTO ES UNA API REST CREADA CON SPRINT BOOT PARA GESTIONAR EN UN FORO DE DISCUCIÓN. 
PERMITE CREAR, LISTAR, ACTUALIZAR Y ELIMINAR TOPICOS.


TECNOLOGIAS UTILIZADAS:

Java 17: Lenguaje principal del ecosistema. 

Spring Boot 3.3.0: Framework para la creación de la aplicación. 

Spring Security: Para el control de acceso y encriptación de contraseñas. 

Hibernate/JPA: Para el mapeo objeto-relacional (ORM). 

MySQL: Base de datos relacional para el almacenamiento de datos. 


ENDPOINTS DE LA API:
La API utiliza seguridad basada en estados. Es necesario autenticarse para interactuar con los tópicos.

AUNTENTICACIÓN:

POST /login: Punto de entrada para obtener el token de acceso.

Usuario de prueba: admin.

Contraseña: 123456.

GESTIÓN DE TÓPICOS:

POST /topicos: Crea un nuevo tópico.

GET /topicos: Lista los tópicos (soporta paginación).

GET /topicos/{id}: Obtiene el detalle de un tópico específico.

PUT /topicos/{id}: Actualiza los datos de un tópico.

DELETE /topicos/{id}: Elimina un tópico del sistema.


ACCESO AL SISTEMA:


Para facilitar la evaluación, ya existe un usuario administrador configurado en la base de datos: 

Login: admin 

Password: 123456 (Encriptada con BCrypt en la base de datos). 


REQUISITOS E INSTALACIÓN:
Clonar el repositorio. 

Configurar las credenciales de la base de datos en el archivo src/main/resources/application.properties. 

Ejecutar el comando mvn spring-boot:run para iniciar el servidor en el puerto 8080. 
