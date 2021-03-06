package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Model.AegHind;
import sample.Model.BussiInfo;
import sample.Model.LeiaBuss;
import sample.Model.PiletiLeidja;
import sample.View.KoikBussidController;

import java.io.IOException;
import java.util.List;

/**
 * Created by Marko on 04/12/2016.
 */
public class Peaklass extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<BussiInfo> bussid = FXCollections.observableArrayList();

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bussiotsing");

        initRootLayout();

        näitaKõikiBusse();
    }



    public Peaklass() {
    }

    public ObservableList<BussiInfo> getBussid() {
        return bussid;
    }

    public void setBussid(ObservableList<BussiInfo> bussid) {
        this.bussid = bussid;
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Peaklass.class.getResource("View/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // TO:DO replace with a message
        }
    }

    public void näitaKõikiBusse() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Peaklass.class.getResource("View/KoikBussid.fxml"));
            AnchorPane koikBussid = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(koikBussid);
            KoikBussidController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace(); //TO:DO
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
