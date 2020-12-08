package com.ingsof2.Objetos;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum TiposDePropiedad {
    DEPARTAMENTO("Departamento"),
    CASA("Casa"),
    TERRENO("Terreno"),
    GALPON("Galpon"),
    LOCAL_COMERCIAL("Local comercial"),
    HOTEL("Hotel"),
    CABANIA("Cabaña"),
    CHALET("Chalet");

    private static final List<TiposDePropiedad> tiposDePropiedadList = new ArrayList<>();

    static {
        tiposDePropiedadList.addAll(EnumSet.allOf(TiposDePropiedad.class));
    }

    private String tipo;

    TiposDePropiedad(String tipo) {
        this.tipo = tipo;
    }

    public static String getTipo(String tipo) {
        for (TiposDePropiedad tipoDePropiedad : tiposDePropiedadList) {
            if (tipoDePropiedad.tipo.equals(tipo)) {
                return tipo;
            }
        }
        return null;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
