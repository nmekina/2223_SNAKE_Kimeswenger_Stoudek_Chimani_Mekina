package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;



public class PlayfieldController {

    @FXML
    public GridPane playfield = new GridPane();




    /*
 if (playfield != null) {
            for (int i = 0; i < ROW_NR; i++) {
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
    /**@author lstoudek
     *
     */
    public PlayfieldController() {
        Pane pane = new Pane();
        pane.setMaxHeight(1);
        pane.setMaxWidth(1);
        pane.getChildren().add(new Label("seffe"));
        playfield.add(pane, 0, 0);
    }


}
