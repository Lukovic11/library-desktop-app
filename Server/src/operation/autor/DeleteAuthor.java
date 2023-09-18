package operation.autor;

import domain.Author;
import operation.AbstractGenericOperation;

public class DeleteAuthor extends AbstractGenericOperation {

    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Author) param).getAuthorId() == null) {
            throw new Exception("ID autora ne sme biti null!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Author) param);
    }

    public boolean isFlag() {
        return flag;
    }

}
