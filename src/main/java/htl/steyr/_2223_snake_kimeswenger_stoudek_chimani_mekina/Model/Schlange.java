package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

public class Schlange {

    static Schlange schlange = null;

    private String direction;

    private int length;


    private Schlange(){
        direction = "D";
        length = 3;
    }

    public static Schlange getSchlange() {
        if (schlange == null){
            schlange = new Schlange();
        }
        return schlange;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
