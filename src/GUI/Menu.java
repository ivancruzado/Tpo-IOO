package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    //public JPanel Menu;
    public JPanel panel1;


    public Menu(){
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema de Laboratorio");
        setLocationRelativeTo(null);
        setVisible(true);
        componentes();
    }

    private void componentes(){
        paneles();
        botonesInicio();
    }

    private void paneles(){

        panel1 = new JPanel();
        panel1.setBackground(Color.gray);
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 700, 700);

    }

    private void botonesInicio(){

        JButton botonPacientes = new JButton("Alta Pacientes");
        botonPacientes.setBounds(300, 300, 150, 30);
        panel1.add(botonPacientes);

        JButton botonUsuarios = new JButton("Alta Usuarios");
        botonUsuarios.setBounds(300, 400, 150, 30);
        panel1.add(botonUsuarios);

        botonPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                VentanaAltaPacientes ventanaAltaPacientes = new VentanaAltaPacientes();
                ventanaAltaPacientes.setVisible(true);
            }
        });

        getContentPane().setLayout(null);
        getContentPane().add(panel1);

        botonUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                AltaUsurious altaUsurious = new AltaUsurious();
                altaUsurious.setVisible(true);
            }
        });

        getContentPane().setLayout(null);
        getContentPane().add(panel1);
    }

}




