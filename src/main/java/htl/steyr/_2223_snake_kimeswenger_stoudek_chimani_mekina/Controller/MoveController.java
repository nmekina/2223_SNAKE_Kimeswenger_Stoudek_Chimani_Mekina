package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.*;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class MoveController extends AnimationTimer {

    public static int LENGTH = 3;

    GridPane playfield;
    Playfield pf = new Playfield();

    int highscore = 0;
    private boolean ismoving = true;

    private String lastDir = "";

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public Position position;

    private long lastTick = 0;

    Settings settings = new Settings();
    double speed = settings.getDifficulty();
    PlayfieldController playfieldController;


    MoveController(GridPane playfield, Position position, PlayfieldController playfieldController) {
        this.playfield = playfield;
        this.position = position;
        this.playfieldController = playfieldController;
        this.playfieldController.placeFood();
    }

    @Override
    public void handle(long l) {
        Schlange schlange = Schlange.getSchlange();
        if (Objects.equals(schlange.getDirection(), " ")){
            ismoving = !ismoving;
            schlange.setDirection(lastDir);
        }else {
            lastDir = schlange.getDirection();
        }

        if (ismoving) {
            if (lastTick == 0) {
                lastTick = l;
            }
            if (l - lastTick > 200000000 / speed) {
                Pane pane = new Pane();
                pane.setStyle(" -fx-background-color: lightgreen");
                if (playfield.getChildren().size() > (1 + LENGTH)) {
                    playfield.getChildren().remove(2);
                }

                lastTick = l;

                switch (schlange.getDirection()) {
                    case "A" -> position.setX(position.getX() - 1);
                    case "D" -> position.setX(position.getX() + 1);
                    case "W" -> position.setY(position.getY() - 1);
                    case "S" -> position.setY(position.getY() + 1);
                }
                if (position.getX() < PlayfieldController.ROW_NR
                        && position.getX() >= 0
                        && position.getY() < PlayfieldController.COL_NR
                        && position.getY() >= 0
                        && ismoving) {
                    playfield.add(pane, position.getX(), position.getY());
                } else {
                    ismoving = false;
                    System.out.println("game stopped");
                    //ToDo Spiel beenden
                }
                if (position.getX() == pf.getFoodX() && position.getY() == pf.getFoodY()) {
                    if ((LENGTH % 7) == 0) {
                        speed += 0.1;
                    }
                    LENGTH += 1;
                    setHighscore(highscore += 1);
                    playfieldController.placeFood();
                }

            }
        }
    }
}



