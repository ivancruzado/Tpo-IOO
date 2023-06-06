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
        ControllerPeticiones controller = ControllerPeticiones.getInstance();
        controller.guardarPaciente("Ambar Martin",18553 ,34 , "Direccion 1", "F", "am@gmail.com");
        controller.guardarPaciente("Juan Cruz", 17551, 23, "Dirección 2", "M", "jc@gmail.com");
        controller.guardarPaciente("Leandro Pessi", 18523, 38, "Dirección 3", "M", "lp@gmail.com");
        controller.guardarPaciente("Tomas Martinez", 17973, 23, "Dirección 4", "M", "tm@gmail.com");
        controller.altaPractica(11,1520,"Analisis de sangre","analisis",30,false);
        controller.altaPractica(12,1521,"Analisis de orina","analisis",30,false);
        controller.altaPractica(24,1523,"Radiografia","Radios",30,false);
        controller.altaPractica(25,1524,"Electro","||",30,false);

    }
}

