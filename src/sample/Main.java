package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Vabad bussipiletid");

        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20, 20, 20, 20));
        gp.setVgap(3);
        gp.setHgap(10);
        Button lux = new Button("Otsi Lux Expressi vabu busse");
        Button simple = new Button("Otsi Simple Expressi vabu busse");
        Button molemad = new Button("Otsi mõlemaid");

        ChoiceBox<String> lahtekohad = new ChoiceBox<>();
        ChoiceBox<String> sihtkohad = new ChoiceBox<>();
        sihtkohad.getItems().addAll("Tallinn", "Tartu", "Pärnu", "Narva");
        lahtekohad.getItems().addAll("Tallinn", "Tartu", "Pärnu", "Narva");
        sihtkohad.setValue("Tallinn");
        lahtekohad.setValue("Tartu");
        Text lähtekohttekst = new Text("Lähtekoht");
        lähtekohttekst.setStyle("-fx-font-size: 25px");
        lähtekohttekst.setStyle("-fx-font-family: monospace");
        Text sihtkohttekst = new Text("Sihtkoht");
        sihtkohttekst.setStyle("-fx-font-size: 25px");
        sihtkohttekst.setStyle("-fx-font-family: monospace");


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(sihtkohttekst ,sihtkohad, lähtekohttekst, lahtekohad, lux, simple, molemad);
        gp.getChildren().add(layout);
        gp.setAlignment(Pos.CENTER);
        GridPane.setHalignment(sihtkohttekst, HPos.RIGHT);
        GridPane.setHalignment(sihtkohad, HPos.RIGHT);


        Scene stseen = new Scene(gp, 400, 400);
        stseen.getStylesheets().add("./sample/Avaleht.css");
        stage.setScene(stseen);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
