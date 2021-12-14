package citizen.central.citizensys.payment;

import citizen.central.citizensys.appointment.UIAppointment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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

    public static void launchPayment() throws IOException {
        FXMLLoader loader = new FXMLLoader(UIPayment.getResource());
        Parent root = loader.load();
        UIPayment appointment = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Payment");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

}
