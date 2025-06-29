# 🦈 FitSharkPal
Aplicación de escritorio en Java para la gestión de un gimnasio, donde usuarios pueden registrarse como **CLIENTE** o **ENTRENADOR**, acceder a funcionalidades específicas según su rol y guardar información en una base de datos MySQL.

## 🚀 Características

- Registro y login de cuentas
- Encriptación de contraseñas
- Menú dinámico según el rol
- Registro de datos personales (nombre, edad, género, nivel)
- Gestión de entrenamientos y funcionalidades para entrenadores
- Conexión a base de datos MySQL

## 🛠 Tecnologías utilizadas

- Java
- MySQL
- JDBC
- Eclipse IDE

## 🗂 Estructura del proyecto

```plaintext
fitsharkpal/
└── src/
    ├── BLL/                 # Lógica de negocio
    │   ├── ConfigRutina.java     # Logica de ingreso de ejercicios y calculo de puntaje
    │   ├── Encriptador.java      # Interfaz para cifrar contraseñas
    │   ├── Gamificacion.java     # Sistema de puntos y niveles 
    │   └── Validacion.java       # Validaciones generales (login, datos, etc.)
    |
    ├── database/        #Diagrama y Script de la Base de Datos
    |   ├── Diagrama-BD-FitsharkPal.mwb      #Diagrama de la Base de Datos
    |   ├── Diagrama-BD-FitsharkPal.mwb.bak      
    |   └── fitshark.sql                     # Script de la Base de Datos    
    |
    ├── DLL/                 # Clases modelo (entidades) y menús
    │   ├── Cliente.java         # Clase Cliente con atributos y nivel
    │   ├── CrudCoach.java       # Clase para modificar datos del Cliente
    │   ├── Cuenta.java          # Clase con datos de usuario y login
    │   ├── Ejercicios           # Clase para llamar la base de datos
    │   ├── Entrenador.java      # Clase Entrenador
    │   ├── MenuCliente.java     # Menu e interaccion del cliente
    │   ├── MenuCoach.java       # Menú e interacción del entrenador
    │   ├── Nivel.java           # Enum con niveles: PRINCIPIANTE, INTERMEDIO, AVANZADO
    │   ├── Rol.java             # Enum con roles: CLIENTE, ENTRENADOR
    │   └── Rutina.java          # Clase para mostrar mensaje final con la rutina completa configurada con su gamificacion
    |
    ├── GUI/                 # Punto de entrada del sistema
    │   ├── Main.java            # Clase principal, contiene el menú inicial
    |   └── JFrames              # Todas las interfaces graficas del usuario
    |
    ├── img/          # Imagenes del Proyecto
    |   └── Muchos PNGS          # Imagenes usadas en el JFrame
    |
    ├── repository/          # Acceso a la base de datos
    │   ├── Conexion.java                    # Clase singleton para conexión MySQL
    │   └── mysql-connector-java-5.1.13.jar  # Llamada a Conexion.java para que la bdd funcione
```

## 📘 Diagrama de Clases

<p align="center">
  <img src="https://github.com/user-attachments/assets/89a37df5-550c-46e7-9ceb-b64854e16d94" alt="Diagrama de Clases" width="700"/>
</p>

## 🎯 Diagrama de Caso de Usos

<p align="center">
  <img src="https://github.com/user-attachments/assets/385b0116-bbc7-446e-b977-82dc7a15e40e" alt="Diagrama de Caso de Usos" width="700"/>
</p>

## 📊 Diagrama de Entidades

<p align="center">
  <img src="https://github.com/user-attachments/assets/1963cb16-1b95-41f7-b4a2-b83dff4a3060" alt="Diagrama de entidades" width="700"/>
</p>

