package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class AddWordController {
    @FXML
    private TextField newEnglishId;

    @FXML
    private TextField  newVietnameseId;

    private DictionaryManagement dictList = new DictionaryManagement();

    public void changeSceneSample(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent addWord = loader.load();
        Scene scene = new Scene(addWord);
        stage.setScene(scene);
    }
    public void addNewWord(ActionEvent event) throws IOException {
        FileWriter fw = new FileWriter("F:/DictionaryProject/src/sample/dictionaries.txt", true);
        fw.write(newEnglishId.getText().toLowerCase()+ ':' + newVietnameseId.getText()+ "\n");
        fw.close();

    }
}
