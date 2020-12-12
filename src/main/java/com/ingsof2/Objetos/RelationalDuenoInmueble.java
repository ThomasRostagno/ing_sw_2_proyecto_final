package com.ingsof2.Objetos;

public class RelationalDuenoInmueble {
    private String dni_duenio;
    private String sexo_duenio;
    private String direccion;

    public RelationalDuenoInmueble(){}

    public RelationalDuenoInmueble(RelationalDuenoInmueble aux){
        this.dni_duenio = aux.dni_duenio;
        this.sexo_duenio = aux.sexo_duenio;
        this.direccion = aux.direccion;
    }

    public RelationalDuenoInmueble(String dni_duenio, String sexo_duenio, String direccion) {
        this.dni_duenio = dni_duenio;
        this.sexo_duenio = sexo_duenio;
        this.direccion = direccion;
    }

    public String getDni_duenio() {
        return dni_duenio;
    }

    public void setDni_duenio(String dni_duenio) {
        this.dni_duenio = dni_duenio;
    }

    public String getSexo_duenio() {
        return sexo_duenio;
    }

    public void setSexo_duenio(String sexo_duenio) {
        this.sexo_duenio = sexo_duenio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
