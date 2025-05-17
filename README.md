# Datos de Productos

Sistema de gestión de inventario para el registro y control de productos. Esta aplicación permite administrar productos mediante su ID, nombre, cantidad y ubicación, ofreciendo funcionalidades para guardar, eliminar y modificar registros.

## Descripción

Este programa desarrollado en Java permite a los usuarios gestionar un inventario de productos de manera eficiente. La aplicación se conecta con una base de datos MySQL para almacenar y recuperar información, proporcionando una interfaz sencilla para realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los registros de productos.

## Características principales

- Registro de productos con campos: ID, Nombre del Producto, Cantidad y Ubicación
- Búsqueda y filtrado de productos
- Modificación de registros existentes
- Eliminación de productos
- Interfaz de usuario intuitiva
- Conexión con base de datos MySQL para almacenamiento persistente

## Requisitos del sistema

- Java Runtime Environment (JRE) 8 o superior
- MySQL 8.4.2
- Conector JDBC para MySQL

## Instalación

1. Clone este repositorio:
   ```
   git clone https://github.com/Frank-Pesadilla/Datos_de_Productos.git
   ```

2. Importe el proyecto en su IDE preferido (Eclipse, NetBeans, IntelliJ).

3. Configure la base de datos MySQL:
   - Cree una base de datos llamada `inventario` (o el nombre que prefiera)
   - Ejecute el script SQL incluido en la carpeta `database` para crear la estructura necesaria
   - Actualice los parámetros de conexión en el archivo de configuración

4. Compile y ejecute la aplicación.

## Configuración de la base de datos

La aplicación utiliza MySQL 8.4.2 para el almacenamiento de datos. Asegúrese de tener instalada esta versión o superior para garantizar la compatibilidad.

### Estructura de la base de datos

La base de datos principal contiene la siguiente tabla:

```sql
CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    ubicacion VARCHAR(50) NOT NULL
);
```

### Parámetros de conexión

Los parámetros de conexión a la base de datos se encuentran en el archivo `src/config/DatabaseConfig.java`. Puede modificarlos según su configuración local:

```java
// Ejemplo de configuración
private static final String DB_URL = "jdbc:mysql://localhost:3306/inventario";
private static final String DB_USER = "root";
private static final String DB_PASSWORD = "password";
```

## Uso

1. Inicie la aplicación ejecutando el archivo principal.
2. Utilice la interfaz para agregar, modificar o eliminar productos.
3. Los datos se guardarán automáticamente en la base de datos MySQL.

## Funcionalidades

### Guardar producto
Permite registrar un nuevo producto en el sistema, asignándole un ID único, nombre, cantidad y ubicación.

### Eliminar producto
Elimina un producto existente del sistema utilizando su ID como referencia.

### Modificar producto
Actualiza la información de un producto existente, permitiendo cambiar su nombre, cantidad y ubicación.

### Búsqueda
Busca productos según diferentes criterios como ID, nombre o ubicación.

## Desarrollo

Este proyecto fue desarrollado utilizando:
- Java
- MySQL 8.4.2
- JDBC para la conexión con la base de datos
- Swing para la interfaz gráfica

## Contribución

Si desea contribuir a este proyecto, por favor:

1. Haga un fork del repositorio
2. Cree una rama para su funcionalidad (`git checkout -b feature/nueva-funcionalidad`)
3. Haga commit de sus cambios (`git commit -am 'Agrega nueva funcionalidad'`)
4. Haga push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Cree un nuevo Pull Request

## Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).

## Contacto

Frank Pesadilla - [GitHub](https://github.com/Frank-Pesadilla)

Link del proyecto: [https://github.com/Frank-Pesadilla/Datos_de_Productos](https://github.com/Frank-Pesadilla/Datos_de_Productos)