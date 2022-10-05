package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

/**
 * Klasse für Positionen der Schlange
 * x => X-Koordinate der Schlange
 * y => Y-Koordinate der Schlange
 */
public class Position {
    private int x;
    private int y;

    /**
     * Konstruktor für eine Position
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * getter und setter der X- und Y-Koordinaten
     */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
