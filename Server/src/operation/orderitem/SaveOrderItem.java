package operation.orderitem;

import domain.OrderItem;
import operation.AbstractGenericOperation;

public class SaveOrderItem extends AbstractGenericOperation {

    OrderItem orderItem;
    String exception = "";
    String exceptionBook;
    String exceptionOrder;
    String exceptionOrderItemId;

    public SaveOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if (orderItem.getBook() == null) {
            exceptionBook = "Knjiga ne sme biti null!\n";
            exception += exceptionBook;
        }
        if (orderItem.getOrder() == null) {
            exceptionOrder = "Nalog ne sme biti null!\n";
            exception += exceptionOrder;
        }
        if (orderItem.getOrderItemId() == null) {
            exceptionOrderItemId = "ID stavke naloga ne sme biti null!\n";
            exception += exceptionOrderItemId;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        orderItem = (OrderItem) repository.save((OrderItem) param);
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

}
