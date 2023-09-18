package operation.order;

import domain.Administrator;
import domain.Member;
import domain.Order;
import java.util.List;
import operation.AbstractGenericOperation;

public class GetOrders extends AbstractGenericOperation {

    List<Order> orders;
    List<Administrator> admins;
    List<Member> members;

    @Override
    protected void preconditions(Object param) throws Exception {
        //Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        orders = repository.get((Order) param);
        admins = repository.get(new Administrator());
        members = repository.get(new Member());
        for (Order o : orders) {
            for (Administrator a : admins) {
                if (o.getAdministrator().getAdminId().equals(a.getAdminId())) {
                    o.setAdministrator(a);
                }
            }
            for (Member m : members) {
                if (o.getMember().getId().equals(m.getId())) {
                    o.setMember(m);
                }
            }
        }

    }

    public List<Order> getOrders() {
        return orders;
    }

}
