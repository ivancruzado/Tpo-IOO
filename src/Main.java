import Controlador.ControllerPeticiones;
import Modelo.Pacientes;
import Modelo.Peticiones;

public class Main {
    public static void main(String[] args)
    {
        Peticiones p1 = new Peticiones("S15","ana",4500);

        System.out.println("el ID de práctica es: "+ p1.GetPracticaID());

        ControllerPeticiones ControllerP = ControllerPeticiones.getInstance();






    }
}