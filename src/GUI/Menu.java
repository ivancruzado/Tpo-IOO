package GUI;

import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame {

    //public JPanel Menu;
    public JPanel panel1;
    private ControllerPeticiones controller;
    private ControllerSucursales controller2;


    public Menu(){
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema de Laboratorio");
        setLocationRelativeTo(null);

        componentes();
        this.setVisible(true);
    }


    private  void componentes(){
        paneles();
       // botonesInicio();
        submenu();


    }

    private void paneles(){

        panel1 = new JPanel();
        panel1.setBackground(Color.gray);
        panel1.setLayout(null);
        // panel1.setBounds(0, 0, 700, 700);

    }
    private  void submenu(){
        // menu desplegable de opciones con alta de usuarios, pacientes, practicas, sucursales y peticiones
        JMenuBar menuBar = new JMenuBar();

        //agregar el menuBar al panel1
        setJMenuBar(menuBar);
        //setVisible(true);

        JMenu Archivo = new JMenu("Archivo");
        menuBar.add(Archivo);
        JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");
        Archivo.add(cerrarSesion);
        JMenuItem salir = new JMenuItem("Salir");
        Archivo.add(salir);

        // apartado de usuarios
        JMenu menuUsuarios = new JMenu("Usuarios");
        menuBar.add(menuUsuarios);
        JMenuItem altaUsuarios = new JMenuItem("Alta Usuarios");
        menuUsuarios.add(altaUsuarios);
        JMenuItem listarUsuarios = new JMenuItem("Listar Usuarios");
        menuUsuarios.add(listarUsuarios);





        // apartado de pacientes
        JMenu menuPacientes = new JMenu("Pacientes");
        menuBar.add(menuPacientes);
        JMenuItem altaPacientes = new JMenuItem("Alta Pacientes");
        menuPacientes.add(altaPacientes);
        JMenuItem listarPacientes = new JMenuItem("Listar Pacientes");
        menuPacientes.add(listarPacientes);
        // apartado de practicas

        JMenu menuPracticas = new JMenu("Practicas");
        menuBar.add(menuPracticas);
        JMenuItem altaPracticas = new JMenuItem("Alta Practicas");
        menuPracticas.add(altaPracticas);
        JMenuItem listarPracticas = new JMenuItem("Listar Practicas");
        menuPracticas.add(listarPracticas);
        // apartado de sucursales
        JMenu menuSucursales = new JMenu("Sucursales");
        menuBar.add(menuSucursales);
        JMenuItem altaSucursales = new JMenuItem("Alta Sucursales");
        menuSucursales.add(altaSucursales);
        JMenuItem listarSucursales = new JMenuItem("Listar Sucursales");
        menuSucursales.add(listarSucursales);
        // apartado de peticiones
        JMenu menuPeticiones = new JMenu("Peticiones");
        menuBar.add(menuPeticiones);
        JMenuItem altaPeticiones = new JMenuItem("Alta Peticiones");
        menuPeticiones.add(altaPeticiones);
        JMenuItem listarPeticiones = new JMenuItem("Listar Peticiones");
        menuPeticiones.add(listarPeticiones);



        // apartado de informes
        JMenu menuInformes = new JMenu("Informes");
        menuBar.add(menuInformes);
        JMenuItem informePacientes = new JMenuItem("Informe Pacientes");
        menuInformes.add(informePacientes);
        JMenuItem informePracticas = new JMenuItem("Informe Practicas");
        menuInformes.add(informePracticas);
        JMenuItem informePeticiones = new JMenuItem("Informe Peticiones");
        menuInformes.add(informePeticiones);


        // apartado de salir

        salir.addActionListener(e -> {
            System.exit(0); // Sale de la aplicación cuando se selecciona
        });
        altaPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                //    AltaPacientes altaPacientes = new AltaPacientes();
              //  altaPacientes.setVisible(true);
            }
        });
        listarPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
          //      ListarPacientes listarPacientes = new ListarPacientes();
             //   listarPacientes.setVisible(true);
            }
        });
        altaPracticas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                VentanaAltaPracticas altaPracticas = new VentanaAltaPracticas();
                altaPracticas.setVisible(true);
            }
        });
        listarPracticas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                TablaPracticas listarPracticas = new TablaPracticas("tabla practicas");
                listarPracticas.setVisible(true);
            }
        });
        altaSucursales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                VentanaAltaSucursal altaSucursales = new VentanaAltaSucursal();
                altaSucursales.setVisible(true);
            }
        });
        listarSucursales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                TablaSucursales listarSucursales = new TablaSucursales("tabla sucursales)");
                listarSucursales.setVisible(true);
            }
        });
        altaPeticiones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                VentanaAltaPeticiones altaPeticiones = new VentanaAltaPeticiones();
                altaPeticiones.setVisible(true);
            }
        });
        listarPeticiones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                TablaPeticiones listarPeticiones = new TablaPeticiones("tabla peticiones");
                listarPeticiones.setVisible(true);
            }
        });

        altaUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                AltaUsuario altaUsuarios = new AltaUsuario();
                altaUsuarios.setVisible(true);
            }
        });

        listarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                TablaUsuarios listarUsuarios = new TablaUsuarios("tabla usuarios");
                listarUsuarios.setVisible(true);
            }
        });
        ;
        cerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                Login login = new Login();
                login.setVisible(true);

            }
        });




    }

/*
    private  void botonesInicio(){


        JButton botonUsuarios = new JButton("Alta Usuarios");
        botonUsuarios.setBounds(60, 300, 150, 30);
        panel1.add(botonUsuarios);

        JButton botonPacientes = new JButton("Pacientes");
        botonPacientes.setBounds(100, 250, 150, 30);
        panel1.add(botonPacientes);


        JButton Practicas = new JButton("Practicas");
        Practicas.setBounds(300, 250, 150, 30);
        panel1.add(Practicas);

        JButton sucursales = new JButton("Sucursales");
        sucursales.setBounds(100, 100, 150, 30);
        panel1.add(sucursales);

        JButton peticiones = new JButton("Peticiones");
        peticiones.setBounds(300, 100, 150, 30);
        panel1.add(peticiones);



        botonUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                AltaUsurious altaUsurious = new AltaUsurious();
                altaUsurious.setVisible(true);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(panel1);

        botonPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                PacientesPrincipal pacientesPrincipal = new PacientesPrincipal();
                pacientesPrincipal.setVisible(true);
            }
        });

        Practicas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                PracticasPrincipal practicasPrincipal = new PracticasPrincipal();
                practicasPrincipal.setVisible(true);
            }
        });
        sucursales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                SucursalesPrincipal sucursalesPrincipal = new SucursalesPrincipal();
                sucursalesPrincipal.setVisible(true);
            }
        });

        peticiones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                PeticionesPrincipal peticionesPrincipal = new PeticionesPrincipal();
                peticionesPrincipal.setVisible(true);
            }
        });




    }
*/

}




