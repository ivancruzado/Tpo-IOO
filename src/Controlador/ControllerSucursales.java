package Controlador;
import java.util.ArrayList;
import java.util.List;
import Modelo.Sucursales;

public class ControllerSucursales {
    private static ControllerSucursales SINGLETON = null;

    List<Sucursales> listaSucursal = new ArrayList<Sucursales>();


    private ControllerSucursales(){}

    public static ControllerSucursales getInstance(){
        if(SINGLETON == null){
            SINGLETON = new ControllerSucursales();
        }
        return SINGLETON;
    }
}
