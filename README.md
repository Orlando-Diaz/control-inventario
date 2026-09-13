# Inventarios

Sistema de control básico de inventario desarrollado con Spring Boot, como proyecto de práctica y aprendizaje.

## 📋 Descripción

Aplicación backend para la gestión de productos en inventario: registro, consulta, actualización y control de existencias. Actualmente en desarrollo activo.

## 🛠️ Stack tecnológico

- **Java 21** (Amazon Corretto)
- **Spring Boot 4.1.1**
    - Spring Data JPA
    - Spring Web MVC
- **Hibernate ORM 7.4.5**
- **MySQL 8.0**
- **Maven** (gestión de dependencias)
- **Tomcat embebido** (servidor)

## 📁 Estructura del proyecto

```
inventarios/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── uniquindio/
│   │   │       └── inventarios/
│   │   │           ├── InventariosApplication.java   # Clase principal
│   │   │           └── modelo/
│   │   │               └── Producto.java              # Entidad JPA
│   │   └── resources/
│   │       ├── application.properties                 # Configuración
│   │       ├── static/
│   │       └── templates/
│   └── test/
├── pom.xml
└── README.md
```

## 🗃️ Modelo de datos

### Producto

| Campo         | Tipo    | Descripción                          |
|---------------|---------|---------------------------------------|
| idProducto    | int     | Identificador único (autogenerado)    |
| descripcion   | String  | Descripción del producto              |
| precio        | double  | Precio unitario                       |
| existencia    | int     | Cantidad disponible en inventario     |

La tabla se genera automáticamente en MySQL mediante Hibernate (`spring.jpa.hibernate.ddl-auto=update`).

## ⚙️ Configuración

### Requisitos previos

- Java 21+
- MySQL 8.0+ corriendo localmente
- Maven (o usar el wrapper incluido `./mvnw`)

### Variables de entorno

Por seguridad, la contraseña de la base de datos se externaliza como variable de entorno:

```properties
spring.datasource.username=${DB_USER:root}
spring.datasource.password=${DB_PASSWORD}
```

Antes de ejecutar, configura `DB_PASSWORD` en tu entorno o en la configuración de ejecución de tu IDE.

### Base de datos

El proyecto crea automáticamente la base de datos `inventario_db` si no existe (`createDatabaseIfNotExist=true`). Solo asegúrate de que MySQL esté corriendo en `localhost:3306`.

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/inventarios.git
   cd inventarios
   ```

2. Configura la variable de entorno `DB_PASSWORD` con tu contraseña de MySQL.

3. Ejecuta con Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

   O desde tu IDE, ejecuta la clase `InventariosApplication`.

4. La aplicación quedará disponible en `http://localhost:8080`.

## 🗺️ Roadmap

- [x] Configuración inicial del proyecto y conexión a MySQL
- [x] Entidad `Producto`
- [ ] Repositorio JPA (`ProductoRepository`)
- [ ] Capa de servicio con lógica de negocio
- [ ] Controlador REST con endpoints CRUD
- [ ] Validaciones de datos (Bean Validation)
- [ ] Manejo global de excepciones
- [ ] Documentación de API (Swagger/OpenAPI)
- [ ] Pruebas unitarias e integración

## 📝 Notas de desarrollo

Este proyecto se documenta progresivamente a medida que se agregan funcionalidades. Los commits siguen la convención [Conventional Commits](https://www.conventionalcommits.org/):

- `feat:` nueva funcionalidad
- `fix:` corrección de errores
- `docs:` cambios en documentación
- `chore:` tareas de mantenimiento

## 👤 Autor

Orlando Díaz