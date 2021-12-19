package citizen.central.citizensys;

import citizen.central.citizensys.Passport.Passport;
import citizen.central.citizensys.appointment.Appointment;
import gov.DGIP.DBDGIP;
import gov.UnionCouncil.UnionCouncil;
import gov.nadra.Nadra;


public class Employee_Infoexp {

    public int issue_passport_token(String name, String age, int token, String cnic) {


        Appointment ap = new Appointment(token);
        if (ap.checkValidAppointment() == true) {
            Nadra nadra = new Nadra(cnic);
            if (nadra.checkValidCnic() == true) {

                Passport passport = new Passport(name, age);
                DBDGIP temp = new DBDGIP();
                temp.add_record(name, age, cnic);

                return 1;

            } else {

                return -1;
            }

        } else {
            return -1;
        }

    }


    public int issue_NIC(int token, String cnic) {

        Appointment ap = new Appointment(token);

        if (ap.checkValidAppointment() == true) {
            Nadra temp = new Nadra(cnic);

            if (temp.checkValidCnic() == true) {

                if (temp.getAge() >= 18) {
                    System.out.println("National Identity Card issued");
                    return 1;
                } else {
                    return -1;
                }

            } else {

                return -1;
            }

        } else {
            return -1;
        }

    }


    public int issue_JVCard(int token, String cnic) {

        Appointment ap = new Appointment(token);
        if (ap.checkValidAppointment() == true) {
            Nadra temp = new Nadra(cnic);

            if (temp.checkValidCnic() == true) {

                if (temp.getAge() < 18) {
                    System.out.println("Juvenile card issued");
                    return 1;
                } else {
                    return -1;
                }

            } else {

                return -1;
            }

        } else {
            return -1;
        }

    }


    public int issue_CRC(int token, String guardian_cnic) {

        Appointment ap = new Appointment(token);
        if (ap.checkValidAppointment() == true) {
            UnionCouncil temp = new UnionCouncil(guardian_cnic);

            if (temp.checkValid_bcertificate() == true) {
                System.out.println("Child Registration Certificate issued");

                return 1;

            } else {

                return -1;
            }

        } else {
            return -1;
        }

    }


}
