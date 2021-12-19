package gov.nadra;

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Nadra {

    private final DBNadra record_database;
    private String cnic;

    public Nadra(String cnic){
        record_database = new DBNadra();
    }

    public boolean checkValidCnic(){
        return true;
    }

    public Date getExpiryDate(){
        return record_database.getCnicExpiry(cnic);
    }

    public Nadra_Record get_info(){
        List<Nadra_Record> list = record_database.getRecord(cnic);
        if(list.isEmpty()){
            return null;
        }
        else{
            return list.get(0);
        }
    }

    public Nadra_Record get_info(String cnic){
        List<Nadra_Record> list = record_database.getRecord(cnic);
        if(list.isEmpty()){
            return null;
        }
        else{
            return list.get(0);
        }
    }

    public int getAge(){
        List<Nadra_Record> list = record_database.getRecord(cnic);

        if(!list.isEmpty()){
            long age = new Date().getTime() - list.get(0).getDate_Of_birth().getTime();
            Date ageDate = new Date(age);

            return ageDate.getYear();
        }
        else {
            return 25;
        }

    }

    public boolean appointmentCRC(String details){
        return true;
    }






}
