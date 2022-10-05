
package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Position;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MoveNormal extends AnimationTimer {

    public static final int LENGTH = 1;

    GridPane playfield;

    public Position position;

    private long lastTick = 0;

    MoveNormal(GridPane playfield, Position position){
        this.playfield = playfield;
        this.position = position;
    }



    @Override
    public void handle(long l) {
        if(lastTick == 0){
            lastTick = l;
        }
        if (l-lastTick > 100000000) {
            Pane pane = new Pane();
            pane.setStyle(" -fx-background-color: lightgreen");
            if (playfield.getChildren().size() > (1 + LENGTH)) {
                playfield.getChildren().remove(2);
            }
            playfield.add(pane, position.getX(), position.getY());
            lastTick=l;
            System.out.println(l);
            this.position.setX(position.getX()+1);
            if (position.getX() == 25){
                position.setX(0);
                this.position.setY(position.getY()+1);
            }
        }

    }
}


