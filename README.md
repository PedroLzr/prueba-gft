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