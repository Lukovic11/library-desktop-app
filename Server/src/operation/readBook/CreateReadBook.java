package operation.readBook;

import domain.ReadBook;
import operation.AbstractGenericOperation;

public class CreateReadBook extends AbstractGenericOperation {

    ReadBook readBook;
    private String exception = "";
    private String exceptionMember;
    private String exceptionBook;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((ReadBook) param).getMember() == null) {
            exceptionMember = "Član ne sme biti null!\n";
            exception += exceptionMember;
        }
        if (((ReadBook) param).getBook() == null) {
            exceptionBook = "Knjiga ne sme biti null!\n";
            exception += exceptionBook;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        readBook = (ReadBook) repository.create((ReadBook) param);
    }

    public ReadBook getReadBook() {
        return readBook;
    }

}
