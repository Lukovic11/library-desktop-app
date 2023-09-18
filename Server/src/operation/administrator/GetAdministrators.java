package operation.administrator;

import domain.Administrator;
import java.util.List;
import operation.AbstractGenericOperation;

public class GetAdministrators extends AbstractGenericOperation {

    private List<Administrator> administrators;

    @Override
    protected void preconditions(Object param) throws Exception {
        //Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        administrators = repository.get((Administrator) param);
    }

    public List<Administrator> getAdministrators() {
        Administrator admin = null;
        for (Administrator a : administrators) {
            if (a.getAdminId() == 0) {
                admin = a;
            }
        }
        if (admin != null) {
            administrators.remove(admin);
        }
        return administrators;
    }

}
