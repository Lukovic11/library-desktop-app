package operation.book;

import domain.Book;
import operation.AbstractGenericOperation;

public class DeleteBook extends AbstractGenericOperation {

    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Book) param).getId() == null) {
            throw new Exception("ID knjige ne sme biti null!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Book) param);
    }

    public boolean isFlag() {
        return flag;
    }

}
