package com.ingsof2.Objetos;

import com.ingsof2.utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class Venta extends Contrato {
    private int Comision;

    public Venta(Contrato aux, int comision) {
        super(aux);
        Comision = comision;
    }

    public Venta(String codigo, String fecha, float precio, int tipo, int comision) {
        super(codigo, fecha, precio, tipo);
        Comision = comision;
    }

    public int getComision() {
        return Comision;
    }

    public void setComision(int comision) {
        Comision = comision;
    }


    /**
     * Entra una lista de ventas y un anio, remuevo las ventas que no se iniciaron ese anio
     **/
    public List<Venta> ventasPorAnio(List<Venta> ventas, String anio) {
        List<Venta> aux = ventas;
        //Convierto anio de String a entero
        int anioint = Integer.parseInt(anio);
        for (int i = aux.size() - 1; i >= 0; i--) {
            //Recupero la fecha de inicio en un String, luego lo hago Date y luego recupero anio. Esto se puede mejorar, ya que gasto mucha memoria asi creo.
            String stringDateVenta = aux.get(i).getFecha();
            LocalDate dateVenta = Utils.stringToLocalDate(stringDateVenta);
            int dateYearVenta = dateVenta.getYear();
            /**Condicional, remueve si los anios son distintos**/
            if (!(dateYearVenta == anioint)) {
                aux.remove(i);
            }
        }
        return aux;
    }
}
