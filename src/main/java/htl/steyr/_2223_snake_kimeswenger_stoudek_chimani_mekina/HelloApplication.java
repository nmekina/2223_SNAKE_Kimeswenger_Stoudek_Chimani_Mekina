package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.ThreadClass1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Settings.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("gehts!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ThreadClass1 thread = new ThreadClass1("musicfiles\\kahootmusic.mp3");
        Thread thread2 = new Thread(thread);
        thread2.start();
        launch();
    }
}