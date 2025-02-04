package com.ingsof2.Objetos;

public class Persona {
    private String nombre;
    private String apellido;
    private String telefono;
    private String dni;
    private String sexo;
    private String direccion;
    private String fechaNac;
    private String email;

    public Persona() {
    }

    public Persona(Persona aux) {
        this.nombre = aux.nombre;
        this.apellido = aux.apellido;
        this.telefono = aux.telefono;
        this.dni = aux.dni;
        this.sexo = aux.sexo;
        this.direccion = aux.direccion;
        this.fechaNac = aux.fechaNac;
        this.email = aux.email;
    }

    public Persona(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fechaNac, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
        this.sexo = sexo;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dni='" + dni + '\'' +
                ", sexo='" + sexo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fecha_nac='" + fechaNac + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
