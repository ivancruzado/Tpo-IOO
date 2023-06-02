package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaUsurious extends JFrame{

        private JTextField txtDNI;
        private JTextField txtNombre;
        private JTextField txtDomicilio;
        private JTextField txtMail;
        private JTextField txtEdad;
        private JPasswordField txtPassword;
    private JPanel AltaUsurious;

        public AltaUsurious() {
            setBackground(Color.gray);
            setTitle("Vista de Usuario");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 500);
            setLayout(new GridLayout(7, 2));
            setVisible(true);

            JLabel lblDNI = new JLabel("DNI:");
            txtDNI = new JTextField();
            JLabel lblNombre = new JLabel("Nombre:");
            txtNombre = new JTextField();
            JLabel lblDomicilio = new JLabel("Domicilio:");
            txtDomicilio = new JTextField();
            JLabel lblMail = new JLabel("Mail:");
            txtMail = new JTextField();
            JLabel lblEdad = new JLabel("Edad:");
            txtEdad = new JTextField();
            JLabel lblPassword = new JLabel("Contraseña:");
            txtPassword = new JPasswordField();
            JButton botonVolver = new JButton("Volver a Menu");
            botonVolver.setBounds(300, 500, 150, 30);

            add(lblDNI);
            add(txtDNI);
            add(lblNombre);
            add(txtNombre);
            add(lblDomicilio);
            add(txtDomicilio);
            add(lblMail);
            add(txtMail);
            add(lblEdad);
            add(txtEdad);
            add(lblPassword);
            add(txtPassword);
            add(botonVolver);

            botonVolver.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    AltaUsurious.this.dispose();
                    Menu menu = new Menu();
                    menu.setVisible(true);
                }
            });
        }

        private void createUIComponents() {
                // TODO: place custom component creation code here
        }
}
