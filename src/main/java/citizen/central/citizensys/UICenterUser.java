package citizen.central.citizensys;

import citizen.central.citizensys.cnic.UINewcnic;
import citizen.central.citizensys.cnic.UIRenewcnic;
import citizen.central.citizensys.user.UILearnerPermit;
import citizen.central.citizensys.user.UINewjv;
import citizen.central.citizensys.user.UIcrc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class UICenterUser {

    private String cnic = "147";
    private Citizen_Controller citizen_controller;

    public UICenterUser(){
        citizen_controller = new Citizen_Controller();
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
        UIcrc.launch(citizen_controller);
    }

    @FXML
    void apply_learner_permit() throws IOException {
        UILearnerPermit.launch(citizen_controller);
    }

}
