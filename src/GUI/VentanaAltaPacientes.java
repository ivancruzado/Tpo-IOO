package GUI;

import Controlador.ControllerPeticiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAltaPacientes extends JFrame {
    public JPanel panel;
    public VentanaAltaPacientes(){
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        componentes();

    }
    private void componentes(){
        paneles();
        Etiquetas();
        botones();
    }

    private void paneles(){
        panel = new JPanel();
        panel.setBackground(Color.gray);
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
        nombre.setBounds(200,50,200,25);
        panel.add(nombre);

        JTextField dni = new JTextField();
        dni.setBounds(200,100,200,25);
        panel.add(dni);

        JTextField edad = new JTextField();
        edad.setBounds(200,150,200,25);
        panel.add(edad);

        JTextField domicilio = new JTextField();
        domicilio.setBounds(200,200,200,25);
        panel.add(domicilio);

        JTextField sexo = new JTextField();
        sexo.setBounds(200,250,200,25);
        panel.add(sexo);

        JTextField Mail = new JTextField();
        Mail.setBounds(200,300,200,25);
        panel.add(Mail);



        JButton boton1 = new JButton("Agregar");
        boton1.setBounds(500,500,100,30);
        panel.add(boton1);

        JButton botonVolver = new JButton("Volver a Menu");
        botonVolver.setBounds(300, 500, 150, 30);
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
                ControllerPeticiones.getInstance().guardarPaciente(a,bb,cc,d,e2,f);

                nombre.setText("");
                dni.setText("");
                edad.setText("");;
                domicilio.setText("");
                sexo.setText("");
                Mail.setText("");

                CustomTable myApp;
                try {
                    myApp = new CustomTable("Tabla Custom");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                myApp.setVisible(true);
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
