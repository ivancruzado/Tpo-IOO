package Controlador;

public class ControllerUsuarios {
    private static ControllerUsuarios SINGLETON = null;
    private ControllerUsuarios(){}

    public static ControllerUsuarios getInstance(){
        if(SINGLETON == null){
                SINGLETON = new ControllerUsuarios();             //1 sola instancia
        }
        return SINGLETON;
    }
}
