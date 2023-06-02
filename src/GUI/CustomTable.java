package GUI;



import Controlador.ControllerPeticiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomTable extends JFrame implements ActionListener {

    private CustomTableModel tableModel;
    private JTable table;
    private ControllerPeticiones controller;

    public CustomTable(String title) throws Exception {
        super(title);
        setBounds(30,20,380,280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = ControllerPeticiones.getInstance();
        tableModel = new CustomTableModel(controller.imprimirLista());
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(380,280));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent ae) {

    }
    public static void main(String[] args) throws Exception {
        CustomTable myApp = new CustomTable("Custom Table Model");
        myApp.setVisible(true);
    }
}
