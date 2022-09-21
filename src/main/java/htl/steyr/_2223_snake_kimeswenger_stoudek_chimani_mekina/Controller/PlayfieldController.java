package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class PlayfieldController {

    public static final int ROW_NR = 25;
    public static final int COL_NR = 20;
    @FXML
    public GridPane playfield = new GridPane();


    /**
     * @author lstoudek
     */
    public void initialize() {
        if (playfield != null) {
            for (int i = 0; i < ROW_NR; i++) {
                for (int j = 0; j < COL_NR; j++) {
                    Pane pane = new Pane();
                    pane.setPrefHeight(20);
                    pane.setPrefWidth(20);
                    playfield.add(pane, i, j);
                    System.out.println(pane + "\t" + i + "\t" + j);
                }
            }
            System.out.println("aef");
        }

    }


}
