package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class FiltroEmpleado {
    public static List<Empleado> filtrarPorSalario(List<Empleado> empleados, double salarioMinimo) {
        return empleados.stream()
                .filter(empleado -> empleado.calcularSalario() >= salarioMinimo)
                .collect(Collectors.toList());
    }

    public static List<Empleado> filtrarPorRol(List<Empleado> empleados, String rol) {
        return empleados.stream()
                .filter(empleado -> empleado.getRol().equalsIgnoreCase(rol))
                .collect(Collectors.toList());
    }

    public static List<Empleado> filtrarPorEdad(List<Empleado> empleados, int edadMinima) {
        return empleados.stream()
                .filter(empleado -> empleado instanceof EmpleadoConEdad)
                .filter(empleado -> ((EmpleadoConEdad) empleado).getEdad() >= edadMinima)
                .collect(Collectors.toList());
    }
}
