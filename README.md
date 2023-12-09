# UltimoParcialLabPOO
Proyecto hecho por:
  John Faber Navia Narvaez, Edward Esteban Davila Salazar

## Descripcion
Este es un proyecto de biblioteca en Java con Spark para el manejo de libros, lectores, préstamos y devoluciones. A continuación, se detallan los endpoints disponibles y las acciones para demostrar el funcionamiento del programa.

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

### Actualizar Multas y Mostrar Información (HTML)

- **URL:** [http://localhost:4567/actualizarMultas](http://localhost:4567/actualizarMultas)
- **Descripción:** Actualiza multas pendientes para cada lector y muestra información en formato HTML.

### Pagar Multas (HTML)

- **URL:** [http://localhost:4567/pagarMultas/html](http://localhost:4567/pagarMultas/html)
- **Descripción:** Permite pagar multas seleccionando un lector.

### Realizar Pago de Multa (POST)

- **URL:** [http://localhost:4567/pagarMulta](http://localhost:4567/pagarMulta)
- **Descripción:** Maneja el pago de una multa mediante una solicitud POST.



...

## Acciones para Demostrar el Funcionamiento

1. Accede al endpoint [http://localhost:4567/lectores/html](http://localhost:4567/lectores/html) para visualizar la lista de lectores y agregar un nuevo lector.
2. Realiza préstamos y devoluciones utilizando los endpoints [http://localhost:4567/prestamo/html](http://localhost:4567/prestamo/html) y [http://localhost:4567/devolucion/html](http://localhost:4567/devolucion/html).
3. Obtén información sobre todos los préstamos con el endpoint [http://localhost:4567/prestamos](http://localhost:4567/prestamos).
4. Accede al endpoint [http://localhost:4567/actualizarMultas](http://localhost:4567/actualizarMultas) para actualizar multas y mostrar información en formato HTML.
5. Paga una multa utilizando el formulario en el endpoint [http://localhost:4567/pagarMultas/html](http://localhost:4567/pagarMultas/html).



