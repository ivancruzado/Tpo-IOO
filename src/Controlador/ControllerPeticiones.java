package Controlador;

import Modelo.Pacientes;
import Modelo.Practica;
import Modelo.Sucursales;

import java.util.ArrayList;
import java.util.List;

public class ControllerPeticiones {

    private static ControllerPeticiones SINGLETON = null;         //variable para saber si se creo o no el objeto singleton
    private static List<Pacientes> lista = new ArrayList<>();
    private static List<Practica> lista2 = new ArrayList<>();

    private ControllerPeticiones() {
    }

    public static ControllerPeticiones getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new ControllerPeticiones();             //1 sola instancia

        }
        return SINGLETON;
    }

    public static List<Pacientes> getLista() {
        return lista;
    }
    public List<Practica> getLista2() {
        return lista2;
    }

    public void guardarPaciente(String n, int d, int e, String dom, String s, String m) {

        Pacientes nuevos = new Pacientes(d, n, dom, m, s, e);
        nuevos.setDNI(d);
        nuevos.setEdad(e);
        nuevos.setNombre(n);
        nuevos.setDomicilio(dom);
        nuevos.setSexo(s);
        nuevos.setMail(m);

        lista.add(nuevos);
    }


    public List<Pacientes> imprimirLista() {
        //for (int i = 0; i < lista.size(); i++) {
        //    System.out.println("Nombre: " + lista.get(i).getNombre() + " dni: " + lista.get(i).getDNI() + " edad: " + lista.get(i).getEdad() +
        //            " Domicilio: " + lista.get(i).getDomicilio() + " Sexo: " + lista.get(i).getSexo() + " Mail: " + lista.get(i).getMail());
        //}
        return lista;
    }

    public void bajaPaciente(int index) {

        lista.remove(index);               //corregir si tiene peticiones activas no puede eliminarse
        /*for (int i = 0; i < lista.size(); i++) {
            int dni2 = lista.get(i).getDNI();
            if(lista.get(i).getDNI() == DNI){
                encontrado = true;
                lista.remove(i);
            }
        }
        return encontrado;*/
    }

    public Pacientes buscarPacientePorDNI(int dni) {
        int index = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDNI() == dni) {
                index = i;
            }
        }
        Pacientes pacientes = new Pacientes(lista.get(index).getDNI(),lista.get(index).getNombre(),lista.get(index).getDomicilio(),
                lista.get(index).getMail(),lista.get(index).getSexo(),lista.get(index).getEdad());
        return pacientes;
    }

    public int buscarindexPacientes(int dni) {
        int index = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDNI() == dni) {
                index = i;
            }
        }
        return index;
    }

    public int buscarindexPracticas(int id) {
        int index = 0;
        for (int i = 0; i < lista2.size(); i++) {
            if (lista2.get(i).getPracticaID() == id) {
                index = i;
            }
        }
        return index;
    }

    public void modificarPaciente(int dni, String nombre, int edad, String mail, String dom,String sexo){

        lista.get(buscarindexPacientes(dni)).setDNI(dni);
        lista.get(buscarindexPacientes(dni)).setNombre(nombre);
        lista.get(buscarindexPacientes(dni)).setEdad(edad);
        lista.get(buscarindexPacientes(dni)).setMail(mail);
        lista.get(buscarindexPacientes(dni)).setDomicilio(dom);
        lista.get(buscarindexPacientes(dni)).setSexo(sexo);

    }



    public void altaPractica(int id, int codigo, String nom, String grupo, int tiempo, boolean deshabilitada) {

        Practica nuevos = new Practica(id,codigo,nom,grupo,tiempo,deshabilitada);
        nuevos.setPracticaID(id);
        nuevos.setCodigoPractica(codigo);
        nuevos.setNombrePractica(nom);
        nuevos.setGrupo(grupo);
        nuevos.setTiempoResultado(tiempo);
        nuevos.setDeshabilitada(deshabilitada);
        lista2.add(nuevos);
    }
    public void bajaPractica(int index) {
        lista2.remove(index);
    }

    public void modificarPractica(int id, int codigo, String nom, String grupo, int tiempo,boolean des){
        lista2.get(buscarindexPracticas(id)).setPracticaID(id);
        lista2.get(buscarindexPracticas(id)).setNombrePractica(nom);
        lista2.get(buscarindexPracticas(id)).setCodigoPractica(codigo);
        lista2.get(buscarindexPracticas(id)).setGrupo(grupo);
        lista2.get(buscarindexPracticas(id)).setTiempoResultado(tiempo);
        lista2.get(buscarindexPracticas(id)).setDeshabilitada(des);
    }






    //public static DTOPacientes toDto(Pacientes pacientes){

    //}






}








