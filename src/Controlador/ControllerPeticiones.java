package Controlador;

import DTO.PacientesDTO;
import DTO.PracticasDTO;
import Modelo.Pacientes;
import Modelo.Practica;
import Modelo.Sucursales;

import java.util.ArrayList;
import java.util.List;

public class ControllerPeticiones {

    private static ControllerPeticiones SINGLETON;         //variable para saber si se creo o no el objeto singleton
    private static List<Pacientes> lista;
    private static List<Practica> lista2;

    private ControllerPeticiones() {}

    public static synchronized ControllerPeticiones getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new ControllerPeticiones();             //1 sola instancia
            initClientes();
            initPracticas();
        }
        return SINGLETON;
    }

    public static List<Pacientes> getLista() {
        return lista;
    }
    public List<Practica> getLista2() {
        return lista2;
    }

    private static void initClientes(){
        lista = new ArrayList<>();
        lista.add(new Pacientes(17812612,"ivan","direcion 1","ic@gmail.com","M",44));
        lista.add(new Pacientes(1855321,"Ambar Martin" ,"Direccion 1", "am@gmail.com", "F", 47));
        lista.add(new Pacientes(23231123, "Leandro Pessi", "Direccion 3", "lp@gmail.com", "M", 23));

    }

    private static void initPracticas(){
        lista2 = new ArrayList<>();
        lista2.add(new Practica(11,1520,"Analisis de sangre","analisis",30,false));
        lista2.add(new Practica(12,1521,"Analisis de orina","analisis",30,false));
        lista2.add(new Practica(24,1523,"Radiografia","Radios",45,false));

    }

    public void altaPaciente(PacientesDTO dto){
        Pacientes paciente = toModel(dto);
        lista.add(paciente);
    }


    public static Pacientes toModel(PacientesDTO dto) {

        Pacientes cliente = new Pacientes(dto.getDni(), dto.getNombre(),dto.getDomicilio(), dto.getMail(), dto.getSexo(), dto.getEdad() );
        return cliente;
    }


    public List<Pacientes> imprimirLista() {
        //for (int i = 0; i < lista.size(); i++) {
        //    System.out.println("Nombre: " + lista.get(i).getNombre() + " dni: " + lista.get(i).getDNI() + " edad: " + lista.get(i).getEdad() +
        //            " Domicilio: " + lista.get(i).getDomicilio() + " Sexo: " + lista.get(i).getSexo() + " Mail: " + lista.get(i).getMail());
        //}
        return lista;
    }

    public void bajaPaciente(int index) {

        lista.remove(index);                  //corregir si tiene peticiones activas no puede eliminarse
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

    public void altaPractica(PracticasDTO dto){
        Practica practica = toModel2(dto);
        lista2.add(practica);
    }


    public static Practica toModel2(PracticasDTO dto) {
        Practica practica = new Practica(dto.getPracticaID(),dto.getCodigoPractica(),dto.getNombrePractica(),dto.getGrupo(),dto.getTiempoResultado(),dto.isDeshabilitada() );
        return practica;
    }


    //public static DTOPacientes toDto(Pacientes pacientes){

    //}


}








