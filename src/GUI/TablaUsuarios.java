package GUI;


import Controlador.ControllerUsuarios;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaUsuarios extends JFrame {

    private CustomTableModel3 tableModel3;
    private JTable table;
    private ControllerUsuarios controller3;

    TableRowSorter<CustomTableModel3> sorter3;

    public TablaUsuarios(String title) {
        super(title);

        setBounds(30, 20, 750, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        table = new JTable(tableModel3);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        sorter3 = new TableRowSorter<>(tableModel3);
        table.setRowSorter(sorter3);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 600));
        JPanel panel = new JPanel();
        JTextField id = new JTextField();
        id.setPreferredSize(new Dimension(200, id.getPreferredSize().height));
        JLabel etiqueta = new JLabel("Id:");
        JButton botonBuscar = new JButton("Buscar");
        JButton volverAtras = new JButton("Volver atras");
        JButton eliminarSucursal = new JButton("Eliminar Sucursal");
        JButton modificarSucursal = new JButton("Edit Sucursal");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverAtras);
        buttonPanel.add(etiqueta);
        buttonPanel.add(id);
        buttonPanel.add(botonBuscar);
        buttonPanel.add(eliminarSucursal);
        buttonPanel.add(modificarSucursal);
        buttonPanel.add(volverAtras);

        panel.add(buttonPanel);

        panel.add(scrollPane);
        add(panel, BorderLayout.CENTER);

        modificarSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if (seleccion != -1) {
                    String columna1 = table.getValueAt(seleccion, 0).toString();
                    String columna2 = table.getValueAt(seleccion, 1).toString();
                    String columna3 = table.getValueAt(seleccion, 2).toString();
                    String columna4 = table.getValueAt(seleccion, 3).toString();

                    modificarSucursal modificarSucursal1 = new modificarSucursal(columna1, columna2, columna3, columna4);
                    //TablaSucursales.this.dispose();
                    TablaUsuarios.this.setVisible(false);
                    modificarSucursal1.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una practica para modificarla");
                }
            }
        });

        volverAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaUsuarios.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });

    }
}
