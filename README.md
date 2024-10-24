
# Conversor de Divisas - Java

Este proyecto es una aplicación simple de consola en Java que permite convertir montos de una divisa a otra utilizando la **Exchange Rate API** para obtener tasas de cambio en tiempo real.

## Características

- Conversión de divisas en tiempo real.
- Soporte para múltiples monedas.
- Interfaz de usuario basada en la consola.
- Obtención de datos mediante la **Exchange Rate API**.

## Requisitos Previos

Para ejecutar este proyecto necesitas tener instalado:

- **Java 8** o superior.
- **Maven** (si utilizas un gestor de dependencias).
- Conexión a Internet (para obtener las tasas de cambio).
- Una **API Key** de [Exchange Rate API](https://www.exchangerate-api.com/) para realizar solicitudes.

## Configuración

### Clave API
Antes de ejecutar el proyecto, debes registrar una cuenta en [Exchange Rate API](https://www.exchangerate-api.com/) y obtener tu clave API. Luego, reemplaza la constante `API_KEY` en el código por tu propia clave:

```java
private static final String API_KEY = "TU_CLAVE_API_AQUI";
```

## Cómo ejecutar el proyecto
- Clona el repositorio o descarga los archivos del proyecto.
- Abre el proyecto en IntelliJ IDEA (u otro entorno de desarrollo).
- Asegúrate de que las dependencias estén instaladas correctamente (usa Maven para recargar las dependencias si es necesario).
- Reemplaza la clave API por la tuya.
- Ejecuta la clase Main.java.

### Uso
Cuando ejecutes la aplicación, se te pedirá que ingreses:

- Moneda base (ej. USD).
- Moneda de destino (ej. EUR).
- Cantidad de dinero que deseas convertir.
- El programa te devolverá el monto convertido utilizando la tasa de cambio actual.

## Mejoras futuras
Algunas características que podrían añadirse en el futuro incluyen:

- Soporte para conversiones de múltiples divisas en una sola ejecución.
- Interfaz gráfica para una mejor experiencia de usuario.
- Manejo de errores más detallado.

