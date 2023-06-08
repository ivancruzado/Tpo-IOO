import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;
import GUI.AltaUsurious;
import GUI.Menu;
import Modelo.Sucursales;


import javax.swing.*;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        Menu menu = new Menu();
        ControllerSucursales controller2 = ControllerSucursales.getInstance();
        controller2.altaSucursal(1,24,"direccion 1", "ivan");
        controller2.altaSucursal(2,25,"direccion 2", "Juan");
        controller2.altaSucursal(3,26,"direccion 3", "Tomas");

    }
}

