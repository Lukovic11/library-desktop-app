package operation.book;

import domain.Author;
import domain.Book;
import java.util.List;
import operation.AbstractGenericOperation;

public class GetBooks extends AbstractGenericOperation {

    List<Book> books;
    List<Author> authors;

    @Override
    protected void preconditions(Object param) throws Exception {
        //Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        books = repository.get((Book) param);
        authors = repository.get(new Author());
        for (Book b : books) {
            for (Author a : authors) {
                if (b.getAuthor().getAuthorId().equals(a.getAuthorId())) {
                    b.setAuthor(a);
                }
            }
        }
    }

    public List<Book> getBooks() {
        Book book1=null;
        for (Book b : books) {
            if (b.getId() == 0) {
                book1=b;
            }
        }
        if(book1!=null){
            books.remove(book1);
        }
        return books;
    }

}
