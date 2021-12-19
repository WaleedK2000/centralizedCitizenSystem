package citizen.central.db;

import citizen.central.citizensys.Citizen;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DbCitizen {

    Configuration con;
    SessionFactory sf;
    Session session;
    Transaction trans;


    public DbCitizen() {
        con = Dbcon.getDbCon();
        con.configure().addAnnotatedClass(Citizen.class);
        sf = con.buildSessionFactory();
        session = sf.openSession();
        trans = session.beginTransaction();
    }

    public boolean addCitizen(Citizen citizen) {

        if (citizenExists(citizen.getCnic(), citizen.getPassword())) {
            System.out.println("Already Exists");
            return false;
        } else {
            session.save(citizen);
            trans.commit();
            return true;
        }

    }

    public boolean citizenExists(String cnic, String password) {
        List<Citizen> list = getCitizen(cnic, password);
        return !list.isEmpty();
    }

    public List<Citizen> getCitizen(String cnic, String password) {
        String query = "SELECT id FROM citizen WHERE cnic = " + cnic + " AND password = " + password;
        return session.createNativeQuery(query, Citizen.class).list();

    }


}
