package org.example;
import java.util.*;
import java.util.Scanner;

public class Aplicacion {
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        GestorDeEmpleados gestor = new GestorDeEmpleados();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver empleados con salario mayor a X");
            System.out.println("2. Ver empleados de un rol específico");
            System.out.println("3. Agregar nuevo empleado");
            System.out.println("4. Mostrar salario promedio");
            System.out.println("5. Salir");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el salario mínimo: ");
                    double salarioMinimo = Double.parseDouble(scanner.nextLine());
                    var empleadosConSalario = gestor.filtrarPorSalario(salarioMinimo);
                    if (empleadosConSalario.isEmpty()) {
                        System.out.println("No hay empleados con salario mayor a " + salarioMinimo);
                    } else {
                        empleadosConSalario.forEach(e -> System.out.println(e));
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el rol (manager, developer, empleado base): ");
                    String rol = scanner.nextLine();
                    var empleadosPorRol = gestor.filtrarEmpleadosPorRol(rol);
                    if (empleadosPorRol.isEmpty()) {
                        System.out.println("No hay empleados con el rol: " + rol);
                    } else {
                        empleadosPorRol.forEach(e -> System.out.println(e));
                    }
                    break;
                case 3:
                    Tipo_Empleado nuevoEmpleado = Tipo_Empleado.crearEmpleadoDesdeTeclado();
                    gestor.agregarEmpleado(nuevoEmpleado);
                    System.out.println("Empleado agregado: " + nuevoEmpleado);
                    break;
                case 4:
                    double salarioPromedio = gestor.obtenerSalarioPromedio();
                    System.out.println("El salario promedio de los empleados es: " + salarioPromedio);
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Programa terminado");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
