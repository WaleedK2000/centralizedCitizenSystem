package citizen.central.citizensys.emp;

import citizen.central.citizensys.cnic.UIRenewcnic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class UIEmployeeCenter {



    @FXML
    void createCRC(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(UICRC_1.getResource());
        Parent root = loader.load();
        UICRC_1 ui_class = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("RENEW");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        String token = ui_class.getTok();

         loader = new FXMLLoader(UIcrc_2.getResource());
         root = loader.load();
        UIcrc_2 ui_class_2 = loader.getController();
         stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("RENEW");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        String guardian_cnic = ui_class_2.getGuardian_cnic();
        String certificate_num = ui_class_2.getCert_num();



    }

    @FXML
    void issueJv(ActionEvent event) {

    }

    @FXML
    void issueNic(ActionEvent event) {

    }

    @FXML
    void issuePassport(ActionEvent event) {

    }


}
