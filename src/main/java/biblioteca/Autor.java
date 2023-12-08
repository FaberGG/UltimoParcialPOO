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
public class Autor {
    private String nombre;
    private String nacionalidad;
    private String fechaNacimiento;


    public Autor(String nombre, String nacionalidad, String fechaNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    
    @Override
    public String toString() {
        return "Autor{" + "nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
}
