package Controlador;

import DTO.UsuarioDTO;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuarios {
    private static ControllerUsuarios SINGLETON = null;
    private static String rol;
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
        listaUsuarios.add(new Usuario("30895613", "jorge" ,"chassaing 4873","jorge@gmail.com" ,20,"1234567","Administrador"));
        listaUsuarios.add(new Usuario("33895613", "jose"  ,"jose larrea 343"  ,"jose@gmail.com"  ,30,"1234567","Laboratorista"));
        listaUsuarios.add(new Usuario("34538563", "gaston","ascuenaga 39" ,"gaston@gmail.com",33,"123456" ,"Recepcionista"));
    }

    public static String getROL(){
        return ControllerUsuarios.rol;
    }


    public static String autenticar(String user, String password){
        for (Usuario usuario : listaUsuarios) {

            if (usuario.getNombre().equals(user) && usuario.getPassword().equals(password))
            {
                   ControllerUsuarios.rol = usuario.getRol();
                   return usuario.getRol();
            }
        }
        return "null";
    }

    public static void altaUsuarios(UsuarioDTO dto){
        listaUsuarios.add(toModel(dto));

    }

    public static boolean bajaUsuarios(String dni) {
        List<UsuarioDTO> lista = getall();
        System.out.println(dni);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getDNI());
            if (lista.get(i).getDNI().equals(dni)) {
                //  toDTO(listaUsuarios.remove(i));
                    toDTO(listaUsuarios.remove(i));
                return true;
            }
        }
        return false;
    }




    public static Usuario toModel(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto.getDNI(),dto.getNombre(),dto.getDomicilio(),dto.getMail(),dto.getEdad(), dto.getPassword(),dto.getRol());
        return usuario;
    }


    public static UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO(usuario.getDNI(),usuario.getNombre(),usuario.getDomicilio(),usuario.getMail(),usuario.getEdad(), usuario.getPassword(),usuario.getRol());
        return dto;
    }

    public static List<UsuarioDTO> getall() {
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();
        for ( Usuario usuario  : listaUsuarios) {
            listaUsuariosDTO.add(toDTO(usuario));
        }
        return listaUsuariosDTO;
    }


}

