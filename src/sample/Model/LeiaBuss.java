package sample.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Marko on 04/12/2016.
 */
public class LeiaBuss extends PiletiLeidja {
    private StringProperty lähtekoht;
    private StringProperty sihtkoht;
    private StringProperty päev;
    private StringProperty kuu;

    public LeiaBuss(String lähtekoht, String sihtkoht, String päev, String kuu){
        super(lähtekoht, sihtkoht, päev, kuu);
        this.lähtekoht = new SimpleStringProperty(lähtekoht);
        this.sihtkoht = new SimpleStringProperty(sihtkoht);
        this.päev = new SimpleStringProperty(päev);
        this.kuu = new SimpleStringProperty(kuu);
    }

    public void setLähtekoht(String lähtekoht) {
        this.lähtekoht.set(lähtekoht);
    }

    public void setSihtkoht(String sihtkoht) {
        this.sihtkoht.set(sihtkoht);
    }

    public void setPäev(String päev) {
        this.päev.set(päev);
    }

    public void setKuu(String kuu) {
        this.kuu.set(kuu);
    }

    public String getLähtekoht() {

        return lähtekoht.get();
    }

    public StringProperty lähtekohtProperty() {
        return lähtekoht;
    }

    public String getSihtkoht() {
        return sihtkoht.get();
    }

    public StringProperty sihtkohtProperty() {
        return sihtkoht;
    }

    public String getPäev() {
        return päev.get();
    }

    public StringProperty päevProperty() {
        return päev;
    }

    public String getKuu() {
        return kuu.get();
    }

    public StringProperty kuuProperty() {
        return kuu;
    }
}
