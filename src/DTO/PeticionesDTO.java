package DTO;

import Modelo.Pacientes;
import Modelo.Practica;
import Modelo.ResultadoPractica;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PeticionesDTO {
    private int idPeticion;
    private int SucursalID;
    private Pacientes Paciente;
    private String ObraSocial;
    private String FechaDeCarga;
    private Practica PracticasAsociadas;
    private String FechaEntrega;
    private String estado;
    private List<ResultadoPractica> listaResultadosPractica;

    public PeticionesDTO(int idPeticion, int sucursalID, Pacientes paciente, String obraSocial, String fechaDeCarga, Practica practicasAsociadas, String fechaEntrega,String estado) {
        this.idPeticion = idPeticion;
        SucursalID = sucursalID;
        Paciente = paciente;
        ObraSocial = obraSocial;
        FechaDeCarga = fechaDeCarga;
        PracticasAsociadas = practicasAsociadas;
        FechaEntrega = fechaEntrega;
        this.estado = estado;
    }

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

    public String getFechaDeCarga() {
        return FechaDeCarga;
    }

    public void setFechaDeCarga(String fechaDeCarga) {
        FechaDeCarga = fechaDeCarga;
    }

    public Practica getPracticasAsociadas() {
        return PracticasAsociadas;
    }

    public void setPracticasAsociadas(Practica practicasAsociadas) {
        PracticasAsociadas = practicasAsociadas;
    }

    public String getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        FechaEntrega = fechaEntrega;
    }

    public List<ResultadoPractica> getListaResultadosPractica() {
        return listaResultadosPractica;
    }

    public void setListaResultadosPractica(List<ResultadoPractica> listaResultadosPractica) {
        this.listaResultadosPractica = listaResultadosPractica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
