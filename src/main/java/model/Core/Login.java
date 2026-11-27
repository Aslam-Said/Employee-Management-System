package model.Core;

import model.Connection.ConnectionUsers;

import java.io.IOException;
import java.util.ArrayList;

public class Login {
    private ConnectionUsers connection;
    private ArrayList<Account> accounts;
    private Account user;
    private Boolean successfulLogin;
    private Boolean correctUserPass;

    public Login() throws IOException {
        this.connection = new ConnectionUsers();
        this.accounts = this.connection.read();
        this.successfulLogin = false;
        this.correctUserPass = false;
        this.user = null;
    }

    public String showMessage(){
        if(correctUserPass && successfulLogin){
            return "You logged in successfully!";
        }
        else return "Incorrect password or username";
    }

    private Boolean checkUser(Account user){
        for(Account acc : accounts){
            if(user.equals(acc)){
                this.user = acc;
                correctUserPass = true;
                return correctUserPass;
            }
        }
        return correctUserPass;
    }

    private Boolean confirmLogin(){
        if(correctUserPass && user.getLoggedIn())
            successfulLogin = true;
        return successfulLogin;
    }

    public Boolean loginUser(Account user){

        Boolean ret = checkUser(user);
        if(ret){
            user.logIn();
        }
        Boolean check = confirmLogin();
        return check;
    }

    public void logout(){
        if(user != null){
            user.logout();
            user = null;
            this.successfulLogin = false;
            this.correctUserPass = false;
        }
    }
}
