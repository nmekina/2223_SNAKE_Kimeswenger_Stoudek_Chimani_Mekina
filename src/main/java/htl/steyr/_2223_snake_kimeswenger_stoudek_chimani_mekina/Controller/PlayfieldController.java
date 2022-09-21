package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.EventListener;


public class PlayfieldController {

    private static final int ROW_NR = 20;
    private static final int COL_NR = 25;
    @FXML
    GridPane playfield = new GridPane();

    /**@author lstoudek
     *  initialisiert das Spielfeld
     */
    public PlayfieldController(){
        for (int i = 0; i < ROW_NR; i++){
            for (int j = 0; j < COL_NR; j++){
                Pane pane = new Pane();
                pane.setStyle("-fx-border-color: black; -fx-border-width: 2px");
                playfield.add(pane, i, j);
                System.out.println(pane + "\t" + i + "\t" + j);
                playfield.setOnMouseClicked(myEventhandler);
            }
        }
        System.out.println("aef");
    }

    EventHandler<MouseEvent> myEventhandler = new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("asdf");
        }
    };


}
