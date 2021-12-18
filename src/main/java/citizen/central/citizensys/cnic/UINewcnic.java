package citizen.central.citizensys.cnic;

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
import java.net.URL;

public class UINewcnic {

    @FXML
    private FontIcon iconOne;

    @FXML
    private FontIcon iconTwo;

    @FXML
    private FontIcon iconThree;


    @FXML
    private Label appointmentLabel;

    @FXML
    private Label payLabel;
    @FXML
    private Label tokenLabel;

    private int tok;

    private String cnic;

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public static URL getResource() {
        return UINewcnic.class.getResource("newcnic.fxml");
    }

    @FXML
    void genToken(MouseEvent event) {
        tok = 1245;
        tokenLabel.setText("Your Token " + tok );
        iconThree.setIconLiteral("ci-checkmark");
    }

    @FXML
    void appointment(MouseEvent event) throws IOException {

        appointmentLabel.setDisable(true);

        FXMLLoader loader = new FXMLLoader(UIAppointment.getResource());
        Parent root = loader.load();
        UIAppointment appointment = loader.getController();
        appointment.labelAppointment("Apply for New CNIC");
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Appointment");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();

        iconOne.setIconLiteral("ci-checkmark");
        appointmentLabel.setText(appointment.getDateTime());

        System.out.println( "Time is: " + appointment.getDateTime());

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

}
