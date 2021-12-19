package citizen.central.citizensys.login;

//citizen.central.citizensys.LoginController

import citizen.central.citizensys.Citizen;
import citizen.central.citizensys.Citizen_Controller;
import citizen.central.citizensys.HelloApplication;
import citizen.central.citizensys.user.UIcrc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;

public class UILogin {
    @FXML
    private TextField userID;

    @FXML
    private PasswordField password;

    private String cnic;

    public static URL getResource() {
        return HelloApplication.class.getResource("login.fxml");
    }

    @FXML
    public void login(ActionEvent event) {

        System.out.println("Login Button Pressed");
        System.out.println("Value in user id field = " + userID.getText());
        System.out.println("Pass = " + password.getText());

        DBLogin dbLogin = new DBLogin();
        if (dbLogin.validate_credential(userID.getText(),password.getText(),'u')){
            cnic = userID.getText();
            closeWindow();
        }
    }


    void closeWindow() {
        Stage stage= (Stage) userID.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void register(ActionEvent event) {
        System.out.println("Register Button Pressed");
    }

    public String getCnic() {
        return cnic;
    }

}
