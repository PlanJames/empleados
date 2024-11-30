package org.example;

class EmpleadoBase extends Tipo_Empleado {
    public EmpleadoBase(String nombre, Integer edad, double salarioBase) {
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