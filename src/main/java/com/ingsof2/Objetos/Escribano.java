package com.ingsof2.Objetos;

import java.util.List;

public class Escribano extends Persona {
    private String matricula;

    public Escribano() {
    }

    public Escribano(Persona aux, String matricula) {
        super(aux);
        this.matricula = matricula;
    }

    public Escribano(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email, String matricula) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
        this.matricula = matricula;
    }

    public static Object[][] getDataVector(List<Escribano> escribanos) {
        Object[][] objects = new Object[escribanos.size()][0];

        for (int i = 0; i < escribanos.size(); i++) {
            objects[i] = escribanos.get(i).toObject();
        }
        return objects;
    }

    public static Object[] getHeaders() {
        return new Object[]{"Nombre", "Apellido", "DNI", "Telefono", "Sexo", "Direccion", "Fecha de Nacimiento", "Email", "Matricula"};
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    private Object[] toObject() {
        return new Object[]{getNombre(), getApellido(), getDni(), getTelefono(), getSexo(), getDireccion(), getFechaNac(), getEmail(), getMatricula()};
    }

    @Override
    public String toString() {
        String template = "\tEscribano:\n" +
                "Nombre: %s\n" +
                "Apellido: %s\n" +
                "Teléfono: %s\n" +
                "DNI: %s\n" +
                "Matrícula: %s\n" +
                "Sexo: %s\n" +
                "Direccción: %s\n" +
                "Fecha de nacimiento: %s\n" +
                "Email: %s\n";

        return String.format(template, this.getNombre(), this.getApellido(), this.getTelefono(), this.getDni(), matricula, this.getSexo(), this.getDireccion(), this.getFechaNac(), this.getEmail());
    }
}
