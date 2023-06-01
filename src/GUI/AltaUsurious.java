package GUI;
import javax.swing.*;
import java.awt.*;

public class AltaUsurious extends JFrame{

        private JTextField txtDNI;
        private JTextField txtNombre;
        private JTextField txtDomicilio;
        private JTextField txtMail;
        private JTextField txtEdad;
        private JPasswordField txtPassword;
    private JPanel AltaUsurious;

        public AltaUsurious() {
            setTitle("Vista de Usuario");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 200);
            setLayout(new GridLayout(6, 2));

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
        }

        private void createUIComponents() {
                // TODO: place custom component creation code here
        }
}
