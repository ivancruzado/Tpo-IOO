package GUI;
import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;
import DTO.PacientesDTO;
import DTO.SucursalesDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
        etiqueta7.setBounds(15,350,100,30);
        panel.add(etiqueta7);
    }


    private void botones(){

        JTextField idPeticion = new JTextField();
        idPeticion.setBounds(160, 50, 250, 30);
        panel.add(idPeticion);
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
            idSucursalArray[i] = idSucursales[i];
            pacientesArray[i] = paciente.get(i).getDni();
        }
        JComboBox<Integer> pacientesComboBox = new JComboBox<>(pacientesArray);
        pacientesComboBox.setBounds(160,150,250,30);
        panel.add(pacientesComboBox);



        JButton boton1 = new JButton("Agregar");
        boton1.setBounds(160, 400, 100, 30);
        boton1.setFont(new Font("Arial", Font.BOLD, 14));
        boton1.setForeground(Color.white);
        boton1.setBackground(new Color(220, 118, 51));
        boton1.setFocusPainted(false);
        panel.add(boton1);

        JButton boton2Volver = new JButton("Volver a Menu");
        boton2Volver.setBounds(300, 400, 150, 30);
        panel.add(boton2Volver);

        ActionListener oyente = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String a = idPeticion.getText();

                //String c = direccion.getText();
                //String d = responsableTec.getText();

                int aa = Integer.parseInt(a);


                /*controller.altaSucursal(new SucursalesDTO(aa,bb,c,d));


                idSucursal.setText("");
                numero.setText("");
                direccion.setText("");;
                responsableTec.setText("");*/
            }
        };
        boton1.addActionListener(oyente);

        boton2Volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAltaPeticiones.this.dispose();
                PeticionesPrincipal peticionesPrincipal = new PeticionesPrincipal();
                peticionesPrincipal.setVisible(true);
            }
        });

    }
}
