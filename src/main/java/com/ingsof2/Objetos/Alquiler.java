package com.ingsof2.Objetos;

import java.util.List;

public class Alquiler extends Contrato{
    private String fecha_fin;
    private String dni_Inquilino;
    private String domicilio_Inmueble;
    private String dni_Garante;
    private String dni_Escribano;

    public Alquiler(){
    }

    public Alquiler(Alquiler aux) {
        super(aux);
        this.fecha_fin = aux.fecha_fin;
        this.fecha_fin = aux.dni_Inquilino;
        this.fecha_fin = aux.domicilio_Inmueble;
        this.fecha_fin = aux.dni_Garante;
        this.fecha_fin = aux.dni_Escribano;
    }

    public Alquiler(String codigo, String fecha, float precio, int tipo, String fecha_fin, String dni_Inquilino, String domicilio_Inmueble, String dni_Garante, String dni_Escribano) {
        super(codigo, fecha, precio, tipo);
        this.fecha_fin = fecha_fin;
        this.fecha_fin = dni_Inquilino;
        this.fecha_fin = domicilio_Inmueble;
        this.fecha_fin = dni_Garante;
        this.fecha_fin = fecha_fin;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDni_Inquilino() {
        return dni_Inquilino;
    }

    public void setDni_Inquilino(String dni_Inquilino) {
        this.dni_Inquilino = dni_Inquilino;
    }

    public String getDomicilio_Inmueble() {
        return domicilio_Inmueble;
    }

    public void setDomicilio_Inmueble(String domicilio_Inmueble) {
        this.domicilio_Inmueble = domicilio_Inmueble;
    }

    public String getDni_Garante() {
        return dni_Garante;
    }

    public void setDni_Garante(String dni_Garante) {
        this.dni_Garante = dni_Garante;
    }

    public String getDni_Escribano() {
        return dni_Escribano;
    }

    public void setDni_Escribano(String dni_Escribano) {
        this.dni_Escribano = dni_Escribano;
    }

    public Object[][] getDataVector(List<Alquiler> alquileres) {
        Object[][] objects = new Object[0][0];

        for (int i = 0; i < alquileres.size(); i++) {
            objects[i] = alquileres.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{getCodigo(),getFecha(), getPrecio(), getTipo(),getFecha_fin(),getDni_Inquilino(),getDomicilio_Inmueble(),getDni_Garante(),getDni_Escribano()};
    }

    public Object[] getHeaders() {
        return new Object[]{"Codigo", "Fecha", "Precio", "Tipo","Fecha Fin","Inquilino","Direccion Inmueble","Garante", "Escribano"};
    }
}
