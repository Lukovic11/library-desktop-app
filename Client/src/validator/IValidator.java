package validator;


public interface IValidator {

    public void validate(String value) throws ValidatorException;
    
    public void validateAuthor(String firstname,String lastname) throws ValidatorException;
    
    public void validateLogin(String firstname,String lastname,String password) throws ValidatorException;
    
    
}
