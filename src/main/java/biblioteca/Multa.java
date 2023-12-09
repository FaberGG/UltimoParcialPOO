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
    private static final double CONST_MONTO_INICIAL = 30000; //pesos
    private static final double CONST_COSTO_POR_MORA = 5000; //pesos por cada mes de atraso

    private Date fechaInicio;
    private Date fechaFin;

    public Multa(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void calcularFechaFin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_MONTH, CONST_PLAZO_PAGAR);
        fechaFin = calendar.getTime();
    }

    public double calcularMonto() {
        // Calcular el tiempo de mora en meses con respecto al instante actual
        Calendar inicioCalendar = Calendar.getInstance();
        inicioCalendar.setTime(fechaInicio);
        Calendar actualCalendar = Calendar.getInstance();
        actualCalendar.setTime(new Date());

        int mesesMora = 0;

        while (inicioCalendar.before(actualCalendar)) {
            inicioCalendar.add(Calendar.MONTH, 1);
            mesesMora++;
        }

        // Calcular el monto total de la multa
        double montoTotal = CONST_MONTO_INICIAL + (mesesMora - 1) * CONST_COSTO_POR_MORA;

        return montoTotal;
    }

    public boolean estaVencida() {
        Date fechaActual = new Date();
        return fechaActual.after(fechaFin);
    }
}
