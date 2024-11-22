package org.example;
import java.util.*;


public class GestorDeEmpleados {
    private List<Empleado> empleados;

    public GestorDeEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Empleado> filtrarEmpleados(double salarioMinimo) {
        return FiltroEmpleado.filtrarPorSalario(empleados, salarioMinimo);
    }

    public List<Empleado> filtrarPorRol(String rol) {
        return FiltroEmpleado.filtrarPorRol(empleados, rol);
    }

    public List<Empleado> filtrarPorEdad(int edadMinima) {
        return FiltroEmpleado.filtrarPorEdad(empleados, edadMinima);
    }

    public double obtenerSalarioPromedio() {
        return empleados.stream()
                .mapToDouble(Empleado::calcularSalario)
                .average()
                .orElse(0.0);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
}
