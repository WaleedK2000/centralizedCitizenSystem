/*import citizen.central.citizensys.Citizen;
import gov.nadra.DBNadra;
import gov.nadra.Nadra_Record;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Nadra_Class_Test {

    Nadra_Record record;
    DBNadra database;

    @Before
    public void setup(){
        database = new DBNadra();
        record = new Nadra_Record(null, "147", "Jhon", "Doe", "85", "96", new Date(2020, 05, 14),'m');
    }

    @Test
    public void insertNadraRecord(){
        database.addRecord(record);
        Nadra_Record ret = database.getRecord("147").get(0);

        assertEquals(ret.getCnic(), "147" );
        assertEquals(ret.getFirst_name(), "Jhon" );



    }


}
*/