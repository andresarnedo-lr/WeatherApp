# WeatherApp - Android Portfolio Project 🌦️

<p align="center">
  <img src="https://github.com/user-attachments/assets/477aef41-0c71-41f3-a908-ebca9f8c42f8" width="120" height="120" alt="WeatherApp Logo" />
</p>

**WeatherApp** es una aplicación moderna de clima diseñada para ofrecer pronósticos en tiempo real con una experiencia de usuario fluida. Este proyecto representa mi trabajo final integrador, donde apliqué conceptos avanzados de desarrollo nativo en Android.

---

## 🛠️ Tech Stack & Herramientas

| Categoría | Tecnología |
| :--- | :--- |
| **Lenguaje** | Kotlin + Coroutines & Flow |
| **UI Framework** | Jetpack Compose (Material Design 3) |
| **Arquitectura** | MVVM + Clean Architecture |
| **DI** | Koin |
| **Networking** | Retrofit + WeatherAPI |
| **Persistencia** | Room Database |
| **Imágenes** | Coil |

---

## ✨ Características Principales

* 🔍 **Búsqueda Dinámica:** Autocompletado de ciudades mediante la API de WeatherApi.
* 📊 **Pronóstico Detallado:** Datos de temperatura, humedad, viento y estado del cielo en tiempo real.
* ⭐ **Gestión de Favoritos:** Persistencia local de ciudades elegidas por el usuario.
* 📱 **UX Fluida:** Implementación de gestos (*Swipe-to-Delete*) para una gestión intuitiva de la lista.
* 🔄 **Manejo de Estados:** Arquitectura reactiva utilizando `StateFlow` y `collectAsStateWithLifecycle`.

---

## 🚀 Instalación y Uso

Sigue estos pasos para ejecutar el proyecto localmente:

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/andresarnedo-/WeatherApp.git](https://github.com/andresarnedo-/WeatherApp.git)
   Obtener API KEY:
Regístrate de forma gratuita en WeatherAPI para obtener tu llave.

Configuración:
Agrega tu llave en el archivo Constants.kt:

const val API_KEY = "TU_LLAVE_AQUÍ"

🧠 Desafíos Técnicos y Aprendizajes
Sincronización de Datos: Logré integrar la respuesta de la API con la base de datos local (Room), asegurando que el usuario tenga acceso rápido a sus ciudades guardadas incluso tras reiniciar la app.

Componentes Reutilizables: Diseñé un sistema de componentes en Compose bajo el principio DRY (Don't Repeat Yourself), facilitando la escalabilidad y el mantenimiento del código.

🎬 Demo
<p align="center">
<img src="" width="280" />
</p>

<p align="center">
Desarrollado por <b>Arnedo Andres Alfredo</b>
</p>
<br>
<img width="72" height="72" alt="image" src="https://github.com/user-attachments/assets/477aef41-0c71-41f3-a908-ebca9f8c42f8" />
