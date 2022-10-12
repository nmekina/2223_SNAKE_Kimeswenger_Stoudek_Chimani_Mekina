package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.ChangeScene;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SettingsController {

    public ImageView Imagefobackground;
    public ImageView Imagefobackground1;
    @FXML
    private Button btn_save;

    @FXML
    private Button btn_highscore;

    @FXML
    private Label label_headline;

    @FXML
    private Slider slider_volume;

    @FXML
    private Label label_volume;

    @FXML
    private Label label_music;

    @FXML
    private RadioButton rb_music_on;

    @FXML
    private RadioButton rb_music_off;

    @FXML
    private Label label_difficulty;

    @FXML
    private RadioButton rb_difficulty_1;

    @FXML
    private RadioButton rb_difficulty_2;

    @FXML
    private RadioButton rb_difficulty_3;

    final ToggleGroup rb_difficulty = new ToggleGroup();
    final ToggleGroup rb_music = new ToggleGroup();
    Settings settings = new Settings();
    FileInputStream inputStream = new FileInputStream("images/snakebackground.png");
    FileInputStream inputStream1 = new FileInputStream("images/snakehead.png");
    Image i = new Image(inputStream);
    Image i1 = new Image(inputStream1);

    public SettingsController() throws FileNotFoundException {
    }

    /**
     * Der Initialize befüllt alle labels, buttons etc.
     * mit den gewünschten Inhalten.
     */
    public void initialize() {
        Imagefobackground.setImage(i);
        Imagefobackground1.setImage(i1);
        label_headline.setText("Settings");
        label_difficulty.setText("Difficulty:");
        label_music.setText("Music:");
        label_volume.setText("Volume:");
        btn_highscore.setText("Highscore");
        btn_save.setText("Save");
        rb_difficulty_1.setText("1");
        rb_difficulty_2.setText("2");
        rb_difficulty_3.setText("3");
        rb_music_on.setText("on");
        rb_music_off.setText("off");

        rb_difficulty_1.setToggleGroup(rb_difficulty);
        rb_difficulty_2.setToggleGroup(rb_difficulty);
        rb_difficulty_3.setToggleGroup(rb_difficulty);
        rb_difficulty_1.setSelected(true);

        rb_music_on.setToggleGroup(rb_music);
        rb_music_off.setToggleGroup(rb_music);
        rb_music_on.setSelected(true);
    }

    @FXML
    void btn_highscore_click(ActionEvent event) throws IOException {
        save();
        ChangeScene.ChangeSceneNow("Highscore", btn_highscore);
    }

    @FXML
    void btn_save_click(ActionEvent event) throws IOException {
        save();
        ChangeScene.ChangeSceneNow("Startmenue", btn_save);
    }

    private void save() {
        savedifficulty();
        savemusic();
        savevolume();
    }

    private void savedifficulty() {
        RadioButton selecteddifficulty = (RadioButton) rb_difficulty.getSelectedToggle();
        int difficultyValue = Integer.parseInt(selecteddifficulty.getText());
        settings.setDifficulty(difficultyValue);
    }

    private void savemusic() {
        RadioButton selectedmusic = (RadioButton) rb_music.getSelectedToggle();
        String musicValue = selectedmusic.getText();
        settings.setMusic(!musicValue.equals("off"));
    }

    private void savevolume() {
        Float sliderValue = Float.valueOf(String.valueOf(slider_volume.getValue()));
        System.out.println(sliderValue);
        settings.setVolume(sliderValue);
    }
}
