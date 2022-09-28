package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.jar.Attributes;

public class StartmenueController {
    public TextArea nameinput;
    public Button settingsbutton;
    public ColorPicker colourpicker;

    ArrayList<String> list=new ArrayList<>();


    public ChoiceBox savedplayersc;

    public void initialize() throws IOException {
        addSpieler();
        for (String oneplayer : list) {
            savedplayersc.getItems().add(oneplayer);
        }



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
        if(nameinput.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ungueltiger Player ");
            alert.setHeaderText(null);
            alert.setContentText("Ungueltiger Player:\n");

            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }else {
            Player p = new Player();
            p.setName(nameinput.getText());
            p.setGames(1);
            p.setHighscore(1);
            addnewplayer(p);
        }
    }
    public void addnewplayer(Player pe) throws IOException {
        Boolean check = true;
        File f = new File("src/main/java/htl/steyr/_2223_snake_kimeswenger_stoudek_chimani_mekina/Model/highscore.json");
        Scanner s = new Scanner(f);
        FileReader fr = new FileReader(f);
        StringBuilder sb = new StringBuilder();

        while (s.hasNextLine()) {
            sb.append(s.nextLine());
        }
        Gson g = new Gson();

        Type listType = new TypeToken<ArrayList<Player>>() {
        }.getType();
        ArrayList<Player> player = g.fromJson(fr, listType);


        Iterator<Player> i = player.iterator();

        int count = 0;
        while (i.hasNext()) {
            count++;
            Player p = i.next();
            if (pe.equals(p.getName())) {
                check = false;
                pe.setGames(pe.getGames()+1);


            }
        }

        if (check) {
            Player playerScore = new Player();


            playerScore.setName(pe.getName());
            playerScore.setHighscore(pe.getHighscore());
            playerScore.setGames(pe.getGames());
            player.add(playerScore);
        }
        FileWriter fw = new FileWriter(f);
        g.toJson(player, fw);
        fw.close();
    }
    }

