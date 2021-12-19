package citizen.central.citizensys.login;

import citizen.central.citizensys.Citizen;
import citizen.central.db.Dbcon;
import gov.nadra.Nadra_Record;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBLogin {

    private final Configuration con;
    private final SessionFactory sf;
    private final Session session;
    private final Transaction trans;

    public DBLogin(){
        con = Dbcon.getDbCon();
        con.configure().addAnnotatedClass(Citizen.class);
        sf = con.buildSessionFactory();
        session = sf.openSession();
        trans = session.beginTransaction();
    }

    public boolean validate_credential(String cnic, String password, char type){

        if(type == 'u'){
            //user
            String query = "SELECT * FORM citizen WHERE cnic = " + cnic + " and password = " + password;
            List<Citizen> list = session.createNativeQuery(query,Citizen.class).list();
            if(list.isEmpty()){
                return false;
            }
            Citizen cit = list.get(0);

            return cit.validatePassword(password);
        }

    }

}
