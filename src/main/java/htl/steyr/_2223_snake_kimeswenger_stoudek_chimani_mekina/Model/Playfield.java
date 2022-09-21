package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller.PlayfieldController;

public class Playfield {

    private int foodX;
    private int foodY;


    public Position randomFood() {
            foodX = (int) (Math.random() * PlayfieldController.ROW_NR);
            foodY = (int) (Math.random() * PlayfieldController.COL_NR);
        return new Position(foodX, foodY);
    }



    public void setFoodX(int foodX) {
        this.foodX = foodX;
    }


    public void setFoodY(int foodY) {
        this.foodY = foodY;
    }
}
