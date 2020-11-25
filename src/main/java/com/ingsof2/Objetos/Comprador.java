package com.ingsof2.Objetos;

public class Comprador extends Persona {
    public Comprador(Persona aux) {
        super(aux);
    }

    public Comprador(String nombre, String apellido, String telefono, int dni, String direccion, String fecha_nac, String email) {
        super(nombre, apellido, telefono, dni, direccion, fecha_nac, email);
    }
}
