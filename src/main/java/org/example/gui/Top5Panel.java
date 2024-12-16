package org.example.gui;

import org.example.services.GestorDeEmpleados;

import javax.swing.*;
import java.awt.*;

public class Top5Panel extends JPanel {
    private GestorDeEmpleados gestor;
    private JTextArea textArea;

    public Top5Panel(GestorDeEmpleados gestor) {
        this.gestor = gestor; // Usar la instancia proporcionada
        setLayout(new BorderLayout());

        // Crear botones
        JButton btnTop5Salario = new JButton("Top 5 Salarios");

        // Área de texto para mostrar resultados
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnTop5Salario);

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Listeners
        btnTop5Salario.addActionListener(e -> mostrarTop5Salario());
    }

    private void mostrarTop5Salario() {
        textArea.setText("Top 5 empleados con mayor salario:\n");
        gestor.obtenerTop5SalarioMayor().forEach(emp -> textArea.append(emp.toString() + "\n"));
    }
}
