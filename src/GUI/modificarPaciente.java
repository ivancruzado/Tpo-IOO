package GUI;

import Controlador.ControllerPeticiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class modificarPaciente extends JFrame {
    public JPanel panel;
    private JTextField dni;
    private JTextField edad;
    private JTextField domicilio;
    private JTextField sexo;
    private JTextField Mail;
    private JTextField nombre;
    private int index;
    private ControllerPeticiones controller;

    public modificarPaciente(String column1Value, String column2Value, String column3Value, String column4Value, String column5Value, String column6Value,int index){
        setSize(700,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        componentes();
        controller = ControllerPeticiones.getInstance();
        nombre = new JTextField(column2Value);
        nombre.setBounds(160, 50, 250, 30);
        panel.add(nombre);

        dni = new JTextField(column1Value);
        dni.setBounds(160,100,250,25);
        panel.add(dni);

        edad = new JTextField(column3Value);
        edad.setBounds(160,150,250,30);
        panel.add(edad);

        domicilio = new JTextField(column4Value);
        domicilio.setBounds(160,200,250,30);
        panel.add(domicilio);

        sexo = new JTextField(column5Value);
        sexo.setBounds(160,250,250,30);
        panel.add(sexo);

        Mail = new JTextField(column6Value);
        Mail.setBounds(160,300,250,30);
        panel.add(Mail);
        this.index = index;



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

        JButton boton1 = new JButton("modificar");
        boton1.setBounds(160, 350, 100, 30);
        boton1.setFont(new Font("Arial", Font.BOLD, 14));
        boton1.setForeground(Color.white);
        boton1.setBackground(new Color(220, 118, 51));
        boton1.setFocusPainted(false);
        panel.add(boton1);

        JButton botonVolver = new JButton("Volver atras");
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
                controller.modificarPaciente(bb,a,cc,f,d,e2);
                JOptionPane.showMessageDialog(null,"Paciente modificado correctamente");
                modificarPaciente.this.dispose();
                TablaPacienteEncontrado tablaPacienteEncontrado = new TablaPacienteEncontrado("Tabla busqueda");
                tablaPacienteEncontrado.setVisible(true);
            }
        };
        boton1.addActionListener(oyente);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarPaciente.this.dispose();
                TablaPacienteEncontrado tablaPacienteEncontrado = new TablaPacienteEncontrado("Tabla busqueda");
                tablaPacienteEncontrado.setVisible(true);
            }
        });





    }


}


