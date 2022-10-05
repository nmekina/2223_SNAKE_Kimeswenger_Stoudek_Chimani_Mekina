package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

/**
 * Klasse für einen Spieler
 * name => Name des Spielers
 * highscore => Highscore des Spielers
 * games => Anzahl der Spiele des Spielers
 */
public class Player {
    public static String name;
    public static Integer highscore;
    public static Integer games;

    /**
     * getter und setter für die obrigen Attribute
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHighscore() {
        return highscore;
    }

    public void setHighscore(Integer highscore) {
        this.highscore = highscore;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }


}
