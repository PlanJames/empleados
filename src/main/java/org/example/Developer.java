package org.example;

class Developer extends Tipo_Empleado {
    private double incentivos;

    public Developer(String nombre, double salarioBase, Integer edad, double incentivos) {
        super(nombre, salarioBase, edad);
        if (incentivos < 0) {
            throw new IllegalArgumentException("Los incentivos deben ser mayores o iguales a cero.");
        }
        this.incentivos = incentivos;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + incentivos;
    }

    @Override
    public String getRol() {
        return "Developer";
    }
}