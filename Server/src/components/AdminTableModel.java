package components;

import domain.Administrator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AdminTableModel extends AbstractTableModel {

    String[] columnNames = new String[]{"firstname", "lastname", "password"};
    List<Administrator> admins;

    public AdminTableModel(List<Administrator> admins) {
        this.admins = admins;
    }

    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public int getRowCount() {
        return admins.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Administrator a = admins.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                a.getFirstname();
            case 1 ->
                a.getLastname();
            case 2 ->
                a.getPassword();
            default ->
                "n/a";
        };
    }

    public void addAdmin(Administrator a) {
        if (admins.contains(a)) {
            return;
        }
        admins.add(a);
        fireTableDataChanged();
    }

}
