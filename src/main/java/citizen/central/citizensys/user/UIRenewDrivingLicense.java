package citizen.central.citizensys.user;

import citizen.central.citizensys.Citizen_Controller;
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

public class UIRenewDrivingLicense implements Initializable {
    @FXML
    private FontIcon iconOne;

    @FXML
    private Label paymentLabel;

    @FXML
    private Label deliveryMsg;

    @FXML
    private Label validmsg;

    private Citizen_Controller citizen_controller;

    private String cnic = "147";

    @FXML
    void payment(MouseEvent event) throws IOException {

        paymentLabel.setDisable(true);
        UIPayment.launchPayment();
        paymentLabel.setText("Payment Complete");
        iconOne.setIconLiteral("ci-checkmark");

        if(!citizen_controller.requestRenewalDriving(cnic)){
            deliveryMsg.setText("Request Failed. Please visit traffic office.");
        }

        deliveryMsg.setVisible(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        citizen_controller = new Citizen_Controller();
        boolean valid = citizen_controller.renew_driving_license();

        if (!valid){
            validmsg.setText("Request Invalid");
            paymentLabel.setDisable(true);
        }

    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage= (Stage) validmsg.getScene().getWindow();
        stage.close();
    }

    public static void launch() throws IOException {
        FXMLLoader loader = new FXMLLoader(UIRenewDrivingLicense.getResource());
        Parent root = loader.load();
        UIRenewDrivingLicense ui_class = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("RENEW");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    private static URL getResource() {
        return UINewjv.class.getResource("renewdrivinglicense.fxml");
    }


}
