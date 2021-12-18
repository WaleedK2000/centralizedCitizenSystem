package citizen.central.citizensys.appointment;

import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.SQLException;


public class Appointment {

    private ObservableList slots;




    public ObservableList<String> check_avaliable_slots(Date date) throws SQLException {

        slots = Database.getAvailableSlots(date);
        return slots;
    }



}
