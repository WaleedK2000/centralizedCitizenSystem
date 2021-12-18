package citizen.central.citizensys;

import citizen.central.citizensys.cnic.UINewcnic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class UICenterUser {

    private String cnic;

    @FXML
    void appointmentNewCnc(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(UINewcnic.getResource());
        Parent root = loader.load();

        UINewcnic newcnic = loader.getController();
        newcnic.setCnic(cnic);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();

    }

    @FXML
    void renew_cnic(ActionEvent event) {

    }
}
