package GUI;

import Controlador.ControllerPeticiones;
import Controlador.ControllerUsuarios;
import DTO.ResultadosDTO;
import DTO.UsuarioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;


public class AltaResultados extends JFrame{

    public ControllerPeticiones controller;

    public AltaResultados() {

        controller = ControllerPeticiones.getInstance();

        setBackground(Color.gray);
        setTitle("Alta de resultado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);

        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        JLabel lblIDResultado = new JLabel("Id resultado:");
        JTextField IDResultado = new JTextField();

        lblIDResultado.setBounds(20, 50, 200, 30);
        IDResultado.setBounds(250, 50, 200, 30);


        JLabel lblpractica = new JLabel("Cod Practica:");
        JTextField CodigoPractica = new JTextField();

        lblpractica.setBounds(20, 80, 200, 30);
        CodigoPractica.setBounds(250, 80, 200, 30);


        JTextField Nombre = new JTextField();
        JLabel lblNombre = new JLabel("Nombre de Pratica:");

        lblNombre.setBounds(20, 110, 200, 30);
        Nombre.setBounds(250, 110, 200, 30);


        JLabel lblReservado = new JLabel("Reservado:");
        JCheckBox Reservado = new JCheckBox();
        lblReservado.setBounds(20, 140, 200, 30);
        Reservado.setBounds(250, 140, 200, 30);

        JLabel lblTiempo = new JLabel("Tiempo Estimado");
        JTextField TiempoEstimado = new JTextField();

        lblTiempo.setBounds(20, 170, 200, 30);
        TiempoEstimado.setBounds(250,170,200,30);


        JLabel lblvalor = new JLabel("valor");
        JTextField valor = new JTextField();

        valor.setBounds(250,200,200,30);
        lblvalor.setBounds(20,200,200,30);

        JButton botonVolver = new JButton("Volver a Menú");

        JButton Guardar = new JButton("Guardar");

        botonVolver.setBounds(20, 300, 150, 30);
        Guardar.setBounds(200, 300, 150, 30);

        add(lblIDResultado);
        add(lblTiempo);
        add(lblNombre);
        add(lblReservado);
        add(lblvalor);
        add(lblpractica);
        add(lblTiempo);
        add(CodigoPractica);
        add(IDResultado);
        add(Nombre);
        add(Reservado);
        add(TiempoEstimado);
        add(CodigoPractica);
        add(valor);


        add(Guardar);

        add(botonVolver);
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                   ResultadosDTO Resultados = new ResultadosDTO(Integer.parseInt(IDResultado.getText()),Integer.parseInt(CodigoPractica.getText()), true,Reservado.isSelected(),Integer.parseInt( TiempoEstimado.getText()),Integer.parseInt(valor.getText()));
                   ControllerPeticiones.altaResultados(Resultados);

                    JOptionPane.showMessageDialog(null, "Resultado Cargado");
                    AltaResultados.this.dispose();


                    TablaResultados listarresultados = new TablaResultados();
                    listarresultados.setVisible(true);


            }
        });



        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AltaResultados.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
    }


        private void createUIComponents() {
                // TODO: place custom component creation code here
        }






}
