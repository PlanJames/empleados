package org.example;

class EmpleadoBase extends Tipo_Empleado {
    public EmpleadoBase(String nombre, double salarioBase, Integer edad) {
        super(nombre, salarioBase, edad);
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