# Práctica 1: Spring Boot, Git y Docker

**Autor:** Juan Carlos Ponce de León Ruiz  
**Asignatura:** Metodologías Ágiles de Desarrollo de Software (MADS)  
**Curso:** 2025/2026 - Universidad de Alicante  

---

## 📌 Funcionalidad Implementada: Comprobador de Palíndromos

Se ha ampliado la aplicación Spring Boot inicial añadiendo una funcionalidad completa siguiendo la arquitectura en capas:

1. **Capa de Modelo / Formulario (`PalindromoData`):**
   - Recoge el texto introducido por el usuario.
   - Aplica validaciones con Bean Validation (`@NotEmpty`, `@Size(min=2, max=50)`).
2. **Capa de Servicio (`PalindromoService`):**
   - Lógica de negocio para comprobar si una palabra o frase es palíndroma (ignorando espacios y mayúsculas).
3. **Capa de Controlador Web (`PalindromoController`):**
   - Atiende peticiones `GET /palindromo` mostrando el formulario.
   - Procesa peticiones `POST /palindromo`, gestionando errores de validación y derivando el resultado a la vista.
4. **Vistas Thymeleaf:**
   - `formPalindromo.html`: Formulario con enlace a datos y mensajes de error.
   - `resultadoPalindromo.html`: Página de resultado con el veredicto devuelto por el servicio.

---

## 🚀 Ejecución en Local

### Con Maven:
```bash
./mvnw spring-boot:run
```

Una vez iniciada la aplicación, accede en tu navegador a:
- **Página principal (Autor):** [http://localhost:8080](http://localhost:8080)
- **Comprobador de Palíndromos:** [http://localhost:8080/palindromo](http://localhost:8080/palindromo)
- **Endpoints de la demo original:**
  - [http://localhost:8080/saludo/Pepito](http://localhost:8080/saludo/Pepito)
  - [http://localhost:8080/saludoplantilla/Pepito](http://localhost:8080/saludoplantilla/Pepito)
  - [http://localhost:8080/saludoform](http://localhost:8080/saludoform)

---

## 🧪 Pruebas Automatizadas

Se han desarrollado pruebas unitarias y de integración que cubren tanto el servicio como la capa web:
- `PalindromoServiceTest`: Pruebas unitarias de la lógica del palíndromo (casos válidos, no válidos y con espacios).
- `PalindromoWebTest`: Pruebas de integración web con `MockMvc` (GET, POST con éxito, POST con fallo y validación de formulario vacío).

Para ejecutar todos los tests:
```bash
./mvnw clean test
```

---

## 🐳 Docker y Docker Hub

La aplicación ha sido dockerizada y la imagen se encuentra publicada en el registro público de Docker Hub:

- **Repositorio en Docker Hub:** [https://hub.docker.com/r/juanlangas/springboot-demo-app](https://hub.docker.com/r/juanlangas/springboot-demo-app)
- **Etiqueta final:** `juanlangas/springboot-demo-app:final`

### Descargar y ejecutar directamente el contenedor Docker:
```bash
docker run -p 8080:8080 juanlangas/springboot-demo-app:final
```
