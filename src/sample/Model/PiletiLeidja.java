package sample.Model;
import javafx.beans.property.*;
import sample.Model.AegHind;
import sample.Model.Bussid;
import sample.Model.LuxExpress;
import sample.Model.SimpleExpress;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PiletiLeidja {
    private String lähtekoht;
    private String sihtkoht;
    private String päev;
    private String kuu;
    private List<Bussid> bussid = new ArrayList<>();
    private List<StringProperty> väljumine = new ArrayList<>();
    private List<DoubleProperty> hind = new ArrayList<>();
    private List<StringProperty> misBuss = new ArrayList<>();
    public List<AegHind> aegJaHind = new ArrayList<>();


    public PiletiLeidja(String lähtekoht, String sihtkoht, String päev, String kuu) throws Exception {
        this.lähtekoht = lähtekoht;
        this.sihtkoht = sihtkoht;
        this.päev = päev;
        this.kuu = kuu;
        bussid.add(new SimpleExpress(lähtekoht, sihtkoht, päev, kuu));
        bussid.add(new LuxExpress(lähtekoht, sihtkoht, päev, kuu));
        for (Bussid buss: bussid) {
            aegJaHind.addAll(buss.leiaVabuKohti());
        }
        for (AegHind aegHind : aegJaHind) {
            väljumine.add(new SimpleStringProperty(aegHind.getAeg()));
            hind.add(aegHind.saaHind());
            misBuss.add(new SimpleStringProperty(aegHind.getBuss()));
        }
    }

    public List<StringProperty> getVäljumine() {
        return väljumine;
    }

    public List<DoubleProperty> getHind() {
        return hind;
    }

    public List<StringProperty> getMisBuss() {
        return misBuss;
    }

    public List<AegHind> leiaPiletid() throws Exception{
        System.out.println("Otsin pileteid marsruudil " + lähtekoht + " -> " + sihtkoht + ".");
        System.out.println("Kuupäeval " + päev + "." + kuu + ".");
        List<AegHind> ajadHinnad = new ArrayList<>();
        for (Bussid buss : bussid){
            ajadHinnad.addAll(buss.leiaVabuKohti());
            for (AegHind aegHind: ajadHinnad) {
                väljumine.add(new SimpleStringProperty(aegHind.getAeg()));
                hind.add(aegHind.saaHind());
                misBuss.add(new SimpleStringProperty(aegHind.getBuss()));
            }
        }
        return ajadHinnad;
    }
    public void prindiPiletid() throws Exception{
        Random r = new Random();
        List<AegHind> ajadHinnad = leiaPiletid();
        Collections.sort(ajadHinnad);
        System.out.println("Sul on " + ajadHinnad.size() + " valikut:");
        for (AegHind aegHind : ajadHinnad){
            System.out.println("Väljub: " + aegHind.getAeg() + "\n"+
                    "Hind  : "  + aegHind.getHind() + "\n"+
                    "Buss  : " + aegHind.getBuss() + "\n");
        }
        AegHind rbuss = ajadHinnad.get(r.nextInt(ajadHinnad.size()));
        System.out.println("Soovitan sulle bussi " + rbuss.getBuss() + ", mis väljub kell " + rbuss.getAeg() + ".");


    }
}
