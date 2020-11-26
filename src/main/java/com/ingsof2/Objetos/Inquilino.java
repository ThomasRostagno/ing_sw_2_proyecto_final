package com.ingsof2.Objetos;

import java.util.List;

public class Inquilino extends Persona {

    public Inquilino() {
    }

    public Inquilino(Persona aux) {
        super(aux);
    }

    public Inquilino(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
    }

    public static Object[][] getDataVector(List<Inquilino> inquilinos) {
        Object[][] objects = new Object[inquilinos.size()][0];

        for (int i = 0; i < inquilinos.size(); i++) {
            objects[i] = inquilinos.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{getNombre(), getApellido(), getDni(), getTelefono(), getSexo(), getDireccion(), getFecha_nac(), getEmail()};
    }

    public static Object[] getHeaders() {
        return new Object[]{"Nombre", "Apellido", "DNI", "Telefono", "Sexo", "Direccion", "Fecha de Nacimiento", "Email"};
    }
}
