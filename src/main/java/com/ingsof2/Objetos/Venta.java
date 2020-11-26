package com.ingsof2.Objetos;

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
}
