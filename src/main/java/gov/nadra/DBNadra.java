package gov.nadra;

import citizen.central.citizensys.Citizen;
import citizen.central.db.Dbcon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBNadra {

    private final Configuration con;
    private final SessionFactory sf;
    private final Session session;
    private final Transaction trans;


    public DBNadra(){
        con = Dbcon.getDbCon();
        con.configure().addAnnotatedClass(Nadra_Record.class);
        sf = con.buildSessionFactory();
        session = sf.openSession();
        trans = session.beginTransaction();
    }

    public boolean addRecord(Nadra_Record record){

        if(exits(record.getCnic())){
            System.out.println("Already Exists");
            return false;
        }
        else {
            session.save(record);
            trans.commit();
            return true;
        }

    }

    public boolean exits(String cnic){
        List<Nadra_Record> list = getRecord(cnic);
        return !list.isEmpty();
    }

    public List<Nadra_Record> getRecord(String cnic){
        String query = "SELECT id FROM nadra WHERE cnic = " + cnic;
        return session.createNativeQuery(query,Nadra_Record.class).list();
    }

}
