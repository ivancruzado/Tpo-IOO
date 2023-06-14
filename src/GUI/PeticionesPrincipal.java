package GUI;

import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeticionesPrincipal extends JFrame {
    public JPanel panel;

    public PeticionesPrincipal() {
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

        JButton altaPeticion = new JButton("Alta Peticiones");
        altaPeticion.setBounds(150, 100, 150, 30);
        altaPeticion.setFont(new Font("Arial", Font.BOLD, 14));
        altaPeticion.setForeground(Color.white);
        altaPeticion.setBackground(new Color(220, 118, 51));
        altaPeticion.setFocusPainted(false);
        panel.add(altaPeticion);

        JButton verPeticiones = new JButton("Ver Peticiones");
        verPeticiones.setBounds(150, 200, 150, 30);
        panel.add(verPeticiones);

        JButton botonVolver = new JButton("Volver al menu");
        botonVolver.setBounds(150, 300, 150, 30);
        panel.add(botonVolver);

        altaPeticion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PeticionesPrincipal.this.dispose();
                VentanaAltaPeticiones ventanaAltaPeticiones = new VentanaAltaPeticiones();
                ventanaAltaPeticiones.setVisible(true);
            }
        });

        verPeticiones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControllerPeticiones.getInstance();
                ControllerSucursales.getInstance();
                PeticionesPrincipal.this.setVisible(false);
                TablaPeticiones tablaPeticiones = new TablaPeticiones("tabla peticiones");
                tablaPeticiones.setVisible(true);
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PeticionesPrincipal.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });

    }
}
