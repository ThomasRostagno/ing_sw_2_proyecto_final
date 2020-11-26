package com.ingsof2.Objetos;

public class Vendedor extends Persona { // Este es el que vende el inmueble, me interesa ya que le doy una comision xdxdxddd
    public Vendedor(Persona aux) {
        super(aux);
    }

    public Vendedor(String nombre, String apellido, String telefono, String dni, String sexo, String direccion, String fecha_nac, String email) {
        super(nombre, apellido, telefono, dni, sexo, direccion, fecha_nac, email);
    }
}
