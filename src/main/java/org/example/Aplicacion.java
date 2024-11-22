package org.example;
import java.util.*;

public class Aplicacion {
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();
        GestorDeEmpleados gestor = new GestorDeEmpleados(empleados);
        EmpleadoCreator creator = new EmpleadoCreator();

        empleados.add(creator.crearEmpleadoPorTeclado());
        empleados.add(creator.crearEmpleadoPorTeclado());

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver empleados con salario mayor a X");
            System.out.println("2. Ver empleados de un rol específico");
            System.out.println("3. Ver empleados mayores de X años");
            System.out.println("4. Agregar nuevo empleado");
            System.out.println("5. Mostrar salario promedio");
            System.out.println("6. Salir");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el salario mínimo: ");
                    double salarioMinimo = Double.parseDouble(scanner.nextLine());
                    List<Empleado> empleadosConSalarioMinimo = gestor.filtrarEmpleados(salarioMinimo);
                    empleadosConSalarioMinimo.forEach(e -> System.out.println(e.getNombre()));
                    break;
                case 2:
                    System.out.println("Ingrese el rol (manager, developer, empleado): ");
                    String rol = scanner.nextLine();
                    List<Empleado> empleadosPorRol = gestor.filtrarPorRol(rol);
                    empleadosPorRol.forEach(e -> System.out.println(e.getNombre()));
                    break;
                case 3:
                    System.out.println("Ingrese la edad mínima: ");
                    int edadMinima = Integer.parseInt(scanner.nextLine());
                    List<Empleado> empleadosPorEdad = gestor.filtrarPorEdad(edadMinima);
                    empleadosPorEdad.forEach(e -> System.out.println(e.getNombre()));
                    break;
                case 4:
                    Empleado nuevoEmpleado = creator.crearEmpleadoPorTeclado();
                    gestor.agregarEmpleado(nuevoEmpleado);
                    System.out.println("Empleado agregado.");
                    break;
                case 5:
                    double salarioPromedio = gestor.obtenerSalarioPromedio();
                    System.out.println("El salario promedio de los empleados es: " + salarioPromedio);
                    break;
                case 6:
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}