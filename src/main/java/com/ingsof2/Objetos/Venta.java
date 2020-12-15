package com.ingsof2.Objetos;

import com.ingsof2.utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class Venta extends Contrato {
    private int Comision;
    private String dniComprador;
    private String sexoComprador;
    private String domicilioInmueble;
    private String dniVendedor;
    private String sexoVendedor;

    public Venta() {

    }

    public Venta(Contrato aux, int comision, String dniComprador, String sexoComprador, String domicilioInmueble, String dniVendedor, String sexoVendedor) {
        super(aux);
        this.Comision = comision;
        this.dniComprador = dniComprador;
        this.sexoComprador = sexoComprador;
        this.domicilioInmueble = domicilioInmueble;
        this.dniVendedor = dniVendedor;
        this.sexoVendedor = sexoVendedor;
    }

    public Venta(String codigo, String fecha, float precio, int tipo, int comision, String dniComprador, String sexoComprador, String domicilioInmueble, String dniVendedor, String sexoVendedor) {
        super(codigo, fecha, precio, tipo);
        this.Comision = comision;
        this.dniComprador = dniComprador;
        this.sexoComprador = sexoComprador;
        this.domicilioInmueble = domicilioInmueble;
        this.dniVendedor = dniVendedor;
        this.sexoVendedor = sexoVendedor;
    }

    public String getSexoComprador() {
        return sexoComprador;
    }

    public void setSexoComprador(String sexoComprador) {
        this.sexoComprador = sexoComprador;
    }

    public String getSexoVendedor() {
        return sexoVendedor;
    }

    public void setSexoVendedor(String sexoVendedor) {
        this.sexoVendedor = sexoVendedor;
    }

    public static Object[][] getDataVector(List<Venta> ventas) {
        Object[][] objects = new Object[ventas.size()][0];

        for (int i = 0; i < ventas.size(); i++) {
            objects[i] = ventas.get(i).toObject();
        }
        return objects;
    }

    public static Object[] getHeaders() {
        return new Object[]{"Código", "Fecha", "Precio", "Tipo", "Comisión", "DNI Comprador", "Sexo Comprador", "Dirección Inmueble", "DNI Vendedor", "Sexo Vendedor"};
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

    private Object[] toObject() {
        return new Object[]{getCodigo(), getFecha(), getPrecio(), getTipo(), getComision(), getDniComprador(), getSexoComprador(), getDomicilioInmueble(), getDniVendedor(), getSexoVendedor()};
    }
}
