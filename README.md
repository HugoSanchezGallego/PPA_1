# Prueba Programación Android 2 - Ejercicio 1

# [Repositorio](https://github.com/HugoSanchezGallego/PPA_1.git)

## Índice
1. [Descripción](#descripción)
2. [Requisitos](#requisitos)
3. [Instalación](#instalación)
4. [Estructura del Proyecto](#estructura-del-proyecto)
5. [Uso](#uso)
6. [Pantallas](#pantallas)
    - [Pantalla Principal](#pantalla-principal)
    - [Añadir Asignatura](#añadir-asignatura)
    - [Ver Horario](#ver-horario)
    - [Clase Actual](#clase-actual)
7. [Componentes Reutilizables](#componentes-reutilizables)
8. [Firebase](#firebase)

## Descripción
"Mi Horario" es una aplicación móvil desarrollada en Kotlin utilizando Jetpack Compose. Permite a los usuarios gestionar su horario de clases, añadiendo asignaturas, visualizando el horario y verificando la clase actual.

## Requisitos
- Android Studio Koala Feature Drop | 2024.1.2
- Kotlin 1.9.0
- Firebase Firestore

## Instalación
1. Clona el repositorio:
    ```sh
    git clone https://github.com/tu_usuario/mi_horario.git
    ```
2. Abre el proyecto en Android Studio.
3. Configura Firebase en tu proyecto:
    - Añade el archivo `google-services.json` en el directorio `app/`.
4. Sincroniza el proyecto con Gradle.

## Estructura del Proyecto
- `app/src/main/java/com/example/ppa_1/`
    - `MainActivity.kt`: Actividad principal que configura la navegación.
    - `AddSubjectScreen.kt`: Pantalla para añadir asignaturas.
    - `MainScreen.kt`: Pantalla principal con opciones de navegación.
    - `ViewScheduleScreen.kt`: Pantalla para ver el horario.
    - `CurrentClassScreen.kt`: Pantalla para ver la clase actual.
    - `Header.kt`: Componente reutilizable para el encabezado.
    - `SubjectListScreen.kt`: Pantalla para listar todas las asignaturas.

## Uso
1. Ejecuta la aplicación en un dispositivo o emulador Android.
2. Navega entre las pantallas utilizando los botones disponibles.

## Pantallas

### Pantalla Principal
- **Descripción**: Pantalla inicial con opciones para añadir asignaturas, ver el horario y verificar la clase actual.
- **Componentes**: Botones de navegación.

### Añadir Asignatura
- **Descripción**: Permite añadir una nueva asignatura al horario.
- **Validaciones**:
    - Todos los campos deben estar llenos.
    - El formato de la hora debe ser `HH:mm`.
    - Solo se permiten días de la semana válidos (lunes a viernes).
    - No se permiten clases en fines de semana.
- **Componentes**: Campos de texto, botones de acción.

### Ver Horario
- **Descripción**: Muestra el horario de clases para un día específico.
- **Componentes**: Campo de texto para el día, botón para ver el horario, lista de asignaturas.

### Clase Actual
- **Descripción**: Muestra la clase actual basada en el día y la hora.
- **Componentes**: Texto con la fecha y hora actual, información de la clase actual.

## Componentes Reutilizables

### Header
- **Descripción**: Componente de encabezado con un fondo azul cian y texto blanco.
- **Uso**: Incluido en todas las pantallas para mostrar el título correspondiente.

## Firebase
- **Configuración**: Utiliza Firebase Firestore para almacenar y recuperar datos de las asignaturas.
- **Dependencias**: 
    ```kotlin
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    ```
