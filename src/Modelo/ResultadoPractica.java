package Modelo;

import jdk.dynalink.beans.StaticClass;

import java.security.interfaces.RSAKey;
import java.util.List;

public class ResultadoPractica {

    private int ResultadoPracticaID;
    private int practicaID;
    private static List<ItemPractica> practicaItem;

    private List <ItemPractica> getPracticaItem ;

    ResultadoPractica Rs = new ResultadoPractica(100,2 );


    public void AgregarPracticaItem (){
        practicaItem.add(new ItemPractica(Rs,"Analisis de Sangre",400,true));


    }



    public ResultadoPractica(int resultadoPracticaID, int practicaID) {
        ResultadoPracticaID = resultadoPracticaID;
        this.practicaID = practicaID;
    }

    public ItemPractica getItemPractica(int resultadoPracticaID){
        int index = -1;
        for (int i = 0; i < practicaItem.size(); i++) {
            if (practicaItem.get(i).getResultadoPracticaID().equals(resultadoPracticaID)) {
                index = i;
            }
        }
        ItemPractica itemPractica = new ItemPractica(practicaItem.get(index).resultadoPracticaID,practicaItem.get(index).getNombre(),practicaItem.get(index).getValor(),
                practicaItem.get(index).getReservado());
        return itemPractica;
    }



    public Boolean esReservado(ItemPractica itemPractica){
        boolean reservado = itemPractica.getReservado();
        return reservado;
    }

    public int getResultadoPracticaID() {
        return ResultadoPracticaID;
    }

    public void setResultadoPracticaID(int resultadoPracticaID) {
        ResultadoPracticaID = resultadoPracticaID;
    }

    public int getPracticaID() {
        return practicaID;
    }

    public void setPracticaID(int practicaID) {
        this.practicaID = practicaID;
    }





}
