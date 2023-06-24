package GUI;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DTO.SucursalesDTO;
import DTO.UsuarioDTO;
import Controlador.ControllerUsuarios;



public class AltaUsuario extends JFrame{

    private JTextField DNI;

    private JTextField Nombre;

    private JTextField Domicilio;

    private JTextField Mail;

    private JTextField Edad;

    private JPasswordField Password;

    private JPasswordField Password2;

    private JPanel AltaUsurious;


    private JComboBox ROLES;

    public AltaUsuario() {




        setBackground(Color.gray);
        setTitle("Vista de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setBounds(20, 50, 200, 30);

        JTextField DNI = new JTextField();
        DNI.setBounds(250, 50, 200, 30);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 80, 200, 30);

        JTextField Nombre = new JTextField();
        Nombre.setBounds(250, 80, 200, 30);

        JLabel lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(20, 110, 200, 30);

        JTextField Domicilio = new JTextField();
        Domicilio.setBounds(250, 110, 200, 30);

        JLabel lblMail = new JLabel("Mail:");
        lblMail.setBounds(20, 140, 200, 30);

        JTextField Mail = new JTextField();
        Mail.setBounds(250, 140, 200, 30);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 170, 200, 30);

        JTextField Edad = new JTextField();
        Edad.setBounds(250, 170, 200, 30);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(20, 200, 200, 30);

        JPasswordField Password = new JPasswordField();
        Password.setBounds(250, 200, 200, 30);

        JLabel lblPassword2 = new JLabel("Repetir Contraseña:");
        lblPassword2.setBounds(20, 230, 200, 30);

        JPasswordField Password2 = new JPasswordField();
        Password2.setBounds(250, 230, 200, 30);



        JLabel lblrol = new JLabel("Rol:");
        lblrol.setBounds(20, 260, 200, 30);

        JComboBox<String> ROLES = new JComboBox<String>();
        ROLES.addItem("Administrador");
        ROLES.addItem("Laboratorista");
        ROLES.addItem("Empleado");

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
        add(lblPassword);
        add(Password);
        add(lblPassword2);
        add(Password2);
        add(lblrol);
        add(ROLES);
        add(Guardar);

        add(botonVolver);
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica que password y password2 sean iguales
                if (Password.getText().equals(Password2.getText())) {
                    // se genera el objeto usuario DTO y se le pasan los datos
                    char[] passwordChars = Password.getPassword();
                    String pword = new String(passwordChars);

                    UsuarioDTO usuariodto = new UsuarioDTO(DNI.getText(), Nombre.getText(), Domicilio.getText(), Mail.getText(),Integer.parseInt(Edad.getText()), pword, ROLES.getSelectedItem().toString());
                    ControllerUsuarios.altaUsuarios(usuariodto);


                    JOptionPane.showMessageDialog(null, "Usuario creado con éxito");
                    AltaUsuario.this.dispose();

              //      Menu menu = new Menu();
                //    menu.setVisible(true);
                    TablaUsuarios listarUsuarios = new TablaUsuarios("tabla usuarios");
                    listarUsuarios.setVisible(true);


                } else {
                    // Muestra un mensaje de error
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }
            }
        });



        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AltaUsuario.this.dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
    }


        private void createUIComponents() {
                // TODO: place custom component creation code here
        }






}
