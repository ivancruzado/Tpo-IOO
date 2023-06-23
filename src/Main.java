
import Controlador.ControllerPeticiones;
import Controlador.ControllerUsuarios;
import Controlador.ControllerSucursales;
import GUI.Login;
import GUI.Menu;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        ControllerSucursales.getInstance();
        ControllerUsuarios.getInstance();

        Login login = new Login();

    }
}

