package GUI;

import Controlador.ControllerPeticiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaPacientes extends JFrame{

    private CustomTableModel tableModel;
    private CustomTableModel tableModel2;

    private JTable table;
    private ControllerPeticiones controller;

    public TablaPacientes(String title){
        super(title);

        setBounds(30,20,500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = ControllerPeticiones.getInstance();
        tableModel = new CustomTableModel(controller.imprimirLista());
        table = new JTable(tableModel);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(450,350));
        JPanel panel = new JPanel();
        JButton volverAtras = new JButton("Volver al Menú");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverAtras);

        panel.add(buttonPanel);
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);

        volverAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaPacientes.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });

}}
