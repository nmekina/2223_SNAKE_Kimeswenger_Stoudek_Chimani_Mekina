package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.*;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

public class MoveController extends AnimationTimer {
    PlayfieldController pc = new PlayfieldController();

    StartmenueController sc = new StartmenueController();

    public static int LENGTH = 3;
    static List<Position> snakePos = new ArrayList<>();
    private int gamepoints=0;

    GridPane playfield;
    Playfield pf = new Playfield();

    int highscore = 0;

    int a;
    private boolean ismoving = true;

    private String lastDir = "";

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public Position position;
    Player pl = new Player();


    int i = 2;


    private long lastTick = 0;

    Settings settings = new Settings();
    double speed = settings.getDifficulty();
    PlayfieldController playfieldController;


    MoveController(GridPane playfield, Position position, PlayfieldController playfieldController) {
        this.playfield = playfield;
        this.position = position;
        snakePos.add(new Position(3, 4));
        snakePos.add(new Position(4, 4));
        snakePos.add(new Position(5, 4));
        this.playfieldController = playfieldController;
        this.playfieldController.placeFood();
    }

    @Override
    public void handle(long l) {
        Schlange schlange = Schlange.getSchlange();
        if (Objects.equals(schlange.getDirection(), " ")) {
            ismoving = !ismoving;
            schlange.setDirection(lastDir);
        } else {
            lastDir = schlange.getDirection();
        }

        if (ismoving) {


            if (lastTick == 0) {
                lastTick = l;
            }
            if (l - lastTick > 200000000 / speed) {
                Pane pane = new Pane();
                pane.setStyle(" -fx-background-color: #" + sc.pl.getColor());
                if (playfield.getChildren().size() > (1 + LENGTH)) {
                    playfield.getChildren().remove(2);


                }

                for (int i = snakePos.size() - 1; i >= 1; i--) {
                    snakePos.get(i).setX(snakePos.get(i - 1).getX());
                    snakePos.get(i).setY(snakePos.get(i - 1).getY());
                }

                lastTick = l;

                switch (schlange.getDirection()) {
                    case "A" -> {
                        position.setX(position.getX() - 1);
                        snakePos.get(0).setX(snakePos.get(0).getX() - 1);
                    }
                    case "D" -> {
                        position.setX(position.getX() + 1);
                        snakePos.get(0).setX(snakePos.get(0).getX() + 1);

                    }
                    case "W" -> {
                        position.setY(position.getY() - 1);
                        snakePos.get(0).setY(snakePos.get(0).getY() - 1);
                    }

                    case "S" -> {
                        position.setY(position.getY() + 1);
                        snakePos.get(0).setY(snakePos.get(0).getY() + 1);
                    }
                }


                    if (snakePos.size()>3){
                    for (int j = 1; j < snakePos.size(); j++) {
                        if (snakePos.get(0).getX() == snakePos.get(j).getX() && snakePos.get(0).getY() == snakePos.get(j).getY()) {
                            ismoving = false;
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Fehler ");
                            alert.setHeaderText(null);
                            alert.setContentText("Eingenen Körper beruehrt\n" +
                                    "Deine Punkteanzahl:"+gamepoints);

                            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                            alert.show();
                            if (gamepoints>=pl.getHighscore()){
                                sc.pl.setHighscore(gamepoints);
                                sc.pl.setGames(sc.pl.getGames()+1);
                                try {
                                    sc.addnewplayer(sc.pl);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }


                        }
                    }
                    }

                    if (position.getX() < PlayfieldController.ROW_NR && position.getX() >= 0 && position.getY() < PlayfieldController.COL_NR && position.getY() >= 0) {
                        playfield.add(pane, position.getX(), position.getY());

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Fehler");
                        alert.setHeaderText(null);
                        alert.setContentText("Spielfeld verlassen\n" +
                                "Deine Punkteanzahl:"+gamepoints);

                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.show();
                        if (gamepoints>=pl.getHighscore()){
                            sc.pl.setHighscore(gamepoints);
                            sc.pl.setGames(sc.pl.getGames()+1);
                            try {
                                sc.addnewplayer(sc.pl);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        ismoving = false;

                    }


                    if (position.getX() == pf.getFoodX() && position.getY() == pf.getFoodY()) {
                        if ((LENGTH % 7) == 0) {
                            speed += 0.1;
                        }
                        LENGTH += 1;
                        gamepoints++;
                        snakePos.add(new Position(snakePos.get(snakePos.size()-1).getX(), snakePos.get(snakePos.size()-1).getY()));
                        setHighscore(highscore += 1);
                        playfieldController.placeFood();
                    }

            }
        }
    }


}


