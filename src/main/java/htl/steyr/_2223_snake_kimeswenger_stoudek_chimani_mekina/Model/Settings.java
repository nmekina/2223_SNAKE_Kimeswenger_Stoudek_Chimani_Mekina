package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

/**
 * Klasse für die Settings des Spiels
 * difficulty => Die Schwierigkeit des Spiels
 * music => Musik ein oder aus
 * volume => Lautstärke des Spiels
 */
public class Settings {
    private static int difficulty = 1;
    private static boolean music = true;
    private static float volume = 50;

    /**
     * getter und setter der obrigen Attribute
     */
    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        Settings.difficulty = difficulty;
    }

    public boolean getMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }


}
