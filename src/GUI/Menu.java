package GUI;

import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;
import Controlador.ControllerUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame {

    //public JPanel Menu;
    public JPanel panel1;
    private ControllerPeticiones controller;
    private ControllerSucursales controller2;
    private ControllerUsuarios controller3;




    public Menu() {
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
        menuPeticiones.add(new JSeparator());

        JMenuItem altaResultados = new JMenuItem("Cargar Resultados");
        menuPeticiones.add(altaResultados);
        JMenuItem listarResultados = new JMenuItem("Listar Resultados");
        menuPeticiones.add(listarResultados);

        // apartado de informes
        JMenu menuInformes = new JMenu("Informes");
        menuBar.add(menuInformes);
        JMenuItem informePacientes = new JMenuItem("Informe Pacientes");
        menuInformes.add(informePacientes);
        JMenuItem informePracticas = new JMenuItem("Informe Practicas");
        menuInformes.add(informePracticas);
        JMenuItem informePeticiones = new JMenuItem("Informe Peticiones");
        menuInformes.add(informePeticiones);


        if (ControllerUsuarios.getROL() == "Recepcionista"){
            menuInformes.setVisible(false);
            altaPacientes.setVisible(false);
            altaUsuarios.setVisible(false);
            altaPracticas.setVisible(false);
            altaSucursales.setVisible(false);


        } else if (ControllerUsuarios.getROL() == "Laboratorista") {
            menuInformes.setVisible(false);
            listarPeticiones.setVisible(false);
            altaPeticiones.setVisible(false);
            listarResultados.setVisible(true);
            menuPacientes.setVisible(false);
            menuUsuarios.setVisible(false);
            menuSucursales.setVisible(false);
            menuPracticas.setVisible(false);




        }


        salir.addActionListener(e -> {
            System.exit(0); // Sale de la aplicación cuando se selecciona
        });

        altaPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                VentanaAltaPacientes Pacientes = new VentanaAltaPacientes();
               Pacientes.setVisible(true);
            }
        });
        listarPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                TablaPacienteEncontrado listarPacientes = new TablaPacienteEncontrado("Alta Pacientes");
                listarPacientes.setVisible(true);
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




}




