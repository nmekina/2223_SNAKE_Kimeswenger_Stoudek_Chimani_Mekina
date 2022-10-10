package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller.PlayfieldController;

/**
 * Klasse das Spielfelds
 * foodX => X-Koordinate des Essens
 * foodY => Y-Koordinate des Essens
 */
public class Playfield {
    static int foodX;
    static int foodY;

    /**
     * platziert das Essen auf einer zufälligen Position
     *
     * @return Positionsobjekt mit X- und Y-Koordinate
     */
    public Position randomFood() {
        setFoodX((int) (Math.random() * PlayfieldController.ROW_NR));
        setFoodY((int) (Math.random() * PlayfieldController.COL_NR));
        return new Position(foodX, foodY);
    }

    public int getFoodX() {
        return foodX;
    }

    public void setFoodX(int foodX) {
        Playfield.foodX = foodX;
    }

    public int getFoodY() {
        return foodY;
    }

    public void setFoodY(int foodY) {
        Playfield.foodY = foodY;
    }
}
