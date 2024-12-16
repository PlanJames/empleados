package org.example.models;

public class Developer extends Tipo_Empleado {
    private double incentivo;

    public Developer(String nombre, double salarioBase, Integer edad, double incentivo, String apellido) {
        super(nombre, apellido, salarioBase, edad);
        this.incentivo = incentivo;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + incentivo;
    }

    @Override
    public String getRol() {
        return "Developer";
    }

    public double getIncentivo() {
        return incentivo;
    }
}
