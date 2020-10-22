package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.Node;

import static java.util.Arrays.sort;


public class Controller {
    @FXML
    private TextField textField;

    @FXML
    private TextArea textArea;

    @FXML
    private Button buttonTranslate;

    @FXML
    private Button speakEnglish;

    public DictionaryManagement dictItem;

    @FXML
    private Button addWordId;

    @FXML
    private ObservableList <String> list = FXCollections.observableArrayList();

    @FXML
    private ListView<String> listView;

    public void searchListWord(KeyEvent event) {
        ObservableList <String> tempList = FXCollections.observableArrayList();
        try {
            dictItem.insertFromFile();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if(list.size() <= dictItem.wordFromFile.length){
                list.clear();
                for (int i = 0; i < dictItem.wordFromFile.length; i++) {
                    list.add(dictItem.wordFromFile[i].getWord_target());
                }
                java.util.Collections.sort(list);
            }
        }catch(Exception e){
            System.out.print("");
        }
        String s = textField.getText();
        s = s.toLowerCase();
        if(s.isEmpty()){
            java.util.Collections.sort(list);
            listView.setItems(list);
        }

        else{
            try {
                for(int i=0;i<dictItem.wordFromFile.length;i++){
                    boolean check = true;
                    boolean checkFound = false;
                    if(s.length() > dictItem.wordFromFile[i].getWord_target().length()){
                        continue;
                    }
                    for(int j =0;j<s.length();j++){
                        if(s.charAt(j) != dictItem.wordFromFile[i].getWord_target().charAt(j)){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        checkFound = true;
                    }
                    if(checkFound){
                        if(tempList.size()<= dictItem.wordFromFile.length){
                            tempList.add(dictItem.wordFromFile[i].getWord_target());
                            java.util.Collections.sort(tempList);
                        }
                        listView.setItems(tempList);

                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }


    }


    public void handleEventTranslate(ActionEvent event) {
        try {
            dictItem = new DictionaryManagement();
            dictItem.insertFromFile();
            String wordSearch = textField.getText();
            wordSearch = wordSearch.toLowerCase();
            for(int i=0;i<dictItem.wordFromFile.length;i++){
                if(wordSearch.equalsIgnoreCase(dictItem.wordFromFile[i].getWord_target())){
                    textArea.setText(dictItem.wordFromFile[i].getWord_explain());
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void changeSceneAddWord(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddWord.fxml"));
        Parent addWord = loader.load();
        Scene scene = new Scene(addWord);
        AddWordController controller = loader.getController();

        stage.setScene(scene);

    }
    public void changeSceneTransText(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TransText.fxml"));
        Parent transText = loader.load();
        Scene scene = new Scene(transText);
        stage.setScene(scene);
    }
    /*public void handleEventSpeak(ActionEvent event) throws IOException, JavaLayerException {
        Audio audio = Audio.getInstance();
        InputStream sound = audio.getAudio("Speak", Language.ENGLISH);
        audio.play(sound);
    }*/
    public void HandleEventTextToSpeech(ActionEvent event) throws Exception {
        String text = textField.getText();
        Translator.pronunciation(text);
    }




}
