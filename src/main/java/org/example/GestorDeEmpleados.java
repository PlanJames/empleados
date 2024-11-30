package org.example;
import java.util.ArrayList;
import java.util.List;

public class GestorDeEmpleados {
    private List<Tipo_Empleado> empleados;
    private FiltroEmpleado filtroEmpleado; // Instance of FiltroEmpleado

    public GestorDeEmpleados() {
        this.empleados = new ArrayList<>();
        this.filtroEmpleado = new FiltroEmpleado(); // Initialize the instance
    }

    public List<Tipo_Empleado> filtrarEmpleadosPorSalario(double salarioMinimo) {
        return filtroEmpleado.filtrarPorSalario(empleados, salarioMinimo);
    }

    public List<Tipo_Empleado> filtrarEmpleadosPorRol(String rol) {
        return filtroEmpleado.filtrarPorRol(empleados, rol);
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
        return new ArrayList<>(empleados); // Return a copy to maintain encapsulation
    }
}
