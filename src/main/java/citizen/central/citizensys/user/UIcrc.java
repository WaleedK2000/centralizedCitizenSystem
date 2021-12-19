package citizen.central.citizensys.user;

import citizen.central.citizensys.Citizen_Controller;
import citizen.central.citizensys.appointment.Appointment;
import citizen.central.citizensys.appointment.UIAppointment;
import citizen.central.citizensys.payment.UIPayment;
import javafx.event.ActionEvent;
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
import java.net.URL;
import java.sql.SQLException;

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

    private Citizen_Controller citizen_controller;

    private String cnic = "147";

    private String tok;

    public Citizen_Controller getCitizen_controller() {
        return citizen_controller;
    }

    public void setCitizen_controller(Citizen_Controller citizen_controller) {
        this.citizen_controller = citizen_controller;
    }

    @FXML
    void appointment(MouseEvent event) throws IOException, SQLException {
        appointmentLabel.setDisable(true);

        FXMLLoader loader = new FXMLLoader(UIAppointment.getResource());
        Parent root = loader.load();
        UIAppointment appointment = loader.getController();
        appointment.labelAppointment("New CRC");
        Appointment app = new Appointment();

        citizen_controller.check_avaliable_slot();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Appointment");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();

        iconTwo.setIconLiteral("ci-checkmark");
        appointmentLabel.setText(appointment.getDateTime());

        System.out.println( "Time is: " + appointment.getDateTime());
        citizen_controller.book_slot(appointment.getDate(),appointment.getSlot().getValue(),cnic);

    }

    @FXML
    void enterDat(MouseEvent event) {

    }

    @FXML
    void genToken(MouseEvent event) {
        tok = citizen_controller.generateToken();
        tokenLabel.setText("Your Token " + tok );
        iconThree.setIconLiteral("ci-checkmark");
    }

    @FXML
    void payment(MouseEvent event) throws IOException, SQLException {
        payLabel.setDisable(true);
        UIPayment.launchPayment();
        payLabel.setText("Payment Complete");
        iconTwo.setIconLiteral("ci-checkmark");
        citizen_controller.do_payment(1800,"CRC");
        citizen_controller.do_booking_confirmation();

    }

    @FXML
    void someData(MouseEvent event) throws IOException {
        dataLabel.setDisable(true);

        FXMLLoader loader = new FXMLLoader(UIcrcdat.getResource());
        Parent root = loader.load();
        UIcrcdat crc_dat = loader.getController();
        crc_dat.setCitizen_controller(citizen_controller);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Child Registration Certificate");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();

        iconOne.setIconLiteral("ci-checkmark");
        //appointmentLabel.setText(appointment.getDateTime());

        //System.out.println( "Time is: " + appointment.getDateTime());
    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage= (Stage) payLabel.getScene().getWindow();
        stage.close();
    }

    public static void launch(Citizen_Controller citizen_controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(UIcrc.getResource());
        Parent root = loader.load();
        UIcrc UI_Class = loader.getController();

        UI_Class.setCitizen_controller(citizen_controller);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Payment");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    private static URL getResource() {
        return UIcrc.class.getResource("crc.fxml");
    }

}
