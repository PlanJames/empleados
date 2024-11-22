package org.example;

public class EmpleadoConEdad extends EmpleadoBase {
    private int edad;

    public EmpleadoConEdad(String nombre, double salarioBase, int edad) {
        super(nombre, salarioBase);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
}