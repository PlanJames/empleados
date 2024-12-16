package org.example.gui;

import org.example.services.GestorDeEmpleados;
import org.example.models.Tipo_Empleado;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FilterPanel extends JPanel {
    private GestorDeEmpleados gestor;
    private JTextArea textArea;
    private JTextField txtSalarioMin;

    public FilterPanel(GestorDeEmpleados gestor) {
        this.gestor = gestor;  // Usar el gestor pasado en vez de crear uno nuevo
        setLayout(new BorderLayout());

        // Crear componentes
        JLabel lblSalarioMinimo = new JLabel("Salario Mínimo:");
        txtSalarioMin = new JTextField(10); // Inicializar el campo de texto
        JButton btnFiltrarSalario = new JButton("Filtrar por Salario");

        this.textArea = new JTextArea();
        this.textArea.setEditable(false);

        // Panel de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.add(lblSalarioMinimo);
        inputPanel.add(txtSalarioMin); // Asegúrate de agregarlo al panel
        inputPanel.add(btnFiltrarSalario);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(this.textArea), BorderLayout.CENTER);

        // Listener
        btnFiltrarSalario.addActionListener(e -> filtrarPorSalario());
    }

    private void filtrarPorSalario() {
        try {
            String salarioTexto = txtSalarioMin.getText().trim();
            double lblSalarioBase = salarioTexto.isEmpty() ? 0 : Double.parseDouble(salarioTexto);

            // Filtrar empleados con salario mayor o igual al salario ingresado
            List<Tipo_Empleado> empleadosFiltrados = gestor.filtrarEmpleadosPorSalario(lblSalarioBase);

            // Mostrar resultados
            textArea.setText("Empleados con salario mayor o igual a " + lblSalarioBase + ":\n");
            if (empleadosFiltrados.isEmpty()) {
                textArea.append("No se encontraron empleados con el salario especificado.\n");
            } else {
                empleadosFiltrados.forEach(emp -> textArea.append(emp.toString() + "\n"));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el salario mínimo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
