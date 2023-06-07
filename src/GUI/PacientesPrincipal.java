package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacientesPrincipal extends JFrame {
    public JPanel panel;
    public PacientesPrincipal() {
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

        JButton altaPacientes = new JButton("Alta Pacientes");
        altaPacientes.setBounds(150, 100, 150, 30);
        altaPacientes.setFont(new Font("Arial", Font.BOLD, 14));
        altaPacientes.setForeground(Color.white);
        altaPacientes.setBackground(new Color(220, 118, 51));
        altaPacientes.setFocusPainted(false);
        panel.add(altaPacientes);

        JButton verPacientes = new JButton("Ver Pacientes");
        verPacientes.setBounds(150, 200, 150, 30);
        panel.add(verPacientes);

        JButton botonVolver = new JButton("Volver al menu");
        botonVolver.setBounds(150, 300, 150, 30);
        panel.add(botonVolver);


        altaPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PacientesPrincipal.this.dispose();
                VentanaAltaPacientes ventanaAltaPacientes = new VentanaAltaPacientes();
                ventanaAltaPacientes.setVisible(true);
            }
        });

        verPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PacientesPrincipal.this.setVisible(false);
                TablaPacienteEncontrado tablaPacienteEncontrado = new TablaPacienteEncontrado("Busqueda por DNI");
                tablaPacienteEncontrado.setVisible(true);
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PacientesPrincipal.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });

    }
}
