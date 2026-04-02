WeatherApp - Android Portfolio Project 🌦️<br>
WeatherApp es una aplicación moderna de clima que permite consultar el pronóstico en tiempo real y gestionar una lista de ciudades favoritas. Este proyecto fue desarrollado como trabajo final para consolidar <br>
conocimientos avanzados en Jetpack Compose, Arquitectura MVVM y Consumo de APIs REST.
<br>
<img width="72" height="72" alt="image" src="https://github.com/user-attachments/assets/477aef41-0c71-41f3-a908-ebca9f8c42f8" />
<br>
🛠️ Tech Stack & Herramientas
<br>
Lenguaje: Kotlin + Coroutines & Flow (para manejo de asincronismo).
<br>
UI: Jetpack Compose con Material Design 3.
<br>
Arquitectura: MVVM (Model-View-ViewModel) con Clean Architecture.
<br>
Networking: Retrofit + Consumo de API (weatherapi)
<br>
Persistencia: Room Database para el almacenamiento local de ciudades.
<br>
Inyección de Dependencias: Koin.
<br>
Imágenes: Coil para la carga de iconos climáticos.
<br>
✨ Características Principales
<br>
Búsqueda Dinámica: Autocompletado de ciudades mediante la API de WeatherApi.
<br>
Pronóstico Detallado: Datos de temperatura, humedad, viento y estado del cielo.
<br>
Gestión de Favoritos: Persistencia local de ciudades elegidas por el usuario.
<br>
UX Fluida: Implementación de gestos (Swipe-to-Delete) para eliminar ciudades de la lista.
<br>
Manejo de Estados: Uso de StateFlow y collectAsStateWithLifecycle para una UI reactiva.
<br>
🚀 Instalación y Uso
<br>
Para ejecutar este proyecto, necesitarás seguir estos pasos:
<br>
Clonar el repositorio:
<br>
git clone https://github.com/andresarnedo-/WeatherApp.git
<br>
Obtener una API KEY gratuita en https://www.weatherapi.com/
<br>
Agrega tu llave en el archivo Constants.kt:
<br>
const val API_KEY = "TU_LLAVE_AQUÍ"
<br>
🧠 Desafíos Técnicos y Aprendizajes
<br>
Sincronización de Datos: Logré integrar la respuesta de la API con la base de datos local para que el usuario tenga acceso rápido a sus ciudades guardadas.
<br>
Componentes Personalizados: Diseñé componentes reutilizables en Compose para mantener un código limpio y escalable (DRY).

