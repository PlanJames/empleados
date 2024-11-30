package org.example;

import java.util.Scanner;

public class Crear_Empleado {
    public Tipo_Empleado crearEmpleadoDesdeTeclado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tipo de empleado (manager, developer, empleado): ");
        String tipo = scanner.nextLine().toLowerCase();

        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el salario base del empleado: ");
        double salarioBase = Double.parseDouble(scanner.nextLine());

        System.out.println("Ingrese la edad del empleado: ");
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
