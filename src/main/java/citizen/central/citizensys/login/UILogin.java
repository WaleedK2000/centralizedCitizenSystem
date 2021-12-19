package citizen.central.citizensys.login;

//citizen.central.citizensys.LoginController

import citizen.central.citizensys.Citizen_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UILogin {
    @FXML
    private TextField userID;

    @FXML
    private PasswordField password;

    @FXML
    public void login(ActionEvent event) {


        System.out.println("Login Button Pressed");

        System.out.println("Value in user id field = " + userID.getText());
        System.out.println("Pass = " + password.getText());



    }

    @FXML
    public void register(ActionEvent event) {
        System.out.println("Register Button Pressed");
    }

}
