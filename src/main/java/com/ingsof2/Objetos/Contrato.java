package com.ingsof2.Objetos;

import java.util.List;

public class Contrato {
    private String codigo;
    private String fecha;
    private float precio; //puede ser por mes de alquiler o por venta final
    private int tipo;

    public Contrato() {
    }

    public Contrato(Contrato aux) {
        this.codigo = aux.codigo;
        this.fecha = aux.fecha;
        this.precio = aux.precio;
        this.tipo = aux.tipo;
    }

    public Contrato(String codigo, String fecha, float precio, int tipo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /*public static Object[][] getDataVector(List<Contrato> contratos) {
        Object[][] objects = new Object[0][0];

        for (int i = 0; i < contratos.size(); i++) {
            objects[i] = contratos.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{codigo, fecha, precio, tipo};
    }

    public static Object[] getHeaders() {
        return new Object[]{"Codigo", "Fecha", "Monto", "Tipo"};
    }*/
}
