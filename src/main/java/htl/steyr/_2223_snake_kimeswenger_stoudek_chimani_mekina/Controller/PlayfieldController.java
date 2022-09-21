package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;


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
                playfield.getRowConstraints().add(new RowConstraints());
            } for (int j = 0; j < COL_NR; j++) {
                playfield.getColumnConstraints().add(new ColumnConstraints());
            }
            System.out.println("aef");
        }

    }


}
