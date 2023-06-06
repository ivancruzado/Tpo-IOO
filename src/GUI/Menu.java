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

        JButton botonPacientes = new JButton("Alta Pacientes");
        botonPacientes.setBounds(300, 400, 150, 30);
        panel1.add(botonPacientes);

        JButton botonUsuarios = new JButton("Alta Usuarios");
        botonUsuarios.setBounds(300, 300, 150, 30);
        panel1.add(botonUsuarios);

        JButton botonBusquedaPaciente = new JButton("Busqueda por DNI");
        botonBusquedaPaciente.setBounds(300, 500, 150, 30);
        panel1.add(botonBusquedaPaciente);

        JButton TablaPacientes = new JButton("Tabla de pacientes");
        TablaPacientes.setBounds(300, 450, 150, 30);
        panel1.add(TablaPacientes);

        JButton Practicas = new JButton("Practicas");
        Practicas.setBounds(300, 200, 150, 30);
        panel1.add(Practicas);

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


        botonBusquedaPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControllerPeticiones.getInstance().imprimirLista();
                Menu.this.setVisible(false);
                TablaPacienteEncontrado tablaPacienteEncontrado = new TablaPacienteEncontrado("Busqueda por DNI");
                tablaPacienteEncontrado.setVisible(true);
            }
        });



        TablaPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                TablaPacientes tablaPacientes = new TablaPacientes("Tabla de pacientes");

                tablaPacientes.setVisible(true);
            }
        });

        Practicas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                PracticasPrincipal practicasPrincipal = new PracticasPrincipal();
                practicasPrincipal.setVisible(true);
            }
        });




    }

}




