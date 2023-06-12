package Modelo;

import Controlador.ControllerPeticiones;
import DTO.PacientesDTO;

import java.util.Date;
import java.util.List;

public class Peticiones {
    private int idPeticion;
    private int SucursalID;
    private Pacientes Paciente;
    private String ObraSocial;
    private Date FechaDeCarga;
    private Practica PracticasAsociadas;
    private Date FechaEntrega;
    private List<ResultadoPractica> listaResultadosPractica;

    public Peticiones(int idPeticion, int sucursalID, Pacientes paciente, String obraSocial, Date fechaDeCarga, Practica practicasAsociadas, Date fechaEntrega,List<ResultadoPractica> listaResultadosPractica) {
        this.idPeticion = idPeticion;
        SucursalID = sucursalID;
        Paciente = paciente;
        ObraSocial = obraSocial;
        FechaDeCarga = fechaDeCarga;
        PracticasAsociadas = practicasAsociadas;
        FechaEntrega = fechaEntrega;
        this.listaResultadosPractica = listaResultadosPractica;
    }

    public void altaResultadoPractica(){
        ResultadoPractica resultadoPractica = new ResultadoPractica(idPeticion,PracticasAsociadas.getPracticaID());
    }

    /*public Peticiones getPeticiones(Pacientes paciente){
        int index = 0;
        List<PacientesDTO>listaP = ControllerPeticiones.getInstance().getAll();
        for (int i = 0; i < listaP.size(); i++) {
            if (listaP.get(i).equals(paciente)) {
                index = i;
            }
        }
        Peticiones peticiones = new Peticiones()
        Pacientes pacientes = new Pacientes(lista.get(index).getDNI(),lista.get(index).getNombre(),lista.get(index).getDomicilio(),
                lista.get(index).getMail(),lista.get(index).getSexo(),lista.get(index).getEdad());
        return pacientes;
    }

     */


    public int getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(int idPeticion) {
        this.idPeticion = idPeticion;
    }

    public int getSucursalID() {
        return SucursalID;
    }

    public void setSucursalID(int sucursalID) {
        SucursalID = sucursalID;
    }

    public Pacientes getPaciente() {
        return Paciente;
    }

    public void setPaciente(Pacientes paciente) {
        Paciente = paciente;
    }

    public String getObraSocial() {
        return ObraSocial;
    }

    public void setObraSocial(String obraSocial) {
        ObraSocial = obraSocial;
    }

    public Date getFechaDeCarga() {
        return FechaDeCarga;
    }

    public void setFechaDeCarga(Date fechaDeCarga) {
        FechaDeCarga = fechaDeCarga;
    }

    public Practica getPracticasAsociadas() {
        return PracticasAsociadas;
    }

    public void setPracticasAsociadas(Practica practicasAsociadas) {
        PracticasAsociadas = practicasAsociadas;
    }

    public Date getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        FechaEntrega = fechaEntrega;
    }

    public List<ResultadoPractica> getListaResultadosPractica() {
        return listaResultadosPractica;
    }

    public void setListaResultadosPractica(List<ResultadoPractica> listaResultadosPractica) {
        this.listaResultadosPractica = listaResultadosPractica;
    }
}
