package components;

import domain.Author;
import domain.Book;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BooksTableModel extends AbstractTableModel {

    List<Book> books;

    public BooksTableModel(List<Book> books) {
        this.books = books;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = books.get(rowIndex);

        switch (columnIndex) {
            case 0 -> {
                return book.getTitle();
            }
            case 1 -> {
                return book.getAuthor();
            }
            case 2 -> {
                return book.getAvailable();
            }
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "Naziv";
            case 1 ->
                "Autor";
            case 2 ->
                "Dostupnost";
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
                Author.class;
            case 2 ->
                Boolean.class;
            default ->
                Object.class;
        };
    }

}
