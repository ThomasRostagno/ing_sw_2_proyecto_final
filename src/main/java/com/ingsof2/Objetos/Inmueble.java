package com.ingsof2.Objetos;

import java.util.List;

public class Inmueble {
    private String tipo; //depto, casa, quinta, cabaña, etc
    private String condicion; //venta,alquiler,ambas
    private String direccion;
    private int superficie;
    private int numAmbientes;
    private String fechaConstruccion;
    private int antiguedad;
    private float valor;
    private String clasificacion; //residencial, familiar, no habitable, etc
    private String dniDuenio;
    private String sexoDuenio;
    private String codigoAlquiler;
    private String codigoZona;

    public Inmueble() {
    }

    public Inmueble(Inmueble inmueble) {
        this.tipo = inmueble.tipo;
        this.condicion = inmueble.condicion;
        this.direccion = inmueble.direccion;
        this.superficie = inmueble.superficie;
        this.numAmbientes = inmueble.numAmbientes;
        this.fechaConstruccion = inmueble.fechaConstruccion;
        this.antiguedad = inmueble.antiguedad;
        this.valor = inmueble.valor;
        this.clasificacion = inmueble.clasificacion;
        this.dniDuenio = inmueble.dniDuenio;
        this.sexoDuenio = inmueble.sexoDuenio;
        this.codigoAlquiler = inmueble.codigoAlquiler;
        this.codigoZona = inmueble.codigoZona;
    }

    public Inmueble(String tipo, String condicion, String direccion, int superficie, int numAmbientes, String fechaConstruccion, int antiguedad, float valor, String clasificacion, String dniDuenio, String sexoDuenio, String codigoAlquiler, String codigoZona) {
        this.tipo = tipo;
        this.condicion = condicion;
        this.direccion = direccion;
        this.superficie = superficie;
        this.numAmbientes = numAmbientes;
        this.fechaConstruccion = fechaConstruccion;
        this.antiguedad = antiguedad;
        this.valor = valor;
        this.clasificacion = clasificacion;
        this.dniDuenio = dniDuenio;
        this.sexoDuenio = sexoDuenio;
        this.codigoAlquiler = codigoAlquiler;
        this.codigoZona = codigoZona;
    }

    public static Object[][] getDataVector(List<Inmueble> inmuebles) {
        Object[][] objects = new Object[inmuebles.size()][0];

        for (int i = 0; i < inmuebles.size(); i++) {
            objects[i] = inmuebles.get(i).toObject();
        }
        return objects;
    }

    public static Object[] getHeaders() {
        return new Object[]{"Tipo", "Condicion", "Direccion", "Superficie", "Ambientes", "Fecha de Construccion", "Antiguedad", "Valor", "Clasificacion", "Inquilino", "Dueño", "Alquiler", "Zona"};
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

    public int getNumAmbientes() {
        return numAmbientes;
    }

    public void setNumAmbientes(int numAmbientes) {
        this.numAmbientes = numAmbientes;
    }

    public String getFechaConstruccion() {
        return fechaConstruccion;
    }

    public void setFechaConstruccion(String fechaConstruccion) {
        this.fechaConstruccion = fechaConstruccion;
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

    public String getDniDuenio() {
        return dniDuenio;
    }

    public void setDniDuenio(String dniDuenio) {
        this.dniDuenio = dniDuenio;
    }

    public String getSexoDuenio() {
        return sexoDuenio;
    }

    public void setSexoDuenio(String sexoDuenio) {
        this.sexoDuenio = sexoDuenio;
    }

    public String getCodigoAlquiler() {
        return codigoAlquiler;
    }

    public void setCodigoAlquiler(String codigoAlquiler) {
        this.codigoAlquiler = codigoAlquiler;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    private Object[] toObject() {
        return new Object[]{getTipo(), getCondicion(), getDireccion(), getSuperficie(), getNumAmbientes(), getFechaConstruccion(), getAntiguedad(), getValor(), getClasificacion(), getDniDuenio(), getSexoDuenio(), getCodigoAlquiler(), getCodigoZona()};
    }

    /**
     * Entra una lista de inmuebles y el codigo de la Zona, remueve todos los inmuebles que no se encuentren en la misma zona
     **/
    public List<Inmueble> listarPorZona(List<Inmueble> inmuebles, String codigoZona) {
        List<Inmueble> aux = inmuebles;
        /**Loop inverso para cerciorar leer todas las posiciones**/
        for (int i = aux.size() - 1; i >= 0; i--) {
            String stringInmuebleCodigoZona = aux.get(i).getCodigoZona();
            /**Condicional para remover los que no pertenecen a la zona**/
            //Esto se logra negando los que no son iguales para que entre al condicional
            if (!(stringInmuebleCodigoZona.equals(codigoZona))) {
                aux.remove(i);
            }
        }
        return aux;
    }


    /**Entra lista de inmuebles y remueve los que son solo de venta**/
    public List<Inmueble> reducirAAlquiler(List<Inmueble> inmuebles) {
        List<Inmueble> aux = inmuebles;
        /**Loop inverso para cerciorar leer todas las posiciones**/
        for (int i = aux.size() - 1; i >= 0; i--) {
            String stringInmuebleCondicion = aux.get(i).getCondicion();
            /**Condicional para remover los que no son alquiler o ambos**/
            if (stringInmuebleCondicion.equals("Venta")) {
                aux.remove(i);
            }
        }
        return aux;
    }

    /**Entra lista de inmuebles y remueve los que son solo de alquiler**/
    public List<Inmueble> reducirAVenta(List<Inmueble> inmuebles) {
        List<Inmueble> aux = inmuebles;
        /**Loop inverso para cerciorar leer todas las posiciones**/
        for (int i = aux.size() - 1; i >= 0; i--) {
            String stringInmuebleCondicion = aux.get(i).getCondicion();
            /**Condicional para remover los que no son alquiler o ambos**/
            if (stringInmuebleCondicion.equals("Alquiler")) {
                aux.remove(i);
            }
        }
        return aux;
    }

    @Override
    public String toString() {
        String template = "\tInmueble:\n" +
                "Tipo: %s\n" +
                "Condición: %s\n" +
                "Dirección: %s\n" +
                "Superficie: %s\n" +
                "Número de ambientes: %s\n" +
                "Fecha de construcción: %s\n" +
                "Antigüedad: %s\n" +
                "Valor: %s\n" +
                "Clasificación: %s\n" +
                "DNI dueño: %s\n" +
                "Código de Zona: %s\n";

        return String.format(template, tipo, condicion, direccion, superficie, numAmbientes, fechaConstruccion, antiguedad, valor, clasificacion, dniDuenio, codigoZona);
    }
}