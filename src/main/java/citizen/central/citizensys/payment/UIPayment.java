package citizen.central.citizensys.payment;

import citizen.central.citizensys.Citizen_info;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class UIPayment {
    @FXML
    private Label total;

    @FXML
    private TextField cardnum;

    private Citizen_info citizen_info;

    public static URL getResource() {
        return UIPayment.class.getResource("payment.fxml");
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

    public String getCardDet() {
        return cardnum.toString();
    }

    @FXML
    void mastercard(ActionEvent event) {

    }

    @FXML
    void visa(ActionEvent event) {

    }

    public void setCitizen_controller(Citizen_info citizen_info) {
        this.citizen_info = citizen_info;
    }

    @FXML
    void payment(ActionEvent event) {
        citizen_info = new Citizen_info();
        citizen_info.do_payment(1800, cardnum.getText());
        Stage stage = (Stage) total.getScene().getWindow();

        stage.close();
    }


}
