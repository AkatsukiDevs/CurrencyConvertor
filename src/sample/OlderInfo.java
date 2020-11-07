package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class OlderInfo {

        @FXML
        private Label infoLbl;


    public void olderInfo(javafx.event.ActionEvent actionEvent)throws IOException {

        try (FileReader reader = new FileReader("Info.txt")) {
            char[] buf = new char[2048];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 2048) {
                    buf = Arrays.copyOf(buf, c);
                }
                infoLbl.setText(String.valueOf(buf));
                reader.close();
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

