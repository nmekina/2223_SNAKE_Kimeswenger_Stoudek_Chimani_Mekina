package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.*;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Statement;


public class PlayfieldController {
    @FXML
    public Label titleLabel;
    @FXML
    public Label highscoreLabel;
    MediaPlayer mediaPlayer;

    Media media;
    Settings s = new Settings();
    public static final int ROW_NR = 25;
    public static final int COL_NR = 20;
    @FXML
    public GridPane playfield = new GridPane();
    public String img;

    MoveController move;

    Playfield pf = new Playfield();
    PlayfieldController playfieldController = this;
    int count = 0;

    static StartmenueController smc = new StartmenueController();

    private EventHandler<MouseEvent> startEventhandler = new StartEventHandler();
    private EventHandler<KeyEvent> moveEventHandler = new MoveEventHandler();
    int xPos;
    int yPos;


    public PlayfieldController() {}

    /**
     * @author lstoudek
     * @author skimeswe
     * In diesem initialize wird aus dem musicfiles Ordner ein Sound ausgewhält.
     * Mittles Lautstärkeregler kann der Sound angepasst werden.
     * ON/OFF kann separat eingestellt werden
     */
    public void initialize() {
        File mediaFile = new File("musicfiles/kahootmusic.mp3");
        media = null;
        playfield.addEventHandler(MouseEvent.MOUSE_RELEASED, startEventhandler);

        try {
            media = new Media(mediaFile.toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setAutoPlay(s.getMusic());
        mediaPlayer.setVolume(s.getVolume() / 100);
    }


    /**
     * @author skimeswe
     * diese Methode plaziert an zufälligen Stellen ein
     * zuvor ausgewähltes Futter
     */
    public GridPane placeFood() {
        if (count > 0) {
            playfield.getChildren().remove(0);
        }
        Position position = pf.randomFood();
        img = smc.getWhichFood();
        Image image = new Image("File:images/" + img, 20, 20, false, false);
        playfield.add(new ImageView(image), position.getX(), position.getY());
        return playfield;
    }


    public class StartEventHandler implements EventHandler<MouseEvent> {
        int i = 0;

        int j = 0;

        @Override
        public void handle(MouseEvent mouseEvent) {
            AnimationTimer th1 = new MoveController(playfield, new Position(j, i), playfieldController);
            th1.start();
            titleLabel.getScene().addEventFilter(KeyEvent.KEY_PRESSED, moveEventHandler);
            playfield.removeEventHandler(MouseEvent.MOUSE_RELEASED, startEventhandler);
        }
    }

    public class MoveEventHandler implements EventHandler<KeyEvent> {


        @Override
        public void handle(KeyEvent keyEvent) {
            System.out.println(keyEvent.getCode());
            Schlange schlange = Schlange.getSchlange();
            String key = keyEvent.getText().toUpperCase();
            if (!(keyEvent.getCode() == KeyCode.ESCAPE)) {
                if (key.equals("A") || key.equals("W") || key.equals("S") || key.equals("D") || key.equals(" ")) {
                    schlange.setDirection(key);
                }
            }else {
                Stage stage = (Stage) highscoreLabel.getScene().getWindow();
                stage.close();
                try {
                    ChangeScene.ChangeSceneNow("Startmenue", titleLabel);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
