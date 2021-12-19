package citizen.central.citizensys.emp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class UIPass {
    @FXML
    private AnchorPane dob;

    @FXML
    private TextField labelName;

    @FXML
    private TextField labelFather;

    @FXML
    private TextField address;

    @FXML
    private TextField number;

    @FXML
    private TextField email;

    public static URL getResource() {
        return UIPass.class.getResource("issue_passport3.fxml");
    }

    @FXML
    void issueTok(ActionEvent event) {
        Stage stage = (Stage) address.getScene().getWindow();
        stage.close();
    }

}
