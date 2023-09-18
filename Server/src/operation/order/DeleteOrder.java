package operation.order;

import domain.Order;
import operation.AbstractGenericOperation;

public class DeleteOrder extends AbstractGenericOperation {

    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Order) param).getOrderId() == null) {
            throw new Exception("ID naloga ne sme biti null!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Order) param);
    }

    public boolean isFlag() {
        return flag;
    }

}
