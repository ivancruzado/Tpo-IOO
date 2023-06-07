package GUI;

import Controlador.ControllerPeticiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    //public JPanel Menu;
    public JPanel panel1;


    public Menu(){
        setSize(700,600);
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

        JButton botonUsuarios = new JButton("Alta Usuarios");
        botonUsuarios.setBounds(60, 300, 150, 30);
        panel1.add(botonUsuarios);

        JButton botonPacientes = new JButton("Pacientes");
        botonPacientes.setBounds(60, 400, 150, 30);
        panel1.add(botonPacientes);


        JButton Practicas = new JButton("Practicas");
        Practicas.setBounds(60, 200, 150, 30);
        panel1.add(Practicas);

        JButton sucursales = new JButton("Sucursales");
        sucursales.setBounds(60, 100, 150, 30);
        panel1.add(sucursales);

        botonUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                AltaUsurious altaUsurious = new AltaUsurious();
                altaUsurious.setVisible(true);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(panel1);

        botonPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                PacientesPrincipal pacientesPrincipal = new PacientesPrincipal();
                pacientesPrincipal.setVisible(true);
            }
        });

        Practicas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                PracticasPrincipal practicasPrincipal = new PracticasPrincipal();
                practicasPrincipal.setVisible(true);
            }
        });
        sucursales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                SucursalesPrincipal sucursalesPrincipal = new SucursalesPrincipal();
                sucursalesPrincipal.setVisible(true);
            }
        });




    }

}




