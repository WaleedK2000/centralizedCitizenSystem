package citizen.central.citizensys;

import citizen.central.citizensys.appointment.Database;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.sql.SQLException;


public class UIAppointment {

    @FXML
    private DatePicker date;

    @FXML
    private ChoiceBox<String> slot;

    @FXML
    void loadSlots(ActionEvent event) throws SQLException {
        System.out.println("yes: ");

        Date dateObj = Date.valueOf(date.getValue());
        ObservableList<String> ol = Database.getAvailableSlots(dateObj);
        slot.setItems(ol);

        System.out.println("h");
        for (String s : ol) {

            System.out.println(s);
        }


    }

}
