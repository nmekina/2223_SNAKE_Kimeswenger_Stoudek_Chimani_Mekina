
package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Position;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Schlange;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Move extends AnimationTimer {

    public static final int LENGTH = 1;

    GridPane playfield;

    public Position position;

    private long lastTick = 0;
    private double speed = 0.2;

    Move(GridPane playfield, Position position){
        this.playfield = playfield;
        this.position = position;
    }



    @Override
    public void handle(long l) {
        if(lastTick == 0){
            lastTick = l;
        }
        if (l-lastTick > 100000000/speed) {
            Pane pane = new Pane();
            pane.setStyle(" -fx-background-color: lightgreen");
            if (playfield.getChildren().size() > (1 + LENGTH)) {
                playfield.getChildren().remove(2);
            }
            playfield.add(pane, position.getX(), position.getY());
            lastTick=l;
            //System.out.println(l);
            Schlange schlange = Schlange.getSchlange();
            System.out.println(schlange.getDirection() + " 43Move");
            switch (schlange.getDirection()){
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
        }

    }
}


