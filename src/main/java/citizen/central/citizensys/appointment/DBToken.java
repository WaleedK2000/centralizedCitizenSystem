package citizen.central.citizensys.appointment;

import citizen.central.db.Dbcon;
import gov.nadra.Nadra_Record;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tokens")
public class DBToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    public DBToken() {
    }

    public DBToken(String token) {

        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public static void addToken(String token) {
        DBToken tok = new DBToken(token);

        Configuration con;
        SessionFactory sf;
        Session session;
        Transaction trans;

        con = Dbcon.getDbCon();
        con.configure().addAnnotatedClass(DBToken.class);
        sf = con.buildSessionFactory();
        session = sf.openSession();
        trans = session.beginTransaction();

        if (!exists(tok.getToken())) {
            System.out.println("Already Exists");
        } else {
            session.save(tok);
            trans.commit();
        }

    }

    public static boolean exists(String tok) {
        List<DBToken> list = getRecord(tok);
        return !list.isEmpty();
    }

    private static List<DBToken> getRecord(String tok) {

        Configuration con;
        SessionFactory sf;
        Session session;
        Transaction trans;

        con = Dbcon.getDbCon();
        con.configure().addAnnotatedClass(DBToken.class);
        sf = con.buildSessionFactory();
        session = sf.openSession();
        trans = session.beginTransaction();

        String query = "SELECT * FROM tokens WHERE token = " + tok;

        return session.createNativeQuery(query, DBToken.class).list();

    }


}
