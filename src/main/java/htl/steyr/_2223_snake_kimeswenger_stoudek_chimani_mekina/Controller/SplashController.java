package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SplashController {
    public ImageView view;
    public AnchorPane AnchorPane;
    public javafx.scene.layout.AnchorPane ap;


    public void initialize() {
        Image image = new Image("https://static.vecteezy.com/system/resources/thumbnails/000/373/352/small/vksq_7pzq_170804.jpg");
        view.setImage(image);
        splash();
    }

    private void splash() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Platform.runLater(new Runnable() {


                    @Override
                    public void run() {
                        try {
                            AnchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Settings.fxml")));
                            Stage stage = new Stage();
                            Scene scene = new Scene(AnchorPane);
                            scene.setFill(Color.TRANSPARENT);
                            stage.initStyle(StageStyle.TRANSPARENT);
                            stage.setTitle("Battleship");
                            stage.setScene(scene);
                            stage.setMinHeight(400);
                            stage.setMinWidth(255);
                            stage.show();
                            ap.getScene().getWindow().hide();
                        } catch (IOException ex) {
                            Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        }.start();

    }
}

