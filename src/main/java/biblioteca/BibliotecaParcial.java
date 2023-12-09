/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package biblioteca;

import static spark.Spark.*;
import com.google.gson.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaParcial {

    private static final String LECTORES_FILE = "lectores.json";

    private static final Gson gson = new Gson();

    public static void main(String[] args) {

        // Cargar lectores y libros al iniciar el programa
        ArrayList<Lector> lectores = cargarLectores();
        ArrayList<Libro> libros = new ArrayList<>();

        // se crea objetos Autor
        Autor jkRowling = new Autor("J.K. Rowling", "Reino Unido", "31 de julio de 1965");
        Autor georgeOrwell = new Autor("George Orwell", "Reino Unido", "25 de junio de 1903");
        //autores de cada libro
        ArrayList<Autor> autoresHarryPotter = new ArrayList<>();
        autoresHarryPotter.add(jkRowling);
        ArrayList<Autor> autores1984 = new ArrayList<>();
        autores1984.add(georgeOrwell);
        // se crean objetos Libro
        Libro harryPotterI = new Libro("Harry Potter y la piedra filosofal", "Fantasia", "Salamandra", "1997", autoresHarryPotter);
        Libro harryPotterII = new Libro("Harry Potter y la camara secreta", "Fantasia", "Salamandra", "1998", autoresHarryPotter);
        Libro t1984 = new Libro("1984", "Distopía", "Secker & Warburg", "1949", autores1984);

        //se crean copias de los libros y añadirlas al libro
        harryPotterI.agregarCopias(crearCopias(harryPotterI, 4));
        harryPotterII.agregarCopias(crearCopias(harryPotterII, 3));
        t1984.agregarCopias(crearCopias(t1984, 1));

        //añade los libros a la lista de libros
        libros.add(harryPotterI);
        libros.add(harryPotterII);
        libros.add(t1984);

        // crea el objeto lector por defecto
        Lector lectorDefecto = new Lector(1, "alfredo", "castillos", "Boston 023");
        lectores.add(lectorDefecto);

        // Por defecto 
        get("/libros/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(libros);
        });

        get("/lectores/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(lectores);
        });

        get("/lectores/html", (req, res) -> {
            res.type("text/html");
            StringBuilder html = new StringBuilder("<html><body><h1>Lista de Lectores</h1><ul>");
            for (Lector lector : lectores) {
                html.append("<li>").append(lector.getNombreCompleto()).append("</li>");
            }
            html.append("</ul>");

            // Agregar botón para redirigir a la lista de lectores generada por GSON
            html.append("<form method='get' action='/lectores/json'>");
            html.append("<input type='submit' value='Ver Lista JSON'>");
            html.append("</form>");

            // Agregar formulario para anadir un lector
            html.append("<h2>Anadir Lector</h2>");
            html.append("<form method='post' action='/lectores/agregar'>");
            html.append("Nombre: <input type='text' name='nombre'><br>");
            html.append("Apellidos: <input type='text' name='apellidos'><br>");
            html.append("Direccion: <input type='text' name='direccion'><br>");
            html.append("<input type='submit' value='Agregar Lector'>");
            html.append("</form>");

            html.append("</body></html>");
            return html.toString();
        });

        // Ruta para manejar la adicion de un nuevo lector
        post("/lectores/agregar", (req, res) -> {
            int numSocio = lectores.size() + 1;
            String nombre = req.queryParams("nombre");
            String apellidos = req.queryParams("apellidos");
            String direccion = req.queryParams("direccion");

            // Crear y agregar el nuevo lector
            Lector nuevoLector = new Lector(numSocio, nombre, apellidos, direccion);
            lectores.add(nuevoLector);

            // Redirigir de nuevo a la pagina de lista de lectores
            res.redirect("/lectores/html");
            return null;
        });

        // Ruta para mostrar el formulario de prestamo de libro
        get("/prestamo/html", (req, res) -> {
            res.type("text/html");
            StringBuilder html = new StringBuilder("<html><body><h1>Prestamo de Libros</h1>");

            // Formulario para seleccionar lector y libro
            html.append("<form method='post' action='/prestamo/realizar'>");

            // Lista desplegable para seleccionar el lector
            html.append("<label for='lector'>Seleccione un lector:</label>");
            html.append("<select name='lector'>");
            for (Lector lector : lectores) {
                html.append("<option value='").append(lector.getNumSocio()).append("'>")
                        .append(lector.getNombreCompleto()).append("</option>");
            }
            html.append("</select><br>");

            // Lista desplegable para seleccionar el libro
            html.append("<label for='libro'>Seleccione un libro:</label>");
            html.append("<select name='libro'>");
            for (Libro libro : libros) {
                html.append("<option value='").append(libro.getNombre()).append("'>")
                        .append(libro.getNombre()).append("</option>");
            }
            html.append("</select><br>");

            // Boton para realizar el prestamo
            html.append("<input type='submit' value='Realizar Prestamo'>");
            html.append("</form>");

            html.append("</body></html>");
            return html.toString();
        });

        // Ruta para manejar la realizacion del prestamo
        post("/prestamo/realizar", (req, res) -> {
            String numSocio = req.queryParams("lector");
            String tituloLibro = req.queryParams("libro");

            // Buscar lector y libro correspondientes
            Lector lectorSeleccionado = null;
            for (Lector lector : lectores) {
                if (Integer.toString(lector.getNumSocio()).equals(numSocio)) {
                    lectorSeleccionado = lector;
                    break;
                }
            }
            Libro libroSeleccionado = null;
            for (Libro libro : libros) {
                if (libro.getNombre().equals(tituloLibro)) {
                    libroSeleccionado = libro;
                    break;
                }
            }

            // Realiza el pretamo
            if (lectorSeleccionado != null && libroSeleccionado != null) {
                for (Copia copia : libroSeleccionado.getCopias()) {
                    if ("NoPrestado".equals(copia.getEstado())) {
                        copia.prestar(lectorSeleccionado);
                        res.redirect("/prestamo/html?mensaje=Prestamo realizado exitosamente");
                        break;
                    }
                }
            } else {
                res.redirect("/prestamo/html?mensaje=Error en el prestamo o copias insuficientes");
            }
            return null;
        });

        //ENDPOINT: formulario de devolucion de libro
        get("/devolucion/html", (req, res) -> {
            res.type("text/html");
            StringBuilder html = new StringBuilder("<html><body><h1>Devolucion de Libros</h1>");

            // Formulario para seleccionar la copia
            html.append("<form method='post' action='/devolucion/realizar'>");

            // Lista de todas las copias y el nombre del lector asociado
            html.append("<label for='copia'>Seleccione una copia:</label>");
            html.append("<select name='copia'>");
            for (Lector lector : lectores) {
                for (Copia copia : lector.getCopias()) {
                    html.append("<option value='").append(copia.getIdentificador()).append("'>")
                            .append("Libro: ").append(copia.getLibro().getNombre())
                            .append(", ID Copia: ").append(copia.getIdentificador())
                            .append(", Lector: ").append(lector.getNombreCompleto()).append("</option>");
                }
            }
            html.append("</select><br>");

            // Boton para realizar la devolucion
            html.append("<input type='submit' value='Realizar Devolucion'>");
            html.append("</form>");

            html.append("</body></html>");
            return html.toString();
        });

        // Ruta para manejar la realizacion de la devolucion
        post("/devolucion/realizar", (req, res) -> {
            int idCopia = Integer.parseInt(req.queryParams("copia"));

            // Buscar copia correspondiente
            Copia copiaSeleccionada = null;
            for (Lector lector : lectores) {
                for (Copia copia : lector.getCopias()) {
                    if (copia.getIdentificador() == idCopia) {
                        copiaSeleccionada = copia;
                        break;
                    }
                }
                if (copiaSeleccionada != null) {
                    break;
                }
            }

            // Realizar la devolucion
            if (copiaSeleccionada != null) {
                copiaSeleccionada.devolver();
                res.redirect("/devolucion/html?mensaje=Devolucion realizada exitosamente");
            } else {
                res.redirect("/devolucion/html?mensaje=Error en la devolucion");
            }
            return null;
        });

        // Ruta para obtener información de todos los préstamos
        get("/prestamos", (req, res) -> {
            res.type("application/json");

            // Lista para almacenar la información de los préstamos
            List<Map<String, Object>> prestamosInfo = new ArrayList<>();

            for (Lector lector : lectores) {
                for (Copia copia : lector.getCopias()) {
                    Prestamo prestamo = copia.getPrestamo();
                    if (prestamo != null) {
                        Map<String, Object> info = new HashMap<>();
                        info.put("lector", lector.getNombreCompleto());
                        info.put("libro", copia.getLibro().getNombre());
                        info.put("fecha_inicio", prestamo.getFechaInicio());
                        info.put("fecha_fin", prestamo.getFechaFin());
                        prestamosInfo.add(info);
                    }
                }
            }

            return gson.toJson(prestamosInfo);
        });

        // Ruta para actualizar multas y mostrar información
        get("/actualizarMultas", (req, res) -> {
            res.type("text/html");
            String html = "<html><body><h1>Multas Actualizadas</h1>";
            // Comprobar multas pendientes para cada lector
            for (Lector lector : lectores) {
                lector.comprobarMultasPendientes();
            }
            return html;
        });
        // Ruta para pagar multas
        get("/pagarMultas/html", (req, res) -> {
            res.type("text/html");
            StringBuilder html = new StringBuilder("<html><body><h1>PAGAR MULTAS</h1>");

            // Boton para pagar una multa
            html.append("<form method='post' action='/pagarMulta'>");
            html.append("<label for='lectorPago'>Seleccione un lector para pagar la multa:</label>");
            html.append("<select name='lectorPago'>");
            for (Lector lector : lectores) {
                html.append("<option value='").append(lector.getNumSocio()).append("'>")
                        .append(lector.getNombreCompleto()).append("</option>");
            }
            html.append("</select>");
            html.append("<input type='submit' value='Pagar Multa'>");
            html.append("</form>");
            html.append("</body></html>");
            return html.toString();
        });
        // Ruta para manejar el pago de una multa
        post("/pagarMulta", (req, res) -> {
            int numSocio = Integer.parseInt(req.queryParams("lectorPago"));

            // Buscar lector correspondiente
            Lector lectorSeleccionado = null;
            for (Lector lector : lectores) {
                if (lector.getNumSocio() == numSocio) {
                    lectorSeleccionado = lector;
                    break;
                }
            }

            // Pagar la multa
            if (lectorSeleccionado != null && lectorSeleccionado.getPrestamo() != null
                    && lectorSeleccionado.getPrestamo().getMulta() != null) {
                //simulo el pago eliminando la multa del lector
                lectorSeleccionado.getPrestamo().setMulta(null);
                res.redirect("/actualizarMultas/?mensaje=Multa pagada exitosamente");

            } else {
                res.redirect("/actualizarMultas/?mensaje=Error al pagar la multa");
            }
            return null;
        });

        // Endpoint para guardar la información de los lectores
        get("/lectores/guardar", (req, res) -> {
            // Guardar la información de los lectores en el archivo
            guardarLectores(lectores);
            return "Información de lectores guardada exitosamente.";
        });
        //endpiont para vaciar el contenido del json
        get("/lectores/vaciar", (req, res) -> {
            ArrayList<Lector> lectoresVacios = new ArrayList<>();
            guardarLectores(lectoresVacios);
            lectores.clear();
            return "Contenido del archivo JSON vaciado exitosamente.";
        });
    }

    //metodo para crear copias de un libro
    private static ArrayList<Copia> crearCopias(Libro libro, int cantidad) {
        Random random = new Random();
        ArrayList<Copia> copias = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            int identificador = random.nextInt(1000);
            Copia copia = new Copia(identificador, libro);
            copias.add(copia);
        }
        return copias;
    }

    //persistencia para lectores
    public static void guardarLectores(ArrayList<Lector> lectores) {
        try (FileWriter writer = new FileWriter(LECTORES_FILE)) {
            gson.toJson(lectores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Lector> cargarLectores() {
        File lectoresFile = new File(LECTORES_FILE);

        if (!lectoresFile.exists()) {
            // Si el archivo no existe, retorna una lista vacía
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(lectoresFile)) {
            return gson.fromJson(reader, ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
