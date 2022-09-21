package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model;

public class Settings {
    private int difficulty = 1;
    private boolean music = true;
    private int volume = 50;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
