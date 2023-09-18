package components;

import domain.Member;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MemberTableModel extends AbstractTableModel {

    List<Member> members;

    public MemberTableModel(List<Member> members) {
        this.members = members;
    }

    @Override
    public int getRowCount() {
        return members.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Member member = members.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return member.getFirstname();
            case 1:
                return member.getLastname();
            case 2:
                return member.getIdCardNumber();
        }

        return "n/a";

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ime";
            case 1:
                return "Prezime";
            case 2:
                return "Broj lične karte";
        }
        return "n/a";
    }

}
