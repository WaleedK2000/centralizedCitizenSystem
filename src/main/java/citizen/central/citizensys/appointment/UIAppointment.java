package citizen.central.citizensys.appointment;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

//TODO initialize place
//TODO connect page to database

public class UIAppointment {

    @FXML
    private Label title;

    @FXML
    private ChoiceBox<String> place;

    @FXML
    private DatePicker date;

    @FXML
    private ChoiceBox<String> slot;

    public static URL getResource() {
        return UIAppointment.class.getResource("appointment.fxml");
    }

    @FXML
    public void loadSlots(ActionEvent event) throws SQLException {
        System.out.println("yes: ");

        Date dateObj = Date.valueOf(date.getValue());
        ObservableList<String> ol = Database.getAvailableSlots(dateObj);
        slot.setItems(ol);

        System.out.println("h");
        for (String s : ol) {
            System.out.println(s);
        }


    }

    public String getDateTime(){

        String dateString = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = slot.getValue();


        return dateString + " " + time;
    }

    public void labelAppointment(String process){
        title.setText(process);
    }

    @FXML
    void confirm(ActionEvent event) {
        Stage stage= (Stage) title.getScene().getWindow();
        stage.close();
    }

}