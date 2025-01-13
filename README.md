# Prueba Técnica GFT
Prueba técnica para vacante como tl

---

## **Instrucciones**

### **Ejecutar en Docker**

Los siguientes comandos se deben ejecutar desde la ruta root del repositorio.

1- Construir la imagen:
```bash
docker build -t pruebatec-app .
```

2- Ejecutar el contenedor:
```bash
docker run -p 8080:8080 pruebatec-app
```

### URLs de interés:

**Swagger UI:** http://localhost:8080/swagger-ui/index.html

**ApiDocs:** http://localhost:8080/v3/api-docs

**Consola H2:** http://localhost:8080/h2-console

### Ejecutar únicamente los tests desde un contenedor Docker:

```bash
docker run -it --rm -v $(pwd)/project:/app -w /app maven:3.9.5-eclipse-temurin-21 mvn test
```

## Más detalles

### Arquitectura del Proyecto

El proyecto sigue una arquitectura basada en **hexagonal/puertos y adaptadores**, que permite un diseño modular y desacoplado. Esto se refleja en la estructura de carpetas:

- **domain**: Contiene la lógica central del negocio (modelo `Price` y su repositorio).
- **application**: Implementa los casos de uso del negocio, como la aplicación de reglas para determinar el precio correcto.
- **infrastructure**: Contiene detalles técnicos como controladores REST, persistencia en la base de datos y DTOs.

Este enfoque asegura que el núcleo del negocio no dependa de detalles externos (por ejemplo, la base de datos o el framework web).

### Documentación de la API

La API está documentada utilizando **Springdoc OpenAPI**. Esto permite explorar y probar los endpoints directamente desde una interfaz web.

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **API Docs (JSON)**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

### Base de Datos

El proyecto utiliza **H2 Database** como base de datos en memoria. Esto simplifica las pruebas y garantiza que la aplicación sea completamente autónoma.

- **URL de la consola H2**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **Configuración por defecto**:
  - URL: `jdbc:h2:mem:pricingdb`
  - Usuario: `sa`
  - Contraseña: *(vacía)*

La base de datos se inicializa automáticamente con datos de ejemplo para cumplir los requisitos de la prueba técnica. Se puede encontrar el script de inicialización en `src/main/resources/data.sql`.
Y el esquema de la tabla en `src/main/resources/schema.sql`

### Pruebas

El proyecto incluye pruebas para validar los casos de uso principales y la funcionalidad de los endpoints REST.

### Decisiones Técnicas

1. **Spring Boot**: Se pedía en la tarea.
2. **Lombok**: Reduce el código repetitivo (getters, setters, etc.), mejorando la legibilidad.
3. **Docker**: Se incluyó un Dockerfile para garantizar la portabilidad y facilitar el despliegue en cualquier entorno.
4. **H2 Database**: Simplifica las pruebas al eliminar la necesidad de configurar una base de datos externa. (Sugerido en la tarea).