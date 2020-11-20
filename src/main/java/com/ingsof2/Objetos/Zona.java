package com.ingsof2.Objetos;

public class Zona {
    private int codigo;
    private String nombre;
    private String descripcion;

    public Zona(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Zona (Zona aux){
        this.codigo = aux.codigo;
        this.nombre = aux.nombre;
        this.descripcion = aux.descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
