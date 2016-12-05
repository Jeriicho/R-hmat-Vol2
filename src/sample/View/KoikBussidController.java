package sample.View;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Model.BussiInfo;
import sample.Model.LeiaBuss;
import sample.Model.PiletiLeidja;
import sample.Peaklass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marko on 04/12/2016.
 */
public class KoikBussidController {

    @FXML
    private TableView<BussiInfo> bussitabel;

    @FXML
    TableColumn<BussiInfo, String> väljumisVeerg;

    @FXML
    TableColumn<BussiInfo, String> bussiVeerg;

    @FXML
    TableColumn<BussiInfo, String> hinnaVeerg;

    @FXML
    private ChoiceBox<String> kuupäev;

    @FXML
    private ChoiceBox<String> kuu;

    @FXML
    private ChoiceBox<String> lähtekoht;

    @FXML
    private ChoiceBox<String> sihtkoht;


    private Peaklass peaklass;


    public KoikBussidController() {};

    @FXML
    private void initialize() {
        kuupäev.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"));
        kuu.setItems(FXCollections.observableArrayList("Jaanuar", "Veebruar", "Märts", "Aprill", "Mai", "Juuni", "August", "September", "Oktoober", "November", "Detsember"));
        lähtekoht.setItems(FXCollections.observableArrayList("Tallinn", "Tartu", "Pärnu", "Narva"));
        sihtkoht.setItems(FXCollections.observableArrayList("Tallinn", "Tartu", "Pärnu", "Narva"));

    }

    private void näitaBusse(LeiaBuss LeiaBuss) {

    }

    @FXML
    private void nupuVajutus() throws Exception {

        if (!(bussitabel.getItems().isEmpty())) {
            peaklass.getBussid().removeAll();
        }
        List<BussiInfo> bussiInfo  = new ArrayList<>();
        String kp = kuupäev.getValue();
        String month = kuu.getValue();
        String from = lähtekoht.getValue();
        String to = sihtkoht.getValue();
        LeiaBuss buska = new LeiaBuss(from, to, kp, kuuNumber(month));
        for (int i = 0; i < buska.getVäljumine().size(); i++) {
            bussiInfo.add(new BussiInfo(buska.getVäljumine().get(i), buska.getHind().get(i), buska.getMisBuss().get(i)));
        }
        for (BussiInfo buss : bussiInfo) {
            peaklass.getBussid().add(buss);
        }
        väljumisVeerg.setCellValueFactory(data -> data.getValue().väljumineProperty());
        bussiVeerg.setCellValueFactory(data -> data.getValue().misBussProperty());
        hinnaVeerg.setCellValueFactory(data -> data.getValue().hindProperty());
    }

    public void setMainApp(Peaklass peaklass) {
        this.peaklass = peaklass;
        bussitabel.setItems(peaklass.getBussid());
    }

    public String kuuNumber(String kuu) {
        if (kuu.equals("Jaanuar")) {
            return "1";
        } else if (kuu.equals("Veebruar")) {
            return "2";
        } else if (kuu.equals("Märts")) {
            return "3";
        } else if (kuu.equals("Aprill")) {
            return "4";
        } else if (kuu.equals("Mai")) {
            return "5";
        } else if (kuu.equals("Juuni")) {
            return "6";
        } else if (kuu.equals("Juuli")) {
            return "7";
        } else if (kuu.equals("August")) {
            return "8";
        } else if (kuu.equals("September")) {
            return "9";
        } else if (kuu.equals("Oktoober")) {
            return "10";
        } else if (kuu.equals("November")) {
            return "11";
        } else if (kuu.equals("Detsember")) {
            return "12";
        }
        return null;
    }
}
