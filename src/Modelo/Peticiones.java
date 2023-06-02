package Modelo;

import java.util.Date;
import java.util.List;



public class Peticiones {
    private int idPeticion;
    private String SucursalID;
    private String Paciente;
    private String ObraSocial;
    private Date FechaDeCarga;
    private String PracticasAsociadas;
    private Date FechaEntrega;
    private int PracticaID;
    private List<ResultadoPractica> Resultados;

    public Peticiones(String sucursalID, String paciente, int idPeticion){       //Constructor
        this.SucursalID = sucursalID;
        this.Paciente = paciente;
        this.idPeticion = idPeticion;

    }

        

    public int GetPracticaID(){

        return PracticaID;
    }

    public int getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(int idPeticion) {
        this.idPeticion = idPeticion;
    }
}
