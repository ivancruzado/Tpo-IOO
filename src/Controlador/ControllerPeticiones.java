package Controlador;

import DTO.PacientesDTO;
import DTO.PeticionesDTO;
import DTO.PracticasDTO;
import DTO.SucursalesDTO;
import Modelo.Pacientes;
import Modelo.Peticiones;
import Modelo.Practica;


import java.text.SimpleDateFormat;
import java.util.*;

public class ControllerPeticiones {

    private static ControllerPeticiones SINGLETON;         //variable para saber si se creo o no el objeto singleton
    private static List<Pacientes> lista;
    private static List<Practica> lista2;
    private static List<Peticiones> lista3;

    private ControllerPeticiones() {}

    public static synchronized ControllerPeticiones getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new ControllerPeticiones();             //1 sola instancia
            initClientes();
            initPracticas();
            initPeticiones();
        }
        return SINGLETON;
    }


    public List<PacientesDTO> getAll() {
        List<PacientesDTO> listaPacientesDTO = new ArrayList<>();
        for (Pacientes paciente : lista) {
            listaPacientesDTO.add(toDTO(paciente));
        }
        return listaPacientesDTO;
    }

    public List<PracticasDTO> getAll2() {
        List<PracticasDTO> listaPracticasDTO = new ArrayList<>();
        for (Practica practica : lista2) {
            listaPracticasDTO.add(toDTO2(practica));
        }
        return listaPracticasDTO;
    }

    public List<PeticionesDTO> getAll3() {
        List<PeticionesDTO> listaPeticionesDTO = new ArrayList<>();
        for (Peticiones peticion : lista3) {
            listaPeticionesDTO.add(toDTO3(peticion));
        }
        return listaPeticionesDTO;
    }


    private static void initClientes(){
        lista = new ArrayList<>();
        lista.add(new Pacientes(17812612,"Ivan","Direcion 1","ic@gmail.com","M",44));
        lista.add(new Pacientes(1755321,"Ambar Martin" ,"Direccion 2", "am@gmail.com", "F", 47));
        lista.add(new Pacientes(23231123, "Leandro Pessi", "Direccion 3", "lp@gmail.com", "M", 23));

    }

    private static void initPracticas(){
        lista2 = new ArrayList<>();
        lista2.add(new Practica(11,1520,"Analisis de sangre","analisis",30,false));
        lista2.add(new Practica(12,1521,"Analisis de orina","analisis",30,false));
        lista2.add(new Practica(24,1523,"Radiografia","Radios",45,false));

    }

    private static void initPeticiones(){
        lista3 = new ArrayList<>();
        //SucursalesDTO sucursalesDTO = ControllerSucursales.getAll().get(0);
        //int id = sucursalesDTO.getIdSucursal();
        Date fechaCarga = new Date(123,5,15);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaGregoriana = dateFormat.format(fechaCarga);
        Date fechaEntrega = new Date(123,5,30);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        String fechaGregoriana2 = dateFormat2.format(fechaEntrega);
        lista3.add(new Peticiones(123,1,lista.get(0),"Osde", fechaGregoriana,lista2.get(0),fechaGregoriana2,"finalizado" ));
        lista3.add(new Peticiones(124,2,lista.get(1),"Ioma", fechaGregoriana,lista2.get(1),fechaGregoriana2,"en curso"));
        lista3.add(new Peticiones(125,3,lista.get(2),"Pami", fechaGregoriana,lista2.get(2),fechaGregoriana2,"iniciado" ));
        lista3.add(new Peticiones(126,2,lista.get(1),"Pami", fechaGregoriana,lista2.get(2),fechaGregoriana2,"finalizado" ));
    }



    public void altaPaciente(PacientesDTO dto){
        Pacientes paciente = toModel(dto);
        lista.add(paciente);
    }


    public static Pacientes toModel(PacientesDTO dto) {

        Pacientes cliente = new Pacientes(dto.getDni(), dto.getNombre(),dto.getDomicilio(), dto.getMail(), dto.getSexo(), dto.getEdad() );
        return cliente;
    }

    public static PacientesDTO toDTO(Pacientes pacientes){
        PacientesDTO dto = new PacientesDTO(pacientes.getDNI(),pacientes.getNombre(),pacientes.getDomicilio(), pacientes.getMail(), pacientes.getSexo(), pacientes.getEdad());
        return dto;
    }

    public void bajaPaciente(int DNI) {
        List<PacientesDTO> listaPacientes =getAll();
        for (int i = 0; i < listaPacientes.size(); i++) {
            if(listaPacientes.get(i).getDni() == DNI){
                toDTO(lista.remove(i));

            }
        }
    }

    public Boolean buscarEstado(int DNI){
        List<PeticionesDTO> listaPeticiones =getAll3();
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(listaPeticiones.get(i).getPaciente().getDNI() == (DNI)){
                if (listaPeticiones.get(i).getEstado().equalsIgnoreCase("finalizado") ){
                    return true;
                }
            }
        }
        return false;
    }

    public PacientesDTO buscarPacientePorDNI(int dni) {
        int index = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDNI() == dni) {
                index = i;
            }
        }
        PacientesDTO pacientes = new PacientesDTO(lista.get(index).getDNI(),lista.get(index).getNombre(),lista.get(index).getDomicilio(),
                lista.get(index).getMail(),lista.get(index).getSexo(),lista.get(index).getEdad());
        return pacientes;
    }

    public int buscarindexPacientes(int dni) {
        int index = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDNI() == dni) {
                index = i;
            }
        }
        return index;
    }

    public int buscarindexPracticas(int id) {
        int index = -1;
        for (int i = 0; i < lista2.size(); i++) {
            if (lista2.get(i).getPracticaID() == id) {
                index = i;
            }
        }
        return index;
    }

    public int buscarindexPeticiones(int id) {
        int index = -1;
        for (int i = 0; i < lista3.size(); i++) {
            if (lista3.get(i).getIdPeticion() == id) {
                index = i;
                return index;
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

    public void bajaPractica(int id) {
        List<PracticasDTO> listaPracticas =getAll2();
        for (int i = 0; i < listaPracticas.size(); i++) {
            if(listaPracticas.get(i).getPracticaID() == id){
                toDTO2(lista2.remove(i));
            }
        }
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

    public PracticasDTO buscarPracticaPorNombre(String nombre) {
        int index = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista2.get(i).getNombrePractica().equalsIgnoreCase(nombre) ) {
                index = i;
            }
        }
        PracticasDTO practica= new PracticasDTO(lista2.get(index).getPracticaID(),lista2.get(index).getCodigoPractica(),lista2.get(index).getNombrePractica(),
                lista2.get(index).getGrupo(),lista2.get(index).getTiempoResultado(),lista2.get(index).isDeshabilitada());
        return practica;
    }


    public static Practica toModel2(PracticasDTO dto) {
        Practica practica = new Practica(dto.getPracticaID(),dto.getCodigoPractica(),dto.getNombrePractica(),dto.getGrupo(),dto.getTiempoResultado(),dto.isDeshabilitada() );
        return practica;
    }

    public static PracticasDTO toDTO2(Practica practicas){
        PracticasDTO dto = new PracticasDTO(practicas.getPracticaID(), practicas.getCodigoPractica(), practicas.getNombrePractica(),
                practicas.getGrupo(), practicas.getTiempoResultado(), practicas.isDeshabilitada());
        return dto;
    }



    public void altaPeticiones(PeticionesDTO dto){
        Peticiones peticiones = toModel3(dto);
        lista3.add(peticiones);
    }

    public void bajaPeticiones(int idPeticion) {
        List<PeticionesDTO> listaPeticiones =getAll3();
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(listaPeticiones.get(i).getIdPeticion() == idPeticion){
                toDTO3(lista3.remove(i));
            }
        }
    }

    public void moverPeticionesActivas(int sucursalBaja,int sucursalAlta){
        List<Peticiones> listaPeticiones = lista3;

        for (Peticiones listaPeticion : listaPeticiones) {
            if (listaPeticion.getSucursalID() == (sucursalBaja)) {
                if (!listaPeticion.getEstado().equals("finalizado")) {
                    listaPeticion.setSucursalID(sucursalAlta);
                    System.out.println(listaPeticion.getSucursalID());
                }
            }
        }
    }

    public void modificarPeticiones(int id, int SucursalID, String obraSocial, String fechaCarga,String fechaEntrega,String estado){
        Peticiones peticion = lista3.get(buscarindexPeticiones(id));
        peticion.setSucursalID(SucursalID);
        //peticion.setPaciente(paciente);
        peticion.setObraSocial(obraSocial);
        peticion.setFechaDeCarga(fechaCarga);
        //peticion.setPracticasAsociadas(practicaAsociada);
        peticion.setFechaEntrega(fechaEntrega);
        peticion.setEstado(estado);
    }

    public static Peticiones toModel3(PeticionesDTO dto) {
        Peticiones peticion = new Peticiones(dto.getIdPeticion(), dto.getSucursalID(), dto.getPaciente(), dto.getObraSocial(), dto.getFechaDeCarga(),dto.getPracticasAsociadas(),
                dto.getFechaEntrega(), dto.getEstado());
        return peticion;
    }



    public static PeticionesDTO toDTO3(Peticiones peticion){
        PeticionesDTO dto = new PeticionesDTO(peticion.getIdPeticion(), peticion.getSucursalID(), peticion.getPaciente(), peticion.getObraSocial(), peticion.getFechaDeCarga(),
                peticion.getPracticasAsociadas(),peticion.getFechaEntrega(),peticion.getEstado());
        return dto;
    }

}








