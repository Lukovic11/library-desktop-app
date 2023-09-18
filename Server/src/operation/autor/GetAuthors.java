package operation.autor;

import domain.Author;
import java.util.List;
import operation.AbstractGenericOperation;

public class GetAuthors extends AbstractGenericOperation {

    List<Author> authors;

    @Override
    protected void preconditions(Object param) throws Exception {
        //Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        authors = repository.get((Author) param);
    }

    public List<Author> getAuthors() {
        Author auth=null;
        for (Author a : authors) {
            if (a.getAuthorId() == 0) {
                auth=a;
            }
        }
        if(auth!=null){
            authors.remove(auth);
        }
        return authors;
    }
}
