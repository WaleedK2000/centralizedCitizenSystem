package citizen.central.citizensys.user;

import citizen.central.citizensys.appointment.UIAppointment;
import citizen.central.citizensys.payment.UIPayment;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;

public class UIcrc {
    @FXML
    private FontIcon iconOne;

    @FXML
    private Label dataLabel;

    @FXML
    private FontIcon iconTwo;

    @FXML
    private Label appointmentLabel;

    @FXML
    private FontIcon iconThree;

    @FXML
    private Label payLabel;

    @FXML
    private FontIcon iconFour;

    @FXML
    private Label tokenLabel;



    @FXML
    void appointment(MouseEvent event) throws IOException {
        appointmentLabel.setDisable(true);

        FXMLLoader loader = new FXMLLoader(UIAppointment.getResource());
        Parent root = loader.load();
        UIAppointment appointment = loader.getController();
        appointment.labelAppointment("New CRC");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Appointment");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();

        iconTwo.setIconLiteral("ci-checkmark");
        appointmentLabel.setText(appointment.getDateTime());

        System.out.println( "Time is: " + appointment.getDateTime());
    }
    /*
    @FXML
    void enterDat(MouseEvent event) throws IOException {

    }
    */
    @FXML
    void enterDat(MouseEvent event) {

    }


    @FXML
    void genToken(MouseEvent event) {
        int tok = 1245;
        tokenLabel.setText("Your Token " + tok );
        iconThree.setIconLiteral("ci-checkmark");
    }

    @FXML
    void payment(MouseEvent event) throws IOException {
        payLabel.setDisable(true);
        FXMLLoader loader = new FXMLLoader(UIPayment.getResource());
        Parent root = loader.load();
        UIPayment appointment = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Payment");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
        payLabel.setText("Payment Complete");
        iconTwo.setIconLiteral("ci-checkmark");
    }

    @FXML
    void someData(MouseEvent event) throws IOException {
        dataLabel.setDisable(true);

        FXMLLoader loader = new FXMLLoader(UIcrcdat.getResource());
        Parent root = loader.load();
        UIcrcdat crc_dat = loader.getController();
        //UIcrcdat.labelAppointment("New CRC");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();

        iconOne.setIconLiteral("ci-checkmark");
        //appointmentLabel.setText(appointment.getDateTime());

        //System.out.println( "Time is: " + appointment.getDateTime());
    }

}
