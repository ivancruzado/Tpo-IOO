package Controlador;
import java.util.ArrayList;
import java.util.List;

import Modelo.Sucursales;

public class ControllerSucursales {
    private static ControllerSucursales SINGLETON = null;

    private static List<Sucursales> listaSucursales = new ArrayList<>();

    private ControllerSucursales(){}

    public static ControllerSucursales getInstance(){
        if(SINGLETON == null){
            SINGLETON = new ControllerSucursales();
        }
        return SINGLETON;
    }

    public void altaSucursal(int idSucursal, int numero, String direccion, String responsableTec){

        Sucursales nuevos = new Sucursales(idSucursal, numero, direccion, responsableTec);
        nuevos.setIdSucursal(idSucursal);
        nuevos.setNumero(numero);
        nuevos.setDireccion(direccion);
        nuevos.setResponsableTec(responsableTec);

        listaSucursales.add(nuevos);
    }

    public void bajaSucursal(int index) {
        listaSucursales.remove(index);     //corregir si tiene peticiones activas no puede eliminarse
    }

    public int buscarindexSucursal(int idSucursal){
        int index = 0;
        for (int i = 0; i < listaSucursales.size(); i++) {
            if (listaSucursales.get(i).getIdSucursal() == idSucursal) {
                index = i;
            }
        }
        return index;
    }

    public void modificarSucursal(int idSucursal, int numero, String direccion, String responsableTec){

        listaSucursales.get(buscarindexSucursal(idSucursal)).setIdSucursal(idSucursal);
        listaSucursales.get(buscarindexSucursal(idSucursal)).setNumero(numero);
        listaSucursales.get(buscarindexSucursal(idSucursal)).setDireccion(direccion);
        listaSucursales.get(buscarindexSucursal(idSucursal)).setResponsableTec(responsableTec);

    }

    public List<Sucursales> getListaSucursales(){
        return listaSucursales;
    }

}
