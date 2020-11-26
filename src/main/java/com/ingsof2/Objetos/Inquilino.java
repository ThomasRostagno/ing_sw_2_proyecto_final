package com.ingsof2.Objetos;

public class Inquilino extends Persona{

    public Inquilino() {
    }

    public Inquilino(Persona aux) {
        super(aux);
    }

    public Inquilino(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
    }
}
