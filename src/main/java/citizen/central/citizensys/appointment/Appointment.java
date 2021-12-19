package citizen.central.citizensys.appointment;

import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.sql.SQLException;


public class Appointment {

    private ObservableList<String> slots;

    private DatePicker date;
    private String selectedSlot;
    private String cnic;
private int token;
public Appointment()
{}
public Appointment(int tok)
{

    token=tok;

}

public void set_token(int a)
{
    token=a;
}

    public void check_avaliable_slots(Date date) throws SQLException {

        slots = Database.getAvailableSlots(date);

    }

    public ObservableList<String> getSlots() {
        return slots;
    }

    public void book_available_slot(DatePicker date, String slot, String cnic) throws SQLException {

        this.date = date;
        this.selectedSlot = slot;
        this.cnic = cnic;


    }

    public String do_booking_confirmation() throws SQLException {
        return Database.confirmAppointment(cnic,date.getValue(),selectedSlot);
    }
    public boolean checkValidAppointment(){
        return true;
    }
}
