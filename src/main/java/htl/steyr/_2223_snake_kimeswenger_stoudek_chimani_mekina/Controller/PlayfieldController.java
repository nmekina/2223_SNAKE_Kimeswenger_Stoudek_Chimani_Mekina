package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Playfield;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;


public class PlayfieldController {

    public static final int ROW_NR = 25;
    public static final int COL_NR = 20;
    @FXML
    public GridPane playfield = new GridPane();

    Playfield pf = new Playfield();

    int xPos;
    int yPos;


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
     * @author lstoudek
     */
    public PlayfieldController() {
        Pane pane = new Pane();
        pane.setMaxHeight(1);
        pane.setMaxWidth(1);
        pane.getChildren().add(new Label("seffe"));
        playfield.add(pane, 0, 0);
        placeFood();
    }

    /**
     * @author skimeswe
     * diese Methode plaziert an zufälligen Stellen einen Apfel (Futter)
     */
    public void placeFood() {

        xPos = pf.getFoodX();
        yPos = pf.getFoodY();
        Image image = new Image("File:images/apple.png");
        playfield.add(new ImageView(image), xPos, yPos);
        System.out.println("x: " + xPos + " y: " + yPos);
    }
}
