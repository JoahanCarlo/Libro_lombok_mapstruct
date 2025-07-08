# 📚 API REST - Gestión de Libros con Lombok y MapStruct

Este proyecto es una API REST desarrollada en **Java** con **Spring Boot**, que permite la gestión de libros. Se utiliza **Lombok** para reducir código repetitivo y **MapStruct** para el mapeo entre entidades y DTOs.

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Lombok
- MapStruct
- MySQL (o base de datos que estés usando)
- Maven

## 🧩 Funcionalidades

- CRUD de libros
- Uso de DTOs para exposición de datos
- Mapeo automático con MapStruct
- Reducción de boilerplate con Lombok (`@Data`, `@Builder`, etc.)
- Documentación de endpoints con Swagger UI

## 🔧 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/JoahanCarlo/Libro_lombok_mapstruct.git

2. Configura tu conexión a la base de datos en src/main/resources/application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/libros_db
   spring.datasource.username=root
   spring.datasource.password=tu_contraseña.
   
3. Ejecuta el proyecto
   ./mvnw spring-boot:run

