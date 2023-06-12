package Modelo;

public class ResultadoPeticion {
    private int IDResultado;
    private String estado;
    private Peticiones idPeticion;

    public ResultadoPeticion(int IDResultado, String estado, Peticiones idPeticion) {
        this.IDResultado = IDResultado;
        this.estado = estado;
        this.idPeticion = idPeticion;
    }

    public int getIDResultado() {
        return IDResultado;
    }

    public void setIDResultado(int IDResultado) {
        this.IDResultado = IDResultado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Peticiones getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Peticiones idPeticion) {
        this.idPeticion = idPeticion;
    }

    public boolean estaFinalizado() {
        boolean finalizado = false;
        if (estado.equals("finalizado")) {
            finalizado = true;
        }
        return finalizado;
    }
}

