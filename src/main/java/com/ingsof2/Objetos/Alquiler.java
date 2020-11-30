package com.ingsof2.Objetos;

import java.util.List;

public class Alquiler extends Contrato {
    private String fechaFin;
    private String dniInquilino;
    private String domicilioInmueble;
    private String dniGarante;
    private String dniEscribano;

    public Alquiler() {
    }

    public Alquiler(Alquiler alquiler) {
        super(alquiler.getCodigo(), alquiler.getFecha(), alquiler.getPrecio(), alquiler.getTipo());
        this.fechaFin = alquiler.fechaFin;
        this.dniInquilino = alquiler.dniInquilino;
        this.domicilioInmueble = alquiler.domicilioInmueble;
        this.dniGarante = alquiler.dniGarante;
        this.dniEscribano = alquiler.dniEscribano;
    }

    public Alquiler(Contrato contrato, String fechaFin, String dniInquilino, String domicilioInmueble, String dniGarante, String dniEscribano) {
        super(contrato);
        this.fechaFin = fechaFin;
        this.dniInquilino = dniInquilino;
        this.domicilioInmueble = domicilioInmueble;
        this.dniGarante = dniGarante;
        this.dniEscribano = dniEscribano;
    }

    public Alquiler(String codigo, String fecha, float precio, int tipo, String fechaFin, String dniInquilino, String domicilioInmueble, String dniGarante, String dniEscribano) {
        super(codigo, fecha, precio, tipo);
        this.fechaFin = fechaFin;
        this.dniInquilino = dniInquilino;
        this.domicilioInmueble = domicilioInmueble;
        this.dniGarante = dniGarante;
        this.dniEscribano = dniEscribano;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDniInquilino() {
        return dniInquilino;
    }

    public void setDniInquilino(String dniInquilino) {
        this.dniInquilino = dniInquilino;
    }

    public String getDomicilioInmueble() {
        return domicilioInmueble;
    }

    public void setDomicilioInmueble(String domicilioInmueble) {
        this.domicilioInmueble = domicilioInmueble;
    }

    public String getDniGarante() {
        return dniGarante;
    }

    public void setDniGarante(String dniGarante) {
        this.dniGarante = dniGarante;
    }

    public String getDniEscribano() {
        return dniEscribano;
    }

    public void setDniEscribano(String dniEscribano) {
        this.dniEscribano = dniEscribano;
    }

    public Object[][] getDataVectorAlquiler(List<Alquiler> alquileres) {
        Object[][] objects = new Object[0][0];

        for (int i = 0; i < alquileres.size(); i++) {
            objects[i] = alquileres.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{getCodigo(), getFecha(), getPrecio(), getTipo(), getFechaFin(), getDniInquilino(), getDomicilioInmueble(), getDniGarante(), getDniEscribano()};
    }

    public Object[] getHeaders() {
        return new Object[]{"Codigo", "Fecha", "Precio", "Tipo", "Fecha Fin", "Inquilino", "Direccion Inmueble", "Garante", "Escribano"};
    }
}
