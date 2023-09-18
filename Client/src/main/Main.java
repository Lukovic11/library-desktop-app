package main;

import controller.Communication;
import form.LoginForm;

public class Main {

    public static void main(String[] args) {
        Communication.getInstance();
        new LoginForm().setVisible(true);
    }

}
