package operation.readBook;

import domain.Member;
import domain.ReadBook;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

public class GetReadBooks extends AbstractGenericOperation {

    List<ReadBook> readBooks=new ArrayList<>();
    List<ReadBook> allReadBooks;
    Member member;
    private String exception = "";
    private String exceptionMember;

    public GetReadBooks(ReadBook rb) {
        member = rb.getMember();
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        if (member == null) {
            exceptionMember = "Član ne sme biti null!\n";
            exception += exceptionMember;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        allReadBooks = repository.get((ReadBook) param);
    }

    public List<ReadBook> getReadBooks() {
        if(allReadBooks!=null){
            for (ReadBook r : allReadBooks) {
                if (r.getMember().getId().equals(member.getId())) {
                    readBooks.add(r);
                }
            }
        }
        
        return readBooks;
    }

}
