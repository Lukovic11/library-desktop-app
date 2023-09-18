package components;

import domain.Administrator;
import domain.Member;
import domain.Order;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class OrderTableModel extends AbstractTableModel {

    List<Order> orders;

    public OrderTableModel(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Order order = orders.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                order.getIssueDate();
            case 1 ->
                order.getValidUntil();
            case 2 ->
                order.getAdministrator();
            case 3 ->
                order.getMember();
            case 4 ->
                order.isStatus();
            default ->
                "n/a";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "Datum izdavanja";
            case 1 ->
                "Vratiti do";
            case 2 ->
                "Izdao/la";
            case 3 ->
                "Član";
            case 4 ->
                "Status";
            default ->
                "n/a";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 ->
                LocalDate.class;
            case 1 ->
                LocalDate.class;
            case 2 ->
                Administrator.class;
            case 3 ->
                Member.class;
            case 4 ->
                Boolean.class;
            default ->
                null;
        };
    }

}
