package GUI;

import DTO.PeticionesDTO;
import DTO.SucursalesDTO;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.util.List;

public class CustomTableModel4 extends AbstractTableModel {

    private String[] columnNames = {"Id Peticion", "Sucursal ID", "Paciente", "Obra social", "Fecha de carga", "practicas", "Fecha entrega","estado"};
    private List<PeticionesDTO> dtoArrayList;



    public CustomTableModel4(List<PeticionesDTO> list){
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
            temp = dtoArrayList.get(row).getIdPeticion();
        }
        else if (col == 1) {
            temp = dtoArrayList.get(row).getSucursalID();
        }
        else if (col == 2) {
            temp = dtoArrayList.get(row).getPaciente().getDNI();
        }
        else if (col == 3) {
            temp = dtoArrayList.get(row).getObraSocial();
        }
        else if (col == 4) {
            temp = dtoArrayList.get(row).getFechaDeCarga();
        }
        else if (col == 5) {
            temp = dtoArrayList.get(row).getPracticasAsociadas().getNombrePractica();
        }
        else if (col == 6) {
            temp = dtoArrayList.get(row).getFechaEntrega();
        }
        else if (col == 7) {
            temp = dtoArrayList.get(row).getEstado();
        }
        return temp;
    }
    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Class getColumnClass(int col) {return Integer.class; }
}
