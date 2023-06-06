package GUI;

import Controlador.ControllerPeticiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modificarPractica extends JFrame {
    public JPanel panel;
    private int index;
    private JTextField practicaID;
    private JTextField codigoPractica;
    private JTextField nombrePractica;
    private JTextField grupo;
    private JTextField tiempoResultado;
    private JTextField deshabilitado;
    private ControllerPeticiones controller;
    public modificarPractica(String column1Value, String column2Value, String column3Value, String column4Value, String column5Value, String column6Value){
        setSize(700,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        controller = ControllerPeticiones.getInstance();
        panel = new JPanel();
        panel.setBackground(new Color(57, 73, 82));
        panel.setLayout(null);
        this.setContentPane(panel);

        practicaID = new JTextField(column1Value);
        practicaID.setBounds(160, 50, 250, 30);
        panel.add(practicaID);

        codigoPractica = new JTextField(column2Value);
        codigoPractica.setBounds(160, 100, 250, 25);
        panel.add(codigoPractica);

        nombrePractica = new JTextField(column3Value);
        nombrePractica.setBounds(160, 150, 250, 30);
        panel.add(nombrePractica);

        grupo = new JTextField(column4Value);
        grupo.setBounds(160, 200, 250, 30);
        panel.add(grupo);

        tiempoResultado = new JTextField(column5Value);
        tiempoResultado.setBounds(160, 250, 250, 30);
        panel.add(tiempoResultado);

        deshabilitado = new JTextField(column6Value);
        deshabilitado.setBounds(160, 300, 250, 30);
        panel.add(deshabilitado);


        componentes();

    }
    private void componentes(){
        paneles();
        Etiquetas();
        botones();
    }

    private void paneles(){

    }
    private void Etiquetas(){
        JLabel etiqueta = new JLabel("Practica ID",SwingConstants.CENTER);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setBounds(15,50,100,30);
        panel.add(etiqueta);
        JLabel etiqueta2 = new JLabel("Codigo de practica",SwingConstants.CENTER);
        etiqueta2.setForeground(Color.WHITE);
        etiqueta2.setBounds(15,100,100,30);
        panel.add(etiqueta2);
        JLabel etiqueta3 = new JLabel("Nombre Practica",SwingConstants.CENTER);
        etiqueta3.setForeground(Color.WHITE);
        etiqueta3.setBounds(15,150,100,30);
        panel.add(etiqueta3);
        JLabel etiqueta4 = new JLabel("Grupo",SwingConstants.CENTER);
        etiqueta4.setForeground(Color.WHITE);
        etiqueta4.setBounds(15,200,100,30);
        panel.add(etiqueta4);
        JLabel etiqueta5 = new JLabel("Tiempo Resultado",SwingConstants.CENTER);
        etiqueta5.setForeground(Color.WHITE);
        etiqueta5.setBounds(15,250,100,30);
        panel.add(etiqueta5);
        JLabel etiqueta6 = new JLabel("Deshabilitar",SwingConstants.CENTER);
        etiqueta6.setForeground(Color.WHITE);
        etiqueta6.setBounds(15,300,100,30);
        panel.add(etiqueta6);

    }

    private void botones() {

        JButton boton1 = new JButton("Modificar");
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
                String a = practicaID.getText();
                String b = codigoPractica.getText();
                String c = nombrePractica.getText();
                String d = grupo.getText();
                String e2 = tiempoResultado.getText();
                String f = deshabilitado.getText();

                int aa = Integer.parseInt(a);
                int bb = Integer.parseInt(b);
                int ee = Integer.parseInt(e2);
                boolean ff = Boolean.parseBoolean(f);
                controller.modificarPractica(aa,bb,c,d,ee,ff);
                JOptionPane.showMessageDialog(null,"Practica modificada correctamente");
                modificarPractica.this.dispose();
                TablaPracticas tablaPracticas = new TablaPracticas("Tabla Practicas");
                tablaPracticas.setVisible(true);
            }
        };
        boton1.addActionListener(oyente);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarPractica.this.dispose();
                TablaPracticas tablaPracticas = new TablaPracticas("Tabla Practicas");
                tablaPracticas.setVisible(true);
            }
        });


    }
}