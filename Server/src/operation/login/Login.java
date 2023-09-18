package operation.login;

import domain.Administrator;
import java.util.List;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.RegularValidator;

public class Login extends AbstractGenericOperation {

    private IValidator validator;
    private String exception = "";
    private String exceptionFirstname;
    private String exceptionLastname;
    private String exceptionPassword;
    private Administrator login;

    @Override
    protected void preconditions(Object param) throws ValidatorException {
        Administrator administrator = (Administrator) param;
        validator = new RegularValidator();
        try {
            validator.validate(administrator.getFirstname());
        } catch (ValidatorException e) {
            exceptionFirstname = e.getMessage();
            exception = exceptionFirstname + "\n";
        }
        try {
            validator.validate(administrator.getLastname());
        } catch (ValidatorException e) {
            exceptionLastname = e.getMessage();
            exception += exceptionLastname + "\n";
        }
        try {
            validator.validate(administrator.getPassword());
        } catch (ValidatorException e) {
            exceptionPassword = e.getMessage();
            exception += exceptionPassword + "\n";
        }
        if (!(exception.equals(""))) {
            throw new ValidatorException(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Administrator administrator = (Administrator) param;
        List<Administrator> administrators = repository.get((Administrator) param);
        for (Administrator a : administrators) {
            if (a.getFirstname().equals(administrator.getFirstname())
                    && a.getLastname().equals(administrator.getLastname())
                    && a.getPassword().equals(administrator.getPassword())) {
                login = a;
                return;
            }
        }
    }

    public Object getLogin() {
        return (Administrator)login;
    }
}
