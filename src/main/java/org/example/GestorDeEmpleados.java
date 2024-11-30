package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GestorDeEmpleados {
    private List<Tipo_Empleado> empleados;
    private FiltroEmpleado filtroEmpleado;

    public GestorDeEmpleados() {
        this.empleados = new ArrayList<>();
        this.filtroEmpleado = new FiltroEmpleado();
    }

    public List<Tipo_Empleado> filtrarEmpleadosPorSalario(double salarioMinimo) {
        return filtroEmpleado.filtrarPorSalario(empleados, salarioMinimo);
    }

    public List<Tipo_Empleado> filtrarEmpleadosPorRol(String rol) {
        return filtroEmpleado.filtrarPorRol(empleados, rol);
    }

    public List<Tipo_Empleado> filtrarEmpleadosPorEdad(Integer edad) {
        return filtroEmpleado.filtrarPorEdad(empleados, edad);
    }

    public double obtenerSalarioPromedio() {
        return empleados.stream()
                .mapToDouble(Tipo_Empleado::calcularSalario)
                .average()
                .orElse(0.0);
    }

    public void agregarEmpleado(Tipo_Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo.");
        }
        empleados.add(empleado);
    }

    public List<Tipo_Empleado> getEmpleados() {
        return empleados;
    }

    public List<Tipo_Empleado> obtenerTop5SalarioMayor() {
        return filtroEmpleado.obtenerTop5PorSalario(empleados);
    }

    public List<Tipo_Empleado> obtenerTop5MasViejosMayorSalario() {
        return filtroEmpleado.obtener5MasViejosPorMayorSalario(empleados);

    }

    public List<Tipo_Empleado> obtenerTop5MasViejosMenorSalario() {
        return filtroEmpleado.obtener5MasViejosPorMenorSalario(empleados);

    }

    public List<Tipo_Empleado> obtenerTop5MejorRendimiento() {
        return filtroEmpleado.filtrarPorMejorRendimiento(empleados);

    }

    public List<Tipo_Empleado> obtenerTop5PeorRendimiento() {
        return filtroEmpleado.filtrarPorPeorRendimiento(empleados);
    }

    public void eliminarEmpleadoPorNombre(List<Tipo_Empleado> empleados, String nombre) {
        empleados.removeIf(empleado -> empleado.getNombre().equalsIgnoreCase(nombre));
    }
}
