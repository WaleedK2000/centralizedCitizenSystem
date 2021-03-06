package citizen.central.citizensys;

import citizen.central.citizensys.appointment.Appointment;
import citizen.central.citizensys.payment.Payment;
import gov.nadra.DBNadra;
import gov.nadra.Nadra;
import gov.nadra.Nadra_Record;
import gov.nadra.TrafficPolice;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Citizen_info {

    static Nadra nadra;
    static Appointment appointment;
    static String appointment_token;

    public int renew_cnic(String cnic) {

        nadra = new Nadra(cnic);
        boolean valid = nadra.checkValidCnic();
        Date expiry = nadra.getExpiryDate();

        if (!valid)
            return -1;


        if (getMonthsToDate(expiry) < 1) {
            return 0;
        } else {
            return -2;
        }

    }

    public Nadra_Record get_info() {
        return nadra.get_info();
    }

    public Nadra_Record get_info(String cnic) {
        DBNadra db = new DBNadra();

        List<Nadra_Record> rec = db.getRecord(cnic);

        if (rec.isEmpty()) {
            return null;
        } else {
            return rec.get(0);
        }


    }

    public boolean apply_learner_permit() {
        return checkLearnerEligibility();
    }

    public boolean renew_driving_license() {
        return checkLearnerEligibility();

    }


    private int getMonthsToDate(Date date) {
        long l = date.getTime() - new Date().getTime();
        Date diff = new Date(l);

        return diff.getMonth();

    }

    public int appointmentNewCNic(String cnic) {
        nadra = new Nadra(cnic);

        if (nadra.checkValidCnic()) {
            if (nadra.getAge() >= 18) {
                return 0;
            }
            return -2;
        } else {
            return -1;
        }
    }

    public int appointmentNewJVCard(String cnic) {
        nadra = new Nadra(cnic);

        if (nadra.checkValidCnic()) {
            if (nadra.getAge() < 18) {
                return 0;
            }
            return -2;
        }
        return -1;
    }

    public ObservableList<String> check_avaliable_slot() {
        appointment = new Appointment();
        return appointment.getSlots();
    }

    public void book_slot(DatePicker date, String slot, String cnic) throws SQLException {
        appointment = new Appointment();
        appointment.book_available_slot(date, slot, cnic);
        //appointment.bookSlot
    }

    public void do_payment(int total, String details) {
        Payment payment = new Payment(total, details);
    }

    public String do_booking_confirmation() throws SQLException {
        appointment_token = appointment.do_booking_confirmation();
        return appointment_token;
    }

    public String generateToken() {
        return appointment_token;
    }

    public boolean appointmentCRC(String Details) {

        return nadra.appointmentCRC(Details);

    }

    public boolean checkLearnerEligibility() {
        return true;
    }

    public boolean requestRenewalDriving(String cnic) {
        TrafficPolice trafficPolice = new TrafficPolice();
        return trafficPolice.sendRequest("RD", cnic);
    }

}
