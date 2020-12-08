package com.ingsof2.Objetos;

import java.util.List;

public class Comprador extends Persona {

    public Comprador() {

    }

    public Comprador(Persona aux) {
        super(aux);
    }

    public Comprador(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
    }

    public static Object[][] getDataVector(List<Comprador> compradores) {
        Object[][] objects = new Object[compradores.size()][0];

        for (int i = 0; i < compradores.size(); i++) {
            objects[i] = compradores.get(i).toObject();
        }
        return objects;
    }

    public static Object[] getHeaders() {
        return new Object[]{"Nombre", "Apellido", "DNI", "Telefono", "Sexo", "Direccion", "Fecha de Nacimiento", "Email"};
    }

    private Object[] toObject() {
        return new Object[]{getNombre(), getApellido(), getDni(), getTelefono(), getSexo(), getDireccion(), getFechaNac(), getEmail()};
    }

    @Override
    public String toString() {
        String template = "\tComprador:\n" +
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
