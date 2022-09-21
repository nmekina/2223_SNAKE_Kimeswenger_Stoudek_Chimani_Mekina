package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller.PlayfieldController;

public class Playfield {

    private int foodX;
    private int foodY;


    private void randomFood() {
        while (true) {
            foodX = (int) (Math.random() * PlayfieldController.ROW_NR);
            foodY = (int) (Math.random() * PlayfieldController.COL_NR);
        }
    }

    public int getFoodX() {
        return foodX;
    }

    public void setFoodX(int foodX) {
        this.foodX = foodX;
    }

    public int getFoodY() {
        return foodY;
    }

    public void setFoodY(int foodY) {
        this.foodY = foodY;
    }
}
