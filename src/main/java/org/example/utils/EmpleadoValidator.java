package org.example.utils;

import org.example.models.*;

public class EmpleadoValidator {
    public static Tipo_Empleado crearEmpleadoDesdeFormulario(
            String rol, String nombre, String apellido, String edadStr,
            String salarioBaseStr, String incentivoStr, String bonoStr
    ) {
        if (rol == null || rol.isEmpty()) throw new IllegalArgumentException("El rol es obligatorio.");
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("El nombre es obligatorio.");
        if (apellido == null || apellido.isEmpty()) throw new IllegalArgumentException("El apellido es obligatorio.");

        // Convertir y validar números
        int edad = validarEntero(edadStr, "Edad");
        double salarioBase = validarDouble(salarioBaseStr, "Salario Base");

        switch (rol.toLowerCase()) {
            case "developer":
                double incentivo = validarDouble(incentivoStr, "Incentivo");
                return new Developer(nombre, incentivo, edad, salarioBase, apellido);
            case "manager":
                double bono = validarDouble(bonoStr, "Bono");
                return new Manager(nombre, bono, edad, salarioBase, apellido);
            case "base":
                return new EmpleadoBase(nombre, apellido, edad, salarioBase);
            default:
                throw new IllegalArgumentException("El rol debe ser Developer, Manager o Base.");
        }
    }

    private static int validarEntero(String valor, String campo) {
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(campo + " debe ser un número entero.");
        }
    }

    private static double validarDouble(String valor, String campo) {
        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(campo + " debe ser un número válido.");
        }
    }
}
