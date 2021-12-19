package gov.UnionCouncil;

import gov.UnionCouncil.DBUnionCouncil;
import gov.UnionCouncil.UC_Record;

import java.util.Date;
import java.util.List;

public class UnionCouncil
{

    private final DBUnionCouncil record_database;
    private String bcertificate_no;

    public UnionCouncil(String bcertificate_no){
        record_database = new DBUnionCouncil();
    }

    public boolean checkValid_bcertificate(){
        return true;
    }


    public UC_Record get_info(){
        List<UC_Record> list = record_database.getRecord(bcertificate_no);
        if(list.isEmpty()){
            return null;
        }
        else{
            return list.get(0);
        }
    }

    public UC_Record get_info(String bcertificate_no){
        List<UC_Record> list = record_database.getRecord(bcertificate_no);
        if(list.isEmpty()){
            return null;
        }
        else{
            return list.get(0);
        }
    }

    public int getAge(){
        List<UC_Record> list = record_database.getRecord(bcertificate_no);

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
