package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

public class Player {
    private static String name;
    private static Integer highscore;

    private static Integer games;

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
