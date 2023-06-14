package GUI;

import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modificarPeticion extends JFrame {
    public JPanel panel;
    private JTextField idPeticion;
    private JTextField sucursalID;
    private JTextField paciente;
    private JTextField ObraSocial;
    private JTextField fechaCarga;
    private JTextField practicasAsoc;
    private JTextField fechaEntrega;
    private JTextField estado;
    private ControllerPeticiones controller;
    public modificarPeticion(String column1Value, String column2Value, String column3Value, String column4Value,String column5Value,String column6Value,String column7Value,String column8Value){
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

        idPeticion = new JTextField(column1Value);
        idPeticion.setBounds(160, 50, 250, 30);
        panel.add(idPeticion);

        sucursalID = new JTextField(column2Value);
        sucursalID.setBounds(160, 100, 250, 25);
        panel.add(sucursalID);

        paciente = new JTextField(column3Value);
        paciente.setBounds(160, 150, 250, 30);
        panel.add(paciente);

        ObraSocial = new JTextField(column4Value);
        ObraSocial.setBounds(160, 200, 250, 30);
        panel.add(ObraSocial);

        fechaCarga = new JTextField(column5Value);
        fechaCarga.setBounds(160, 250, 250, 30);
        panel.add(fechaCarga);

        practicasAsoc = new JTextField(column6Value);
        practicasAsoc.setBounds(160, 300, 250, 30);
        panel.add(practicasAsoc);

        fechaEntrega = new JTextField(column7Value);
        fechaEntrega.setBounds(160, 350, 250, 30);
        panel.add(fechaEntrega);

        estado = new JTextField(column8Value);
        estado.setBounds(160, 400, 250, 30);
        panel.add(estado);
        componentes();

        idPeticion.setEnabled(false);
        paciente.setEnabled(false);
        practicasAsoc.setEnabled(false);
    }
    private void componentes(){
        Etiquetas();
        botones();
    }

    private void Etiquetas(){
        JLabel etiqueta = new JLabel("Id Peticion",SwingConstants.CENTER);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setBounds(15,50,100,30);
        panel.add(etiqueta);
        JLabel etiqueta2 = new JLabel("Id Sucursal",SwingConstants.CENTER);
        etiqueta2.setForeground(Color.WHITE);
        etiqueta2.setBounds(15,100,100,30);
        panel.add(etiqueta2);
        JLabel etiqueta3 = new JLabel("Paciente",SwingConstants.CENTER);
        etiqueta3.setForeground(Color.WHITE);
        etiqueta3.setBounds(15,150,100,30);
        panel.add(etiqueta3);
        JLabel etiqueta4 = new JLabel("Obra Social",SwingConstants.CENTER);
        etiqueta4.setForeground(Color.WHITE);
        etiqueta4.setBounds(15,200,100,30);
        panel.add(etiqueta4);
        JLabel etiqueta5 = new JLabel("Fecha Carga",SwingConstants.CENTER);
        etiqueta5.setForeground(Color.WHITE);
        etiqueta5.setBounds(15,250,100,30);
        panel.add(etiqueta5);
        JLabel etiqueta6 = new JLabel("Practicas Asociadas",SwingConstants.CENTER);
        etiqueta6.setForeground(Color.WHITE);
        etiqueta6.setBounds(15,300,100,30);
        panel.add(etiqueta6);
        JLabel etiqueta7 = new JLabel("Fecha Entrega",SwingConstants.CENTER);
        etiqueta7.setForeground(Color.WHITE);
        etiqueta7.setBounds(15,350,100,30);
        panel.add(etiqueta7);
        JLabel etiqueta8 = new JLabel("Estado",SwingConstants.CENTER);
        etiqueta8.setForeground(Color.WHITE);
        etiqueta8.setBounds(15,400,100,30);
        panel.add(etiqueta8);

    }

    private void botones() {

        JButton boton1 = new JButton("Modificar");
        boton1.setBounds(160, 450, 100, 30);
        boton1.setFont(new Font("Arial", Font.BOLD, 14));
        boton1.setForeground(Color.white);
        boton1.setBackground(new Color(220, 118, 51));
        boton1.setFocusPainted(false);
        panel.add(boton1);

        JButton botonVolver = new JButton("Volver atras");
        botonVolver.setBounds(300, 450, 150, 30);
        panel.add(botonVolver);

        ActionListener oyente = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String id = idPeticion.getText();
                String a = sucursalID.getText();
                String b = ObraSocial.getText();
                String c =fechaCarga.getText();
                String d = fechaEntrega.getText();
                String ee = estado.getText();

                int aa = Integer.parseInt(a);
                int idInt = Integer.parseInt(id);

                controller.modificarPeticiones(idInt,aa,b,c,d,ee);
                JOptionPane.showMessageDialog(null,"Sucursal modificada correctamente");
                modificarPeticion.this.dispose();
                TablaPeticiones tablaPeticiones = new TablaPeticiones("Tabla Peticiones");
                tablaPeticiones.setVisible(true);
            }
        };
        boton1.addActionListener(oyente);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarPeticion.this.dispose();
                TablaPeticiones tablaPeticiones = new TablaPeticiones("Tabla Peticiones");
                tablaPeticiones.setVisible(true);
            }
        });


    }
}