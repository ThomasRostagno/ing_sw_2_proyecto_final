package com.ingsof2.Objetos;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum CondicionesDePropiedad {
    RESIDENCIAL("Residencial"),
    FAMILIAR("Familiar"),
    COMERCIAL("Comercial"),
    EVENTOS("Eventos"),
    NO_HABITABLE("No habitable");

    private static final List<CondicionesDePropiedad> condicionesDePropiedadList = new ArrayList<>();

    static {
        condicionesDePropiedadList.addAll(EnumSet.allOf(CondicionesDePropiedad.class));
    }

    private String condicion;

    CondicionesDePropiedad(String condicion) {
        this.condicion = condicion;
    }

    public static String getCondicion(String condicion) {
        for (CondicionesDePropiedad condicionDePropiedad : condicionesDePropiedadList) {
            if (condicionDePropiedad.condicion.equals(condicion)) {
                return condicion;
            }
        }
        return null;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
}
