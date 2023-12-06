/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author IngSis
 */
public class Libro {

    private String nombre;
    private String tipo;
    private String editorial;
    private String año;

    ArrayList<Autor> autores;
    ArrayList<Copia> copias;

    public Libro(String nombre, String tipo, String editorial, String año) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.año = año;
        this.copias = new ArrayList<>();
        this.autores = new ArrayList<>();
    }
}
