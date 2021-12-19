package citizen.central.citizensys.payment;

import java.util.Date;

public class Payment {

    private final int id;
    private final int amount;
    private final Date date;
    private final String details;

    public Payment(int amount, String details) {
        date = new Date();
        this.amount = amount;
        id = 2;
        this.details = details;
    }

    public void do_payments() {

    }


}
