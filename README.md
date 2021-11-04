# autentificacion-georef
# Aplicacion para Autentificacion - Registro y Referencia Geografica

Las funcionalidades con las que cuenta esta aplicacion rest son las siguientes:
- Poder dar de alta un usuario.
- Realizar un login con un usuario existente.
- Obtener las referencias geograficas de una provincia Argentina

# Tecnologias

- Spring boot
- Java 8
- Swagger
- H2

# Base de datos

La aplicacion al momento de iniciar crea una base en Memoria, con su respectiva estructura.
Las tablas que se crean son las siguientes:

 - Rol
 - Usuario

##Importante
Al momento de iniciar la aplicacion se ingresan datos a la tabla Rol y al de Usuario.
Los datos que se ingresan son
###Tabla Rol
Tipos de roles ROLE_ADMIN, ROLE_USER
###Tabla usuario
Nombre: Usuario Test
Nombre de usuario: usuarioTest
Mail: usuariotest@gmail.com
Contrasenia: pass1234

Los datos que se lleguen a ingresar se eliminaran al momento de dar de baja la aplicacion.

# Swagger ruta acceso

Para pruebas en ambiente local 
http://localhost:8080/swagger-ui.html#/

## Usuarios
Sise desea realizar una alte de otro usuario, desde swagger se lo puede hacer.
La estructura que se debe tener en ese caso es la siguiente:
{
  "email": "unmaildeusuario@mail.com",
  "nombre": "Nombre del usuario",
  "nombreUsuario": "nombreUsuario",
  "password": "passUsuario987",
  "roles": [
    "ROLE_USER"
  ]
}