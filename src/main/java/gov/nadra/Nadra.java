package gov.nadra;

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






}
