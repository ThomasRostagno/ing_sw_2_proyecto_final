package com.ingsof2.Objetos;

import com.ingsof2.utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class Venta extends Contrato {
    private int Comision;
    private String dniComprador;
    private String domicilioInmueble;
    private String dniVendedor;

    public Venta() {

    }

    public Venta(Contrato aux, int comision, String dniComprador, String domicilioInmueble, String dniVendedor) {
        super(aux);
        Comision = comision;
        this.dniComprador = dniComprador;
        this.domicilioInmueble = domicilioInmueble;
        this.dniVendedor = dniVendedor;
    }

    public Venta(String codigo, String fecha, float precio, int tipo, int comision, String dniComprador, String domicilioInmueble, String dniVendedor) {
        super(codigo, fecha, precio, tipo);
        Comision = comision;
        this.dniComprador = dniComprador;
        this.domicilioInmueble = domicilioInmueble;
        this.dniVendedor = dniVendedor;
    }

    public static Object[][] getDataVector(List<Venta> ventas) {
        Object[][] objects = new Object[ventas.size()][0];

        for (int i = 0; i < ventas.size(); i++) {
            objects[i] = ventas.get(i).toObject();
        }
        return objects;
    }

    public static Object[] getHeaders() {
        return new Object[]{"Código", "Fecha", "Precio", "Tipo", "Comisión", "Comprador", "Dirección Inmueble", "Vendedor"};
    }

    public int getComision() {
        return Comision;
    }

    public void setComision(int comision) {
        Comision = comision;
    }

    public String getDniComprador() {
        return dniComprador;
    }

    public void setDniComprador(String dniComprador) {
        this.dniComprador = dniComprador;
    }

    public String getDomicilioInmueble() {
        return domicilioInmueble;
    }

    public void setDomicilioInmueble(String domicilioInmueble) {
        this.domicilioInmueble = domicilioInmueble;
    }

    public String getDniVendedor() {
        return dniVendedor;
    }

    public void setDniVendedor(String dniVendedor) {
        this.dniVendedor = dniVendedor;
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

    private Object[] toObject() {
        return new Object[]{getCodigo(), getFecha(), getPrecio(), getTipo(), getComision(), getDniComprador(), getDomicilioInmueble(), getDniVendedor()};
    }
}
