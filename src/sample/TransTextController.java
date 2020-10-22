package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class TransTextController {
    @FXML
    TextArea textAreaFirst;
    @FXML
    TextArea textAreaSecond;
    @FXML
    Label labelFirst;
    @FXML
    Label labelSecond;
    public void changeSceneSample(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent addWord = loader.load();
        Scene scene = new Scene(addWord);
        stage.setScene(scene);
    }

    public void transferEng_Vie(ActionEvent event) {
        String tmp = labelFirst.getText();
        labelFirst.setText(labelSecond.getText());
        labelSecond.setText(tmp);
        //change translate
    }

    public void handleEventTranslate(ActionEvent event) throws Exception{
        if (labelFirst.getText().equals("English")) {
            textAreaSecond.setText(Translator.TranslateAString(textAreaFirst.getText(), "en", "vi"));
        } else {
            textAreaSecond.setText(Translator.TranslateAString(textAreaFirst.getText(), "vi", "en"));
        }
    }

}
