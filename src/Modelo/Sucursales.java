package Modelo;

import Controlador.ControllerPeticiones;
import Controlador.ControllerSucursales;
import DTO.SucursalesDTO;

import java.util.List;

public class Sucursales {
    int idSucursal;
    int numero;
    String direccion;
    String ResponsableTec;

    public Sucursales(int idSucursal, int numero, String direccion, String responsableTec) {
        this.idSucursal = idSucursal;
        this.numero = numero;
        this.direccion = direccion;
        ResponsableTec = responsableTec;
    }
    private ControllerSucursales controller = ControllerSucursales.getInstance();
    private List<SucursalesDTO> listaSucursales = controller.getAll();

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


    public Boolean sucursalExiste(int idSucursal){
        boolean encontrado = false;
        for (int i = 0; i < listaSucursales.size(); i++) {

            if(listaSucursales.get(i).getIdSucursal() == idSucursal){
                encontrado = true;
            }
        }
        return encontrado;
    }

    public Sucursales buscarSucursal(int idSucursal) {
        int index = 0;
        for (int i = 0; i < listaSucursales.size(); i++) {
            if (listaSucursales.get(i).getIdSucursal() == idSucursal) {
                index = i;
            }
        }
        Sucursales sucursal = new Sucursales(listaSucursales.get(index).getIdSucursal(),listaSucursales.get(index).getNumero(),listaSucursales.get(index).getDireccion(),
                listaSucursales.get(index).getResponsableTec());
        return sucursal;
    }

    public int getIdSucursalActiva(int idSucursalDadaBaja){
        int idActiva = (int) (Math.random() * 3) + 1;           //listaSucursales.size(
        while(idActiva == idSucursalDadaBaja){
            idActiva = (int) (Math.random() * 3) + 1;
        }

        return idActiva;
    }
}
