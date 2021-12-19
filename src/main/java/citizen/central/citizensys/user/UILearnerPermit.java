package citizen.central.citizensys.user;

import citizen.central.citizensys.Citizen_info;
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

public class UILearnerPermit implements Initializable {

    @FXML
    private Label validmsg;

    @FXML
    private FontIcon iconOne;

    @FXML
    private Label paymentLabel;

    @FXML
    private FontIcon iconTwo;

    @FXML
    private Label printLabel;

    private Citizen_info citizen_info;

    public void setCitizen_controller(Citizen_info citizen_info) {
        this.citizen_info = citizen_info;
    }

    public static void launch(Citizen_info citizen_info) throws IOException {
        FXMLLoader loader = new FXMLLoader(UILearnerPermit.getResource());
        Parent root = loader.load();
        UILearnerPermit UI_Class = loader.getController();
        UI_Class.setCitizen_controller(citizen_info);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Payment");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();

    }

    private static URL getResource() {
        return UILearnerPermit.class.getResource("learnerPermit.fxml");
    }

    @FXML
    void payment(MouseEvent event) throws IOException {

        paymentLabel.setDisable(true);
        UIPayment.launchPayment();
        paymentLabel.setText("Payment Complete");
        iconOne.setIconLiteral("ci-checkmark");
        citizen_info.do_payment(1800, "lp");

    }

    @FXML
    void print(MouseEvent event) {
        printLabel.setDisable(true);
        iconTwo.setIconLiteral("ci-checkmark");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(citizen_info == null){
            citizen_info = new Citizen_info();
        }

        if(!citizen_info.checkLearnerEligibility()){
            validmsg.setText("You already have A license");
            paymentLabel.setDisable(true);
        }
    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage= (Stage) paymentLabel.getScene().getWindow();
        stage.close();
    }



}
