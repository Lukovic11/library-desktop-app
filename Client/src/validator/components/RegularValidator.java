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

    @Override
    public void validateAuthor(String firstname, String lastname) throws ValidatorException {
        if (firstname == null || firstname.isEmpty()) {
            throw new ValidatorException("Popunite polje za unos imena!");
        }
        if (lastname == null || lastname.isEmpty()) {
            throw new ValidatorException("Popunite polje za unos prezimena!");
        }
        if (!(firstname.matches("[a-zA-Z]+"))&&!(firstname.matches(" "))) {
            throw new ValidatorException("Polje na unos imena sme da sadrži isključivo slova!");
        }
        if (!(lastname.matches("[a-zA-Z]+"))&&!(lastname.matches(" "))) {
            throw new ValidatorException("Polje na unos prezimena sme da sadrži isključivo slova!");
        }
    }

    @Override
    public void validateLogin(String firstname, String lastname, String password) throws ValidatorException {
        if (firstname == null || firstname.isEmpty()) {
            throw new ValidatorException("Popunite polje za unos imena!");
        }
        if (lastname == null || lastname.isEmpty()) {
            throw new ValidatorException("Popunite polje za unos prezimena!");
        }
        if (password == null || password.isEmpty()) {
            throw new ValidatorException("Popunite polje za lozinku!");
        }
        if (!(firstname.matches("[a-zA-Z]+"))) {
            throw new ValidatorException("Polje na unos imena sme da sadrži isključivo slova!");
        }
        if (!(lastname.matches("[a-zA-Z]+"))) {
            throw new ValidatorException("Polje na unos prezimena sme da sadrži isključivo slova!");
        }

    }

}
