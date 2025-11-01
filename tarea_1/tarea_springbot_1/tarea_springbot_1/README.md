# Tarea - Clase 1


---

## Objetivo

Asegurar que tienes tu entorno de desarrollo completamente configurado y que comprendes la estructura de un proyecto Spring Boot

---

## Parte 1: Configuración del Entorno

### Requisitos
Instala y configura las siguientes herramientas:

1. **Java Development Kit (JDK) 17+**
    - OpenJDK o Oracle JDK
    - Configura `JAVA_HOME`

2. **Apache Maven 3.9+**
    - Configura en PATH
    - Verifica instalación

3. **IntelliJ IDEA**
    - Community (gratuito) o Ultimate
    - Configura JDK en el IDE

4. **Git**
    - Instala y configura usuario/email

### Verificación

Se instala y se ejecuta los siguientes comandos con las capturas de los resultados:

```bash
java -version
java version "19.0.2" 2023-01-17

javac -version
javac 19.0.2

mvn -version
Running version 1.1.9.

git --version
git version 2.40.1.windows.1
```
---
# Mi Primer Proyecto Spring Boot

## Información del Proyecto

- **Nombre:** tarea_springbot_1
- **Versión de Spring Boot:** 3.x.x
- **Java:** 17
- **Build Tool:** Maven

# Estructura del Proyecto

Explica brevemente cada directorio o archivo principal del proyecto **Spring Boot**.

---

### `src/main/java/dev/alefiengo/miprimerspringboot/`
- **`MiPrimerSpringbootApplication.java`**:  
  Es la clase **principal** del proyecto Spring Boot.  
  Contiene el método `main()` que inicia la aplicación y carga el contexto de Spring.  
  Al ejecutarse, lanza el servidor Tomcat y arranca el proyecto.

---

### `src/main/resources/`
- **`application.properties`**:  
  Archivo de **configuración** del proyecto.  
  Aquí se definen parámetros como el puerto del servidor (`server.port`), configuración de base de datos, rutas de logs, perfiles (`spring.profiles.active`), etc.

---

### `src/test/`
- Carpeta destinada a las **pruebas unitarias y de integración** del proyecto.  
  Aquí se crean clases de prueba que validan el comportamiento del código (por ejemplo, con **JUnit** o **Mockito**) asegurando que las funcionalidades funcionen correctamente antes del despliegue.

---

### `pom.xml`
- Archivo de **configuración del proyecto Maven**.  
  Define las **dependencias**, **plugins** y **propiedades** necesarias para compilar y ejecutar el proyecto.  
  También contiene el identificador del proyecto (`groupId`, `artifactId`, `version`) y la configuración de Spring Boot.

---

### `target/`
- Carpeta **generada automáticamente por Maven** al compilar el proyecto.  
  Contiene los archivos `.class`, los recursos empaquetados y el archivo ejecutable `.jar` del proyecto.  
  No se debe modificar manualmente (normalmente está en `.gitignore`).

---

## Cómo Ejecutar

1. Abre el proyecto en **IntelliJ IDEA** o tu IDE preferido.
2. Localiza la clase principal:
3. Haz clic derecho sobre la clase y selecciona **Run 'TareaSpringbot1Application'**.
4. Espera que la consola muestre el mensaje:
5. Abre tu navegador e ingresa a:
   `http://localhost:8080`

## Dependencias Principales

El archivo `pom.xml` define las librerías necesarias para compilar, ejecutar y probar el proyecto.  
A continuación se describen las dependencias más relevantes:


### `spring-boot-starter-web`
- Proporciona todos los componentes necesarios para construir **aplicaciones web y servicios REST** con Spring Boot.
- Incluye:
    - **Spring MVC** → para manejar rutas, controladores y peticiones HTTP.
    - **Tomcat** → servidor web embebido (no requiere instalación externa).
    - **Jackson** → convierte automáticamente objetos Java ↔ JSON.
- Es la base de cualquier aplicación que exponga endpoints HTTP.

---

### `spring-boot-starter-test`
- Contiene las herramientas necesarias para **pruebas unitarias y de integración**.
- Incluye:
    - **JUnit 5** → ejecución de pruebas.
    - **Mockito** → simulación de dependencias.
    - **Spring Test** → utilidades para probar controladores y servicios de Spring.

### `spring-boot-maven-plugin`
- Plugin incluido en la sección `<build>`, que permite:
    - Empaquetar el proyecto como un **archivo ejecutable `.jar`** con todas las dependencias.
    - Ejecutar la aplicación con comandos como:
      ```bash
      mvn spring-boot:run
      ```
- Facilita la compilación y el despliegue del proyecto sin configuraciones adicionales.

---

### Dependencias gestionadas por el **Parent**
El proyecto hereda de `spring-boot-starter-parent` (versión **3.5.7**), lo que:
- Simplifica la gestión de versiones.
- Garantiza compatibilidad entre las dependencias.
- Aplica configuraciones predeterminadas de Maven y Spring Boot (por ejemplo, compilador Java 17).


## Conceptos Aprendidos

### ¿Qué es Spring Boot?
Spring Boot es un **framework de desarrollo Java** que facilita la creación de aplicaciones web y servicios **REST** sin necesidad de realizar configuraciones manuales complejas.  
Proporciona una estructura predeterminada (convenciones sobre configuración) y un servidor embebido (como Tomcat) para ejecutar la aplicación directamente.

---

### ¿Qué es Maven?
**Maven** es una herramienta de **gestión y construcción de proyectos Java**.  
Se encarga de:
- Descargar y administrar las **dependencias** (librerías necesarias).
- Estandarizar la **estructura del proyecto** (`src/main/java`, `src/test/java`, etc.).
- Automatizar procesos como **compilar**, **probar**, **empaquetar** y **ejecutar** el proyecto.

El archivo principal de configuración de Maven es `pom.xml`, donde se declaran las dependencias, plugins y propiedades del proyecto.

---

### ¿Qué significa "Tomcat started on port 8080"?
Este mensaje aparece en la consola al iniciar una aplicación Spring Boot:


## Autor
Yber Chuquimia Ticona - Curso Spring Boot & Kafka