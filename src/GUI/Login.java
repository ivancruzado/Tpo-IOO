package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame {

    //public JPanel Menu;
    public JPanel panel1;
    private JTextField user;
    private JPasswordField pass;

    public Login() {
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenido al Sistema de Laboratorio");
        setLocationRelativeTo(null);
        componentes();
        this.setVisible(true);
    }


    private void componentes() {
        paneles();


    }

    private void paneles() {

        panel1 = new JPanel();
        panel1.setBackground(Color.gray);
        panel1.setLayout(null);

        JLabel usernameLabel = new JLabel("Usuario:");
        usernameLabel.setBounds(100, 50, 250, 30);

        user = new JTextField();
        user.setBounds(180, 50, 250, 30);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(100, 100, 250, 30);

        pass = new JPasswordField();
        pass.setBounds(180, 100, 250, 30);

        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(100, 150, 160, 30);

        JButton exitButton = new JButton("Salir");
        exitButton.setBounds(280, 150, 160, 30);


        panel1.setVisible(true);


        panel1.add(usernameLabel);
        panel1.add(user);
        panel1.add(passwordLabel);
        panel1.add(pass);
        panel1.add(loginButton);
        panel1.add(exitButton);


        // panel1.setBounds(0, 0, 700, 500);
        add(panel1);
        exitButton.addActionListener(e -> {
            System.exit(0); // Sale de la aplicación
        });
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = user.getText();
                String password = new String(pass.getPassword());



                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(panel1, "Inicio de sesión exitoso");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Credenciales inválidas");
                }
            }
        });


    }

}




