package org.example.models;

public abstract class Tipo_Empleado {
    private String nombre;
    private String apellido;  // Agregar el apellido
    private Integer edad;
    private double salarioBase;

    // Constructor
    public Tipo_Empleado(String nombre, String apellido, double salarioBase, int edad) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío.");
        }
        if (apellido == null || apellido.isBlank()) {  // Verificación para el apellido
            throw new IllegalArgumentException("El apellido del empleado no puede estar vacío.");
        }
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor a 0.");
        }
        if ( edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser un número positivo.");
        }
        if ( edad <18) {
            throw new IllegalArgumentException("La edad debe ser mayor a 18 años.");
        }

        this.nombre = nombre;
        this.apellido = apellido;  // Asignar el apellido
        this.salarioBase = salarioBase;
        this.edad = edad;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract double calcularSalario();

    public abstract String getRol();

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {  // Modificado para devolver el apellido
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBono() {
        return salarioBase;
    }

    public double getIncentivo() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s %s,Apellido: %s %s, Rol: %s, Salario: %.2f, Edad: %s",
                nombre, apellido, getRol(), calcularSalario(), edad != null ? edad : "N/A");
    }
}
