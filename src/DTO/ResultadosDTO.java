package DTO;

public class ResultadosDTO {

    private int     ResultadoID ;
    private int     CodigoDePractica ;
    private String  NombreDePractica ;
    private String  Grupo ;
    private int     ValoresCriticos ;
    private boolean ValoresReservados;
    private int     TiempoEstimado;

    public ResultadosDTO(int resultadoID, int codigoDePractica, String nombreDePractica, String grupo, int valoresCriticos, boolean valoresReservados, int tiempoEstimado) {
        ResultadoID = resultadoID;
        CodigoDePractica = codigoDePractica;
        NombreDePractica = nombreDePractica;
        Grupo = grupo;
        ValoresCriticos = valoresCriticos;
        ValoresReservados = valoresReservados;
        TiempoEstimado = tiempoEstimado;
    }

    public int getResultadoID() {
        return ResultadoID;
    }

    public void setResultadoID(int resultadoID) {
        ResultadoID = resultadoID;
    }

    public int getCodigoDePractica() {
        return CodigoDePractica;
    }

    public void setCodigoDePractica(int codigoDePractica) {
        CodigoDePractica = codigoDePractica;
    }

    public String getNombreDePractica() {
        return NombreDePractica;
    }

    public void setNombreDePractica(String nombreDePractica) {
        NombreDePractica = nombreDePractica;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    public int getValoresCriticos() {
        return ValoresCriticos;
    }

    public void setValoresCriticos(int valoresCriticos) {
        ValoresCriticos = valoresCriticos;
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



}
