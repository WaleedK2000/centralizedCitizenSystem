package citizen.central.citizensys;

import citizen.central.citizensys.appointment.Appointment;
import citizen.central.citizensys.payment.Payment;
import citizen.central.db.Dbcon;
import gov.nadra.Nadra;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class Citizen_Controller {


    Appointment appointment;
    String appointment_token;

   public int appointmentNewCNic(String cnic){

       Nadra nadra = new Nadra(cnic);

       if (nadra.checkValidCnic() ){
           if (nadra.getAge() >= 18){
                return 0;
           }
           return -2;
       }
       else {
           return -1;
       }
   }

   public ObservableList<String> check_avaliable_slot(){
       appointment = new Appointment();
       return appointment.getSlots();
   }

   public void book_slot(DatePicker date, String slot, String cnic) throws SQLException {
       appointment = new Appointment();
       appointment.book_available_slot(date,slot,cnic);
       //appointment.bookSlot
   }

   public void do_payment(int total, String details){
        Payment payment = new Payment(total,details);
   }

   public String do_booking_confirmation() throws SQLException {
        appointment_token =  appointment.do_booking_confirmation();
        return appointment_token;
   }

   public String generateToken(){
       return appointment_token;
   }



}
