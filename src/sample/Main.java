package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.awt.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 500));
        /*Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add Word");
        dialog.setHeaderText("Add one Word");
        ButtonType addWord = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addWord , ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20,150,10,10));

        TextField englishAdded = new TextField();

        TextField vietnameseAdded = new TextField();

        grid.add(new Label("English"), 0, 0);
        grid.add(english, 1, 0);
        grid.add(new Label("Vietnamese"),0,1);
        grid.add(vietnamese,1,1);*/



        
        primaryStage.show();
    }


    public static void main(String[] args) { launch(args); }
}
