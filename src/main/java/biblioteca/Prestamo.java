/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author IngSis
 */
public class Prestamo {

    private static final int CONST_PLAZO_DEVOLVER = 30; //dias
    private Date fechaInicio;
    private Date fechaFin;
    private Multa multa;

    public Prestamo(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date calcularFechaFin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_MONTH, CONST_PLAZO_DEVOLVER);
        return calendar.getTime();
    }

    public Multa generarMulta() {
        Multa nuevaMulta = new Multa(new Date());
        this.multa = nuevaMulta;
        return nuevaMulta;
    }
}
