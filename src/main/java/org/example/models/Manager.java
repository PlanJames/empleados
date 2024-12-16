package org.example.models;

public class Manager extends Tipo_Empleado {
    private double bono;

    public Manager(String nombre, double salarioBase, Integer edad, double bono, String apellido) {
        super(nombre, apellido, salarioBase, edad);
        this.bono = bono;
    }


    @Override
    public double calcularSalario() {
        return getSalarioBase() + bono;
    }

    @Override
    public String getRol() {
        return "Manager";
    }

    public double getBono() {
        return bono;
    }
}
