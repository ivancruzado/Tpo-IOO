package GUI;
import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;


import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TablaSucursales extends JFrame {

    private CustomTableModel3 tableModel3;
    private JTable table;
    private ControllerSucursales controller;
    private ControllerPeticiones controller2;

    TableRowSorter<CustomTableModel3> sorter3;

    public TablaSucursales(String title) {
        setTitle("Alta de Sucursales");

        setBounds(30,20,750,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = ControllerSucursales.getInstance();
        controller2 = ControllerPeticiones.getInstance();
        tableModel3 = new CustomTableModel3(controller.getAll());

        table = new JTable(tableModel3);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        sorter3 = new TableRowSorter<>(tableModel3);
        table.setRowSorter(sorter3);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700,600));
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
        add(panel,BorderLayout.CENTER);

        modificarSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if (seleccion != -1) {
                    String columna1 = table.getValueAt(seleccion,0).toString();
                    String columna2 = table.getValueAt(seleccion,1).toString();
                    String columna3 = table.getValueAt(seleccion,2).toString();
                    String columna4 = table.getValueAt(seleccion,3).toString();

                    modificarSucursal modificarSucursal1 = new modificarSucursal(columna1,columna2,columna3,columna4);
                    //TablaSucursales.this.dispose();
                    TablaSucursales.this.setVisible(false);
                    modificarSucursal1.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione una practica para modificarla");
                }
            }
        });

        volverAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaSucursales.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });


        eliminarSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();

                if(seleccion != -1){
                    String columna1 = table.getValueAt(seleccion,0).toString();
                    int columna1int = Integer.parseInt(columna1);
                    if(controller.buscarEstado(columna1int) == true) {
                        JOptionPane.showMessageDialog(null,"Error. La sucursal tiene peticiones finalizadas");
                    }
                    else {
                        controller2.moverPeticionesActivas(columna1int,1);
                        controller.bajaSucursal(columna1int);

                        JOptionPane.showMessageDialog(null,"Sucursal eliminada correctamente");
                    }

                    TablaSucursales tablaSucursales = new TablaSucursales("tabla Sucursales");
                    TablaSucursales.this.setVisible(false);
                    tablaSucursales.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar, seleccione la sucursal a eliminar");
                }

            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sorter3.setRowFilter(RowFilter.regexFilter(id.getText(),0));
            }
        });
    }
}
