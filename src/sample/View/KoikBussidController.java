package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.MainApp;
import sample.Model.PiletiLeidja;
import sample.Peaklass;

/**
 * Created by Marko on 04/12/2016.
 */
public class KoikBussidController {

    @FXML
    private TableView<PiletiLeidja> bussitabel;

    @FXML
    TableColumn<PiletiLeidja, String> väljumisVeerg;

    @FXML
    TableColumn<PiletiLeidja, String> saabumisVeerg;

    @FXML
    TableColumn<PiletiLeidja, String> bussiVeerg;

    @FXML
    TableColumn<PiletiLeidja, String> kuupäevaVeerg;

    @FXML
    private ChoiceBox<String> kuupäev;

    @FXML
    private ChoiceBox<String> kuu;

    @FXML
    private ChoiceBox<String> lähtekoht;

    @FXML
    private ChoiceBox<String> sihtkoht;

    @FXML
    private ChoiceBox<String> buss;

    private Peaklass peaklass;

    @FXML
    private void lisaBuss() {
        //TO-DO
    }

    public KoikBussidController() {};

    @FXML
    private void initialize() {
        kuupäev.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"));
        kuu.setItems(FXCollections.observableArrayList("Jaanuar", "Veebruar", "Märts", "Aprill", "Mai", "Juuni", "August", "September", "Oktoober", "November", "Detsember"));
        lähtekoht.setItems(FXCollections.observableArrayList("Tallinn", "Tartu", "Pärnu", "Narva"));
        sihtkoht.setItems(FXCollections.observableArrayList("Tallinn", "Tartu", "Pärnu", "Narva"));
        buss.setItems(FXCollections.observableArrayList("Lux Express", "Simple Express"));

    }

    private void näitaBusse(PiletiLeidja piletiLeidja) {

    }

    @FXML
    private void nupuVajutus() {
        
    }

    public void setMainApp(Peaklass peaklass) {
        this.peaklass = peaklass;
        //bussitabel.setItems(peaklass.getBussid());
    }
}
