package com.ingsof2.Objetos;

import java.util.List;

public class Zona {
    private String codigo;
    private String nombre;
    private String descripcion;

    public Zona(){
    }

    public Zona(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Zona (Zona aux){
        this.codigo = aux.codigo;
        this.nombre = aux.nombre;
        this.descripcion = aux.descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public Object[][] getDataVector(List<Zona> zonas) {
        Object[][] objects = new Object[0][0];

        for (int i = 0; i < zonas.size(); i++) {
            objects[i] = zonas.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{getCodigo(),getNombre(),getDescripcion()};
    }

    public Object[] getHeaders() {
        return new Object[]{"Codigo", "Nombre", "Descripcion"};
    }
}
