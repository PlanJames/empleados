package org.example.services;

import org.example.models.Tipo_Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorDeEmpleados {
    // Cambiar el tipo de la lista a Tipo_Empleado
    private List<Tipo_Empleado> empleados;

    // Constructor
    public GestorDeEmpleados() {
        this.empleados = new ArrayList<>();
    }

    // Método para agregar un empleado
    public void agregarEmpleado(Tipo_Empleado empleado) {
        empleados.add(empleado);
    }

    // Método para obtener todos los empleados
    public List<Tipo_Empleado> getEmpleados() {
        return empleados;
    }

    // Filtrar empleados por salario
    public List<Tipo_Empleado> filtrarEmpleadosPorSalario(double salarioMinimo) {
        return empleados.stream()
                .filter(emp -> emp.calcularSalario() > salarioMinimo)
                .collect(Collectors.toList());
    }

    // Obtener los top 5 empleados con mayor salario
    public List<Tipo_Empleado> obtenerTop5SalarioMayor() {
        return empleados.stream()
                .sorted((e1, e2) -> Double.compare(e2.calcularSalario(), e1.calcularSalario()))
                .limit(5)
                .collect(Collectors.toList());
    }

    // Calcular el salario promedio
    public double obtenerSalarioPromedio() {
        return empleados.stream()
                .mapToDouble(Tipo_Empleado::calcularSalario)
                .average()
                .orElse(0.0);
    }
}
