package Modelo;

public class ItemPractica {

    ResultadoPractica resultadoPracticaID;
    String nombre;
    int valor;
    Boolean reservado;

    public ItemPractica(ResultadoPractica resultadoPracticaID, String nombre, int valor, Boolean reservado) {
        this.resultadoPracticaID = resultadoPracticaID;
        this.nombre = nombre;
        this.valor = valor;
        this.reservado = reservado;
    }

    public Boolean esCritico(String nombre){                   //nombre o practicaID
        ValoresCriticos listaValores = ValoresCriticos.getValoresCriticos(nombre);
        boolean critico = false;
        int valorMin = listaValores.getValorMin();
        int valorMax = listaValores.getValorMax();
        if (this.valor>valorMax || this.valor<valorMin){
            critico = true;
        }
        return critico;
    }

    public ResultadoPractica getResultadoPracticaID() {
        return resultadoPracticaID;
    }

    public void setResultadoPracticaID(ResultadoPractica resultadoPracticaID) {
        this.resultadoPracticaID = resultadoPracticaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }
}
