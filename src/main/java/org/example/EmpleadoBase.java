package org.example;

public class EmpleadoBase implements Empleado {
    private String nombre;
    private double salarioBase;

    public EmpleadoBase(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }

    @Override
    public String getRol() {
        return "Empleado Base";
    }
}