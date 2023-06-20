package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaUsuario extends JFrame{

    private JTextField DNI;

    private JTextField Nombre;

    private JTextField Domicilio;

    private JTextField Mail;

    private JTextField Edad;

    private JPasswordField Password;

    private JPasswordField Password2;

    private JPanel AltaUsurious;

        public AltaUsuario() {
            setBackground(Color.gray);
            setTitle("Vista de Usuario");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 500);
            setLayout(new GridLayout(7, 2));
            setVisible(true);

            JLabel lblDNI = new JLabel("DNI:");
            DNI = new JTextField();
            JLabel lblNombre = new JLabel("Nombre:");
            Nombre = new JTextField();
            JLabel lblDomicilio = new JLabel("Domicilio:");
            Domicilio = new JTextField();
            JLabel lblMail = new JLabel("Mail:");
            Mail = new JTextField();
            JLabel lblEdad = new JLabel("Edad:");
            Edad = new JTextField();
            JLabel lblPassword = new JLabel("Contraseña:");
            Password = new JPasswordField();
            JButton botonVolver = new JButton("Volver a Menu");
            botonVolver.setBounds(300, 500, 150, 30);

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
            add(botonVolver);

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
