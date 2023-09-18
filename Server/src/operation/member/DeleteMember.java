package operation.member;

import domain.Member;
import operation.AbstractGenericOperation;

public class DeleteMember extends AbstractGenericOperation {

    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Member) param).getId() == null) {
            throw new Exception("ID člana ne sme biti null!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Member) param);
    }

    public boolean isFlag() {
        return flag;
    }

}
