package GUI;

import Controlador.ControllerPeticiones;
import DTO.PacientesDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAltaPacientes extends JFrame {
    public JPanel panel;
    public ControllerPeticiones controller;
    public VentanaAltaPacientes(){
        setSize(700,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        controller = ControllerPeticiones.getInstance();
        componentes();
        setVisible(true);


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
        JLabel etiqueta = new JLabel("Nombre",SwingConstants.CENTER);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setBounds(15,50,100,30);
        panel.add(etiqueta);
        JLabel etiqueta2 = new JLabel("Dni",SwingConstants.CENTER);
        etiqueta2.setForeground(Color.WHITE);
        etiqueta2.setBounds(15,100,100,30);
        panel.add(etiqueta2);
        JLabel etiqueta3 = new JLabel("Edad",SwingConstants.CENTER);
        etiqueta3.setForeground(Color.WHITE);
        etiqueta3.setBounds(15,150,100,30);
        panel.add(etiqueta3);
        JLabel etiqueta4 = new JLabel("Domicilio",SwingConstants.CENTER);
        etiqueta4.setForeground(Color.WHITE);
        etiqueta4.setBounds(15,200,100,30);
        panel.add(etiqueta4);
        JLabel etiqueta5 = new JLabel("Sexo",SwingConstants.CENTER);
        etiqueta5.setForeground(Color.WHITE);
        etiqueta5.setBounds(15,250,100,30);
        panel.add(etiqueta5);
        JLabel etiqueta6 = new JLabel("Mail",SwingConstants.CENTER);
        etiqueta6.setForeground(Color.WHITE);
        etiqueta6.setBounds(15,300,100,30);
        panel.add(etiqueta6);


    }


    private void botones(){
        JTextField nombre = new JTextField();
        nombre.setBounds(160, 50, 250, 30);
        panel.add(nombre);

        JTextField dni = new JTextField();
        dni.setBounds(160,100,250,25);
        panel.add(dni);

        JTextField edad = new JTextField();
        edad.setBounds(160,150,250,30);
        panel.add(edad);

        JTextField domicilio = new JTextField();
        domicilio.setBounds(160,200,250,30);
        panel.add(domicilio);

        JTextField sexo = new JTextField();
        sexo.setBounds(160,250,250,30);
        panel.add(sexo);

        JTextField Mail = new JTextField();
        Mail.setBounds(160,300,250,30);
        panel.add(Mail);



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
                String a = nombre.getText();
                String b = dni.getText();
                String c = edad.getText();
                String d = domicilio.getText();
                String e2 = sexo.getText();
                String f = Mail.getText();

                int bb = Integer.parseInt(b);
                int cc = Integer.parseInt(c);

                controller.altaPaciente(new PacientesDTO(bb,a,d,f,e2,cc));

                nombre.setText("");
                dni.setText("");
                edad.setText("");;
                domicilio.setText("");
                sexo.setText("");
                Mail.setText("");

            }
        };
        boton1.addActionListener(oyente);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAltaPacientes.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);

            }
        });





    }


}
