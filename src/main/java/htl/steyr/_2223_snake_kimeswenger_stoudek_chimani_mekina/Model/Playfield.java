package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller.PlayfieldController;

/**
 * Klasse das Spielfelds
 * foodX => X-Koordinate des Essens
 * foodY => Y-Koordinate des Essens
 */
public class Playfield {
    private int foodX;
    private int foodY;

    /**
     * platziert das Essen auf einer zufälligen Position
     *
     * @return Positionsobjekt mit X- und Y-Koordinate
     */
    public Position randomFood() {
        foodX = (int) (Math.random() * PlayfieldController.ROW_NR);
        foodY = (int) (Math.random() * PlayfieldController.COL_NR);
        return new Position(foodX, foodY);
    }
}
