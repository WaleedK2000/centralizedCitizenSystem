package citizen.central.citizensys;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));

        /*
        DBNadra db = new DBNadra();
        //db.addRecord(new Nadra_Record(0L,"147","Abc", "Xyz", "852", "963" , new Date(1995,02,02),'m'));
        db.addRecord(new Nadra_Record(0L,"258","Aminah", "Sheikh", "111", "963887" , new Date(1978, Calendar.JUNE,7),'f'));
        db.addRecord(new Nadra_Record(0L,"748","Mohammad", "Akram", "999", "77444558" , new Date(1970, Calendar.SEPTEMBER,2),'m'));
        db.addRecord(new Nadra_Record(0L,"612","Junaid", "Khan", "999", "77444558" , new Date(1973, Calendar.SEPTEMBER,2),'m'));

        DBLogin dbLogin = new DBLogin();
        */
        //dbLogin.addUser("147", "123");


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("center_user.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Central Citizen System");

        Image logo = new Image(String.valueOf(HelloApplication.class.getResource("img/logo.png")));

        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
    }
}