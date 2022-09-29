package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.ChangeScene;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Player;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Playfield;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Settings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StartmenueController {
    public TextArea nameinput;
    public Button settingsbutton;
    public ColorPicker colourpicker;
    public ChoiceBox<String> whichFood;
    private String png;

    private static FileWriter fw;

    ArrayList<String> list = new ArrayList<>();

    public String getWhichFood() {
        return png;
    }


    public ChoiceBox<String> savedplayersc;

    /**
     * @author skimeswe
     * change Food (apple, banana)
     * @throws IOException
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


    public void submitbtn(ActionEvent actionEvent) throws IOException {
        System.out.println("aa");

        Player p = new Player();
        p.setName(nameinput.getText());
        p.setGames(1);
        p.setHighscore(1);
        addnewplayer(p);
        ChangeScene.ChangeSceneNow("playfield", settingsbutton);
        png = whichFood.getSelectionModel().getSelectedItem() + ".png";
        getWhichFood();
        System.out.println(png);
        System.out.println("bb");

        if (nameinput.getText().equals("")) {
            if (nameinput.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ungueltiger Player ");
                alert.setHeaderText(null);
                alert.setContentText("Ungueltiger Player:\n");

                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.showAndWait();
            }

        }



    }
    
    public void addnewplayer(Player p) throws IOException {


        JsonParser parser = new JsonParser();
        JSONObject obj = new JSONObject();
        obj.append("name", p.getName());
        obj.append("games", p.getName());
        obj.append("highscore", p.getHighscore());
        Gson g = new Gson();


        JsonArray a = (JsonArray) parser.parse(new FileReader("src/main/java/htl/steyr/_2223_snake_kimeswenger_stoudek_chimani_mekina/Model/highscore.json"));   // reading the file and creating a json array of it.

        //a.add(String.valueOf(obj));   // adding your created object into the array
        a.add(p.toString());   // adding your created object into the array
        System.out.println(a.toString());

     //   fw = new FileWriter("src/main/java/htl/steyr/_2223_snake_kimeswenger_stoudek_chimani_mekina/Model/highscore.json");
       // fw.write(String.valueOf(js));
        //fw.close();


        }

    }

