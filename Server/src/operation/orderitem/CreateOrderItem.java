package operation.orderitem;

import domain.OrderItem;
import operation.AbstractGenericOperation;

public class CreateOrderItem extends AbstractGenericOperation {

    OrderItem orderItem;
    String exception = "";
    String exceptionBook;
    String exceptionOrder;

    public CreateOrderItem(OrderItem par) {
        orderItem = par;
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
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        orderItem = (OrderItem) repository.create(orderItem);
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

}
