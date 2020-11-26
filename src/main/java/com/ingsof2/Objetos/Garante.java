package com.ingsof2.Objetos;

public class Garante extends Persona{

    private String DNI_Inquilino;

    public Garante(){
    }

    public Garante(Persona aux, String DNI_Inquilino) {
        super(aux);
        this.DNI_Inquilino = DNI_Inquilino;
    }

    public Garante(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email, String DNI_Inquilino) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
        this.DNI_Inquilino = DNI_Inquilino;
    }

    public String getDNI_Inquilino() {
        return DNI_Inquilino;
    }

    public void setDNI_Inquilino(String DNI_Inquilino) {
        this.DNI_Inquilino = DNI_Inquilino;
    }
}
