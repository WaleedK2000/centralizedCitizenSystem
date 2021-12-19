package citizen.central.citizensys;

import gov.nadra.DBNadra;
import gov.nadra.Nadra;
import gov.nadra.Nadra_Record;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));


        DBNadra db = new DBNadra();
        //db.addRecord(new Nadra_Record(0L,"147","Abc", "Xyz", "852", "963" , new Date(1995,02,02),'m'));
        db.addRecord(new Nadra_Record(0L,"963","Test ", "Mother", "741258", "963887" , new Date(1975,04,07),'f'));
        db.addRecord(new Nadra_Record(0L,"852","Test", "Father", "85447", "77444558" , new Date(1975,05,02),'m'));

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("center_user.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Central Citizen System");

        Image logo = new Image(String.valueOf(HelloApplication.class.getResource("img/logo.png")));

        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
    }
}