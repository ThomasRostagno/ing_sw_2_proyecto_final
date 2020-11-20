package com.ingsof2.Objetos;

public class Garante extends Persona{
    public Garante(Persona aux) {
        super(aux);
    }

    public Garante(String nombre, String apellido, String telefono, int dni, String direccion, String fecha_nac, String email) {
        super(nombre, apellido, telefono, dni, direccion, fecha_nac, email);
    }
}
