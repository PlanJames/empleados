package org.example;

import java.util.Scanner;

public class Aplicacion {
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        GestorDeEmpleados gestor = new GestorDeEmpleados();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione una sección:");
            System.out.println("1. General");
            System.out.println("2. Top5");
            System.out.println("3. Filter");
            System.out.println("4. Salir");

            int opcionSeccion = Integer.parseInt(scanner.nextLine());

            switch (opcionSeccion) {
                case 1 -> mostrarGeneral(gestor, scanner);
                case 2 -> mostrarTop5(gestor);
                case 3 -> mostrarFilters(gestor, scanner);
                case 4 -> {
                    continuar = false;
                    System.out.println("Programa terminado");
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarGeneral(GestorDeEmpleados gestor, Scanner scanner) {
        System.out.println("\nGeneral:");
        System.out.println("1. Agregar nuevo empleado");
        System.out.println("2. Mostrar salario promedio");
        System.out.println("3. Todos los empleados");

        int opcionGeneral = Integer.parseInt(scanner.nextLine());

        switch (opcionGeneral) {
            case 1 -> {
                Crear_Empleado nuevoEmpleado = new Crear_Empleado();
                Tipo_Empleado empleado = nuevoEmpleado.crearEmpleadoDesdeTeclado();
                gestor.agregarEmpleado(empleado);
                System.out.println("Empleado agregado: " + empleado);
            }
            case 2 -> System.out.println("El salario promedio de los empleados es: " + gestor.obtenerSalarioPromedio());
            case 3 -> System.out.println("Empleados: " + gestor.getEmpleados());
            default -> System.out.println("Opción no válida.");
        }
    }

    private void mostrarTop5(GestorDeEmpleados gestor) {
        System.out.println("\nTop5:");
        System.out.println("1. Top 5 empleados con mayor salario");
        System.out.println("2. Top 5 más viejos con mayor salario");
        System.out.println("3. Top 5 más viejos con menor salario");
        System.out.println("4. Top 5 mejores rendimientos");
        System.out.println("5. Top 5 peores rendimientos");

        Scanner scanner = new Scanner(System.in);
        int opcionTop5 = Integer.parseInt(scanner.nextLine());

        switch (opcionTop5) {
            case 1 -> gestor.obtenerTop5SalarioMayor().forEach(System.out::println);
            case 2 -> gestor.obtenerTop5MasViejosMayorSalario().forEach(System.out::println);
            case 3 -> gestor.obtenerTop5MasViejosMenorSalario().forEach(System.out::println);
            case 4 -> gestor.obtenerTop5MejorRendimiento().forEach(System.out::println);
            case 5 -> gestor.obtenerTop5PeorRendimiento().forEach(System.out::println);
            default -> System.out.println("Opción no válida.");
        }
    }

    private void mostrarFilters(GestorDeEmpleados gestor, Scanner scanner) {
        System.out.println("\nFilter:");
        System.out.println("1. Ver empleados con salario mayor a X");
        System.out.println("2. Ver empleados de un rol específico");
        System.out.println("3. Ver empleados mayores a X edad");

        int opcionFiltro = Integer.parseInt(scanner.nextLine());

        switch (opcionFiltro) {
            case 1 -> {
                System.out.println("Ingrese el salario mínimo:");
                double salarioMinimo = Double.parseDouble(scanner.nextLine());
                gestor.filtrarEmpleadosPorSalario(salarioMinimo).forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Ingrese el rol:");
                String rol = scanner.nextLine();
                gestor.filtrarEmpleadosPorRol(rol).forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Ingrese la edad mínima:");
                int edadMinima = Integer.parseInt(scanner.nextLine());
                gestor.filtrarEmpleadosPorEdad(edadMinima).forEach(System.out::println);
            }
            default -> System.out.println("Opción no válida.");
        }
    }
}
