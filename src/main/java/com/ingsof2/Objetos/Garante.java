package com.ingsof2.Objetos;

import java.util.List;

public class Garante extends Persona{

    private String DNI_Inquilino;

    public Garante(){
    }

    public Garante(Persona aux, String DNI_Inquilino) {
        super(aux);
        this.DNI_Inquilino = DNI_Inquilino;
    }

    public Garante(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email, String DNI_Inquilino) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
        this.DNI_Inquilino = DNI_Inquilino;
    }

    public String getDNI_Inquilino() {
        return DNI_Inquilino;
    }

    public void setDNI_Inquilino(String DNI_Inquilino) {
        this.DNI_Inquilino = DNI_Inquilino;
    }

    public Object[][] getDataVector(List<Garante> garantes) {
        Object[][] objects = new Object[0][0];

        for (int i = 0; i < garantes.size(); i++) {
            objects[i] = garantes.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{getNombre(),getApellido(),getDni(),getTelefono(),getSexo(),getDireccion(),getFecha_nac(),getEmail(),getDNI_Inquilino()};
    }

    public Object[] getHeaders() {
        return new Object[]{"Nombre", "Apellido", "DNI", "Telefono","Sexo","Direccion","Fecha de Nacimiento","Email", "Inquilino"};
    }
}
