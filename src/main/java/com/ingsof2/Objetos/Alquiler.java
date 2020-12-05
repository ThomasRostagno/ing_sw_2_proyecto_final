package com.ingsof2.Objetos;

import com.ingsof2.utils.Utils;

import java.time.LocalDate;
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
            if (alquileres.get(i).metodo()) {
                objects[i] = alquileres.get(i).toObject();
            }

        }
        return objects;
    }

    private boolean metodo() {

        String fechaFin = this.getFechaFin();

        String[] fechafin = fechaFin.split("/");

        int dd = Integer.parseInt(fechafin[0]);
        int mm = Integer.parseInt(fechafin[1]);
        int yy = Integer.parseInt(fechafin[2]);

        return (Utils.isValidVigencia(dd, mm, yy));
    }

    private Object[] toObject() {
        return new Object[]{getCodigo(), getFecha(), getPrecio(), getTipo(), getFechaFin(), getDniInquilino(), getDomicilioInmueble(), getDniGarante(), getDniEscribano()};
    }

    public Object[] getHeaders() {
        return new Object[]{"Codigo", "Fecha", "Precio", "Tipo", "Fecha Fin", "Inquilino", "Direccion Inmueble", "Garante", "Escribano"};
    }

    /**
     * Entra una lista de alquileres y dos fechas, una de inicio y otra de fin, remueve todos los alquileres que se encuentren fuera de las fechas
     **/
    public List<Alquiler> alquileresBetween(List<Alquiler> alquileres, String fecha1, String fecha2) {
        List<Alquiler> aux = alquileres;
        /**Creacion fechas**/
        LocalDate dateStart = Utils.stringToLocalDate(fecha1);
        LocalDate dateEnd = Utils.stringToLocalDate(fecha2);
        /**Loop inverso para cerciorar leer todas las posiciones**/
        for (int i = aux.size() - 1; i >= 0; i--) {
            String stringDateAlquiler = aux.get(i).getFechaFin();
            LocalDate dateAlquiler = Utils.stringToLocalDate(stringDateAlquiler);
            /**Logica Condicional para remover elementos fuera del dominio**/
            /*Si la fecha del alquiler esta antes de la primera fecha (inicio presuntamente), evalua verdadero y elimina*/
            /*Si la fecha del alquiler esta despues de la segunda fecha (fin presuntamente), evalua verdadero y la elimina*/
            if (dateAlquiler.isBefore(dateStart) || dateAlquiler.isAfter(dateEnd)) {
                aux.remove(i);
            }
        }
        return aux;
    }

    /**
     * Entra una lista de alquileres y un anio, remuevo los alquileres que no se iniciaron ese anio
     **/
    public List<Alquiler> alquileresPorAnio(List<Alquiler> alquileres, String anio) {
        List<Alquiler> aux = alquileres;
        //Convierto anio de String a entero
        int anioint = Integer.parseInt(anio);
        for (int i = aux.size() - 1; i >= 0; i--) {
            //Recupero la fecha de inicio en un String, luego lo hago Date y luego recupero anio. Esto se puede mejorar, ya que gasto mucha memoria asi creo.
            String stringDateAlquier = aux.get(i).getFecha();
            LocalDate dateAlquiler = Utils.stringToLocalDate(stringDateAlquier);
            int dateYearAlquiler = dateAlquiler.getYear();
            /**Condicional, remueve si los anios son distintos**/
            if (!(dateYearAlquiler == anioint)) {
                aux.remove(i);
            }
        }
        return aux;
    }
}
