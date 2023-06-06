package GUI;
import Controlador.ControllerPeticiones;


import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TablaPracticas extends JFrame {

    private CustomTableModel2 tableModel2;
    private JTable table;
    private ControllerPeticiones controller;

    TableRowSorter<CustomTableModel2> sorter2;

    public TablaPracticas(String title) {
        super(title);

        setBounds(30,20,750,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = ControllerPeticiones.getInstance();
        tableModel2 = new CustomTableModel2(controller.getLista2());



        table = new JTable(tableModel2);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        sorter2 = new TableRowSorter<>(tableModel2);
        table.setRowSorter(sorter2);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700,600));
        JPanel panel = new JPanel();
        JTextField id = new JTextField();
        id.setPreferredSize(new Dimension(200, id.getPreferredSize().height));
        JLabel etiqueta = new JLabel("Id:");
        JButton botonBuscar = new JButton("Buscar");
        JButton volverAtras = new JButton("Volver atras");
        JButton EliminarPaciente = new JButton("Eliminar practica");
        JButton modificarPaciente = new JButton("Editar practica");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverAtras);
        buttonPanel.add(etiqueta);
        buttonPanel.add(id);
        buttonPanel.add(botonBuscar);
        buttonPanel.add(EliminarPaciente);
        buttonPanel.add(modificarPaciente);
        buttonPanel.add(volverAtras);

        panel.add(buttonPanel);

        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);



        modificarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if (seleccion != -1) {
                    String columna1 = table.getValueAt(seleccion,0).toString();
                    String columna2 = table.getValueAt(seleccion,1).toString();
                    String columna3 = table.getValueAt(seleccion,2).toString();
                    String columna4 = table.getValueAt(seleccion,3).toString();
                    String columna5 = table.getValueAt(seleccion,4).toString();
                    String columna6 = table.getValueAt(seleccion,5).toString();

                    modificarPractica practica = new modificarPractica(columna1,columna2,columna3,columna4,columna5,columna6);
                    TablaPracticas.this.dispose();
                    TablaPracticas.this.setVisible(false);
                    practica.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione una practica para modificarlo");
                }

            }
        });

        volverAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaPracticas.this.dispose();
                PracticasPrincipal practicasPrincipal = new PracticasPrincipal();
                practicasPrincipal.setVisible(true);
            }
        });

        EliminarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = table.getSelectedRow();
                if(seleccion != -1){
                    controller.bajaPractica(seleccion);
                    JOptionPane.showMessageDialog(null,"Practica eliminada correctamente");
                    TablaPracticas tablaPracticas = new TablaPracticas("tabla practicas");
                    TablaPracticas.this.setVisible(false);
                    tablaPracticas.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar, seleccione la practica a eliminar");
                }

            }
        });



        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String b = id.getText();
                int bb = Integer.parseInt(b);
                sorter2.setRowFilter(RowFilter.regexFilter(id.getText(),0));
            }
        });
    }
}
