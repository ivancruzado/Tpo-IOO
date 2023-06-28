package GUI;
import DTO.PeticionesDTO;
import DTO.ResultadosDTO;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.util.List;

public class CustomTableResultados extends AbstractTableModel {


    private String [] columnNames = {"Resultado ID" , "Codigo de practica" , "Nombre de la practica" , "Grupo", "Valores Criticos" ,"Valores Reservados","Tiempo estimado"};

    private List<ResultadosDTO> dtoArrayList;


    public CustomTableResultados(List<ResultadosDTO> list){
        this.dtoArrayList = list;
    }

    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = dtoArrayList.get(row).getResultadoID();
        }
        else if (col == 1) {
            temp = dtoArrayList.get(row).getCodigoDePractica();
        }
        else if (col == 2) {
            temp = dtoArrayList.get(row).getNombreDePractica();
        }
        else if (col == 3) {
            temp = dtoArrayList.get(row).getGrupo();
        }
        else if (col == 4) {
            temp = dtoArrayList.get(row).getValoresCriticos();
        }
        else if (col == 5) {
            temp = dtoArrayList.get(row).getTiempoEstimado();
        }


        return temp;
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        int size;
        if (dtoArrayList != null) {
            size = dtoArrayList.size();
            return size;
        }
        return 0;
    }


















    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Class getColumnClass(int col) {return Integer.class; }
}




