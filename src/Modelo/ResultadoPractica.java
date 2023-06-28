package Modelo;

import jdk.dynalink.beans.StaticClass;

import java.security.interfaces.RSAKey;
import java.util.List;

public class ResultadoPractica {

    private int ResultadoPracticaID;
    private int practicaID;
    private boolean EsCritico;
    private boolean ValoresReservados;
    private int TiempoEstimado;

    private int valor;
    private static List<ItemPractica> practicaItem;

    public ResultadoPractica(int resultadoPracticaID, int practicaID, boolean esCritico, boolean valoresReservados, int tiempoEstimado, int valor) {
        ResultadoPracticaID = resultadoPracticaID;
        this.practicaID = practicaID;
        EsCritico = esCritico;
        ValoresReservados = valoresReservados;
        TiempoEstimado = tiempoEstimado;
        this.valor = valor;
    }

    public int getResultadoPracticaID() {
        return ResultadoPracticaID;
    }

    public void setResultadoPracticaID(int resultadoPracticaID) {
        ResultadoPracticaID = resultadoPracticaID;
    }

    public int getPracticaID() {
        return practicaID;
    }

    public void setPracticaID(int practicaID) {
        this.practicaID = practicaID;
    }

    public boolean isEsCritico() {
        return EsCritico;
    }

    public void setEsCritico(boolean esCritico) {
        EsCritico = esCritico;
    }

    public boolean isValoresReservados() {
        return ValoresReservados;
    }

    public void setValoresReservados(boolean valoresReservados) {
        ValoresReservados = valoresReservados;
    }

    public int getTiempoEstimado() {
        return TiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        TiempoEstimado = tiempoEstimado;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
