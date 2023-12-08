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
public class Multa {

    private static final int CONST_PLAZO_PAGAR = 20; //dias

    private Date fechaInicio;
    private Date fechaFin;

    public Multa(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date calcularFechaFin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_MONTH, CONST_PLAZO_PAGAR);
        return calendar.getTime();
    }
}
