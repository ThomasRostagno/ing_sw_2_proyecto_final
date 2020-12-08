package com.ingsof2.Objetos;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum TiposDeSexo {
    MASCULINO("Masculino"),
    FEMENINO("Femenino");

    private static final List<TiposDeSexo> sexosList = new ArrayList<>();

    static {
        sexosList.addAll(EnumSet.allOf(TiposDeSexo.class));
    }

    private String sexo;

    TiposDeSexo(String sexo) {
        this.sexo = sexo;
    }

    public static String getSexo(String sexo) {
        for (TiposDeSexo tipoDeSexo : sexosList) {
            if (tipoDeSexo.sexo.equals(sexo)) {
                return sexo;
            }
        }
        return null;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
