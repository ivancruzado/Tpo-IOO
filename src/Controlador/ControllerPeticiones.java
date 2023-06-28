package Controlador;

import DTO.*;
import Modelo.*;


import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ControllerPeticiones {

    private static ControllerPeticiones SINGLETON;         //variable para saber si se creo o no el objeto singleton
    private static List<Pacientes> lista;
    private static List<Practica> lista2;
    private static List<Peticiones> lista3;

    private static List<ValoresCriticos> lista4;

    private static List<ResultadoPractica> listResultados;

    private ControllerPeticiones() {}

    public static synchronized ControllerPeticiones getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new ControllerPeticiones();             //1 sola instancia
            initClientes();
            initPracticas();
            initPeticiones();
            initValoresCriticos();
            initRecultados();
        }
        return SINGLETON;
    }

    public static void altaResultados(ResultadosDTO resultados) {

            ResultadoPractica resultado = toModelResultado(resultados);
            listResultados.add(resultado);
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

    public List<ValoresCriticosDTO> getAll4() {
        List<ValoresCriticosDTO> listaValoresCriticosDTO = new ArrayList<>();
        for (ValoresCriticos ValorCritico : lista4){
            listaValoresCriticosDTO.add(toDTO4(ValorCritico));
        }
        return listaValoresCriticosDTO ;
    }

    public  static List<ResultadosDTO>  getAll5() {
        List<ResultadosDTO> listaResultadosDTO = new ArrayList<>();
        for (ResultadoPractica resultado : listResultados) {
            listaResultadosDTO.add(toDTOResultado(resultado));
        }
        return listaResultadosDTO;
    }


    public boolean escritico(int idresultado) {
        List<ResultadosDTO> listaResultadosDTO = new ArrayList<>();
        listaResultadosDTO = this.getAll5();

        for (ResultadosDTO resultado : listaResultadosDTO) {
            if (resultado.getResultadoPracticaID() == idresultado) {
                return (resultado.isEsCritico());
            }
        }
        return true;  // si no existe el Resulatado para ese id de Peticion
    }


    public static boolean validarCarga(int idresultado) {
        List<ResultadosDTO> listaResultadosDTO = new ArrayList<>();
        listaResultadosDTO = ControllerPeticiones.getAll5();

        for (ResultadosDTO resultado : listaResultadosDTO) {

            if(resultado.getValor() == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


    public static boolean esresevado(int idresultado) {
        List<ResultadosDTO> listaResultadosDTO = new ArrayList<>();
        listaResultadosDTO = ControllerPeticiones.getAll5();

        for (ResultadosDTO resultado : listaResultadosDTO) {
            if (resultado.getResultadoPracticaID() == idresultado) {
                return (resultado.isValoresReservados());
            }
        }
        return true;  // si no existe el Resulatado para ese id de Peticion

    }

    private static void initRecultados(){
        listResultados = new ArrayList<>();
        listResultados.add(new ResultadoPractica(1,1,true,true,1,10));
        listResultados.add(new ResultadoPractica(2,4,true,true,12,120));
        listResultados.add(new ResultadoPractica(3,3,true,true,1,11));

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
        lista3.add(new Peticiones(126,2,lista.get(1),"Ioma", fechaGregoriana,lista2.get(2),fechaGregoriana2,"finalizado" ));
    }

    private static void initValoresCriticos(){
        lista4= new ArrayList<>();
        lista4.add(new ValoresCriticos("Bilirubina total (neonato)",0      ,20));
        lista4.add(new ValoresCriticos("Calcio"                    ,6      ,13));
        lista4.add(new ValoresCriticos("Calcio iónico"             ,0      ,1));
        lista4.add(new ValoresCriticos("Fibrinógeno"               ,100    ,0));
        lista4.add(new ValoresCriticos("Glucosa"                   ,40     ,500));
        lista4.add(new ValoresCriticos("Glucosa LCR"               ,20     ,0));
        lista4.add(new ValoresCriticos("Hematocrito"               ,20     ,60));
        lista4.add(new ValoresCriticos("Hemoglobina"               ,7      ,21));
        lista4.add(new ValoresCriticos("Recuento de plaquetas"     ,20000  ,999000));
        lista4.add(new ValoresCriticos("Potasio"                   ,2      ,6));
        lista4.add(new ValoresCriticos("Tiempo de protrombina"     ,11     ,0));
        lista4.add(new ValoresCriticos("Sodio"                     ,120    ,160));
        lista4.add(new ValoresCriticos("Glóbulos blancos"          ,1500   ,40000));
        lista4.add(new ValoresCriticos("ph"                        ,7200   ,7600));
        lista4.add(new ValoresCriticos("Exceso de base"            ,-18    ,18));
        lista4.add(new ValoresCriticos("pCO2"                      ,20     ,70));
        lista4.add(new ValoresCriticos("KPTT"                      ,0      ,80));
        lista4.add(new ValoresCriticos("Carbamazepina"             ,0      ,12));
        lista4.add(new ValoresCriticos("Difenilhidantoina"         ,0      ,20));
        lista4.add(new ValoresCriticos("Fenobarbital"              ,0      ,40));
        lista4.add(new ValoresCriticos("Litio"                     ,0      ,1));
        lista4.add(new ValoresCriticos("Fósforo"                   ,1      ,9));
        lista4.add(new ValoresCriticos("Tiempo de trombina"        ,0      ,180));
        lista4.add(new ValoresCriticos("Salicilato"                ,0      ,70));
        lista4.add(new ValoresCriticos("Teofilina"                 ,0      ,20));
        lista4.add(new ValoresCriticos("Valproico"                 ,0      ,150));
        lista4.add(new ValoresCriticos("Digoxina"                  ,0      ,4));
        lista4.add(new ValoresCriticos("Metrotexate"               ,0      ,90));
        lista4.add(new ValoresCriticos("R.I.N"                     ,0      ,6));
        lista4.add(new ValoresCriticos("Factor VIII"               ,10     ,0));

    }


    public void altaPaciente(PacientesDTO dto){
        Pacientes paciente = toModel(dto);
        lista.add(paciente);
    }



    public static Pacientes toModel(PacientesDTO dto) {

        Pacientes cliente = new Pacientes(dto.getDni(), dto.getNombre(),dto.getDomicilio(), dto.getMail(), dto.getSexo(), dto.getEdad() );
        return cliente;
    }

    public static ResultadoPractica toModelResultado(ResultadosDTO dto) {

    ResultadoPractica resultado = new ResultadoPractica(dto.getResultadoPracticaID(),dto.getPracticaID(),dto.isEsCritico(),dto.isValoresReservados(),dto.getTiempoEstimado(),dto.getValor());
    return resultado;
    }

    public static PacientesDTO toDTO(Pacientes pacientes){
        PacientesDTO dto = new PacientesDTO(pacientes.getDNI(),pacientes.getNombre(),pacientes.getDomicilio(), pacientes.getMail(), pacientes.getSexo(), pacientes.getEdad());
        return dto;
    }

    public static ResultadosDTO toDTOResultado(ResultadoPractica resultado){
        ResultadosDTO dto = new ResultadosDTO(resultado.getResultadoPracticaID(),resultado.getPracticaID(),resultado.isEsCritico(),resultado.isValoresReservados(),resultado.getTiempoEstimado(),resultado.getValor());
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

    public static int buscarindexResulatdos(int id) {
        int index = -1;
        for (int i = 0; i < listResultados.size(); i++) {
            if (listResultados.get(i).getResultadoPracticaID() == id) {
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
        int index = buscarindexPacientes(dni);
        PacientesDTO pacientesDTO = toDTO(lista.get(index));
        pacientesDTO.setNombre(nombre);
        pacientesDTO.setEdad(edad);
        pacientesDTO.setMail(mail);
        pacientesDTO.setDomicilio(dom);
        pacientesDTO.setSexo(sexo);
        Pacientes pacientes = toModel(pacientesDTO);
        lista.set(index,pacientes);

    }

    public static void ModificarResultados(int id, int cod, boolean reservado, boolean criticos, int valor, int Tiempoestimado){
        int index = buscarindexResulatdos(id);
        ResultadosDTO resulatdosDTO = toDTOResultado(listResultados.get(index));
        resulatdosDTO.setResultadoPracticaID(id);
        resulatdosDTO.setPracticaID(cod);
        resulatdosDTO.setEsCritico(criticos);
        resulatdosDTO.setValoresReservados(reservado);
        resulatdosDTO.setValor(valor);
        resulatdosDTO.setTiempoEstimado(Tiempoestimado);
        ResultadoPractica res = toModelResultado(resulatdosDTO);
        listResultados.set(index,res);

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
        int index = buscarindexPracticas(id);
        PracticasDTO practicasDTO = toDTO2(lista2.get(index));
        practicasDTO.setCodigoPractica(codigo);
        practicasDTO.setNombrePractica(nom);
        practicasDTO.setGrupo(grupo);
        practicasDTO.setTiempoResultado(tiempo);
        practicasDTO.setDeshabilitada(des);
        Practica practica = toModel2(practicasDTO);
        lista2.set(index,practica);
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

    public static void modificarPeticiones(int id, int SucursalID, String obraSocial, String fechaCarga, String fechaEntrega, String estado){
        int index = ControllerPeticiones.buscarindexResulatdos(id);
        PeticionesDTO peticionesDTO = toDTO3(lista3.get(index));
        peticionesDTO.setSucursalID(SucursalID);
        peticionesDTO.setObraSocial(obraSocial);
        peticionesDTO.setFechaDeCarga(fechaCarga);
        peticionesDTO.setFechaEntrega(fechaEntrega);
        peticionesDTO.setEstado(estado);
        Peticiones peticiones = toModel3(peticionesDTO);
        lista3.set(index,peticiones);
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

    public static ValoresCriticos toModel4 (ValoresCriticosDTO dto){
        ValoresCriticos ValorCritico = new ValoresCriticos(dto.getNombre(), dto.getValorMin(), dto.getValorMax());
        return ValorCritico;
    }

    public static ValoresCriticosDTO toDTO4 (ValoresCriticos ValorCritico){
        ValoresCriticosDTO dto = new ValoresCriticosDTO(ValorCritico.getNombre(), ValorCritico.getValorMin(), ValorCritico.getValorMax());
        return dto;
    }






}








