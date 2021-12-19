package citizen.central.citizensys.emp;

import citizen.central.citizensys.HelloApplication;
import citizen.central.citizensys.user.UIcrcdat;
import gov.UnionCouncil.DBUnionCouncil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;

public class UIcrc_2 {

    private String guardian_cnic;
    private String cert_num;

    @FXML
    private TextField cnic;

    @FXML
    private TextField cert;

    public String getGuardian_cnic() {
        return guardian_cnic;
    }

    public String getCert_num() {
        return cert_num;
    }

    @FXML
    void proceed(ActionEvent event) {
        guardian_cnic = cnic.getText();

        DBUnionCouncil dbUnionCouncil = new DBUnionCouncil();


        if(dbUnionCouncil.exists(cert.getText())){
            guardian_cnic = cnic.getText();
            cert_num = cert.getText();
            closeWindow();
        }

    }

    void closeWindow() {
        Stage stage = (Stage) cnic.getScene().getWindow();
        stage.close();
    }

    public static URL getResource() {
        return UIcrc_2.class.getResource("crc_2.fxml");
    }


}
