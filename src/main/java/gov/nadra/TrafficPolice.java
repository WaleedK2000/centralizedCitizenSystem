package gov.nadra;

public class TrafficPolice {

    public boolean sendDetails(String type, String cnic){

        String traffic_db = type+","+cnic;
        return true;

    }

}
