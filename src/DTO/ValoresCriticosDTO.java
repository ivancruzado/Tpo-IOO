package DTO;

public class ValoresCriticosDTO {

    private String Nombre;
    private int ValorMin;

    private int ValorMax;




    public ValoresCriticosDTO(String nombre, int ValorMin, int ValorMax) {
        this.Nombre = nombre;
        this.ValorMin = ValorMin;
        this.ValorMax = ValorMax;

    }







    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getValorMin() {
        return ValorMin;
    }

    public void setValorMin(int valorMin) {
        ValorMin = valorMin;
    }

    public int getValorMax() {
        return ValorMax;
    }

    public void setValorMax(int valorMax) {
        ValorMax = valorMax;
    }



}
