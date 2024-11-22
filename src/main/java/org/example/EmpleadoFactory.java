package org.example;

public class EmpleadoFactory {
    public static Empleado crearEmpleado(String tipo, String nombre, double salarioBase, double extra) {
        switch (tipo.toLowerCase()) {
            case "manager":
                return new Manager(nombre, salarioBase, extra);
            case "developer":
                return new Developer(nombre, salarioBase, extra);
            case "empleado":
                return new EmpleadoBase(nombre, salarioBase);
            default:
                throw new IllegalArgumentException("Tipo de empleado no reconocido");
        }
    }
}