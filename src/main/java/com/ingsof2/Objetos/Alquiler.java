package com.ingsof2.Objetos;

public class Alquiler extends Contrato{
    private String fecha_fin;

    public Alquiler(Contrato aux, String fecha_fin) {
        super(aux);
        this.fecha_fin = fecha_fin;
    }

    public Alquiler(String codigo, String fecha, float precio, int tipo, String fecha_fin) {
        super(codigo, fecha, precio, tipo);
        this.fecha_fin = fecha_fin;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
