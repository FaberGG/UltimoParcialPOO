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

    private ArrayList<Copia> copias;
    private Multa multa;

    public Lector(int numSocio, String nombre, String apellidos, String direccion) {
        this.numSocio = numSocio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.copias = new ArrayList<>();
    }

    public void agregarCopia(Copia copia) {
        if (this.copias.size() < 3) {
            this.copias.add(copia);
        }
    }

    public void removerCopia(Copia copia) {
        copias.remove(copia);
    }

    public void comprobarMultasPendientes() {
        
    }
    public String getNombreCompleto(){
        return nombre + " " + apellidos;
    }

    public int getNumSocio() {
        return numSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Copia> getCopias() {
        return copias;
    }

    public Multa getMulta() {
        return multa;
    }
    
}
