package GUI;

import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAltaSucursal extends JFrame {
    public JPanel panel;
    private ControllerSucursales controller;
    public VentanaAltaSucursal(){
        setSize(700,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        controller = ControllerSucursales.getInstance();
        componentes();

    }
    private void componentes(){
        paneles();
        Etiquetas();
        botones();
    }

    private void paneles(){
        panel = new JPanel();
        panel.setBackground(new Color(57, 73, 82));
        panel.setLayout(null);
        this.getContentPane().add(panel);
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
        JLabel etiqueta4 = new JLabel("Responsable Tecnico",SwingConstants.CENTER);
        etiqueta4.setForeground(Color.WHITE);
        etiqueta4.setBounds(15,200,100,30);
        panel.add(etiqueta4);
    }


    private void botones(){

        JTextField idSucursal = new JTextField();
        idSucursal.setBounds(160, 50, 250, 30);
        panel.add(idSucursal);

        JTextField numero = new JTextField();
        numero.setBounds(160,100,250,25);
        panel.add(numero);

        JTextField direccion = new JTextField();
        direccion.setBounds(160,150,250,30);
        panel.add(direccion);

        JTextField responsableTec = new JTextField();
        responsableTec.setBounds(160,200,250,30);
        panel.add(responsableTec);


        JButton boton1 = new JButton("Agregar");
        boton1.setBounds(160, 350, 100, 30);
        boton1.setFont(new Font("Arial", Font.BOLD, 14));
        boton1.setForeground(Color.white);
        boton1.setBackground(new Color(220, 118, 51));
        boton1.setFocusPainted(false);
        panel.add(boton1);

        JButton botonVolver = new JButton("Volver a Menu");
        botonVolver.setBounds(300, 350, 150, 30);
        panel.add(botonVolver);

        ActionListener oyente = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String a = idSucursal.getText();
                String b = numero.getText();
                String c = direccion.getText();
                String d = responsableTec.getText();

                int aa = Integer.parseInt(a);
                int bb = Integer.parseInt(b);

                controller.altaSucursal(aa,bb,c,d);


                idSucursal.setText("");
                numero.setText("");
                direccion.setText("");;
                responsableTec.setText("");
            }
        };
        boton1.addActionListener(oyente);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAltaSucursal.this.dispose();
                SucursalesPrincipal sucursalesPrincipal = new SucursalesPrincipal();
                sucursalesPrincipal.setVisible(true);
            }
        });

    }
}

