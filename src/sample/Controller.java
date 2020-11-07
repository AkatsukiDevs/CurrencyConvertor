package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox ruble;

    @FXML
    private CheckBox dollar;

    @FXML
    private CheckBox euro;

    @FXML
    private CheckBox tenge;

    @FXML
    private TextField textfield;

    @FXML
    private Button covert;
    String total = "";

    @FXML
    private Button info;
    public static ArrayList<String> arr=new ArrayList<String >();

    @FXML
    void initialize() {

        covert.setOnAction(actionEvent -> {
            total="";
            arr.isEmpty();
            String field = textfield.getText();
            boolean numeric = true;
            float soms = Float.parseFloat(field);


            try {
                Double num = Double.parseDouble(field);
            } catch (NumberFormatException e) {
                numeric = false;
            }

            if(numeric){


                if(ruble.isSelected()){
                    total=total+(Math.round((soms / 1.08)*100.0)/100.0 +" rubles"+"\n");

                }
                if(dollar.isSelected()){
                    total=total+(Math.round((soms / 83.82)*100.0)/100.0 +" dollars"+"\n");

                }
                if(euro.isSelected()){
                    total=total+(Math.round((soms / 99.53)*100.0)/100.0  +" euro"+"\n");

                }
                if(tenge.isSelected()){
                    total=total+(Math.round((soms / 0.19)*100.0)/100.0  +" tenge"+"\n");

                }
                String n = total;
                arr.add(n);

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/sample1.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                String title = "Result";
                stage.setTitle(title);
                stage.setResizable(false);
                stage.showAndWait();




            }


        });



    }

    @FXML
    void Info(ActionEvent event) throws IOException{

            Stage stage = new Stage();
            Pane layout = FXMLLoader.load(getClass().getResource("olderInfo.fxml"));
            Scene fourth = new Scene(layout);
            stage.setScene(fourth);

            FileWriter writer = new FileWriter("Info.txt", true);
            writer.write(total);
            writer.close();

            stage.show();


    }
}
