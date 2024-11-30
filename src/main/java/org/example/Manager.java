package org.example;

class Manager extends Tipo_Empleado {
    private double bonus;

    public Manager(String nombre, double salarioBase, Integer edad, double bonus) {
        super(nombre, salarioBase, edad);
        if (bonus < 0) {
            throw new IllegalArgumentException("El bonus debe ser mayor o igual a cero.");
        }
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonus;
    }

    @Override
    public String getRol() {
        return "Manager";
    }
}
