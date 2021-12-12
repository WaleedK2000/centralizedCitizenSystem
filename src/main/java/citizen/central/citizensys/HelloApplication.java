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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cnic/renewcnic.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Central Citizen System");

        Image logo = new Image(String.valueOf(HelloApplication.class.getResource("img/logo.png")));

        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
    }
}