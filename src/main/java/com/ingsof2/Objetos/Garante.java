package com.ingsof2.Objetos;

import java.util.List;

public class Garante extends Persona {

    private String dniInquilino;

    public Garante() {
    }

    public Garante(Persona aux, String dniInquilino) {
        super(aux);
        this.dniInquilino = dniInquilino;
    }

    public Garante(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email, String dniInquilino) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
        this.dniInquilino = dniInquilino;
    }

    public String getDniInquilino() {
        return dniInquilino;
    }

    public void setDniInquilino(String dniInquilino) {
        this.dniInquilino = dniInquilino;
    }

    public static Object[][] getDataVector(List<Garante> garantes) {
        Object[][] objects = new Object[garantes.size()][0];

        for (int i = 0; i < garantes.size(); i++) {
            objects[i] = garantes.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{getNombre(), getApellido(), getDni(), getTelefono(), getSexo(), getDireccion(), getFechaNac(), getEmail(), getDniInquilino()};
    }

    public static Object[] getHeaders() {
        return new Object[]{"Nombre", "Apellido", "DNI", "Telefono", "Sexo", "Direccion", "Fecha de Nacimiento", "Email", "Inquilino"};
    }

    @Override
    public String toString() {
        String template = "\tGarante:\n" +
                "Nombre: %s\n" +
                "Apellido: %s\n" +
                "Teléfono: %s\n" +
                "DNI: %s\n" +
                "DNI Inquilino: %s\n" +
                "Sexo: %s\n" +
                "Direccción: %s\n" +
                "Fecha de nacimiento: %s\n" +
                "Email: %s\n";

        return String.format(template, this.getNombre(), this.getApellido(), this.getTelefono(), this.getDni(), dniInquilino, this.getSexo(), this.getDireccion(), this.getFechaNac(), this.getEmail());
    }
}
