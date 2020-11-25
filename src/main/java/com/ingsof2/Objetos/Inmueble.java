package com.ingsof2.Objetos;

public class Inmueble {
    private String tipo; //depto, casa, quinta, cabaña, etc
    private String condicion; //venta,alquiler,ambas
    private String direccion;
    private int superficie;
    private int num_ambientes;
    private String fecha_construccion;
    private int antiguedad;
    private float valor;
    private String clasificacion; //residencial, familiar, no habitable, etc

    public Inmueble() {
    }

    public Inmueble(Inmueble aux) {
        this.tipo = aux.tipo;
        this.condicion = aux.condicion;
        this.direccion = aux.direccion;
        this.superficie = aux.superficie;
        this.num_ambientes = aux.num_ambientes;
        this.fecha_construccion = aux.fecha_construccion;
        this.antiguedad = aux.antiguedad;
        this.valor = aux.valor;
        this.clasificacion = aux.clasificacion;
    }

    public Inmueble(String tipo, String condicion, String direccion, int superficie, int num_ambientes, String fecha_construccion, int antiguedad, float valor, String clasificacion) {
        this.tipo = tipo;
        this.condicion = condicion;
        this.direccion = direccion;
        this.superficie = superficie;
        this.num_ambientes = num_ambientes;
        this.fecha_construccion = fecha_construccion;
        this.antiguedad = antiguedad;
        this.valor = valor;
        this.clasificacion = clasificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getNum_ambientes() {
        return num_ambientes;
    }

    public void setNum_ambientes(int num_ambientes) {
        this.num_ambientes = num_ambientes;
    }

    public String getFecha_construccion() {
        return fecha_construccion;
    }

    public void setFecha_construccion(String fecha_construccion) {
        this.fecha_construccion = fecha_construccion;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
