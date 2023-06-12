package Modelo;

import java.util.List;

public class ValoresCriticos {
    private String nombre;
    private int valorMin;
    private int valorMax;


    private static List<ValoresCriticos> valoresCriticos;

    public ValoresCriticos(String nombre, int valorMin, int valorMax) {
        this.nombre = nombre;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
    }

    public static ValoresCriticos getValoresCriticos(String nombre){
        int index = 0;
        for (int i = 0; i < valoresCriticos.size(); i++) {
            if (valoresCriticos.get(i).getNombre().equalsIgnoreCase( nombre)) {
                index = i;
            }
        }
        ValoresCriticos valoresCriticos1 = new ValoresCriticos(valoresCriticos.get(index).getNombre(),valoresCriticos.get(index).getValorMin(),valoresCriticos.get(index).getValorMax());
        return valoresCriticos1;
    }

    public void agregarValorCritico(){
        valoresCriticos.add(new ValoresCriticos(this.nombre,this.valorMin,this.valorMax));
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorMin() {
        return valorMin;
    }

    public void setValorMin(int valorMin) {
        this.valorMin = valorMin;
    }

    public int getValorMax() {
        return valorMax;
    }

    public void setValorMax(int valorMax) {
        this.valorMax = valorMax;
    }
}
