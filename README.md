# UltimoParcialLabPOO
Proyecto hecho por:
  John Faber Navia Narvaez, Edward Esteban Davila Salazar

## Descripcion
Este es un proyecto de biblioteca en Java con Spark para el manejo de libros, lectores, préstamos y devoluciones. A continuación, se detallan los endpoints disponibles y las acciones para demostrar el funcionamiento del programa.

##Diagrama
![Diagrama de Proceso](https://github.com/FaberGG/UltimoParcialPOO/Diagrama%20de%20proceso.png)
## respuesta a la pregunta planteada
Este diagrama refleja la complejidad del flujo de ejecución, incluyendo la interacción entre las diferentes funcionalidades como préstamos, devoluciones, actualización de multas y pago de multas. La complejidad puede ser confusa para un usuario final porque implica una variedad de operaciones y formularios que deben comprenderse y utilizarse correctamente. Además, la gestión de multas y la persistencia de datos pueden añadir capas de complejidad que pueden resultar confusas para alguien que no esté familiarizado con la lógica interna del sistema.
## Requisitos

- **Java JDK 18**: Asegúrate de tener Java JDK 18 instalado en tu sistema en caso contrario puedes modificar el archivo [POM](UltimoParcialPOO/pom.xml)
.
- **Maven**: Necesitarás Maven para compilar y ejecutar el proyecto.

## Instalación y Ejecución

1. **Clona el Proyecto**: Abre una terminal y ejecuta el siguiente comando para clonar el proyecto:

    ```bash
    git clone https://github.com/FaberGG/UltimoParcialPOO.git
    ```

2. **Accede a la Carpeta del Proyecto**:

    ```bash
    cd UltimoParcialPOO
    ```

3. **Ejecuta con Maven**:

    ```bash
    mvn exec:java
    ```

4. **Accede a los Endpoints**:

   Abre tu navegador web y accede a los diferentes endpoints, o utiliza herramientas como cURL o Postman.
   se recomienda instalar la extension para navegadores JSON Formatter
## Endpoints

### Obtener Lista de Libros (JSON)

- **URL:** [http://localhost:4567/libros/json](http://localhost:4567/libros/json)
- **Descripción:** Devuelve la lista de libros en formato JSON.

### Obtener Lista de Lectores (JSON)

- **URL:** [http://localhost:4567/lectores/json](http://localhost:4567/lectores/json)
- **Descripción:** Devuelve la lista de lectores en formato JSON.

### Obtener Lista de Lectores (HTML)

- **URL:** [http://localhost:4567/lectores/html](http://localhost:4567/lectores/html)
- **Descripción:** Muestra la lista de lectores y un formulario en formato HTML, permitiendo agregar nuevos lectores.

### Realizar Préstamo de Libro (HTML)

- **URL:** [http://localhost:4567/prestamo/html](http://localhost:4567/prestamo/html)
- **Descripción:** Permite realizar un préstamo seleccionando un lector y un libro.

### Realizar Devolución de Libro (HTML)

- **URL:** [http://localhost:4567/devolucion/html](http://localhost:4567/devolucion/html)
- **Descripción:** Permite realizar la devolución de un libro seleccionando una copia.

### Obtener Información de Préstamos (JSON)

- **URL:** [http://localhost:4567/prestamos](http://localhost:4567/prestamos)
- **Descripción:** Devuelve información sobre todos los préstamos en formato JSON.

### Actualizar Multas (HTML)

- **URL:** [http://localhost:4567/actualizarMultas](http://localhost:4567/actualizarMultas)
- **Descripción:** Actualiza multas pendientes para cada lector.

### Pagar Multas (HTML)

- **URL:** [http://localhost:4567/pagarMultas/html](http://localhost:4567/pagarMultas/html)
- **Descripción:** Permite pagar multas seleccionando un lector.

### Guardar Lectores (HTML)

- **URL:** [http://localhost:4567/lectores/guardar](http://localhost:4567/lectores/guardar)
- **Descripción:** Permite guardar en formato json la informacion de los lectores ingresada en un archivo json en el repositorio, esta información sera cargada al inicio de la ejeccion.

### vaciar lectores (HTML)

- **URL:** [http://localhost:4567/lectores/vaciar](http://localhost:4567/lectores/vaciar)
- **Descripción:** Permite vaciar todos los lectores añadodos hasta el momento del programa y del archivo json.



...

## Acciones para Demostrar el Funcionamiento

1. Accede al endpoint [http://localhost:4567/lectores/html](http://localhost:4567/lectores/html) para visualizar la lista de lectores y agregar un nuevo lector.
2. Visualizar la informacion de los lectores añadidos en el paso anterior [http://localhost:4567/lectores/json](http://localhost:4567/lectores/json).
3. Realiza préstamos y devoluciones utilizando los endpoints [http://localhost:4567/prestamo/html](http://localhost:4567/prestamo/html) y [http://localhost:4567/devolucion/html](http://localhost:4567/devolucion/html).
4. Obtén información sobre todos los préstamos con el endpoint [http://localhost:4567/prestamos](http://localhost:4567/prestamos).
5. Accede al endpoint [http://localhost:4567/actualizarMultas](http://localhost:4567/actualizarMultas) para actualizar multas.
6. Paga una multa utilizando el formulario en el endpoint [http://localhost:4567/pagarMultas/html](http://localhost:4567/pagarMultas/html) (solo funciona en caso de que al actualizar una multa se haya generado una, es decir que se haya vencido el prestamo para un lector).
7. guarda la informacion de los lectores añadidos accediendo al endpoint [http://localhost:4567/lectores/guardar](http://localhost:4567/lectores/guardar).
8. Deten la ejecucion del proyecto y accede al enpoint [http://localhost:4567/lectores/json](http://localhost:4567/lectores/json) para comprobar la informacion de los lectores guardados.
9. accede al endpoint [http://localhost:4567/lectores/vaciar](http://localhost:4567/lectores/vaciar) para eliminar toda la informacion de los lectores, tanto del programa en ejecución como del archivo json de respaldo.
10. accede al enpoint [http://localhost:4567/lectores/json](http://localhost:4567/lectores/json) para comprobar que se hayan eliminado todos los lectores del programa.



