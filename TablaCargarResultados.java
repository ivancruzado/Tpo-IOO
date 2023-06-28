/*package GUI;

import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;
import DTO.PacientesDTO;



import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class TablaCargarResultados extends JFrame {


    private CustomTableModel5 tableModel5;
    private JTable table;
    private ControllerPeticiones controller;


    TableRowSorter<CustomTableModel5> sorter5;

    public TablaCargarResultados (String title){
        super(title);

        setBounds(30,20,750,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = ControllerPeticiones.getInstance();
        tableModel5 = new CustomTableModel5(controller.getAll5());

        table = new JTable(tableModel5);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        sorter5 = new TableRowSorter<>(tableModel5);
        table.setRowSorter(sorter5);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700,600));
        JPanel panel = new JPanel();
        JTextField id = new JTextField();
        id.setPreferredSize(new Dimension(200, id.getPreferredSize().height));
        JLabel etiqueta = new JLabel("Id:");
        JButton botonBuscar = new JButton("Buscar");
        JButton volverAtras = new JButton("Volver atras");
        JButton eliminarResultado = new JButton("Eliminar Resultado");
        JButton modificarResultado = new JButton("Edit Resultado");

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
                    String columna7 = table.getValueAt(seleccion,6).toString();

                    modificarResultado Resultado = new modificarResultado (columna1,columna2,columna3,columna4,columna5,columna6,columna7);
                    //TablaCargarResultados.this.dispose();
                    TablaCargarResultados.this.setVisible(false);
                    Resultado.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione un Resultado para modificarlo");
                }

            }
        });

        volverAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaCargarResultados.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });


        EliminarResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if(seleccion != -1){
                    String columna1 = table.getValueAt(seleccion,0).toString();
                    int id1int = Integer.parseInt(columna1);
                    controller.bajaResultado(id1int);
                    JOptionPane.showMessageDialog(null,"Resultado eliminada correctamente");
                    TablaCargarResultados tablaCargarResultados = new TablaCargarResultados("tabla Cargar Resultado");
                    TablaCargarResultados.this.setVisible(false);
                    tablaCargarResultados.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar, seleccione el Resultado a eliminar");
                }

            }
        });




        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                sorter5.setRowFilter(RowFilter.regexFilter(id.getText(),0));
            }
        });



    }


}
*/