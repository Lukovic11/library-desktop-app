package operation.book;

import domain.Book;
import operation.AbstractGenericOperation;

public class CreateBook extends AbstractGenericOperation {

    private Book book;
    private String exception = "";
    private String exceptionAuthor;
    private String exceptionTitle;
    private String exceptionAvailable;

    public CreateBook(Book book) {
        this.book = book;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Book) param).getAuthor() == null) {
            exceptionAuthor = "Autor ne sme biti null!\n";
            exception += exceptionAuthor;
        }
        if (((Book) param).getTitle() == null) {
            exceptionTitle = "Naslov ne sme biti null!\n";
            exception += exceptionTitle;
        }
        if (((Book) param).getAvailable() != true && ((Book) param).getAvailable() != false) {
            exceptionAvailable = "Dostupnost mora biti true ili false!\n";
            exception += exceptionAvailable;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        book = (Book) repository.create(book);
    }

    public Book getBook() {
        return book;
    }

}
