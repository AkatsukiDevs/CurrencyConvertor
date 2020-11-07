package sample;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileWriter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static sample.Controller.arr;

public class Window {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ok;

    @FXML
    private Text total;





    @FXML
    void initialize() {


        String name = String.valueOf(arr).replaceAll("\\[", "").replaceAll("\\]", "");
        total.setText(name);
        arr.clear();
        ok.setOnAction(actionEvent -> {
            total.setText("");
            ok.getScene().getWindow().hide();



        });






    }
}

