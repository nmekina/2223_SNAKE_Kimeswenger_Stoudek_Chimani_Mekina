package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller.StartmenueController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Klasse fürs wechseln der Scene in das mitegegebene fxml-Fenster
 */
public class ChangeScene {

    /**
     * wechelt die Scene
     *
     * @param game   => Name des Fensters inn welches gewechselt werden soll
     * @param button => Button, um die alte Stage schließen zu können
     * @throws IOException
     */
    public static void ChangeSceneNow(String game, Button button) throws IOException {
        Stage stage = new Stage();

        Stage stageclose = (Stage) button.getScene().getWindow();
        stageclose.close();

        final FXMLLoader fxmlLoader = new FXMLLoader();
        URL u = StartmenueController.class.getResource(game + ".fxml");

        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle(game);
        stage.setScene(scene);
        stage.show();
    }
}
