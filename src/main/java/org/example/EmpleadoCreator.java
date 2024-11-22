package org.example;
import java.util.*;



public class EmpleadoCreator {
    private Scanner scanner = new Scanner(System.in);

    public Empleado crearEmpleadoPorTeclado() {
        System.out.println("Ingrese el tipo de empleado (manager, developer, empleado): ");
        String tipo = scanner.nextLine().toLowerCase();

        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el salario base del empleado: ");
        double salarioBase = Double.parseDouble(scanner.nextLine());

        double extra = 0;
        if (tipo.equals("manager")) {
            System.out.println("Ingrese el bonus del manager: ");
            extra = Double.parseDouble(scanner.nextLine());
        } else if (tipo.equals("developer")) {
            System.out.println("Ingrese los incentivos del developer: ");
            extra = Double.parseDouble(scanner.nextLine());
        }

        return EmpleadoFactory.crearEmpleado(tipo, nombre, salarioBase, extra);
    }
}



