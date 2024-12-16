package org.example.gui;

import org.example.services.GestorDeEmpleados;

import javax.swing.*;

public class MainFrame extends JFrame {
    private GestorDeEmpleados gestor;

    public MainFrame() {
        gestor = new GestorDeEmpleados();

        setTitle("Gestor de Empleados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Agregar Empleado", new GeneralPanel(gestor));
        tabbedPane.addTab("Top 5 Salarios", new Top5Panel(gestor));
        tabbedPane.addTab("Filtrar Por Salario", new FilterPanel(gestor));  // Agregar el FilterPanel aquí

        // Agregar el tabbedPane al panel principal
        add(tabbedPane);
        setLocationRelativeTo(null); // Centrar ventana
        setVisible(true);
    }
}
