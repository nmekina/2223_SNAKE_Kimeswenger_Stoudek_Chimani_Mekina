package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class StartmenueController {
    public TextArea nameinput;
    public Button settingsbutton;
    public ColorPicker colourpicker;

    ArrayList<String> list1=new ArrayList<>();
    ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3);

    public ChoiceBox savedplayersc;

    public void initialize() {

        for (String oneplayer : allplayers) {
            choicebox_username.getItems().add(oneplayer);
        }
        addSpieler();

    }

    public void settingsbuttonclicked(ActionEvent actionEvent) {
        list1.add(nameinput.getText());
    }
    public void addSpieler() throws IOException {
        File file = new File("src/main/java/htl/steyr/_2223_snake_kimeswenger_stoudek_chimani_mekina/Model/highscore.json");
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONArray json = new JSONArray(content);


        for (int z = 0; z < json.length(); z++) {
            JSONObject getplayer = json.getJSONObject(z);
            String player = getplayer.getString("name");
            allplayers.add(player);
        }
    }
}

