package org.example.gui;

import org.example.models.Developer;
import org.example.models.EmpleadoBase;
import org.example.models.Manager;
import org.example.services.GestorDeEmpleados;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GeneralPanel extends JPanel {
    private GestorDeEmpleados gestor;
    private JTextArea textArea;

    public GeneralPanel(GestorDeEmpleados gestor) {
        this.gestor = gestor;
        setLayout(new BorderLayout());

        // Crear botones
        JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
        JButton btnMostrarPromedio = new JButton("Mostrar Salario Promedio");
        JButton btnMostrarEmpleados = new JButton("Mostrar Todos los Empleados");

        // Área de texto para mostrar resultados
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAgregarEmpleado);
        buttonPanel.add(btnMostrarPromedio);
        buttonPanel.add(btnMostrarEmpleados);

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Listeners
        btnAgregarEmpleado.addActionListener(e -> agregarEmpleado());
        btnMostrarPromedio.addActionListener(e -> mostrarPromedio());
        btnMostrarEmpleados.addActionListener(e -> mostrarEmpleados());
    }

    private void agregarEmpleado() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Agregar Empleado");
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(0, 2, 10, 10));
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);

        JLabel lblRol = new JLabel("Rol (Empleado, Developer, Manager):");
        JTextField txtRol = new JTextField();
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblApellido = new JLabel("Apellido:");
        JTextField txtApellido = new JTextField();
        JLabel lblEdad = new JLabel("Edad:");
        JTextField txtEdad = new JTextField();
        JLabel lblSalarioBase = new JLabel("Salario Base:");
        JTextField txtSalarioBase = new JTextField();

        dialog.add(lblRol);
        dialog.add(txtRol);
        dialog.add(lblNombre);
        dialog.add(txtNombre);
        dialog.add(lblApellido);
        dialog.add(txtApellido);
        dialog.add(lblEdad);
        dialog.add(txtEdad);
        dialog.add(lblSalarioBase);
        dialog.add(txtSalarioBase);

        JLabel lblIncentivo = new JLabel("Incentivo:");
        JTextField txtIncentivo = new JTextField();
        JLabel lblBono = new JLabel("Bono:");
        JTextField txtBono = new JTextField();

        lblIncentivo.setVisible(false);
        txtIncentivo.setVisible(false);
        lblBono.setVisible(false);
        txtBono.setVisible(false);

        dialog.add(lblIncentivo);
        dialog.add(txtIncentivo);
        dialog.add(lblBono);
        dialog.add(txtBono);

        txtRol.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { actualizarCampos(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { actualizarCampos(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { actualizarCampos(); }

            private void actualizarCampos() {
                String rol = txtRol.getText().trim().toLowerCase();
                lblIncentivo.setVisible(rol.equals("developer"));
                txtIncentivo.setVisible(rol.equals("developer"));
                lblBono.setVisible(rol.equals("manager"));
                txtBono.setVisible(rol.equals("manager"));
                dialog.pack();
            }
        });

        JButton btnAgregar = new JButton("Agregar");
        dialog.add(new JLabel());
        dialog.add(btnAgregar);

        btnAgregar.addActionListener(e -> {
            try {
                String rol = txtRol.getText().trim().toLowerCase();
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                Integer edad = txtEdad.getText().isEmpty() ? null : Integer.parseInt(txtEdad.getText());
                double salarioBase = Double.parseDouble(txtSalarioBase.getText());

                if (salarioBase <= 0) {
                    JOptionPane.showMessageDialog(dialog, "El salario base debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (rol.equals("developer")) {
                    double incentivo = Double.parseDouble(txtIncentivo.getText());
                    if (incentivo <= 0) {
                        JOptionPane.showMessageDialog(dialog, "El incentivo debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Developer dev = new Developer(nombre, salarioBase, edad, incentivo, apellido);
                    gestor.agregarEmpleado(dev);
                    guardarEnArchivo(dev);
                } else if (rol.equals("manager")) {
                    double bono = Double.parseDouble(txtBono.getText());
                    if (bono <= 0) {
                        JOptionPane.showMessageDialog(dialog, "El bono debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Manager mgr = new Manager(nombre, salarioBase, edad, bono, apellido);
                    gestor.agregarEmpleado(mgr);
                    guardarEnArchivo(mgr);
                } else {
                    EmpleadoBase base = new EmpleadoBase(nombre, apellido, edad, salarioBase);
                    gestor.agregarEmpleado(base);
                    guardarEnArchivo(base);
                }

                JOptionPane.showMessageDialog(dialog, "Empleado agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, ingresa valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.pack();
        dialog.setVisible(true);
    }

    private void guardarEnArchivo(Object empleado) {
        // Ruta del archivo dentro de la carpeta resources
        String filePath = "src/main/resources/empleados.txt";

        // Asegurarse de que la carpeta resources existe
        File folder = new File("src/main/resources");
        if (!folder.exists()) {
            folder.mkdirs();  // Si no existe, crear la carpeta
        }

        // Crear el archivo si no existe
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();  // Crear el archivo si no existe
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al crear el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Verificar si el empleado ya está en el archivo
        if (empleado instanceof Developer) {
            Developer dev = (Developer) empleado;
            if (empleadoYaRegistrado(dev.getNombre(), dev.getApellido())) {
                JOptionPane.showMessageDialog(this, "Este empleado ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (empleado instanceof Manager) {
            Manager manager = (Manager) empleado;
            if (empleadoYaRegistrado(manager.getNombre(), manager.getApellido())) {
                JOptionPane.showMessageDialog(this, "Este empleado ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (empleado instanceof EmpleadoBase) {
            EmpleadoBase empBase = (EmpleadoBase) empleado;
            if (empleadoYaRegistrado(empBase.getNombre(), empBase.getApellido())) {
                JOptionPane.showMessageDialog(this, "Este empleado ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        try (FileWriter fw = new FileWriter(filePath, true);
             PrintWriter writer = new PrintWriter(fw)) {

            if (empleado instanceof Developer) {
                Developer dev = (Developer) empleado;
                writer.println("Rol: Developer");
                writer.println("Nombre: " + dev.getNombre());
                writer.println("Apellido: " + dev.getApellido());
                writer.println("Edad: " + dev.getEdad());
                writer.println("Salario Base: " + dev.getSalarioBase());
                writer.println("Incentivo: " + dev.getIncentivo());
                writer.println();
            } else if (empleado instanceof Manager) {
                Manager manager = (Manager) empleado;
                writer.println("Rol: Manager");
                writer.println("Nombre: " + manager.getNombre());
                writer.println("Apellido: " + manager.getApellido());
                writer.println("Edad: " + manager.getEdad());
                writer.println("Salario Base: " + manager.getSalarioBase());
                writer.println("Bono: " + manager.getBono());
                writer.println();
            } else if (empleado instanceof EmpleadoBase) {
                EmpleadoBase empBase = (EmpleadoBase) empleado;
                writer.println("Rol: Empleado");
                writer.println("Nombre: " + empBase.getNombre());
                writer.println("Apellido: " + empBase.getApellido());
                writer.println("Edad: " + empBase.getEdad());
                writer.println("Salario Base: " + empBase.getSalarioBase());
                writer.println();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private boolean empleadoYaRegistrado(String nombre, String apellido) {
        String filePath = "src/main/resources/empleados.txt";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            boolean encontrado = false;
            String empleadoNombre = null;
            String empleadoApellido = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.startsWith("Nombre: ")) {
                    empleadoNombre = line.substring(8).trim(); // Extrae el nombre
                }

                if (line.startsWith("Apellido: ")) {
                    empleadoApellido = line.substring(10).trim(); // Extrae el apellido
                }

                // Compara si ambos, nombre y apellido, coinciden
                if (empleadoNombre != null && empleadoApellido != null) {
                    if (empleadoNombre.equals(nombre) && empleadoApellido.equals(apellido)) {
                        encontrado = true;
                        break;
                    }
                }
            }
            return encontrado;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    private void mostrarPromedio() {
        double promedio = gestor.obtenerSalarioPromedio();
        textArea.setText("Salario promedio: " + promedio);
    }

    private void mostrarEmpleados() {
        textArea.setText("Lista de empleados:\n");
        gestor.getEmpleados().forEach(emp -> textArea.append(emp.toString() + "\n"));
    }
}
