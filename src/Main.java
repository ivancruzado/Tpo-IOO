
import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;
import GUI.Login;
import GUI.Menu;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        ControllerSucursales.getInstance();

       // Menu menu = new Menu();
        Login login = new Login();

    }
}

