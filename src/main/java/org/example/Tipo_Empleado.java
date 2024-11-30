package org.example;

public abstract class Tipo_Empleado {
    private final String nombre;
    private final double salarioBase;
    private final Integer edad;
    private final double rendimiento; // Added performance indicator

    public Tipo_Empleado(String nombre, double salarioBase, Integer edad) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío.");
        }
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor a 0.");
        }
        if (edad != null && edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser un número positivo.");
        }

        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.edad = edad;
        this.rendimiento = Math.random() * 100; // Example: randomly generated performance percentage
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public abstract double calcularSalario();

    public abstract String getRol();

    @Override
    public String toString() {
        return String.format("Nombre: %s, Rol: %s, Salario: %.2f, Edad: %s, Rendimiento: %.2f%%",
                nombre, getRol(), calcularSalario(), edad != null ? edad : "N/A", rendimiento);
    }
}
