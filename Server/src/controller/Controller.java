package controller;

import domain.Administrator;
import domain.Author;
import domain.Book;
import domain.Member;
import domain.Order;
import domain.OrderItem;
import domain.ReadBook;
import operation.AbstractGenericOperation;
import operation.administrator.GetAdministrators;
import operation.autor.CreateAuthor;
import operation.autor.DeleteAuthor;
import operation.autor.GetAuthors;
import operation.autor.SaveAuthor;
import operation.book.CreateBook;
import operation.book.DeleteBook;
import operation.book.GetBooks;
import operation.book.SaveBook;
import operation.login.Login;
import operation.member.CreateMember;
import operation.member.DeleteMember;
import operation.member.GetMembers;
import operation.member.SaveMember;
import operation.order.CreateOrder;
import operation.order.DeleteOrder;
import operation.order.GetOrders;
import operation.order.SaveOrder;
import operation.orderitem.CreateOrderItem;
import operation.orderitem.GetOrderItems;
import operation.orderitem.SaveOrderItem;
import operation.readBook.GetReadBooks;
import operation.readBook.CreateReadBook;

public class Controller {

    private static Controller controller;
    private AbstractGenericOperation operation;

    public Controller() {
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public Object login(Administrator administrator) throws Exception {
        operation = new Login();
        operation.execute(administrator);
        return ((Login) operation).getLogin();
    }

    public Object create(Object object) throws Exception {
        if (object instanceof Book) {
            return createBook(object);
        }
        if (object instanceof Author) {
            return createAuthor(object);
        }
        if (object instanceof Member) {
            return createMember(object);
        }
        if (object instanceof Order) {
            return createOrder(object);
        }
        if (object instanceof OrderItem) {
            return createOrderItem(object);
        }
        if (object instanceof ReadBook) {
            return createReadBook(object);
        }
        return null;
    }

    public Object save(Object object) throws Exception {
        if (object instanceof Book) {
            return saveBook(object);
        }
        if (object instanceof Author) {
            return saveAuthor(object);
        }
        if (object instanceof Member) {
            return saveMember(object);
        }
        if (object instanceof Order) {
            return saveOrder(object);
        }
        if (object instanceof OrderItem) {
            return saveOrderItem(object);
        }
        
        return null;
    }

    public Object delete(Object object) throws Exception {
        if (object instanceof Book) {
            return deleteBook(object);
        }
        if (object instanceof Author) {
            return deleteAuthor(object);
        }
        if (object instanceof Member) {
            return deleteMember(object);
        }
        if (object instanceof Order) {
            return deleteOrder(object);
        }
        return null;
    }

    public Object get(Object object) throws Exception {
        if (object instanceof Administrator) {
            return getAdministrators(object);
        }
        if (object instanceof Book) {
            return getBooks(object);
        }
        if (object instanceof Author) {
            return getAuthors(object);
        }
        if (object instanceof Member) {
            return getMembers(object);
        }
        if (object instanceof Order) {
            return getOrders(object);
        }
        if (object instanceof OrderItem) {
            return getOrderItems(object);
        }
        if (object instanceof ReadBook) {
            return getReadBooks(object);
        }
        return null;
    }

    private Object createBook(Object object) throws Exception {
        operation = new CreateBook((Book) object);
        operation.execute(object);
        return ((CreateBook) operation).getBook();
    }
    
    private Object createAuthor(Object object) throws Exception {
        operation = new CreateAuthor((Author) object);
        operation.execute(object);
        return ((CreateAuthor) operation).getAuthor();
    }

    private Object createMember(Object object) throws Exception {
        operation = new CreateMember();
        operation.execute(object);
        return ((CreateMember) operation).getMember();
    }

    private Object createOrder(Object object) throws Exception {
        operation = new CreateOrder((Order) object);
        operation.execute(object);
        return ((CreateOrder) operation).getOrder();
    }

    private Object createOrderItem(Object object) throws Exception {
        operation = new CreateOrderItem((OrderItem) object);
        operation.execute(object);
        return ((CreateOrderItem) operation).getOrderItem();
    }

    private Object createReadBook(Object object) throws Exception {
        operation = new CreateReadBook();
        operation.execute(object);
        return ((CreateReadBook) operation).getReadBook();
    }
    
    private Object saveBook(Object object) throws Exception {
        operation = new SaveBook();
        operation.execute(object);
        return ((SaveBook) operation).getBook();
    }
    
    private Object saveAuthor(Object object) throws Exception {
        operation = new SaveAuthor();
        operation.execute(object);
        return ((SaveAuthor) operation).getAuthor();
    }

    private Object saveMember(Object object) throws Exception {
        operation = new SaveMember();
        operation.execute(object);
        return ((SaveMember) operation).getMember();
    }

    private Object saveOrder(Object object) throws Exception {
        operation = new SaveOrder();
        operation.execute(object);
        return ((SaveOrder) operation).getOrder();
    }

    private Object saveOrderItem(Object object) throws Exception {
        operation = new SaveOrderItem((OrderItem) object);
        operation.execute(object);
        return ((SaveOrderItem) operation).getOrderItem();
    }
    

    private Object deleteBook(Object object) throws Exception {
        operation = new DeleteBook();
        operation.execute(object);
        return ((DeleteBook) operation).isFlag();
    }
    
    private Object deleteAuthor(Object object) throws Exception {
        operation = new DeleteAuthor();
        operation.execute(object);
        return ((DeleteAuthor) operation).isFlag();
    }

    private Object deleteMember(Object object) throws Exception {
        operation = new DeleteMember();
        operation.execute(object);
        return ((DeleteMember) operation).isFlag();
    }

    private Object deleteOrder(Object object) throws Exception {
        operation = new DeleteOrder();
        operation.execute(object);
        return ((DeleteOrder) operation).isFlag();
    }

    private Object getAdministrators(Object object) throws Exception {
        operation = new GetAdministrators();
        operation.execute(object);
        return ((GetAdministrators) operation).getAdministrators();
    }

    private Object getBooks(Object object) throws Exception {
        operation = new GetBooks();
        operation.execute(object);
        return ((GetBooks) operation).getBooks();
    }

    private Object getAuthors(Object object) throws Exception {
        operation = new GetAuthors();
        operation.execute(object);
        return ((GetAuthors) operation).getAuthors();
    }

    private Object getMembers(Object object) throws Exception {
        operation = new GetMembers();
        operation.execute(object);
        return ((GetMembers) operation).getMembers();
    }

    private Object getOrders(Object object) throws Exception {
        operation = new GetOrders();
        operation.execute(object);
        return ((GetOrders) operation).getOrders();
    }

    private Object getOrderItems(Object object) throws Exception {
        operation = new GetOrderItems();
        operation.execute(object);
        return ((GetOrderItems) operation).getOrderItems();
    }

    private Object getReadBooks(Object object) throws Exception {
        operation = new GetReadBooks((ReadBook)object);
        operation.execute((ReadBook)object);
        return ((GetReadBooks) operation).getReadBooks();
    }

    

}
