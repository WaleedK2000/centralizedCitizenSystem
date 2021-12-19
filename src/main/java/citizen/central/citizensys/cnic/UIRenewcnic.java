package citizen.central.citizensys.cnic;

import citizen.central.citizensys.Citizen_info;
import citizen.central.citizensys.payment.Payment;
import citizen.central.citizensys.payment.UIPayment;
import gov.nadra.Nadra_Record;
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

public class UIRenewcnic implements Initializable {

    @FXML
    private FontIcon iconOne;

    @FXML
    private Label payLabel;

    @FXML
    private Label notifLabel;

    private Citizen_info citizen_info;

    private String cnic = "147";

    private Nadra_Record record;
    @FXML
    private Label validMsg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        citizen_info = new Citizen_info();
        int valid = citizen_info.renew_cnic(cnic);
        record = citizen_info.get_info();

        if(valid == -1){
            validMsg.setText("Cnic Not Valid. Please Visit Nearest NADRA Office");
            payLabel.setDisable(true);
        }
        else if (valid == -2){
            validMsg.setText("CNIC Validity period is greater than One Month");
            payLabel.setDisable(true);
        }


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
        notifLabel.setVisible(true);
        iconOne.setIconLiteral("ci-checkmark");

        String cardnum = appointment.getCardDet();
        Payment pay = new Payment(1800,cardnum);

    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage= (Stage) payLabel.getScene().getWindow();
        stage.close();
    }

    public static void launch() throws IOException {
        FXMLLoader loader = new FXMLLoader(UIRenewcnic.getResource());
        Parent root = loader.load();
        UIRenewcnic ui_class = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("RENEW");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    private static URL getResource() {
        return UIRenewcnic.class.getResource("renewcnic.fxml");
    }

}
