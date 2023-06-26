package GUI;

import Controlador.ControllerPeticiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticasPrincipal extends JFrame {
    public JPanel panel;

    public PracticasPrincipal() {
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        componentes();

    }

    private void componentes() {
        paneles();
        Etiquetas();
        botones();
    }

    private void paneles() {
        panel = new JPanel();
        panel.setBackground(new Color(57, 73, 82));
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void Etiquetas() {

    }


    private void botones() {

        JButton boton1 = new JButton("Alta Practicas");
        boton1.setBounds(150, 100, 150, 30);
        boton1.setFont(new Font("Arial", Font.BOLD, 14));
        boton1.setForeground(Color.white);
        boton1.setBackground(new Color(220, 118, 51));
        boton1.setFocusPainted(false);
        panel.add(boton1);

        JButton verPracticas = new JButton("Ver Practicas");
        verPracticas.setBounds(150, 200, 150, 30);
        panel.add(verPracticas);

        JButton botonVolver = new JButton("Volver al menu");
        botonVolver.setBounds(150, 300, 150, 30);
        panel.add(botonVolver);

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PracticasPrincipal.this.dispose();
                VentanaAltaPracticas ventanaAltaPracticas = new VentanaAltaPracticas();
                ventanaAltaPracticas.setVisible(true);
            }
        });

        verPracticas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PracticasPrincipal.this.setVisible(false);
                TablaPracticas tablaPracticas = new TablaPracticas("tabla practicas");
                tablaPracticas.setVisible(true);
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PracticasPrincipal.this.dispose();
                Menu menu = new Menu("Recepcionista");
                menu.setVisible(true);
            }
        });

    }
}