package GUI;

import DTO.PacientesDTO;


import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CustomTableModel extends AbstractTableModel {

    private String[] columnNames = {"DNI","Nombre","Edad","Domicilio","Sexo","Mail"};
    private List<PacientesDTO> dtoArrayList;



    public CustomTableModel(List<PacientesDTO> list){
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
            temp = dtoArrayList.get(row).getDni();
        }
        else if (col == 1) {
            temp = dtoArrayList.get(row).getNombre();
        }
        else if (col == 2) {
            temp = dtoArrayList.get(row).getEdad();
        }
        else if (col == 3) {
            temp = dtoArrayList.get(row).getDomicilio();
        }
        else if (col == 4) {
            temp = dtoArrayList.get(row).getSexo();
        }
        else if (col == 5) {
            temp = dtoArrayList.get(row).getMail();
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
