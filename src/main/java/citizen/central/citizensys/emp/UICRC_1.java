package citizen.central.citizensys.emp;

import citizen.central.citizensys.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;

public class UICRC_1 {
    @FXML
    private TextField tokenId;
    private String tok;

    public static URL getResource() {
        return UICRC_1.class.getResource("crc_1.fxml");
    }

    @FXML
    void proceed(ActionEvent event) {
        tok = tokenId.getText();
        closeWindow();
    }

    public String getTok() {
        return tok;
    }

    void closeWindow() {
        Stage stage = (Stage) tokenId.getScene().getWindow();
        stage.close();
    }


}
