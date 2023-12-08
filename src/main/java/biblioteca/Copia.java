/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author IngSis
 */
public class Copia {

    private int identificador;
    private String estado;
    private Libro libro;
    private transient Lector lector;
    private Prestamo prestamo;

    public Copia(int identificador, Libro libro) {
        this.identificador = identificador;
        this.estado = "NoPrestado";
        this.libro = libro;
    }

    public void prestar(Lector lector) {
        if ("NoPrestado".equals(estado)) {
            estado = "prestado";
            this.prestamo = new Prestamo(new Date());
            setLector(lector);
            lector.agregarCopia(this);
        }
    }

    public void devolver() {
        if ("prestado".equals(estado)) {
            this.lector.removerCopia(this);
            estado = "NoPrestado";
            this.prestamo = null;
            setLector(null);
        }
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public Libro getLibro() {
        return libro;
    }

    public Lector getLector() {
        return lector;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }
    
    
}
