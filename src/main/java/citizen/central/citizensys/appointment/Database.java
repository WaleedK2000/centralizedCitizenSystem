package citizen.central.citizensys.appointment;

import citizen.central.db.Dbcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class Database {



    public static ObservableList<String> getAvailableSlots(ResultSet resultSet) throws SQLException {
        ObservableList<String> time = FXCollections.observableArrayList();
        while (resultSet.next()){
            Time timeObj = resultSet.getTime("time");
            String timeString = timeObj.toString();
            time.add(timeString);
        }
        return time;
    }

    // Returns Available Slots Free one day from today
    public static ObservableList<String> getAvailableSlots() throws SQLException {

        Date dat = new Date(2021,12,13);

        String sql = "select time from workslot where workslot.time NOT IN  ( select startTime from appointment WHERE date = ? AND counter_id = ? );\n";
        Connection con = Dbcon.mySQLConnection();
        assert con != null;
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setDate(1,dat);
        statement.setInt(2,2500);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet.getFetchSize()+ "  size");
        return getAvailableSlots(resultSet);
    }

    public static ObservableList<String> getAvailableSlots(Date dat) throws SQLException {

       // Date dat = new Date(2021,12,13);

        String sql = "select time from workslot where workslot.time NOT IN  ( select startTime from appointment WHERE date = ? AND counter_id = ? );\n";
        Connection con = Dbcon.mySQLConnection();
        assert con != null;
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setDate(1,dat);
        statement.setInt(2,2500);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet.getFetchSize()+ "  size");
        return getAvailableSlots(resultSet);
    }

}
