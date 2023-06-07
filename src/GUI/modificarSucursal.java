package GUI;

import Controlador.ControllerSucursales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modificarSucursal extends JFrame {
    public JPanel panel;
    private JTextField idSucursal;
    private JTextField numero;
    private JTextField direccion;
    private JTextField Responsable;
    private ControllerSucursales controller;
    public modificarSucursal(String column1Value, String column2Value, String column3Value, String column4Value){
        setSize(700,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        controller = ControllerSucursales.getInstance();
        panel = new JPanel();
        panel.setBackground(new Color(57, 73, 82));
        panel.setLayout(null);
        this.setContentPane(panel);

        idSucursal = new JTextField(column1Value);
        idSucursal.setBounds(160, 50, 250, 30);
        panel.add(idSucursal);

        numero = new JTextField(column2Value);
        numero.setBounds(160, 100, 250, 25);
        panel.add(numero);

        direccion = new JTextField(column3Value);
        direccion.setBounds(160, 150, 250, 30);
        panel.add(direccion);

        Responsable = new JTextField(column4Value);
        Responsable.setBounds(160, 200, 250, 30);
        panel.add(Responsable);

        componentes();
    }
    private void componentes(){
        Etiquetas();
        botones();
    }

    private void Etiquetas(){
        JLabel etiqueta = new JLabel("Id Sucursal",SwingConstants.CENTER);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setBounds(15,50,100,30);
        panel.add(etiqueta);
        JLabel etiqueta2 = new JLabel("Numero",SwingConstants.CENTER);
        etiqueta2.setForeground(Color.WHITE);
        etiqueta2.setBounds(15,100,100,30);
        panel.add(etiqueta2);
        JLabel etiqueta3 = new JLabel("Direccion",SwingConstants.CENTER);
        etiqueta3.setForeground(Color.WHITE);
        etiqueta3.setBounds(15,150,100,30);
        panel.add(etiqueta3);
        JLabel etiqueta4 = new JLabel("Responsable tecnico",SwingConstants.CENTER);
        etiqueta4.setForeground(Color.WHITE);
        etiqueta4.setBounds(15,200,100,30);
        panel.add(etiqueta4);
    }

    private void botones() {

        JButton boton1 = new JButton("Modificar");
        boton1.setBounds(160, 350, 100, 30);
        boton1.setFont(new Font("Arial", Font.BOLD, 14));
        boton1.setForeground(Color.white);
        boton1.setBackground(new Color(220, 118, 51));
        boton1.setFocusPainted(false);
        panel.add(boton1);

        JButton botonVolver = new JButton("Volver atras");
        botonVolver.setBounds(300, 350, 150, 30);
        panel.add(botonVolver);

        ActionListener oyente = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String a = idSucursal.getText();
                String b = numero.getText();
                String c =direccion.getText();
                String d = Responsable.getText();

                int aa = Integer.parseInt(a);
                int bb = Integer.parseInt(b);

                controller.modificarSucursal(aa,bb,c,d);
                JOptionPane.showMessageDialog(null,"Sucursal modificada correctamente");
                modificarSucursal.this.dispose();
                TablaSucursales tablaSucursales = new TablaSucursales("Tabla sucursales");
                tablaSucursales.setVisible(true);
            }
        };
        boton1.addActionListener(oyente);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarSucursal.this.dispose();
                TablaSucursales tablaSucursales = new TablaSucursales("tabla sucursales");
                tablaSucursales.setVisible(true);
            }
        });


    }
}