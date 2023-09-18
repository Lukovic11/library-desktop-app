package controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Administrator;
import domain.Author;
import domain.Book;
import domain.Member;
import domain.Order;
import domain.OrderItem;
import domain.ReadBook;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Communication {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Communication instance;

    public Communication() {
        try {
            socket = new Socket("127.0.0.1", 9000);
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Administrator login(String firstname, String lastname, String password) throws Exception {
        Administrator administrator = new Administrator();
        administrator.setFirstname(firstname);
        administrator.setLastname(lastname);
        administrator.setPassword(password);
        Request request = new Request(Operation.LOGIN, administrator);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Administrator) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Administrator> getAllAdministrators() throws Exception {
        Request request = new Request(Operation.GET, new Administrator());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Administrator>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Author> getAllAuthors() throws Exception {
        Request request = new Request(Operation.GET, new Author());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Author>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Book> getAllBooks() throws Exception {
        Request request = new Request(Operation.GET, new Book());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Book>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Member> getAllMembers() throws Exception {
        Request request = new Request(Operation.GET, new Member());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Member>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Order> getAllOrders() throws Exception {
        Request request = new Request(Operation.GET, new Order());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Order>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<OrderItem> getAllOrderItems() throws Exception {
        Request request = new Request(Operation.GET, new OrderItem());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<OrderItem>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<ReadBook> getReadBooks(Member member) throws Exception {
        ReadBook rb = new ReadBook();
        rb.setMember(member);
        Request request = new Request(Operation.GET, rb);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<ReadBook>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Book createBook(Book book) throws Exception {
        Request request = new Request(Operation.CREATE, book);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Book) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Author createAuthor(Author author) throws Exception {
        Request request = new Request(Operation.CREATE, author);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Author) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Book saveBook(Book book) throws Exception {
        Request request = new Request(Operation.SAVE, book);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Book) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Author saveAuthor(Author author) throws Exception {
        Request request = new Request(Operation.SAVE, author);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Author) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Member createMember(Member member) throws Exception {
        Request request = new Request(Operation.CREATE, member);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Member) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Member saveMember(Member member) throws Exception {
        Request request = new Request(Operation.SAVE, member);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Member) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void deleteMember(Member member) throws Exception {
        Request request = new Request(Operation.DELETE, member);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void deleteBook(Book book) throws Exception {
        Request request = new Request(Operation.DELETE, book);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void deleteAuthor(Author author) throws Exception {
        Request request = new Request(Operation.DELETE, author);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public Order createOrder(Order order) throws Exception {
        Request request = new Request(Operation.CREATE, order);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Order) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Order saveOrder(Order order) throws Exception {
        Request request = new Request(Operation.SAVE, order);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Order) response.getResult();
        }
        throw response.getException();
    }

    public OrderItem createOrderItem(OrderItem orderItem) throws Exception {
        Request request = new Request(Operation.CREATE, orderItem);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (OrderItem) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public OrderItem saveOrderItem(OrderItem orderItem) throws Exception {
        Request request = new Request(Operation.SAVE, orderItem);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (OrderItem) response.getResult();
        }
        throw response.getException();
    }

    public void deleteOrder(Order order) throws Exception {
        Request request = new Request(Operation.DELETE, order);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public ReadBook createReadBook(ReadBook rb) throws Exception {
        Request request = new Request(Operation.CREATE, rb);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (ReadBook) response.getResult();
        }
        throw response.getException();
    }
    
}
