package GUI;
import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;
import DTO.PacientesDTO;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaResultados extends JFrame  {


    private CustomTableResultados TableResultados;
    private JTable table;
    private ControllerPeticiones controller;


    TableRowSorter<CustomTableResultados> sorter;

    public TablaResultados (){
        setTitle("Listado de Resultados");
        setBounds(30,20,750,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = ControllerPeticiones.getInstance();
        TableResultados = new CustomTableResultados(controller.getAll5());

        table = new JTable(TableResultados);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(TableResultados);
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700,600));
        JPanel panel = new JPanel();
        JTextField id = new JTextField();
        id.setPreferredSize(new Dimension(200, id.getPreferredSize().height));
        JLabel etiqueta = new JLabel("Id:");
        JButton botonBuscar = new JButton("Buscar");
        JButton volverAtras = new JButton("Volver atras");
        JButton eliminarResultado = new JButton("Eliminar Resultado");
        JButton modificarResultado = new JButton("Editar Resultado");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverAtras);
        buttonPanel.add(etiqueta);
        buttonPanel.add(id);
        buttonPanel.add(botonBuscar);
        buttonPanel.add(eliminarResultado);
        buttonPanel.add(modificarResultado);
        buttonPanel.add(volverAtras);

        panel.add(buttonPanel);

        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);


        modificarResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if (seleccion != -1) {

                    String columna1 = table.getValueAt(seleccion,0).toString();
                    String columna2 = table.getValueAt(seleccion,1).toString();
                    String columna3 = table.getValueAt(seleccion,2).toString();
                    String columna4 = table.getValueAt(seleccion,3).toString();
                    String columna5 = table.getValueAt(seleccion,4).toString();
                    String columna6 = table.getValueAt(seleccion,5).toString();

                    modificarResultados Resultado = new modificarResultados (Integer.parseInt(columna1),Integer.parseInt(columna2),Boolean.valueOf(columna3),Boolean.valueOf(columna4),Integer.parseInt(columna5),Integer.parseInt(columna6));
                    TablaResultados.this.dispose();
                    TablaResultados.this.setVisible(false);
                    Resultado.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione un Resultado para modificarlo");
                }

            }
        });

        volverAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaResultados.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });


        eliminarResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if(seleccion != -1){
                    String columna1 = table.getValueAt(seleccion,0).toString();
                    int id1int = Integer.parseInt(columna1);
                    controller.bajaResultado(id1int);
                    JOptionPane.showMessageDialog(null,"Resultado eliminada correctamente");
                    TablaResultados tablaCargarResultados = new TablaResultados();
                    TablaResultados.this.setVisible(false);
                    tablaCargarResultados.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar, seleccione el Resultado a eliminar");
                }

            }
        });




        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                sorter.setRowFilter(RowFilter.regexFilter(id.getText(),0));
            }
        });



    }


}


