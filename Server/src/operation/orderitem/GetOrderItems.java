package operation.orderitem;

import domain.Book;
import domain.OrderItem;
import java.util.List;
import operation.AbstractGenericOperation;

public class GetOrderItems extends AbstractGenericOperation {

    List<OrderItem> orderItems;
    List<Book> books;

    @Override
    protected void preconditions(Object param) throws Exception {
        //Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        orderItems = repository.get((OrderItem) param);
        books = repository.get(new Book());
        for (OrderItem oi : orderItems) {
            for (Book b : books) {
                if (oi.getBook().getId().equals(b.getId())) {
                    oi.setBook(b);
                }
            }
        }
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

}
