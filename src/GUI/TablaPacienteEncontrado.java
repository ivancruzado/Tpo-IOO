package GUI;
import Controlador.ControllerPeticiones;
import Modelo.Pacientes;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TablaPacienteEncontrado extends JFrame {

    private CustomTableModel tableModel;
    private JTable table;
    private ControllerPeticiones controller;

    TableRowSorter<CustomTableModel> sorter;

    public TablaPacienteEncontrado(String title) {
        super(title);

        setBounds(30,20,750,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = ControllerPeticiones.getInstance();
        tableModel = new CustomTableModel(controller.getLista());


        table = new JTable(tableModel);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700,600));
        JPanel panel = new JPanel();
        JTextField dni = new JTextField();
        dni.setPreferredSize(new Dimension(200, dni.getPreferredSize().height));
        JLabel etiqueta = new JLabel("Dni:");
        JButton botonBuscar = new JButton("Buscar");
        JButton volverAtras = new JButton("Volver al Menú");
        JButton EliminarPaciente = new JButton("Eliminar paciente");
        JButton modificarPaciente = new JButton("Editar paciente");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverAtras);
        buttonPanel.add(etiqueta);
        buttonPanel.add(dni);
        buttonPanel.add(botonBuscar);
        buttonPanel.add(EliminarPaciente);
        buttonPanel.add(modificarPaciente);
        buttonPanel.add(volverAtras);

        panel.add(buttonPanel);

        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);




        volverAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaPacienteEncontrado.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });

        EliminarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if(seleccion != -1){
                    controller.bajaPaciente(seleccion);
                    JOptionPane.showMessageDialog(null,"Paciente eliminado correctamente");
                    TablaPacienteEncontrado tablaPacienteEncontrado = new TablaPacienteEncontrado("tabla pacientes");
                    TablaPacienteEncontrado.this.setVisible(false);
                    tablaPacienteEncontrado.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar, seleccione el paciente a eliminar");
                }

            }
        });

        modificarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                String selecciondni = table.getValueAt(seleccion,0).toString();
                if (seleccion != -1) {
                    //String columna1 = table.getValueAt(seleccion,0).toString();
                    String columna2 = table.getValueAt(seleccion,1).toString();
                    String columna3 = table.getValueAt(seleccion,2).toString();
                    String columna4 = table.getValueAt(seleccion,3).toString();
                    String columna5 = table.getValueAt(seleccion,4).toString();
                    String columna6 = table.getValueAt(seleccion,5).toString();

                    modificarPaciente modificarPaciente = new modificarPaciente(selecciondni,columna2,columna3,columna4,columna5,columna6,seleccion);
                    TablaPacienteEncontrado.this.setVisible(false);
                    modificarPaciente.setVisible(true);


                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione un paciente para modificarlo");
                }

            }
        });


        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sorter.setRowFilter(RowFilter.regexFilter(dni.getText(),0));
            }
        });


    }

}
