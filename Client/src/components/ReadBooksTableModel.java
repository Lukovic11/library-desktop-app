package components;

import domain.Book;
import domain.ReadBook;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ReadBooksTableModel extends AbstractTableModel {

    List<ReadBook> readBooks;

    public ReadBooksTableModel(List<ReadBook> readBooks) {
        this.readBooks = readBooks;
        System.out.println(readBooks);
    }

    @Override
    public int getRowCount() {
        return readBooks.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ReadBook readBook = readBooks.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                readBook.getBook().getTitle();
            case 1 ->
                readBook.getBook().getAuthor();
            default ->
                "n/a";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "Naziv knjige";
            case 1 ->
                "Autor";
            default ->
                "n/a";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
         return switch (columnIndex) {
            case 0 ->
                Book.class;
            case 1 ->
                Book.class;
            default ->
                null;
        };
    }

    
    
    
    
}
