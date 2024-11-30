package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class FiltroEmpleado {
    public List<Tipo_Empleado> filtrarPorSalario(List<Tipo_Empleado> empleados, double salarioMinimo) {
        return empleados.stream()
                .filter(empleado -> empleado.calcularSalario() >= salarioMinimo)
                .collect(Collectors.toList());
    }

    public List<Tipo_Empleado> filtrarPorRol(List<Tipo_Empleado> empleados, String rol) {
        return empleados.stream()
                .filter(empleado -> empleado.getRol().equalsIgnoreCase(rol))
                .collect(Collectors.toList());
    }

    public List<Tipo_Empleado> filtrarPorEdad(List<Tipo_Empleado> empleados, int edadMinima) {
        return empleados.stream()
                .filter(empleado -> empleado.getEdad() >= edadMinima)
                .collect(Collectors.toList());
    }
}
