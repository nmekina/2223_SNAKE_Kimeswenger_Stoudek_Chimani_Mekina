package htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;

import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.ChangeScene;
import htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StartmenueController {
    public Player pl = new Player();

    public String name;
    public TextField nameinput;
    public Button settingsbutton;
    public ColorPicker colourpicker;
    public ChoiceBox<String> whichFood;
    private static String png;
    public AnchorPane startmenuepane;

    ArrayList<String> list = new ArrayList<>();

    public String getWhichFood() {
        return png;
    }

    EventHandler eventHandler = new escEventhandler();

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
startmenuepane.addEventFilter(KeyEvent.KEY_PRESSED, eventHandler);

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
        pl.setName(nameinput.getText());
        pl.setColor(toRGBCode(colourpicker.getValue()));


        ChangeScene.ChangeSceneNow("playfield", settingsbutton);


    }
    private static String toRGBCode(Color color) {
        String returner = color.toString();
        returner = returner.substring(2);
        if (returner.contains("fff")) {
            returner = returner.substring(0, returner.length() - 2);
        } else {
            returner = returner.replace("ff", "");
        }
        return returner;
    }

    public void addnewplayer(Player p) throws Exception {



        String file = "src/main/java/htl/steyr/_2223_snake_kimeswenger_stoudek_chimani_mekina/Model/highscore.json";
        String json = readFileAsString(file);
        JSONArray ja = new JSONArray(json);
        JSONArray ja2 = new JSONArray();

        Boolean b = false;
        Boolean a = false;
        for (int i = 0; i < ja.length(); i++) {

            JSONObject objv = null;
            objv = ja.getJSONObject(i);
            if (objv.getString("name").equals(p.getName())) {
                b = true;
                int games;
                games= (int) objv.get("games");
                games++;
                objv.remove("games");
                objv.put("games",games);
                a = true;
            }
            if (objv.getString("name").equals(p.getName())&&objv.getInt("highscore")<=p.getHighscore()) {
                objv.remove("highscore");
                objv.put("highscore",p.getHighscore());
                a = true;
            }
            ja2.put(objv);


        }

        if(a){
            FileWriter fw1 = new FileWriter(file);
            fw1.write(String.valueOf(ja2));
            fw1.close();
        }


            JSONObject obj = new JSONObject();
            obj.put("name", p.getName());
            obj.put("games", p.getGames());
            obj.put("highscore", p.getHighscore());
        if (!b) {
            ja2.put(obj);
            FileWriter fw = new FileWriter(file);
            fw.write(String.valueOf(ja2));
            fw.close();
        }

    }

    public static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public class escEventhandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent keyEvent) {
            if ((keyEvent.getCode() == KeyCode.ESCAPE)) {
                try {
                    ChangeScene.ChangeSceneNow("Settings", settingsbutton);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

