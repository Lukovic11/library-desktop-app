package operation.autor;

import domain.Author;
import operation.AbstractGenericOperation;

public class SaveAuthor extends AbstractGenericOperation {

    private Author author;
    private String exception = "";
    private String exceptionId;
    private String exceptionFirstname;
    private String exceptionLastname;


    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Author) param).getAuthorId() == 0 || ((Author) param).getAuthorId() == 0L || ((Author) param).getAuthorId() == null) {
            exceptionId = "Nevalidan ID!\n";
            exception += exceptionId;
        }
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
        author = (Author) repository.save((Author)param);
    }

    public Author getAuthor() {
        return author;
    }

}
