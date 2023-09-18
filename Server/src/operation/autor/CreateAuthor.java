package operation.autor;

import domain.Author;
import operation.AbstractGenericOperation;

public class CreateAuthor extends AbstractGenericOperation {

    private Author author;
    private String exception = "";
    private String exceptionFirstname;
    private String exceptionLastname;

    public CreateAuthor(Author author) {
        this.author = author;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Author) param).getFirstname() == null) {
            exceptionFirstname = "Ime ne sme biti null!\n";
            exception += exceptionFirstname;
        }
        if (((Author) param).getLastname() == null) {
            exceptionLastname = "Prezime ne sme biti null!\n";
            exception += exceptionLastname;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        author = (Author) repository.create(author);
    }

    public Author getAuthor() {
        return author;
    }

}
