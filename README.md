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
    ├── bll/                 # Lógica de negocio
    │   ├── Ejercicios.java      # Lógica para ejercicios personalizados
    │   ├── Gamificacion.java    # Sistema de puntos y niveles
    │   ├── Validacion.java      # Validaciones generales (login, datos, etc.)
    │   └── Encriptador.java     # Interfaz para cifrar contraseñas
    ├── dll/                 # Clases modelo (entidades) y menús
    │   ├── Cliente.java         # Clase Cliente con atributos y nivel
    │   ├── Cuenta.java          # Clase base con datos de usuario y login
    │   ├── Entrenador.java      # Clase Entrenador
    │   ├── Entrenamientos.java  # Lógica base para entrenamientos
    │   ├── Fuerza.java          # Entrenamiento específico de fuerza
    │   ├── Resistencia.java     # Entrenamiento específico de resistencia
    │   ├── Volumen.java         # Entrenamiento específico de volumen
    │   ├── Rol.java             # Enum con roles: CLIENTE, ENTRENADOR
    │   ├── MenuCliente.java     # Menú e interacción del cliente
    │   └── MenuCoach.java       # Menú e interacción del entrenador
    ├── repository/          # Acceso a la base de datos
    │   └── Conexion.java        # Clase singleton para conexión MySQL
    ├── gui/                 # Punto de entrada del sistema
    │   └── Main.java            # Clase principal, contiene el menú inicial
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
  <img src="https://github.com/user-attachments/assets/5124f21e-f5b0-4fc7-80b4-e5f7d7d8e079" alt="Diagrama de entidades" width="700"/>
</p>
