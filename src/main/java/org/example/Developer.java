package org.example;

public class Developer implements Empleado {
    private String nombre;
    private double salarioBase;
    private double incentivos;

    public Developer(String nombre, double salarioBase, double incentivos) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.incentivos = incentivos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + incentivos;
    }

    @Override
    public String getRol() {
        return "Developer";
    }
}