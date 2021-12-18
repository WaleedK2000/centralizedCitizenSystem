package citizen.central.citizensys.payment;

import java.util.Date;

public class Payment {

    private int id;
    private int amount;
    private Date date;
    private String details;

    public Payment(int amount, String details){
        date = new Date();
        this.amount = amount;
        id = 2;
        this.details = details;
    }

    public void do_payments(){

    }



}
