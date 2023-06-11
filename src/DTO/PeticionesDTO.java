package DTO;

import Modelo.Pacientes;
import Modelo.Practica;
import Modelo.ResultadoPractica;

import java.util.Date;
import java.util.List;

public class PeticionesDTO {
    private int idPeticion;
    private int SucursalID;
    private Pacientes Paciente;
    private String ObraSocial;
    private Date FechaDeCarga;
    private Practica PracticasAsociadas;
    private Date FechaEntrega;

    public PeticionesDTO(int idPeticion, int sucursalID, Pacientes paciente, String obraSocial, Date fechaDeCarga, Practica practicasAsociadas, Date fechaEntrega) {
        this.idPeticion = idPeticion;
        SucursalID = sucursalID;
        Paciente = paciente;
        ObraSocial = obraSocial;
        FechaDeCarga = fechaDeCarga;
        PracticasAsociadas = practicasAsociadas;
        FechaEntrega = fechaEntrega;
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

}
