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

import java.util.ArrayList;
import java.util.jar.Attributes;

public class StartmenueController {
    public TextArea nameinput;
    public Button settingsbutton;
    public ColorPicker colourpicker;

    ArrayList<String> list1=new ArrayList<>();
    ObservableList<String>list;

    public ChoiceBox savedplayersc;

    public void initialize() {
        savedplayersc.setItems( list);


    }

    public void settingsbuttonclicked(ActionEvent actionEvent) {
        list.add(nameinput.getText());
    }
}
