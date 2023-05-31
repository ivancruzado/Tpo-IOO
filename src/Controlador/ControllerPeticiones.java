package Controlador;

import Modelo.Pacientes;
import Modelo.Usuario;

import java.util.Map;

public class ControllerPeticiones {

    private static ControllerPeticiones SINGLETON = null;         //variable para saber si se creo o no el objeto singleton
    private ControllerPeticiones(){}

    public static ControllerPeticiones getInstance(){
        if(SINGLETON == null){
            SINGLETON = new ControllerPeticiones();             //1 sola instancia
        }
        return SINGLETON;
    }

    private Map<String, Pacientes> pacientes;
    private Map<String, Usuario> usuarios;


}
