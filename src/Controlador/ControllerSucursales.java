package Controlador;

import java.util.ArrayList;
import java.util.List;

import DTO.SucursalesDTO;
import Modelo.Sucursales;

public class ControllerSucursales {
    private static ControllerSucursales SINGLETON = null;

    private static List<Sucursales> listaSucursales = new ArrayList<>();

    private ControllerSucursales(){}

    public synchronized static ControllerSucursales getInstance(){
        if(SINGLETON == null){
            SINGLETON = new ControllerSucursales();
            initSucursales();
        }
        return SINGLETON;
    }

    private static void initSucursales(){
        listaSucursales = new ArrayList<>();
        listaSucursales.add(new Sucursales(1,24,"direccion 1", "ivan"));
        listaSucursales.add(new Sucursales(2,25,"direccion 2", "Juan"));
        listaSucursales.add(new Sucursales(3,26,"direccion 3", "Tomas"));

    }

    public void altaSucursal(SucursalesDTO dto){
        Sucursales sucursales = toModel(dto);
        listaSucursales.add(sucursales);
    }


    public void bajaSucursal(int id) {               //corregir si tiene peticiones activas no puede eliminarse
        List<SucursalesDTO> lista =getAll();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getIdSucursal() == id){
                toDTO(listaSucursales.remove(i));
            }
        }
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
    public List<SucursalesDTO> getAll() {
        List<SucursalesDTO> listaSucursalesDTO = new ArrayList<>();
        for (Sucursales sucursal : listaSucursales) {
            listaSucursalesDTO.add(toDTO(sucursal));
        }
        return listaSucursalesDTO;
    }

    public int[] getIdSucursal(){
        int[]idSucursales = new int[listaSucursales.size()];
        for (int i = 0; i < listaSucursales.size(); i++) {

            idSucursales[i] = listaSucursales.get(i).getIdSucursal();
        }
        return idSucursales;
    }

    public static Sucursales toModel(SucursalesDTO dto) {
        Sucursales sucursal = new Sucursales(dto.getIdSucursal(),dto.getNumero(),dto.getDireccion(),dto.getResponsableTec());
        return sucursal;
    }

    public static SucursalesDTO toDTO(Sucursales sucursales){
        SucursalesDTO dto = new SucursalesDTO(sucursales.getIdSucursal(),sucursales.getNumero(),sucursales.getDireccion(),sucursales.getResponsableTec());
        return dto;
    }
}
