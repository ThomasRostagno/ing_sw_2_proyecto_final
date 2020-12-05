package com.ingsof2.Objetos;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TiposDeContratos {
    ALQUILER(1, "Alquiler"),
    VENTA(2, "Venta"),
    AMBOS(3, "Ambos");

    private static final Map<Integer, TiposDeContratos> contratosMap = new HashMap<>();

    static {
        for (TiposDeContratos tiposDeContratos : EnumSet.allOf(TiposDeContratos.class)) {
            contratosMap.put(tiposDeContratos.tipo, tiposDeContratos);
        }
    }

    private int tipo;
    private String descripcion;

    TiposDeContratos(int tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public static int getTipo(String descripcion) {
        for (Integer integer : contratosMap.keySet()) {
            if (contratosMap.get(integer).descripcion.equals(descripcion)) {
                return integer;
            }
        }
        return -1;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
