package citizen.central.citizensys.payment;

import citizen.central.citizensys.appointment.UIAppointment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;

public class UIPayment {
    @FXML
    private Label total;

    public static URL getResource() {
        return UIPayment.class.getResource("payment.fxml");
    }

    @FXML
    void mastercard(ActionEvent event) {

    }

    @FXML
    void visa(ActionEvent event) {

    }

    @FXML
    void payment(ActionEvent event) {
        Stage stage= (Stage) total.getScene().getWindow();
        stage.close();
    }

}
