package GUI;
import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;
import DTO.PacientesDTO;
import DTO.PeticionesDTO;
import DTO.PracticasDTO;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;


public class VentanaAltaPeticiones extends JFrame {
    public JPanel panel;
    private ControllerPeticiones controller;
    private ControllerSucursales controller2;


    public VentanaAltaPeticiones(){
        setSize(700,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        controller = ControllerPeticiones.getInstance();
        controller2 = ControllerSucursales.getInstance();
        componentes();

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
        JLabel etiqueta = new JLabel("Id Peticion",SwingConstants.CENTER);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setBounds(15,50,100,30);
        panel.add(etiqueta);
        JLabel etiqueta2 = new JLabel("ID Sucursal",SwingConstants.CENTER);
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
        JLabel etiqueta5 = new JLabel("Fecha Alta",SwingConstants.CENTER);
        etiqueta5.setForeground(Color.WHITE);
        etiqueta5.setBounds(15,250,100,30);
        panel.add(etiqueta5);
        JLabel etiqueta6 = new JLabel("Practicas Asociadas",SwingConstants.CENTER);
        etiqueta6.setForeground(Color.WHITE);
        etiqueta6.setBounds(15,300,100,30);
        panel.add(etiqueta6);
        JLabel etiqueta7 = new JLabel("Fecha Entrega",SwingConstants.CENTER);
        etiqueta7.setForeground(Color.WHITE);
        etiqueta7.setBounds(15,360,100,30);
        panel.add(etiqueta7);
        JLabel etiqueta8 = new JLabel("Estado",SwingConstants.CENTER);
        etiqueta8.setForeground(Color.WHITE);
        etiqueta8.setBounds(15,400,100,30);
        panel.add(etiqueta8);
    }


    private void botones(){

        JTextField idPeticion = new JTextField();
        idPeticion.setBounds(160, 50, 250, 30);
        panel.add(idPeticion);
        /*JTextField idSucursal = new JTextField();
        idSucursal.setBounds(160, 100, 250, 30);
        panel.add(idSucursal);
         */
        int[] idSucursales = controller2.getIdSucursal();
        Integer[] idSucursalArray = new Integer[idSucursales.length];
        for (int i = 0; i < idSucursales.length; i++) {
            idSucursalArray[i] = idSucursales[i];
        }
        JComboBox<Integer> idSucursalComboBox = new JComboBox<>(idSucursalArray);
        idSucursalComboBox.setBounds(160,100,250,30);
        panel.add(idSucursalComboBox);

        List<PacientesDTO> paciente = controller.getAll();
        Integer[] pacientesArray = new Integer[paciente.size()];
        for (int i = 0; i < pacientesArray.length; i++) {
            pacientesArray[i] = paciente.get(i).getDni();
        }
        JComboBox<Integer> pacientesComboBox = new JComboBox<>(pacientesArray);
        pacientesComboBox.setBounds(160,150,250,30);
        panel.add(pacientesComboBox);

        JTextField obraSocial = new JTextField();
        obraSocial.setBounds(160, 200, 250, 30);
        panel.add(obraSocial);

        JTextField FechaAlta = new JTextField();
        FechaAlta.setBounds(160, 250, 250, 30);
        panel.add(FechaAlta);

        List<PracticasDTO> practicas = controller.getAll2();
        String[] practicasArray = new String[paciente.size()+1];
        practicasArray[0] = " ";
        for (int i = 1; i < practicasArray.length; i++) {

            practicasArray[i] = practicas.get(i-1).getNombrePractica();
        }
        JComboBox<String> practicasComboBox = new JComboBox<>(practicasArray);
        practicasComboBox.setBounds(160,300,250,30);
        panel.add(practicasComboBox);



        JTextField FechaEntrega = new JTextField();
        FechaEntrega.setBounds(160, 360, 250, 30);
        panel.add(FechaEntrega);

        JTextField estado = new JTextField("Iniciado");
        estado.setBounds(160, 400, 250, 30);
        panel.add(estado);


        JButton boton1 = new JButton("Agregar");
        boton1.setBounds(160, 450, 100, 30);
        boton1.setFont(new Font("Arial", Font.BOLD, 14));
        boton1.setForeground(Color.white);
        boton1.setBackground(new Color(220, 118, 51));
        boton1.setFocusPainted(false);
        panel.add(boton1);

        JButton boton2Volver = new JButton("Volver a Menu");
        boton2Volver.setBounds(300, 450, 150, 30);
        panel.add(boton2Volver);

        practicasComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> practicasComboBox2 = new JComboBox<>(practicasArray);
                practicasComboBox2.setBounds(450,300,200,30);
                panel.add(practicasComboBox2);

            }
        });

        ActionListener oyente = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String a = idPeticion.getText();
                int b = idSucursalComboBox.getSelectedIndex();
                int bb = idSucursalArray[b];
                int c = pacientesComboBox.getSelectedIndex();
                int dni = pacientesArray[c];
                PacientesDTO pacienteDTO = controller.buscarPacientePorDNI(dni);
                String d = obraSocial.getText();
                String ee = FechaAlta.getText();
                int f = practicasComboBox.getSelectedIndex();
                String practica = practicasArray[f];
                PracticasDTO practicaDTO = controller.buscarPracticaPorNombre(practica);
                String g = FechaEntrega.getText();
                String h = estado.getText();

                int aa = Integer.parseInt(a);

                controller.altaPeticiones(new PeticionesDTO(aa,bb,ControllerPeticiones.toModel(pacienteDTO),d,ee,ControllerPeticiones.toModel2(practicaDTO),g,h));

                idPeticion.setText("");
                obraSocial.setText("");
                FechaAlta.setText("");
                FechaEntrega.setText("");
                estado.setText("");
            }
        };
        boton1.addActionListener(oyente);

        boton2Volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAltaPeticiones.this.dispose();
                Menu menu = new Menu("Recepcionista");
                menu.setVisible(true);
            }
        });

    }
}
