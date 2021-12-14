package citizen.central.citizensys.user;

import citizen.central.citizensys.payment.UIPayment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;

public class UIRenewDrivingLicense {
    @FXML
    private FontIcon iconOne;

    @FXML
    private Label paymentLabel;

    @FXML
    private Label deliveryMsg;

    @FXML
    void payment(MouseEvent event) throws IOException {
        paymentLabel.setDisable(true);
        UIPayment.launchPayment();
        paymentLabel.setText("Payment Complete");
        iconOne.setIconLiteral("ci-checkmark");
        deliveryMsg.setVisible(true);
    }
}
