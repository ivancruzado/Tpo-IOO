package GUI;

import Controlador.ControllerPeticiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SucursalesPrincipal extends JFrame {
    public JPanel panel;

    public SucursalesPrincipal() {
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        componentes();
    }

    private void componentes() {
        paneles();
        botones();
    }

    private void paneles() {
        panel = new JPanel();
        panel.setBackground(new Color(57, 73, 82));
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }



    private void botones() {

        JButton altaSucursal = new JButton("Alta Sucursal");
        altaSucursal.setBounds(150, 100, 150, 30);
        altaSucursal.setFont(new Font("Arial", Font.BOLD, 14));
        altaSucursal.setForeground(Color.white);
        altaSucursal.setBackground(new Color(220, 118, 51));
        altaSucursal.setFocusPainted(false);
        panel.add(altaSucursal);

        JButton verSucursales = new JButton("Ver Sucursales");
        verSucursales.setBounds(150, 200, 150, 30);
        panel.add(verSucursales);

        JButton botonVolver = new JButton("Volver al menu");
        botonVolver.setBounds(150, 300, 150, 30);
        panel.add(botonVolver);

        altaSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SucursalesPrincipal.this.dispose();
                VentanaAltaSucursal ventanaAltaSucursal = new VentanaAltaSucursal();
                ventanaAltaSucursal.setVisible(true);
            }
        });

        verSucursales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SucursalesPrincipal.this.setVisible(false);
                TablaSucursales tablaSucursales = new TablaSucursales("tabla sucursales");
                tablaSucursales.setVisible(true);
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SucursalesPrincipal.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });

    }
}
