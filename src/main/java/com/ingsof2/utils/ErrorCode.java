package com.ingsof2.utils;

public enum ErrorCode {
    FAIL_GETTING_IMAGE(1, "Fail getting image."),
    FAIL_CONNECTING_TO_DB(2, "Fail connecting to the database."),
    FAIL_DISCONNECTING_TO_DB(3, "Fail disconnecting to the database."),
    FAIL_EXECUTING_QUERY(4, "Fail executing query."),
    FAIL_SAVING_IN_DB(5, "Fail saving to the database"),
    INVALID_FIELDS(6, "Datos invalidos"),
    FAIL_SELECTING_COMPRADOR(7, "Por favor seleccione un comprador"),
    FAIL_SELECTING_DUENIO(8, "Por favor seleccione un dueño"),
    FAIL_SELECTING_ESCRIBANO(9, "Por favor seleccione un escribano"),
    FAIL_SELECTING_GARANTE(10, "Por favor seleccione un garante"),
    FAIL_SELECTING_INQUILINO(11, "Por favor seleccione un inquilino"),
    FAIL_SELECTING_PROPIEDAD(12, "Por favor seleccione una propiedad"),
    FAIL_SELECTING_VENDEDOR(13, "Por favor seleccione un vendedor"),
    FAIL_SELECTING_ZONA(14, "Por favor seleccione una zona"),
    INVALID_CHARACTER(15, "Por favor ingrese un caracter válido");

    private String code;
    private String description;

    ErrorCode(int code, String description) {
        this.code = String.format("%s", code);
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
