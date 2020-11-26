package com.ingsof2.Objetos;

import java.util.List;

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
    private String dni_Inquilino;
    private String dni_Dueño;
    private String codigo_Alquiler;
    private String codigo_Zona;

    public Inmueble() {
    }

    public Inmueble(Inmueble aux){
        this.tipo = aux.tipo;
        this.condicion = aux.condicion;
        this.direccion = aux.direccion;
        this.superficie = aux.superficie;
        this.num_ambientes = aux.num_ambientes;
        this.fecha_construccion = aux.fecha_construccion;
        this.antiguedad = aux.antiguedad;
        this.valor = aux.valor;
        this.clasificacion = aux.clasificacion;
        this.dni_Inquilino = aux.dni_Inquilino;
        this.dni_Dueño = aux.dni_Dueño;
        this.codigo_Alquiler = aux.codigo_Alquiler;
        this.codigo_Zona = aux.codigo_Zona;
    }

    public Inmueble(String tipo, String condicion, String direccion, int superficie, int num_ambientes, String fecha_construccion, int antiguedad, float valor, String clasificacion, String dni_Inquilino, String dni_Dueño, String codigo_Alquiler, String codigo_Zona) {
        this.tipo = tipo;
        this.condicion = condicion;
        this.direccion = direccion;
        this.superficie = superficie;
        this.num_ambientes = num_ambientes;
        this.fecha_construccion = fecha_construccion;
        this.antiguedad = antiguedad;
        this.valor = valor;
        this.clasificacion = clasificacion;
        this.dni_Inquilino = dni_Inquilino;
        this.dni_Dueño = dni_Dueño;
        this.codigo_Alquiler = codigo_Alquiler;
        this.codigo_Zona = codigo_Zona;
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

    public String getDni_Inquilino() {
        return dni_Inquilino;
    }

    public void setDni_Inquilino(String dni_Inquilino) {
        this.dni_Inquilino = dni_Inquilino;
    }

    public String getDni_Dueño() {
        return dni_Dueño;
    }

    public void setDni_Dueño(String dni_Dueño) {
        this.dni_Dueño = dni_Dueño;
    }

    public String getCodigo_Alquiler() {
        return codigo_Alquiler;
    }

    public void setCodigo_Alquiler(String codigo_Alquiler) {
        this.codigo_Alquiler = codigo_Alquiler;
    }

    public String getCodigo_Zona() {
        return codigo_Zona;
    }

    public void setCodigo_Zona(String codigo_Zona) {
        this.codigo_Zona = codigo_Zona;
    }


    public Object[][] getDataVector(List<Inmueble> inmuebles) {
        Object[][] objects = new Object[0][0];

        for (int i = 0; i < inmuebles.size(); i++) {
            objects[i] = inmuebles.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{getTipo(),getCondicion(),getDireccion(),getSuperficie(),getNum_ambientes(),getFecha_construccion(),getAntiguedad(),getValor(),getClasificacion(),getDni_Inquilino(),getDni_Dueño(),getCodigo_Alquiler(),getCodigo_Zona()};
    }

    public Object[] getHeaders() {
        return new Object[]{"Tipo", "Condicion", "Direccion", "Superficie","Ambientes","Fecha de Construccion","Antiguedad","Valor","Clasificacion","Inquilino","Dueño","Alquiler","Zona"};
    }
}