package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Playfield;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Position;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Settings;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;


public class PlayfieldController {
    MediaPlayer mediaPlayer;
    Media media;
    Settings s = new Settings();
    public static final int ROW_NR = 25;
    public static final int COL_NR = 20;
    @FXML
    public GridPane playfield = new GridPane();
    public String img;

    Playfield pf = new Playfield();

    static StartmenueController smc = new StartmenueController();

    private final EventHandler<MouseEvent> startEventhandler = new StartEventHandler();
    int xPos;
    int yPos;


    public PlayfieldController() throws FileNotFoundException {
    }


    /**
     * @author lstoudek
     * @author skimeswe
     */


    public void initialize() throws MalformedURLException {

        placeFood();

        File mediaFile = new File("musicfiles/kahootmusic.mp3");
        Media media = null;
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
    /*
 if (playfield != null) {
            for (int i = 0; i < ROW_NR; i++) {
                playfield.getRowConstraints().add(new RowConstraints());
            } for (int j = 0; j < COL_NR; j++) {
                playfield.getColumnConstraints().add(new ColumnConstraints());
                for (int j = 0; j < COL_NR; j++) {
                    Pane pane = new Pane();
                    pane.setPrefHeight(20);
                    pane.setPrefWidth(20);
                    pane.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
                    playfield.add(pane, i, j);
                    System.out.println(pane + "\t" + i + "\t" + j);
                }
            }
            ColumnConstraints col1 = new ColumnConstraints();
            col1.setPrefWidth(20);
            playfield.getColumnConstraints().addAll(col1);
            System.out.println("aef");
        }

     */


    /**
     * @author skimeswe
     * diese Methode plaziert an zufälligen Stellen einen Apfel (Futter)
     */
    public void placeFood() {
        Position position = pf.randomFood();
        img = smc.getWhichFood();
        Image image = new Image("File:images/" + img, 20, 20, false, false);
        playfield.add(new ImageView(image), position.getX(), position.getY());
    }


    class StartEventHandler implements EventHandler<MouseEvent> {
        int i = 0;

        int j = 0;

        @Override
        public void handle(MouseEvent mouseEvent) {
            AnimationTimer th1 = new MoveNormal(playfield, new Position(j, i));
            // Thread th1 = new MoveNormal(playfield, new Position(j, i));
            th1.start();


            //playfield.removeEventHandler(MouseEvent.MOUSE_RELEASED, startEventhandler);
        }
    }
}
