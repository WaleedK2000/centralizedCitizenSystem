package citizen.central.citizensys.cnic;

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

public class UIRenewcnic {

    @FXML
    private FontIcon iconOne;

    @FXML
    private Label payLabel;

    @FXML
    private Label notifLabel;

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
    }
}
