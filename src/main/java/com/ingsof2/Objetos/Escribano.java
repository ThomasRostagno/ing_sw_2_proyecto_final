package com.ingsof2.Objetos;

public class Escribano extends Persona{
    private int matricula;

    public Escribano(){
    }

    public Escribano(Persona aux, int matricula) {
        super(aux);
        this.matricula = matricula;
    }

    public Escribano(String nombre, String apellido, String telefono, int dni, String sexo, String direccion, String fecha_nac, String email, int matricula) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
