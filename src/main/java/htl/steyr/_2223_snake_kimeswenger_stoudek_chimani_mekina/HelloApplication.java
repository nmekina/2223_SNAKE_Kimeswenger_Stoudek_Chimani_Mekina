package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller.SettingsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(SettingsController.class.getResource("Settings.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Snake!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}