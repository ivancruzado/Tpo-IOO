package GUI;

import Controlador.ControllerUsuarios;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaUsuarios extends JFrame {

    private CustomTableUser tableModelUser;
    private JTable table;
    private ControllerUsuarios controller3;

    TableRowSorter<CustomTableUser> sorter3;

    public TablaUsuarios(String title) {
        setTitle("Nomina de usuarios del sistema (Solo administrador)");

        setBounds(30, 20, 750, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller3 = ControllerUsuarios.getInstance();
        tableModelUser = new CustomTableUser(controller3.getall());


        table = new JTable(tableModelUser);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        sorter3 = new TableRowSorter<>(tableModelUser);
        table.setRowSorter(sorter3);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 600));
        JPanel panel = new JPanel();
        JTextField id = new JTextField();
        id.setPreferredSize(new Dimension(200, id.getPreferredSize().height));
        JLabel etiqueta = new JLabel("Nombre:");
        JButton botonBuscar = new JButton("Buscar");
        JButton volverAtras = new JButton("Volver atras");
        JButton EliminarUsuario = new JButton("Eliminar Usuario");
        JButton modificarUsuario = new JButton("Edit Usuario");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverAtras);
        buttonPanel.add(etiqueta);
        buttonPanel.add(id);
        buttonPanel.add(botonBuscar);
        buttonPanel.add(EliminarUsuario);
        buttonPanel.add(modificarUsuario);
        buttonPanel.add(volverAtras);

        panel.add(buttonPanel);

        panel.add(scrollPane);
        add(panel, BorderLayout.CENTER);

        modificarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if (seleccion != -1) {
                    String columna1 = table.getValueAt(seleccion, 0).toString();
                    String columna2 = table.getValueAt(seleccion, 1).toString();
                    String columna3 = table.getValueAt(seleccion, 2).toString();
                    String columna4 = table.getValueAt(seleccion, 3).toString();

                    ModificarUsuario GUImodificarusuario = new ModificarUsuario(columna1,columna2,columna3,columna4);
                    TablaUsuarios.this.setVisible(false);
                    GUImodificarusuario.setVisible(true);

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


        EliminarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if(seleccion != -1){
                    String DNIint = table.getValueAt(seleccion,2).toString();
                    boolean confirmacion = ControllerUsuarios.bajaUsuarios(DNIint);
                    if (confirmacion==true) {
                        JOptionPane.showMessageDialog(null, "usuario eliminado correctamente");
                        TablaUsuarios tablaUsuarios = new TablaUsuarios("tabla usuarios");
                        TablaUsuarios.this.setVisible(false);
                        tablaUsuarios.setVisible(true);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar, seleccione el usuario a eliminar");
                }

            }
        });
        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonBuscar.doClick();
            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                sorter3.setRowFilter(RowFilter.regexFilter(id.getText(),0));
            }
        });
    }
}
