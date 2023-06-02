package Controlador;

import Modelo.Pacientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ControllerPeticiones {

    private static ControllerPeticiones SINGLETON = null;         //variable para saber si se creo o no el objeto singleton

    private static List<Pacientes> lista = new ArrayList<>();

    private ControllerPeticiones() {
    }

    public static ControllerPeticiones getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new ControllerPeticiones();             //1 sola instancia
            lista = getLista();
        }
        return SINGLETON;
    }


    public static List<Pacientes> getLista() {
        return lista;
    }

    public void guardarPaciente(String n, int d, int e, String dom, String s, String m) {
        Pacientes nuevos = new Pacientes();
        nuevos.setDNI(d);
        nuevos.setEdad(e);
        nuevos.setNombre(n);
        nuevos.setDomicilio(dom);
        nuevos.setSexo(s);
        nuevos.setMail(m);
        lista.add(nuevos);

    }

    public List<Pacientes> imprimirLista() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Nombre: " + lista.get(i).getNombre() + " dni: " + lista.get(i).getDNI() + " edad: " + lista.get(i).getEdad() +
                    " Domicilio: " + lista.get(i).getDomicilio() + " Sexo: " + lista.get(i).getSexo() + " Mail: " + lista.get(i).getMail());
        }
        return lista;
    }

    //public static DTOPacientes toDto(Pacientes pacientes){

    //}
}

