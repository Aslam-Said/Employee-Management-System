package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField Username;
    @FXML private PasswordField Password;
    @FXML private Label errorlabel;
    public void Login() {
        String name= Username.getText();
        String pass=Password.getText();
    }
}