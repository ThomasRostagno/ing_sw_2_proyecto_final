package com.ingsof2.Objetos;

public class Escribano extends Persona{
    private String matricula;

    public Escribano(Persona aux, String matricula) {
        super(aux);
        this.matricula = matricula;
    }

    public Escribano(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email, String matricula) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
