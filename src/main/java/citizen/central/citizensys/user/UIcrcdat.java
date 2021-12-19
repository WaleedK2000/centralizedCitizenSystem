package citizen.central.citizensys.user;

import citizen.central.citizensys.Citizen_info;
import gov.nadra.Nadra_Record;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class UIcrcdat {

    private String fathername = "";
    private String mothername = "";
    private String sFathecnic;
    private String sMothercnic;

    @FXML
    private Label fatherNameLabel;

    @FXML
    private Label motherNameLabel;

    @FXML
    private Label validLabel;

    @FXML
    private TextField mothercnic;

    @FXML
    private TextField fathercnic;

    @FXML
    private DatePicker dob;

    @FXML
    private Button buttonVer;

    private Citizen_info citizen_info;

    public static URL getResource() {
        return UIcrcdat.class.getResource("crc_data.fxml");
    }

    public void setCitizen_controller(Citizen_info citizen_info) {
        this.citizen_info = citizen_info;
    }

    @FXML
    void loadFatherDetails() {

        fathername = "Father Name";
        Nadra_Record father_det = citizen_info.get_info(fathercnic.getText());

        if (father_det == null) {
            fathername = "Not Found";
        } else {
            fathername = father_det.getFirst_name() + father_det.getLast_name();
        }
        fatherNameLabel.setText(fathername);
    }

    @FXML
    void loadMotherDetails() {
        mothername = "Mother Name";
        Nadra_Record mother_dat = citizen_info.get_info(mothercnic.getText());

        if (mother_dat == null) {
            mothername = "Not Found";
        } else {
            mothername = mother_dat.getFirst_name() + mother_dat.getLast_name();
        }
        motherNameLabel.setText(mothername);
    }

    @FXML
    void verify(ActionEvent event) {
        if (!Objects.equals(fathername, "") && !Objects.equals(mothername, "")) {
            validLabel.setText("All Data Valid");
            buttonVer.setText("Proceed");
            buttonVer.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("wo");
                    Stage stage = (Stage) motherNameLabel.getScene().getWindow();
                    stage.close();
                }
            });

            validLabel.setText("Details Valid");
            sFathecnic = fathercnic.getText();
            sMothercnic = mothercnic.getText();

        } else {
            loadFatherDetails();
            loadMotherDetails();
        }
    }

    public String getFatherDetails() {
        return sFathecnic + "," + fathercnic.getText();
    }

    public String getMotherDetails() {
        return sMothercnic + "," + mothercnic.getText();
    }
}
