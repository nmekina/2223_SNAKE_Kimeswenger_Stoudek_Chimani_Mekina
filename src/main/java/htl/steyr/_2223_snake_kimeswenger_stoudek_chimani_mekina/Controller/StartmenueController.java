package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.ChangeScene;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Player;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class StartmenueController {
    public TextArea nameinput;
    public Button settingsbutton;
    public ColorPicker colourpicker;
    public ChoiceBox<String> whichFood;
    private static String png;

    ArrayList<String> list = new ArrayList<>();

    public String getWhichFood() {
        return png;
    }


    public ChoiceBox<String> savedplayersc;

    /**
     * @throws IOException
     * @author skimeswe
     * change Food (apple, banana)
     */
    public void initialize() throws IOException {
        addSpieler();
        for (String oneplayer : list) {
            savedplayersc.getItems().add(oneplayer);
        }
        whichFood.getItems().add("apple");
        whichFood.getItems().add("banana");


    }

    public void addSpieler() throws IOException {
        File file = new File("src/main/java/htl/steyr/_2223_snake_kimeswenger_stoudek_chimani_mekina/Model/highscore.json");
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONArray json = new JSONArray(content);


        for (int z = 0; z < json.length(); z++) {
            JSONObject getplayer = json.getJSONObject(z);
            String player = getplayer.getString("name");
            list.add(player);
        }
    }


    public void submitbtn(ActionEvent actionEvent) throws Exception {
        png = whichFood.getSelectionModel().getSelectedItem() + ".png";
        System.out.println("hier start");
        System.out.println(png);
        if (savedplayersc.getSelectionModel().getSelectedItem() != null) {
            nameinput.appendText(savedplayersc.getSelectionModel().getSelectedItem());


        } else if (nameinput.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ungueltiger Player ");
            alert.setHeaderText(null);
            alert.setContentText("Ungueltiger Player:\n");

            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
        Player p = new Player();
        p.setName(nameinput.getText());
        p.setGames(11);
        p.setHighscore(10);
        addnewplayer(p);


        ChangeScene.ChangeSceneNow("playfield", settingsbutton);


    }

    public void addnewplayer(Player p) throws Exception {


        String file = "src/main/java/htl/steyr/_2223_snake_kimeswenger_stoudek_chimani_mekina/Model/highscore.json";
        String json = readFileAsString(file);
        JSONArray ja = new JSONArray(json);

/*
        int count = 0;
        while (i.hasNext()) {
            count++;
            ja = i.next();
            if (Objects.equals(Player.name, p.name)) {
                check = false;
                p.games++;
                p.coins = coins + p.coins;
                if (Settings.getHighscoreonoff()) {
                    if (score > p.highscore) {
                        player.get(count - 1).highscore = score;
                    }
                }
            }
        }*/
        Boolean b = false;

        for (int i = 0; i < ja.length(); i++) {
            JSONObject objv = null;
            objv = ja.getJSONObject(i);
            if (objv.getString("name").equals(p.getName())) {
                b = true;
            }

        }

            JSONObject obj = new JSONObject();
            obj.put("name", p.getName());
            obj.put("games", p.getGames());
            obj.put("highscore", p.getHighscore());
        if (!b) {
            ja.put(obj);
            System.out.println(ja);
            FileWriter fw = new FileWriter(file);
            fw.write(String.valueOf(ja));
            fw.close();
        }

    }

    public static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }


}

