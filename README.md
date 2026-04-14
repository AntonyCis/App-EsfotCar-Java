# 🚗 App EsfotCar - Sistema de Registro de Vehículos

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=java)
![JavaFX](https://img.shields.io/badge/JavaFX-Modern_UI-orange?style=for-the-badge)
![MongoDB Atlas](https://img.shields.io/badge/MongoDB-Atlas-4EA94B?style=for-the-badge&logo=mongodb)
![Maven](https://img.shields.io/badge/Maven-Build-C71A22?style=for-the-badge&logo=apachemaven)

Aplicación de escritorio desarrollada en Java para la gestión y registro de vehículos. Este proyecto implementa una arquitectura **Modelo-Vista-Controlador (MVC)**, interfaces gráficas modernas y operaciones asíncronas en la nube. 

Desarrollado como parte del módulo de Aplicaciones Distribuidas en la **Escuela de Formación de Tecnólogos (ESFOT - EPN)**.

---

## ✨ Características Principales

* **Interfaz de Usuario Moderna:** Diseño minimalista e intuitivo construido con JavaFX (FXML), utilizando layouts responsivos, bordes suavizados y retroalimentación visual.
* **Persistencia en la Nube:** Conexión directa a bases de datos NoSQL utilizando **MongoDB Atlas**.
* **Procesamiento Asíncrono (Hilos):** Las operaciones de red (guardar y solicitar datos a la base de datos) se ejecutan en un **hilo secundario dedicado** (`Thread`), garantizando que la interfaz gráfica principal (`JavaFX Application Thread`) nunca se congele.
* **Confirmación de Integridad de Datos:** Al guardar, el sistema realiza una consulta de verificación a la nube, recuperando el objeto `Vehiculo` recién creado para confirmar la transacción exitosa al usuario.
* **Código Limpio:** Uso intensivo de **Lombok** (`@Getter`, `@Setter`, `@AllArgsConstructor`) para reducir el código repetitivo (boilerplate) en los modelos de datos.

---

## 🛠️ Tecnologías y Librerías

* **Lenguaje:** Java (Compatible con JDK 17 / 21 LTS)
* **Framework UI:** JavaFX (Manejo mediante archivo `.fxml` independiente)
* **Base de Datos:** MongoDB Driver Sync (`org.mongodb:mongodb-driver-sync:4.11.1`)
* **Herramientas:** Maven (Gestor de dependencias), Lombok.

---

## 🏗️ Estructura del Proyecto

El código fuente está organizado siguiendo el patrón MVC:

```text
src/main/
├── java/ec/edu/epn/taller2carros/
│   ├── model/         # Entidad de negocio (Vehiculo.java)
│   ├── db/            # Lógica de conexión y persistencia (ConexionMongo.java)
│   ├── controller/    # Intermediario entre Vista y Modelo (VehiculoController.java)
│   ├── Main.java      # Clase principal de configuración de la ventana JavaFX
│   └── Lanzador.java  # Wrapper para ejecución segura sin configuración de módulos
│
└── resources/ec/edu/epn/taller2carros/
    ├── ventana_vehiculo.fxml  # Diseño visual de la interfaz
    └── images/
        └── carro.png          # Assets gráficos
```
---

## 🚀 Instalación y Ejecución

### Prerrequisitos
* Tener instalado **Java JDK 17 o superior** (Se recomienda la versión 21 LTS).
* **Maven** instalado o integrado en tu IDE (IntelliJ IDEA recomendado).
* Un cluster activo en **MongoDB Atlas**.

### Pasos
1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/TU_USUARIO/AppEsfotCar.git](https://github.com/TU_USUARIO/AppEsfotCar.git)
   ```
2. **Configurar las credenciales de Base de Datos:**
   * Abre el archivo `src/main/java/ec/edu/epn/taller2carros/db/ConexionMongo.java`.
   * Reemplaza la variable `URI` con la cadena de conexión de tu cluster de MongoDB Atlas. *(Asegúrate de colocar tu usuario y contraseña correctos sin los símbolos `< >`)*.
3. **Descargar dependencias:**
   Deja que Maven actualice y descargue Lombok, el Driver de Mongo y JavaFX.
4. **Ejecutar la aplicación:**
   Ejecuta la clase **`Lanzador.java`**. *(Nota: Ejecutar directamente `Main.java` puede causar errores de módulos de JavaFX en versiones recientes del JDK).*

---

## 👨‍💻 Autor

**Antony Cisneros** *Estudiante de Tecnología Superior en Desarrollo de Software*
```

***

**Tip adicional:** En la sección "Pasos" > "Clonar el repositorio", recuerda cambiar `TU_USUARIO` por tu nombre de usuario de GitHub para que el link funcione correctamente cuando alguien lo copie. ¡Mucho éxito con la entrega del informe!
