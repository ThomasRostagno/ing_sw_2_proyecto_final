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
    private String dni_Inquilino;
    private String dni_Duenio;
    private String codigo_Alquiler;
    private String codigo_Zona;

    public Inmueble() {
    }

    public Inmueble(Inmueble inmueble){
        this.tipo = inmueble.tipo;
        this.condicion = inmueble.condicion;
        this.direccion = inmueble.direccion;
        this.superficie = inmueble.superficie;
        this.num_ambientes = inmueble.num_ambientes;
        this.fecha_construccion = inmueble.fecha_construccion;
        this.antiguedad = inmueble.antiguedad;
        this.valor = inmueble.valor;
        this.clasificacion = inmueble.clasificacion;
        this.dni_Inquilino = inmueble.dni_Inquilino;
        this.dni_Duenio = inmueble.dni_Duenio;
        this.codigo_Alquiler = inmueble.codigo_Alquiler;
        this.codigo_Zona = inmueble.codigo_Zona;
    }

    public Inmueble(String tipo, String condicion, String direccion, int superficie, int num_ambientes, String fecha_construccion, int antiguedad, float valor, String clasificacion, String dni_Inquilino, String dni_Duenio, String codigo_Alquiler, String codigo_Zona) {
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
        this.dni_Duenio = dni_Duenio;
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

    public String getDni_Duenio() {
        return dni_Duenio;
    }

    public void setDni_Duenio(String dni_Duenio) {
        this.dni_Duenio = dni_Duenio;
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

    @Override
    public String toString() {
        return "Inmueble{" +
                "tipo='" + tipo + '\'' +
                ", condicion='" + condicion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", superficie=" + superficie +
                ", num_ambientes=" + num_ambientes +
                ", fecha_construccion='" + fecha_construccion + '\'' +
                ", antiguedad=" + antiguedad +
                ", valor=" + valor +
                ", clasificacion='" + clasificacion + '\'' +
                ", dni_Inquilino='" + dni_Inquilino + '\'' +
                ", dni_Duenio='" + dni_Duenio + '\'' +
                ", codigo_Alquiler='" + codigo_Alquiler + '\'' +
                ", codigo_Zona='" + codigo_Zona + '\'' +
                '}';
    }
}