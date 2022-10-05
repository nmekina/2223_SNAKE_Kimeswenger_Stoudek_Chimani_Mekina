package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

/**
 * Klass für die Schlange
 * schlange => Schlangen instanz, weil Singleton
 * direction => Richtung der Schlange
 * length => Länge der Schlange
 */
public class Schlange {
    static Schlange schlange = null;
    private String direction;
    private int length;

    /**
     * privater Konstruktor fürs setzen der Richtung und der Länge
     */
    private Schlange() {
        direction = "D";
        length = 3;
    }

    /**
     * getter und setter der obrigen Attribute
     */
    public static Schlange getSchlange() {
        if (schlange == null) {
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
