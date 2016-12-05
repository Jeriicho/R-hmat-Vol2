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

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    TableColumn<BussiInfo, Double> hinnaVeerg;

    @FXML
    private ChoiceBox<String> kuupäev;

    @FXML
    private ChoiceBox<String> kuu;

    @FXML
    private ChoiceBox<String> lähtekoht;

    @FXML
    private ChoiceBox<String> sihtkoht;


    private Peaklass peaklass;
    private BufferedWriter bfw;

    public KoikBussidController() {};

    @FXML
    private void initialize() throws IOException{
        kuupäev.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"));
        kuu.setItems(FXCollections.observableArrayList("Jaanuar", "Veebruar", "Märts", "Aprill", "Mai", "Juuni", "August", "September", "Oktoober", "November", "Detsember"));
        lähtekoht.setItems(FXCollections.observableArrayList("Tallinn", "Tartu", "Kuressaare", "Narva"));
        sihtkoht.setItems(FXCollections.observableArrayList("Tallinn", "Tartu", "Kuressaare", "Narva"));
        bfw = new BufferedWriter(new FileWriter("logi.log", true));
        bfw.write("Programm käivitub. Tänane kuupäev: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "\n");
        bfw.close();
    }

    private void näitaBusse(LeiaBuss LeiaBuss) {

    }

    @FXML
    private void nupuVajutus() throws IOException, VigaseMarsruudiErind, TühjaLahtriErind {
        bfw = new BufferedWriter(new FileWriter("logi.log", true));
        if (!(bussitabel.getItems().isEmpty())) {
            bussitabel.getColumns().removeAll();
        }
        if (kuupäev.getValue() == null || kuu.getValue() == null || lähtekoht.getValue() == null || sihtkoht.getValue() == null){
            bfw.write("!Tühi lahter!");
            bfw.close();
            JOptionPane.showMessageDialog(null, "Tühi lahter!");
            //throw new TühjaLahtriErind();
            return;
        }
        List<BussiInfo> bussiInfo  = new ArrayList<>();
        String kp = kuupäev.getValue();
        String month = kuu.getValue();
        String from = lähtekoht.getValue();
        String to = sihtkoht.getValue();
        if (to.equals(from)){
            bfw.write("!Vigane marsruut!\n");
            bfw.close();
            throw new VigaseMarsruudiErind();
        }
        bfw.write("Otsin busse marsruudil " + from + " -> " + to + " kp " + kp + "." + month.toLowerCase() + "\n");
        LeiaBuss buska = new LeiaBuss(from, to, kp, kuuNumber(month));
        for (int i = 0; i < buska.getVäljumine().size(); i++) {
            bussiInfo.add(new BussiInfo(buska.getVäljumine().get(i), buska.getHind().get(i), buska.getMisBuss().get(i)));
        }
        if (bussiInfo.size() == 0) bfw.write("Ei leidnud ühtegi bussi!\n");
        else bfw.write("Leidsin järgnevad bussid: \n");
        for (BussiInfo buss : bussiInfo) {
            peaklass.getBussid().add(buss);
            bfw.write(buss.toString() + "\n");
        }
        bfw.write("--------------------------------\n");
        väljumisVeerg.setCellValueFactory(data -> data.getValue().väljumineProperty());
        bussiVeerg.setCellValueFactory(data -> data.getValue().misBussProperty());
        hinnaVeerg.setCellValueFactory(data -> data.getValue().hindProperty().asObject());
        bfw.close();
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
