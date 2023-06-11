package DTO;


import java.util.List;

public class SucursalesDTO {
    int idSucursal;
    int numero;
    String direccion;
    String ResponsableTec;

    public SucursalesDTO(int idSucursal, int numero, String direccion, String responsableTec) {
        this.idSucursal = idSucursal;
        this.numero = numero;
        this.direccion = direccion;
        ResponsableTec = responsableTec;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getResponsableTec() {
        return ResponsableTec;
    }

    public void setResponsableTec(String responsableTec) {
        ResponsableTec = responsableTec;
    }
}
