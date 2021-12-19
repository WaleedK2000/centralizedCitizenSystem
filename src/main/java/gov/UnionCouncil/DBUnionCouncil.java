package gov.UnionCouncil;

import citizen.central.db.Dbcon;
import gov.UnionCouncil.UC_Record;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBUnionCouncil {

    private final Configuration con;
    private final SessionFactory sf;
    private final Session session;
    private final Transaction trans;


    public DBUnionCouncil(){
        con = Dbcon.getDbCon();
        con.configure().addAnnotatedClass(UC_Record.class);
        sf = con.buildSessionFactory();
        session = sf.openSession();
        trans = session.beginTransaction();
    }

    public boolean addRecord(UC_Record record){

        if(exists(record.getBcertificate_No())){
            System.out.println("Already Exists");
            return false;
        }
        else {
            session.save(record);
            trans.commit();
            return true;
        }

    }

    public boolean exists(String bcertertificate_no){
        List<UC_Record> list = getRecord(bcertertificate_no);
        return !list.isEmpty();
    }

    public List<UC_Record> getRecord(String bcertertificate_no){
        String query = "SELECT * FROM union_council  WHERE cnic = " + bcertertificate_no;



        return session.createNativeQuery(query,UC_Record.class).list();
    }




}
