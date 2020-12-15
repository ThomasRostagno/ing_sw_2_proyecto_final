package com.ingsof2.Objetos;

import com.ingsof2.utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class Alquiler extends Contrato {
    private String fechaFin;
    private String dniInquilino;
    private String sexoInquilino;
    private String domicilioInmueble;
    private String dniGarante;
    private String sexoGarante;
    private String dniEscribano;
    private String sexoEscribano;

    public Alquiler() {
    }

    public Alquiler(Alquiler alquiler) {
        super(alquiler.getCodigo(), alquiler.getFecha(), alquiler.getPrecio(), alquiler.getTipo());
        this.fechaFin = alquiler.fechaFin;
        this.dniInquilino = alquiler.dniInquilino;
        this.sexoInquilino = alquiler.sexoInquilino;
        this.domicilioInmueble = alquiler.domicilioInmueble;
        this.dniGarante = alquiler.dniGarante;
        this.sexoGarante = alquiler.sexoGarante;
        this.dniEscribano = alquiler.dniEscribano;
        this.sexoEscribano = alquiler.sexoEscribano;
    }

    public Alquiler(Contrato contrato, String fechaFin, String dniInquilino, String sexoInquilino, String domicilioInmueble, String dniGarante, String sexoGarante, String dniEscribano, String sexoEscribano) {
        super(contrato);
        this.fechaFin = fechaFin;
        this.dniInquilino = dniInquilino;
        this.sexoInquilino = sexoInquilino;
        this.domicilioInmueble = domicilioInmueble;
        this.dniGarante = dniGarante;
        this.sexoGarante = sexoGarante;
        this.dniEscribano = dniEscribano;
        this.sexoEscribano = sexoEscribano;
    }

    public Alquiler(String codigo, String fecha, float precio, int tipo, String fechaFin, String dniInquilino, String sexoInquilino, String domicilioInmueble, String dniGarante, String sexoGarante, String dniEscribano, String sexoEscribano) {
        super(codigo, fecha, precio, tipo);
        this.fechaFin = fechaFin;
        this.dniInquilino = dniInquilino;
        this.sexoInquilino = sexoInquilino;
        this.domicilioInmueble = domicilioInmueble;
        this.dniGarante = dniGarante;
        this.sexoGarante = sexoGarante;
        this.dniEscribano = dniEscribano;
        this.sexoEscribano = sexoEscribano;
    }

    public static Object[][] getDataVector(List<Alquiler> alquileres) {
        Object[][] objects = new Object[alquileres.size()][0];

        for (int i = 0; i < alquileres.size(); i++) {
            objects[i] = alquileres.get(i).toObject();

        }
        return objects;
    }

    public static Object[] getHeaders() {
        return new Object[]{"Codigo", "Fecha", "Precio", "Tipo", "Fecha Fin", "DNI Inquilino", "Sexo Inquilino", "Direccion Inmueble", "DNI Garante", "Sexo Garante", "DNI Escribano", "Sexo Escribano"};
    }

    /**
     * Entra una lista de alquileres y dos fechas, una de inicio y otra de fin, remueve todos los alquileres que se encuentren fuera de las fechas
     **/
    public static List<Alquiler> alquileresBetween(List<Alquiler> alquileres, String fecha1, String fecha2) {
        /**Creacion fechas**/
        LocalDate dateStart = Utils.stringToLocalDate(fecha1);
        LocalDate dateEnd = Utils.stringToLocalDate(fecha2);
        /**Loop inverso para cerciorar leer todas las posiciones**/
        for (int i = alquileres.size() - 1; i >= 0; i--) {
            String stringDateAlquiler = alquileres.get(i).getFechaFin();
            LocalDate dateAlquiler = Utils.stringToLocalDate(stringDateAlquiler);
            /**Logica Condicional para remover elementos fuera del dominio**/
            /*Si la fecha del alquiler esta antes de la primera fecha (inicio presuntamente), evalua verdadero y elimina*/
            /*Si la fecha del alquiler esta despues de la segunda fecha (fin presuntamente), evalua verdadero y la elimina*/
            if (dateAlquiler.isBefore(dateStart) || dateAlquiler.isAfter(dateEnd)) {
                alquileres.remove(i);
            }
        }
        return alquileres;
    }

    /**
     * Entra una lista de alquileres y un anio, remuevo los alquileres que no se iniciaron ese anio
     **/
    public static List<Alquiler> alquileresPorAnio(List<Alquiler> alquileres, String anio) {
        //Convierto anio de String a entero
        int anioint = Integer.parseInt(anio);
        for (int i = alquileres.size() - 1; i >= 0; i--) {
            //Recupero la fecha de inicio en un String, luego lo hago Date y luego recupero anio. Esto se puede mejorar, ya que gasto mucha memoria asi creo.
            String stringDateAlquier = alquileres.get(i).getFecha();
            LocalDate dateAlquiler = Utils.stringToLocalDate(stringDateAlquier);
            int dateYearAlquiler = dateAlquiler.getYear();
            /**Condicional, remueve si los anios son distintos**/
            if (!(dateYearAlquiler == anioint)) {
                alquileres.remove(i);
            }
        }
        return alquileres;
    }

    public String getSexoInquilino() {
        return sexoInquilino;
    }

    public void setSexoInquilino(String sexoInquilino) {
        this.sexoInquilino = sexoInquilino;
    }

    public String getSexoGarante() {
        return sexoGarante;
    }

    public void setSexoGarante(String sexoGarante) {
        this.sexoGarante = sexoGarante;
    }

    public String getSexoEscribano() {
        return sexoEscribano;
    }

    public void setSexoEscribano(String sexoEscribano) {
        this.sexoEscribano = sexoEscribano;
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

    private Object[] toObject() {
        return new Object[]{getCodigo(), getFecha(), getPrecio(), getTipo(), getFechaFin(), getDniInquilino(), getDomicilioInmueble(), getDniGarante(), getDniEscribano()};
    }
}
