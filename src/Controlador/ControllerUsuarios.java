package Controlador;

import DTO.UsuarioDTO;
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
        listaUsuarios.add(new Usuario("30895613", "jorge" ,"chassaing 4873","jorge@gmail.com" ,20,"1234567","administador"));
        listaUsuarios.add(new Usuario("33895613", "jose"  ,"jose larrea 343"  ,"jose@gmail.com"  ,30,"1234567","administador"));
        listaUsuarios.add(new Usuario("34538563", "gaston","ascuenaga 39" ,"gaston@gmail.com",33,"123456" ,"administrador"));
        System.out.println("CARGA INICIAL");
    }

    public static String autenticar(String user, String password){
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario.getNombre());
            //&& (usuario.getPassword().equals(password)
            System.out.println(usuario.getPassword());
            if ((usuario.getNombre().equals(user)) ){
                System.out.println("Usuario autenticado");
                return usuario.getNombre();
            }
        }
        return "null";
    }

    public static void altaUsuarios(UsuarioDTO dto){
        listaUsuarios.add(toModel(dto));

    }




    public static Usuario toModel(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto.getDNI(),dto.getNombre(),dto.getDomicilio(),dto.getMail(),dto.getEdad(),dto.getPassword(),dto.getRol());
        return usuario;
    }


    public static UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO(usuario.getDNI(),usuario.getNombre(),usuario.getDomicilio(),usuario.getMail(),usuario.getEdad(),usuario.getPassword(),usuario.getRol());
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

