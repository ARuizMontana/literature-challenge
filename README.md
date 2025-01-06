# Spring Boot Library Management System

Este proyecto es una aplicación de consola desarrollada con **Spring Boot** que permite gestionar y consultar una biblioteca usando el repositorio de [Gutendex](https://gutendex.com). Incluye funcionalidades para buscar libros, autores y palabras clave, así como opciones de filtrado avanzadas.

## Funcionalidades del Proyecto

El sistema presenta las siguientes funcionalidades:

1. Consulta por nombres de Autores, Títulos y palabras claves
2. Lista de todos los libros consultados
3. Lista de todos los autores de los libros consultados
4. Consulta todos los autores vivos de los libros consultados
5. Consulta por identificador del libro
6. Consulta todos los libros por un lenguaje específico de los libros consultados
7. Parámetros de búsqueda (Filtros para la opción 1)
8. Consultar todos los libros del repositorio
9. Selección de lenguaje (Filtro)
10. Ingreso de género (Filtro)
11. Selección rango de años de vida del autor (Filtro)
12. Limpiar los filtros a valores de fábrica

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.3.2
- Maven
- Postgres
- H2 Database
- Git
- Retrofit 2

## Instalación

Sigue estos pasos para ejecutar el proyecto:

1. Clona el repositorio en tu máquina local:
```bash  
git clone https://github.com/tu_usuario/tu-repositorio.git 
```  
2. Accede al directorio del proyecto:
```bash  
cd tu-repositorio
```  
3. Compila y ejecuta el proyecto:
```bash  
mvn spring-boot:run
```  
## Configuración de PostgreSQL

Si prefieres utilizar PostgreSQL como base de datos, sigue estos pasos:
1. Asegúrate de tener PostgreSQL instalado y en ejecución en tu máquina.
2. Crea una base de datos para el proyecto: 
```sql 
CREATE DATABASE library_management; 
```
3.  Actualiza el archivo application.properties o application.yml para configurar PostgreSQL:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_management
spring.datasource.username=tu_usuarioa
spring.datasource.password=tu_contraseña
```  
4. Ejecuta la aplicación normalmente:
```properties 
mvn spring-boot:run
```  

## Uso

1. Una vez iniciado, el sistema mostrará el Menú Principal.
2. Ingresa el número correspondiente a la opción que deseas utilizar.
3. Para aplicar filtros avanzados, selecciona la opción 7 del menú principal.
4. Sigue las instrucciones para consultar y gestionar los datos de la biblioteca.

## Autor
- Anderson Ruiz


Este archivo incluye instrucciones para configurar PostgreSQL como base de datos y usar las funcionalidades de este proyecto. Si necesitas alguna duda, házmelo saber. 😊