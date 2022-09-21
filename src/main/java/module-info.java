module htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina {
    requires javafx.controls;
    requires javafx.fxml;
    requires soundPlay;


    opens htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina to javafx.fxml;
    exports htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina;
    exports htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller;
    opens htl.steyr._2223_snake_kimeswenger_stoudek_chimani_mekina.Controller to javafx.fxml;
}