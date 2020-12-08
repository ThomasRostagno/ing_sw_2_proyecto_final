package com.ingsof2.Objetos;

import java.util.List;

public class Zona {
    private String codigo;
    private String nombre;
    private String descripcion;

    public Zona() {
    }

    public Zona(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Zona(Zona zona) {
        this.codigo = zona.codigo;
        this.nombre = zona.nombre;
        this.descripcion = zona.descripcion;
    }

    public static Object[][] getDataVector(List<Zona> zonas) {
        Object[][] objects = new Object[zonas.size()][0];

        for (int i = 0; i < zonas.size(); i++) {
            objects[i] = zonas.get(i).toObject();
        }
        return objects;
    }

    public static Object[] getHeaders() {
        return new Object[]{"Codigo", "Nombre", "Descripcion"};
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

    private Object[] toObject() {
        return new Object[]{getCodigo(), getNombre(), getDescripcion()};
    }

    @Override
    public String toString() {
        return nombre;
    }
}
