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
                .filter(empleado -> empleado.getEdad() != null && empleado.getEdad() >= edadMinima)
                .collect(Collectors.toList());
    }

    public List<Tipo_Empleado> obtenerTop5PorSalario(List<Tipo_Empleado> empleados) {
        return empleados.stream()
                .sorted(Comparator.comparingDouble(Tipo_Empleado::calcularSalario).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Tipo_Empleado> obtener5MasViejosPorMayorSalario(List<Tipo_Empleado> empleados) {
        return empleados.stream()
                .sorted(Comparator.comparingInt(Tipo_Empleado::getEdad)
                        .thenComparingDouble(Tipo_Empleado::calcularSalario).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Tipo_Empleado> obtener5MasViejosPorMenorSalario(List<Tipo_Empleado> empleados) {
        return empleados.stream()
                .sorted(Comparator.comparingInt(Tipo_Empleado::getEdad)
                        .thenComparingDouble(Tipo_Empleado::calcularSalario))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Tipo_Empleado> filtrarPorMejorRendimiento(List<Tipo_Empleado> empleados) {
        return empleados.stream()
                .sorted(Comparator.comparingDouble(Tipo_Empleado::getRendimiento).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Tipo_Empleado> filtrarPorPeorRendimiento(List<Tipo_Empleado> empleados) {
        return empleados.stream()
                .sorted(Comparator.comparingDouble(Tipo_Empleado::getRendimiento))
                .limit(5)
                .collect(Collectors.toList());
    }


}
