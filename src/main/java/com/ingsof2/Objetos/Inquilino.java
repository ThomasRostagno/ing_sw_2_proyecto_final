package com.ingsof2.Objetos;

import java.util.List;

public class Inquilino extends Persona {

    public Inquilino() {
    }

    public Inquilino(Persona aux) {
        super(aux);
    }

    public Inquilino(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fechaNac, String email) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fechaNac, email);
    }

    public static Object[][] getDataVector(List<Inquilino> inquilinos) {
        Object[][] objects = new Object[inquilinos.size()][0];

        for (int i = 0; i < inquilinos.size(); i++) {
            objects[i] = inquilinos.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{getNombre(), getApellido(), getDni(), getTelefono(), getSexo(), getDireccion(), getFechaNac(), getEmail()};
    }

    public static Object[] getHeaders() {
        return new Object[]{"Nombre", "Apellido", "DNI", "Telefono", "Sexo", "Direccion", "Fecha de Nacimiento", "Email"};
    }

    @Override
    public String toString() {
        String template = "\tInquilino:\n" +
                "Nombre: %s\n" +
                "Apellido: %s\n" +
                "Teléfono: %s\n" +
                "DNI: %s\n" +
                "Sexo: %s\n" +
                "Direccción: %s\n" +
                "Fecha de nacimiento: %s\n" +
                "Email: %s\n";

        return String.format(template, this.getNombre(), this.getApellido(), this.getTelefono(), this.getDni(), this.getSexo(), this.getDireccion(), this.getFechaNac(), this.getEmail());
    }
}
