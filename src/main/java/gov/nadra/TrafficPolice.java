package gov.nadra;

public class TrafficPolice {

    public boolean sendDetails(String type, String cnic) {

        String traffic_db = type + "," + cnic;
        return true;

    }

    public boolean sendRequest(String type, String cnic) {

        try {
            wait(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

}
