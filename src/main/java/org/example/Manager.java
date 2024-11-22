package org.example;

class Manager implements Empleado {
    private String nombre;
    private double salarioBase;
    private double bonus;

    public Manager(String nombre, double salarioBase, double bonus) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.bonus = bonus;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bonus;
    }

    @Override
    public String getRol() {
        return "Manager";
    }
}
