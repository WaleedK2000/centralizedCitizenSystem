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

public class Citizen_Controller {


    Appointment appointment;

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

   public void book_slot(DatePicker date, String slot){
       Appointment appointment = new Appointment();
       appointment.book_available_slot(date,slot);
       //appointment.bookSlot
   }

   public void do_payment(int total, String details){
        Payment payment = new Payment(total,details);
   }

   public int do_booking_confirmation(DatePicker date, String slot){
        return appointment.book_available_slot(date, slot);
   }



}
