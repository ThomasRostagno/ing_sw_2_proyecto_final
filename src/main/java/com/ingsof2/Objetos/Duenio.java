package com.ingsof2.Objetos;

public class Duenio extends Persona {

    public Duenio() {
    }

    public Duenio(Persona persona) {
        super(persona);
    }

    public Duenio(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
    }
}
