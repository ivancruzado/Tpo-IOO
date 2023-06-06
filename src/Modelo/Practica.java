package Modelo;

import java.util.Date;

public class Practica {

    int practicaID;
    int codigoPractica;
    String nombrePractica;
    String grupo;
    int tiempoResultado;
    boolean deshabilitada;

    public Practica(int practicaID, int codigoPractica, String nombrePractica, String grupo, int tiempoResultado,boolean deshabilitada) {
        this.practicaID = practicaID;
        this.codigoPractica = codigoPractica;
        this.nombrePractica = nombrePractica;
        this.grupo = grupo;
        this.tiempoResultado = tiempoResultado;
        this.deshabilitada = deshabilitada;
    }

    public int getPracticaID() {
        return practicaID;
    }

    public void setPracticaID(int practicaID) {
        this.practicaID = practicaID;
    }

    public int getCodigoPractica() {
        return codigoPractica;
    }

    public void setCodigoPractica(int codigoPractica) {
        this.codigoPractica = codigoPractica;
    }

    public String getNombrePractica() {
        return nombrePractica;
    }

    public void setNombrePractica(String nombrePractica) {
        this.nombrePractica = nombrePractica;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getTiempoResultado() {
        return tiempoResultado;
    }

    public void setTiempoResultado(int tiempoResultado) {
        this.tiempoResultado = tiempoResultado;
    }

    public boolean isDeshabilitada() {
        return deshabilitada;
    }

    public void setDeshabilitada(boolean deshabilitada) {
        this.deshabilitada = deshabilitada;
    }





}
