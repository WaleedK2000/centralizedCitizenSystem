package citizen.central.citizensys.appointment;

import citizen.central.db.Dbcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;


public class Database {


    public static ObservableList<String> getAvailableSlots(ResultSet resultSet) throws SQLException {
        ObservableList<String> time = FXCollections.observableArrayList();
        while (resultSet.next()) {
            Time timeObj = resultSet.getTime("time");
            String timeString = timeObj.toString();
            time.add(timeString);
        }
        return time;
    }

    // Returns Available Slots Free one day from today
    public static ObservableList<String> getAvailableSlots() throws SQLException {

        Date dat = new Date(2021, 12, 13);

        String sql = "select time from workslot where workslot.time NOT IN  ( select startTime from appointment WHERE date = ? AND counter_id = ? );\n";
        Connection con = Dbcon.mySQLConnection();
        assert con != null;
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setDate(1, dat);
        statement.setInt(2, 2500);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet.getFetchSize() + "  size");
        return getAvailableSlots(resultSet);
    }

    public static ObservableList<String> getAvailableSlots(Date dat) throws SQLException {

        // Date dat = new Date(2021,12,13);

        String sql = "select time from workslot where workslot.time NOT IN  ( select startTime from appointment WHERE date = ? AND counter_id = ? );\n";
        Connection con = Dbcon.mySQLConnection();
        assert con != null;
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setDate(1, dat);
        statement.setInt(2, 2500);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet.getFetchSize() + "  size");
        return getAvailableSlots(resultSet);
    }

    public static String confirmAppointment(String cnic, LocalDate date, String time) throws SQLException {
        String sql = "INSERT INTO appointment (counter_id, citizen, `date`, startTime, endTime) VALUES (2500, ?, ?, ? , '09:30' )";
        Connection con = Dbcon.mySQLConnection();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, cnic);
        statement.setDate(2, Date.valueOf(date));
        statement.setString(3, time);
        String tok = cnic + "_" +date.getMonth() + date.getYear();
        DBToken.addToken(tok);
        return tok;
    }



}
