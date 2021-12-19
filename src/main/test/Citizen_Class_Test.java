/*

import citizen.central.citizensys.Citizen;
import citizen.central.db.DbCitizen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Citizen_Class_Test {

    Citizen citizen;
    DbCitizen database;

    @Before
    public void setup(){
        database = new DbCitizen();
        citizen = new Citizen("147","password");
    }

    @Test
    public void insertCitizen(){
        database.addCitizen(citizen);
        Citizen ret = database.getCitizen("147", "password").get(0);
        assertEquals(ret.getCnic(),"147");
        assertEquals(ret.getPassword(),"password");

    }
    @Test
    public void doubleInsert(){
        assertEquals(database.addCitizen(citizen),false);

    }





}
*/