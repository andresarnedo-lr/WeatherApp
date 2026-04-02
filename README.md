WeatherApp - Android Portfolio Project 🌦️
WeatherApp es una aplicación moderna de clima que permite consultar el pronóstico en tiempo real y gestionar una lista de ciudades favoritas. Este proyecto fue desarrollado como trabajo final para consolidar conocimientos avanzados en Jetpack Compose, Arquitectura MVVM y Consumo de APIs REST.
<br>
<img width="72" height="72" alt="image" src="https://github.com/user-attachments/assets/477aef41-0c71-41f3-a908-ebca9f8c42f8" />

🛠️ Tech Stack & Herramientas
Lenguaje: Kotlin + Coroutines & Flow (para manejo de asincronismo).

UI: Jetpack Compose con Material Design 3.

Arquitectura: MVVM (Model-View-ViewModel) con Clean Architecture.

Networking: Retrofit + Consumo de API (weatherapi)

Persistencia: Room Database para el almacenamiento local de ciudades.

Inyección de Dependencias: Koin.

Imágenes: Coil para la carga de iconos climáticos.

✨ Características Principales
Búsqueda Dinámica: Autocompletado de ciudades mediante la API de WeatherApi.

Pronóstico Detallado: Datos de temperatura, humedad, viento y estado del cielo.

Gestión de Favoritos: Persistencia local de ciudades elegidas por el usuario.

UX Fluida: Implementación de gestos (Swipe-to-Delete) para eliminar ciudades de la lista.

Manejo de Estados: Uso de StateFlow y collectAsStateWithLifecycle para una UI reactiva.

🚀 Instalación y Uso
Para ejecutar este proyecto, necesitarás seguir estos pasos:

Clonar el repositorio:
git clone https://github.com/andresarnedo-/WeatherApp.git
Obtener una API KEY gratuita en https://www.weatherapi.com/
Agrega tu llave en el archivo Constants.kt:
const val API_KEY = "TU_LLAVE_AQUÍ"

🧠 Desafíos Técnicos y Aprendizajes
Sincronización de Datos: Logré integrar la respuesta de la API con la base de datos local para que el usuario tenga acceso rápido a sus ciudades guardadas.

Componentes Personalizados: Diseñé componentes reutilizables en Compose para mantener un código limpio y escalable (DRY).

