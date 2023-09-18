package operation.order;

import domain.Order;
import operation.AbstractGenericOperation;

public class SaveOrder extends AbstractGenericOperation {

    Order order;
    String exception = "";
    String exceptionId;
    String exceptionAdministrator;
    String exceptionIssueDate;
    String exceptionValidUntil;
    String exceptionMember;

    @Override
    protected void preconditions(Object param) throws Exception {
        if ((((Order) param).getOrderId() == null)) {
            exceptionId = "ID naloga ne sme biti null!\n";
            exception += exceptionId;
        }
        if ((((Order) param).getAdministrator() == null)) {
            exceptionAdministrator = "Administrator ne sme biti null!\n";
            exception += exceptionAdministrator;
        }
        if ((((Order) param).getIssueDate() == null)) {
            exceptionIssueDate = "Datum od ne sme biti null!\n";
            exception += exceptionIssueDate;
        }
        if ((((Order) param).getValidUntil() == null)) {
            exceptionValidUntil = "Datum do ne sme biti null!\n";
            exception += exceptionValidUntil;
        }
        if ((((Order) param).getMember() == null)) {
            exceptionMember = "Član ne sme biti null!\n";
            exception += exceptionMember;
        }

        if (!(exception.equals(""))) {
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        order = (Order) repository.save((Order) param);
    }

    public Order getOrder() {
        return order;
    }

}
