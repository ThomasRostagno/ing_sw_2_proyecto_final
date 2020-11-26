package com.ingsof2.Objetos;

import java.util.List;

public class Dueño extends Persona{
    public Dueño(){
    };

    public Dueño(Persona aux) {
        super(aux);
    }

    public Dueño(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
    }

    public Object[][] getDataVector(List<Dueño> dueños) {
        Object[][] objects = new Object[0][0];

        for (int i = 0; i < dueños.size(); i++) {
            objects[i] = dueños.get(i).toObject();
        }
        return objects;
    }

    private Object[] toObject() {
        return new Object[]{getNombre(),getApellido(),getDni(),getTelefono(),getSexo(),getDireccion(),getFecha_nac(),getEmail()};
    }

    public Object[] getHeaders() {
        return new Object[]{"Nombre", "Apellido", "DNI", "Telefono","Sexo","Direccion","Fecha de Nacimiento","Email"};
    }
}
