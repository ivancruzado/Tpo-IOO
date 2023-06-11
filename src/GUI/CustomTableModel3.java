package GUI;

import DTO.SucursalesDTO;


import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CustomTableModel3 extends AbstractTableModel {

    private String[] columnNames = {"Id Sucursal", "Numero", "Direccion", "Responsable Tecnico"};
    private List<SucursalesDTO> dtoArrayList;



    public CustomTableModel3(List<SucursalesDTO> list){
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
            temp = dtoArrayList.get(row).getIdSucursal();
        }
        else if (col == 1) {
            temp = dtoArrayList.get(row).getNumero();
        }
        else if (col == 2) {
            temp = dtoArrayList.get(row).getDireccion();
        }
        else if (col == 3) {
            temp = dtoArrayList.get(row).getResponsableTec();
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
