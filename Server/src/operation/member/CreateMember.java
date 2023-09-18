package operation.member;

import domain.Member;
import operation.AbstractGenericOperation;

public class CreateMember extends AbstractGenericOperation {

    Member member;
    String exception = "";
    String exceptionFirstname;
    String exceptionLastname;
    String exceptionIdCardNumber;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Member) param).getFirstname() == null) {
            exceptionFirstname = "Ime ne sme biti null!\n";
            exception += exceptionFirstname;
        }
        if (((Member) param).getLastname() == null) {
            exceptionLastname = "Prezime ne sme biti null!\n";
            exception += exceptionLastname;
        }
        if (((Member) param).getIdCardNumber() == null) {
            exceptionIdCardNumber = "Broj licne karte ne sme biti null!\n";
            exception += exceptionIdCardNumber;
        }
        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        member = (Member) repository.create((Member) param);
    }

    public Member getMember() {
        return member;
    }

}
