package citizen.central.citizensys;

import citizen.central.citizensys.cnic.UINewcnic;
import citizen.central.citizensys.cnic.UIRenewcnic;
import citizen.central.citizensys.login.UILogin;
import citizen.central.citizensys.user.UILearnerPermit;
import citizen.central.citizensys.user.UINewjv;
import citizen.central.citizensys.user.UIRenewDrivingLicense;
import citizen.central.citizensys.user.UIcrc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UICenterUser implements Initializable {

    private String cnic = "147";
    private Citizen_info citizen_info;

    public UICenterUser(){
        citizen_info = new Citizen_info();
    }

    @FXML
    void appointmentNewCnc(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(UINewcnic.getResource());
        Parent root = loader.load();

        UINewcnic newcnic = loader.getController();
        newcnic.setCnic(cnic);
        newcnic.newCnic(cnic);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();

    }

    @FXML
    void renew_cnic(ActionEvent event) throws IOException {
        UIRenewcnic.launch();
    }

    @FXML
    void appointmentNewJVCard() throws IOException {
        UINewjv.launch();
    }

    @FXML
    void appointmentNewCRC() throws IOException {
        UIcrc.launch(citizen_info);
    }

    @FXML
    void apply_learner_permit() throws IOException {
        UILearnerPermit.launch(citizen_info);
    }

    @FXML
    void renew_driving_license(ActionEvent event) {
        try {
            UIRenewDrivingLicense.launch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader loader = new FXMLLoader(UILogin.getResource());
        Parent root = null;
        try {
            root = loader.load();
            UILogin UI_Class = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Payment");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();

            cnic = UI_Class.getCnic();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
