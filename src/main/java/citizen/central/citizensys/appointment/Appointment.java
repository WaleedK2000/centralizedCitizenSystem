package citizen.central.citizensys.appointment;

import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.sql.SQLException;


public class Appointment {

    private ObservableList<String> slots;


    public void check_avaliable_slots(Date date) throws SQLException {

        slots = Database.getAvailableSlots(date);

    }

    public ObservableList<String> getSlots() {
        return slots;
    }

    public int book_available_slot(DatePicker date, String slot){
        int token_num = 11122;
        return token_num;
    }

}
