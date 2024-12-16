package org.example.models;

public class EmpleadoBase extends Tipo_Empleado {
    public EmpleadoBase(String nombre, String apellido, int edad, double salarioBase) {
        super(nombre, apellido, salarioBase, edad);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }

    @Override
    public String getRol() {
        return "Empleado Base";
    }
}
