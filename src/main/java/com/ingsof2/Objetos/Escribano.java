package com.ingsof2.Objetos;

public class Escribano extends Persona{
    private String matricula;

    public Escribano(Persona aux, String matricula) {
        super(aux);
        this.matricula = matricula;
    }

    public Escribano(String nombre, String apellido, String telefono, int dni, String direccion, String fecha_nac, String email, String matricula) {
        super(nombre, apellido, telefono, dni, direccion, fecha_nac, email);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
