package citizen.central.citizensys.cnic;

import citizen.central.citizensys.Citizen_Controller;
import citizen.central.citizensys.appointment.UIAppointment;
import citizen.central.citizensys.payment.UIPayment;
import javafx.event.ActionEvent;
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
import java.net.URL;
import java.sql.SQLException;

public class UINewcnic {

    @FXML
    private FontIcon iconOne;

    @FXML
    private FontIcon iconTwo;

    @FXML
    private FontIcon iconThree;


    @FXML
    private Label appointmentLabel;

    @FXML
    private Label payLabel;
    @FXML
    private Label tokenLabel;

    @FXML
    private Label valid_msg;

    private String tok;

    private String cnic;

    Citizen_Controller citizen_controller;

    public void newCnic(String cnic){
        this.cnic = cnic;
        int cond = citizen_controller.appointmentNewCNic(cnic);
        if(cond == -2){
            valid_msg.setText("You are under 18. Consider making JV instead");
        }
        else if (cond == -1){
            valid_msg.setText("You already have a cnic");
        }
    }

    public UINewcnic(){
        citizen_controller = new Citizen_Controller();
    }


    public void setCnic(String cnic) {
        this.cnic = cnic;
    }



    public static URL getResource() {
        return UINewcnic.class.getResource("newcnic.fxml");
    }

    @FXML
    void genToken(MouseEvent event) {
        tok = citizen_controller.generateToken();
        tokenLabel.setText("Your Token " + tok );
        iconThree.setIconLiteral("ci-checkmark");
    }

    @FXML
    void appointment(MouseEvent event) throws IOException, SQLException {

        appointmentLabel.setDisable(true);

        FXMLLoader loader = new FXMLLoader(UIAppointment.getResource());
        Parent root = loader.load();
        UIAppointment appointment = loader.getController();
        appointment.labelAppointment("Apply for New CNIC");
        citizen_controller.check_avaliable_slot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Appointment");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();



        iconOne.setIconLiteral("ci-checkmark");
        appointmentLabel.setText(appointment.getDateTime());

        System.out.println( "Time is: " + appointment.getDateTime());
        citizen_controller.book_slot(appointment.getDate(),appointment.getSlot().getValue(),cnic);


    }

    @FXML
    void payment(MouseEvent event) throws IOException, SQLException {
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
        iconTwo.setIconLiteral("ci-checkmark");

        citizen_controller.do_booking_confirmation();

    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage= (Stage) payLabel.getScene().getWindow();
        stage.close();
    }

}
