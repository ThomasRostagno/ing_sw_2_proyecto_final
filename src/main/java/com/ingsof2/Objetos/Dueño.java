package com.ingsof2.Objetos;

public class Dueño extends Persona{
    public Dueño(Persona aux) {
        super(aux);
    }

    public Dueño(String nombre, String apellido, String telefono, int dni, String sexo, String direccion, String fecha_nac, String email) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
    }
}
