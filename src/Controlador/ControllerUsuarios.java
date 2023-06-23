package Controlador;

import DTO.PacientesDTO;
import DTO.PeticionesDTO;
import DTO.UsuarioDTO;
import Modelo.Pacientes;
import Modelo.Peticiones;
import Modelo.Sucursales;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuarios {
    private static ControllerUsuarios SINGLETON = null;

    private static List<Usuario> listaUsuarios = new ArrayList<>();


    private ControllerUsuarios() {
    }

    public synchronized static ControllerUsuarios getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new ControllerUsuarios();             //1 sola instancia
            initUsuarios();
        }
        return SINGLETON;
    }

    private static void initUsuarios() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("30895613", "Jorge" ,"segovia","jorge@gmail.com" ,20,"1234567","administador"));
        listaUsuarios.add(new Usuario("33895613", "jose"  ,"perez"  ,"jose@gmail.com"  ,30,"1234567","administador"));
        listaUsuarios.add(new Usuario("34538563", "Gaston","Candel" ,"gaston@gmail.com",33,"123456" ,"administrador"));
    }

    public static List<Usuario> getAll() {
        return listaUsuarios;
    }


    }

}

