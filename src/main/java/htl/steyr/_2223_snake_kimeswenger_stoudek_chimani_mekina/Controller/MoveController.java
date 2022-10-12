
package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Playfield;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Position;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Schlange;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Settings;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MoveController extends AnimationTimer {

    public static int LENGTH = 1;

    GridPane playfield;
    Playfield pf = new Playfield();

    int highscore = 0;

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


    MoveController(GridPane playfield, Position position) {
        this.playfield = playfield;
        this.position = position;
    }

    @Override
    public void handle(long l) {
        if (lastTick == 0) {
            lastTick = l;
        }
        if (l - lastTick > 200000000 / speed) {
            Pane pane = new Pane();
            pane.setStyle(" -fx-background-color: lightgreen");
            if (playfield.getChildren().size() > (1 + LENGTH)) {
                playfield.getChildren().remove(2);
            }
            playfield.add(pane, position.getX(), position.getY());
            lastTick = l;
            Schlange schlange = Schlange.getSchlange();
            switch (schlange.getDirection()) {
                case "A":
                    position.setX(position.getX() - 1);
                    break;
                case "D":
                    position.setX(position.getX() + 1);
                    break;
                case "W":
                    position.setY(position.getY() - 1);
                    break;
                case "S":
                    position.setY(position.getY() + 1);
            }
            if (position.getX() == pf.getFoodX() && position.getY() == pf.getFoodY()) {
                LENGTH += 1;
                setHighscore(highscore += 1);
            }

        }

    }
}


