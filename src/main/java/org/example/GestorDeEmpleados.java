package org.example;
import java.util.ArrayList;
import java.util.List;

public class GestorDeEmpleados {
    private List<Tipo_Empleado> empleados;

    public GestorDeEmpleados() {
        this.empleados = new ArrayList<>();
    }

    public List<Tipo_Empleado> filtrarEmpleadosPorSalario(double salarioMinimo) {
        return FiltroEmpleado.filtrarPorSalario(empleados, salarioMinimo);
    }

    public List<Tipo_Empleado> filtrarEmpleadosPorRol(String rol) {
        return FiltroEmpleado.filtrarPorRol(empleados, rol);
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
