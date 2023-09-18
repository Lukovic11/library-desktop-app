package validator.components;

import validator.IValidator;
import validator.ValidatorException;

public class RegularValidator implements IValidator {

    @Override
    public void validate(String value) throws ValidatorException {
        if (value == null || value.isEmpty()) {
            throw new ValidatorException("Sva polja su obavezna!");
        }
    }

}
