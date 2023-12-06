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
public class Lector {
    private int numSocio;
    private String nombre;
    private String apellidos;
    private String direccion;
    
    private Copia[] copias;
    private Multa multa;

    public Lector(int numSocio, String nombre, String apellidos, String direccion) {
        this.numSocio = numSocio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.copias = new Copia[3];
    }
    
    
}
