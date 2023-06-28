package GUI;

import Controlador.ControllerUsuarios;
import DTO.UsuarioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ModificarUsuario extends JFrame{

    private JTextField DNI;
    private JTextField Usuario;

    private JTextField Nombre;

    private JTextField Domicilio;

    private JTextField Mail;

    private JTextField Edad;


    private JPanel AltaUsurious;

    private JComboBox ROLES;

    public ModificarUsuario(String UNO, String DOS, String TRES, String CUATRO) {


        setBackground(Color.gray);
        setTitle("Vista de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setBounds(20, 50, 200, 30);

        JTextField DNI = new JTextField(TRES);
        DNI.setBounds(250, 50, 200, 30);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 80, 200, 30);

        JTextField Nombre = new JTextField(UNO);
        Nombre.setBounds(250, 80, 200, 30);

        JLabel lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(20, 110, 200, 30);

        JTextField Domicilio = new JTextField(DOS);
        Domicilio.setBounds(250, 110, 200, 30);

        JLabel lblMail = new JLabel("Mail:");
        lblMail.setBounds(20, 140, 200, 30);

        JTextField Mail = new JTextField(CUATRO);
        Mail.setBounds(250, 140, 200, 30);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 170, 200, 30);

        JTextField Edad = new JTextField();
        Edad.setBounds(250, 170, 200, 30);

        JLabel lblrol = new JLabel("Rol:");
        lblrol.setBounds(20, 260, 200, 30);

        JComboBox<String> ROLES = new JComboBox<String>();
        ROLES.addItem("Administrador");
        ROLES.addItem("Laboratorista");
        ROLES.addItem("Recepcionista");

        ROLES.setBounds(250, 260, 200, 30);


        JButton botonVolver = new JButton("Volver a Menú");
        botonVolver.setBounds(20, 300, 150, 30);

        JButton Guardar = new JButton("Guardar");
        Guardar.setBounds(200, 300, 150, 30);

        add(lblDNI);
        add(DNI);
        add(lblNombre);
        add(Nombre);
        add(lblDomicilio);
        add(Domicilio);
        add(lblMail);
        add(Mail);
        add(lblEdad);
        add(Edad);
        add(lblrol);
        add(ROLES);
        add(Guardar);

        add(botonVolver);
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                  //  UsuarioDTO usuariodto = new UsuarioDTO(DNI.getText(), Nombre.getText(),  ,Integer.parseInt(Edad.getText()), pword, ROLES.getSelectedItem().toString());
                ControllerUsuarios.ModificarUsuario(DNI.getText(),Domicilio.getText(),Mail.getText(),Nombre.getText());


                    JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
                    ModificarUsuario.this.dispose();

              //      Menu menu = new Menu();
                //    menu.setVisible(true);
                    TablaUsuarios listarUsuarios = new TablaUsuarios("tabla usuarios");
                    listarUsuarios.setVisible(true);


            }
        });



        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificarUsuario.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
        }


        private void createUIComponents() {
                // TODO: place custom component creation code here
        }






}
