package org.example;

import java.util.Scanner;

public abstract class Tipo_Empleado {
    private String nombre;
    private double salarioBase;
    private Integer edad;

    public Tipo_Empleado(String nombre, double salarioBase, Integer edad) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor que cero.");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularSalario();

    public abstract String getRol();

    public Integer getEdad () {
        return edad;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Rol: %s, Salario: %.2f", nombre, getRol(), calcularSalario());
    }

    public static Tipo_Empleado crearEmpleadoDesdeTeclado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tipo de empleado (manager, developer, empleado): ");
        String tipo = scanner.nextLine().toLowerCase();

        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el salario base del empleado: ");
        double salarioBase = Double.parseDouble(scanner.nextLine());

        System.out.println("Ingrese edad del empleado: ");
        Integer edad = Integer.valueOf(scanner.nextLine());

        switch (tipo) {
            case "manager":
                System.out.println("Ingrese el bonus del manager: ");
                double bonus = Double.parseDouble(scanner.nextLine());
                return new Manager(nombre, salarioBase, edad, bonus);
            case "developer":
                System.out.println("Ingrese los incentivos del developer: ");
                double incentivos = Double.parseDouble(scanner.nextLine());
                return new Developer(nombre, salarioBase, edad, incentivos);
            case "empleado":
                return new EmpleadoBase(nombre, edad, salarioBase);
            default:
                throw new IllegalArgumentException("Tipo de empleado no reconocido.");
        }
    }
}
