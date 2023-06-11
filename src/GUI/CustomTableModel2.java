package GUI;

import DTO.PracticasDTO;


import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CustomTableModel2 extends AbstractTableModel {

    private String[] columnNames = {"Practica ID", "Codigo de practica", "Nombre de practica", "Grupo", "Tiempo resultado","Deshabilitado"};
    private List<PracticasDTO> dtoArrayList;



    public CustomTableModel2(List<PracticasDTO> list){
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

    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = dtoArrayList.get(row).getPracticaID();
        }
        else if (col == 1) {
            temp = dtoArrayList.get(row).getCodigoPractica();
        }
        else if (col == 2) {
            temp = dtoArrayList.get(row).getNombrePractica();
        }
        else if (col == 3) {
            temp = dtoArrayList.get(row).getGrupo();
        }
        else if (col == 4) {
            temp = dtoArrayList.get(row).getTiempoResultado();
        }
        else if (col == 5) {
            temp = dtoArrayList.get(row).isDeshabilitada();
        }
        return temp;
    }
    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Class getColumnClass(int col) {
        return Integer.class;
    }
}
