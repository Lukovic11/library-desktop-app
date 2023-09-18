package operation.member;

import domain.Member;
import java.util.List;
import operation.AbstractGenericOperation;

public class GetMembers extends AbstractGenericOperation {

    List<Member> members;

    @Override
    protected void preconditions(Object param) throws Exception {
        //Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        members = repository.get((Member) param);
    }

    public List<Member> getMembers() {
        Member mem=null;
        for (Member m : members) {
            if (m.getId() == 0) {
                mem=m;
            }
        }
        if(mem!=null){
            members.remove(mem);
        }
        return members;
    }

}
