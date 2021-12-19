package citizen.central.citizensys;

import citizen.central.citizensys.emp.UICRC_1;
import citizen.central.citizensys.emp.UIEmployeeCenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UIWelcome {


    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button userbtn;

    @FXML
    void admin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(UIEmployeeCenter.getResource());
        Parent root = loader.load();
        UIEmployeeCenter ui_class = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("RENEW");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

         stage = (Stage) userbtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void user(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(UICenterUser.getResource());
        Parent root = loader.load();
        UICenterUser ui_class = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("RENEW");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

        stage = (Stage) userbtn.getScene().getWindow();
        stage.close();
    }



}
