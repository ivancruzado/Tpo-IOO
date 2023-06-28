package GUI;

import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;
import DTO.PacientesDTO;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaPeticiones extends JFrame {

    private CustomTableModel4 tableModel4;
    private JTable table;
    private ControllerPeticiones controller;

    TableRowSorter<CustomTableModel4> sorter4;

    public TablaPeticiones(String title) {
        super(title);

        setBounds(30,20,1000,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = ControllerPeticiones.getInstance();
        tableModel4 = new CustomTableModel4(controller.getAll3());

        table = new JTable(tableModel4);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        sorter4 = new TableRowSorter<>(tableModel4);
        table.setRowSorter(sorter4);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(900,600));
        JPanel panel = new JPanel();
        JTextField id = new JTextField();
        id.setPreferredSize(new Dimension(100, id.getPreferredSize().height));
        JLabel etiqueta = new JLabel("Id:");
        JButton botonBuscar = new JButton("Buscar");
        JButton volverAtras = new JButton("Volver atras");
        JButton eliminarPeticion = new JButton("Eliminar");
        JButton modificarPeticion = new JButton("Editar");
        JButton verresultado = new JButton("Ver Resultado");
        JButton listarCriticos = new JButton("Listar Peticiones Criticas");



        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverAtras);
        buttonPanel.add(etiqueta);
        buttonPanel.add(id);
        buttonPanel.add(botonBuscar);
        buttonPanel.add(eliminarPeticion);
        buttonPanel.add(modificarPeticion);
        buttonPanel.add(volverAtras);
        buttonPanel.add(verresultado);
        buttonPanel.add(listarCriticos);

        panel.add(buttonPanel);

        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);


        verresultado.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if (seleccion != -1) {

                    String Idpeticion = table.getValueAt(seleccion,0).toString();
                    if (ControllerPeticiones.validarCarga(Integer.parseInt(Idpeticion))){

                        Boolean reservado = ControllerPeticiones.esresevado(Integer.parseInt(Idpeticion));

                        if (reservado==true){
                            JOptionPane.showMessageDialog(null, "Esta Peticion tiene valores reservados, por lo que debe retirlo personalmente");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Mostrar los datos");

                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Esta Peticion aun no tiene resultados cargados");

                    }

            //        modificarPeticion modificarPeticion1 = new modificarPeticion(columna1,columna2,columna3,columna4,columna5,columna6,columna7,columna8);
                    //TablaPeticiones.this.dispose();
                 //   TablaPeticiones.this.setVisible(false);
             //       modificarPeticion1.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione un peticion");
                }
            }

        });

        modificarPeticion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if (seleccion != -1) {

                    String columna1 = table.getValueAt(seleccion,0).toString();
                    String columna2 = table.getValueAt(seleccion,1).toString();
                    String columna3 = table.getValueAt(seleccion,2).toString();
                    String columna4 = table.getValueAt(seleccion,3).toString();
                    String columna5 = table.getValueAt(seleccion,4).toString();
                    String columna6 = table.getValueAt(seleccion,5).toString();
                    String columna7 = table.getValueAt(seleccion,6).toString();
                    String columna8 = table.getValueAt(seleccion,7).toString();

                    modificarPeticion modificarPeticion1 = new modificarPeticion(columna1,columna2,columna3,columna4,columna5,columna6,columna7,columna8);
                    //TablaPeticiones.this.dispose();
                    TablaPeticiones.this.setVisible(false);
                    modificarPeticion1.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione una practica para modificarla");
                }
            }
        });

        volverAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                TablaPeticiones.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });


        eliminarPeticion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();

                if(seleccion != -1) {
                    String columna1 = table.getValueAt(seleccion, 0).toString();
                    int columna1int = Integer.parseInt(columna1);
                    controller.bajaPeticiones(columna1int);
                    JOptionPane.showMessageDialog(null, "Peticion eliminada correctamente");

                    TablaPeticiones tablaPeticiones = new TablaPeticiones("tabla Peticiones");
                    TablaPeticiones.this.setVisible(false);
                    tablaPeticiones.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar, seleccione la peticion a eliminar");
                }

            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter4.setRowFilter(RowFilter.regexFilter(id.getText(),0));
        };
    });
}

}
