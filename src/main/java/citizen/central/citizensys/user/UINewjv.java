package citizen.central.citizensys.user;

import citizen.central.citizensys.Citizen_info;
import citizen.central.citizensys.appointment.UIAppointment;
import citizen.central.citizensys.payment.UIPayment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UINewjv implements Initializable {

    private int tok;

    @FXML
    private FontIcon iconOne;

    @FXML
    private Label appointmentLabel;

    @FXML
    private FontIcon iconTwo;

    @FXML
    private Label payLabel;

    @FXML
    private FontIcon iconThree;

    @FXML
    private Label tokenLabel;

    @FXML
    private Label validMsg;

    private Citizen_info citizen_info;

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    private  String cnic;

    public static void launch(String cnic) throws IOException {
        FXMLLoader loader = new FXMLLoader(UINewjv.getResource());
        Parent root = loader.load();
        UINewjv ui_class = loader.getController();
        ui_class.setCnic(cnic);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("New JV");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    private static URL getResource() {
        return UINewjv.class.getResource("newjv.fxml");
    }

    @FXML
    void appointment(MouseEvent event) throws IOException {
        appointmentLabel.setDisable(true);

        FXMLLoader loader = new FXMLLoader(UIAppointment.getResource());
        Parent root = loader.load();
        UIAppointment appointment = loader.getController();
        appointment.labelAppointment("Apply for New JV");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Appointment");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();

        iconOne.setIconLiteral("ci-checkmark");
        appointmentLabel.setText(appointment.getDateTime());

        System.out.println("Time is: " + appointment.getDateTime());
    }

    @FXML
    void genToken(MouseEvent event) {
        tok = 1245;
        tokenLabel.setText("Your Token " + tok);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        citizen_info = new Citizen_info();
        int valid = citizen_info.appointmentNewJVCard(cnic);


        if (valid == -1) {
            validMsg.setText("JV Request Not Valid");
            disableAll();
        } else if (valid == -2) {
            validMsg.setText("Age Greater than 18");
            disableAll();
        }
    }

    private void disableAll() {
        tokenLabel.setDisable(true);
        appointmentLabel.setDisable(true);
        payLabel.setDisable(true);

    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) payLabel.getScene().getWindow();
        stage.close();
    }

}
