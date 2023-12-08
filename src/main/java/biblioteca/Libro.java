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

    private ArrayList<Autor> autores;
    private transient ArrayList<Copia> copias;

    public Libro(String nombre, String tipo, String editorial, String año,
            ArrayList<Autor> autores) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.año = año;
        this.copias = new ArrayList<>();
        this.autores = autores;
    }

    public void agregarCopia(Copia copia) {
        this.copias.add(copia);
    }

    public void agregarCopias(ArrayList<Copia> copias) {
        for (Copia copia : copias) {
            this.copias.add(copia);
        }
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", tipo=" + tipo + ", editorial=" + editorial + ", a\u00f1o=" + año + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAño() {
        return año;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public ArrayList<Copia> getCopias() {
        return copias;
    }

}
