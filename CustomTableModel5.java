/*package GUI;




import DTO.PeticionesDTO;
import DTO.ResultadosDTO;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.util.List;




public class CustomTableModel5 extends AbstractTableModel {

    private String [] columnNames = {"Resultado ID" , "Codigo de practica" , "Nombre de la practica" , "Grupo", "Valores Criticos" ,"Valores Reservados","Tiempo estimado"};

    private List<ResultadosDTO> dtoArrayList;


    public CustomTableModel5(List<ResultadosDTO> list){
        this.dtoArrayList = list;
    }




    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        int size;
        if (dtoArrayList == null) {
            size = 0;
        }
        else {
            size = dtoArrayList.size();
        }
        return size;
    }


















    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Class getColumnClass(int col) {return Integer.class; }
}


}
*/