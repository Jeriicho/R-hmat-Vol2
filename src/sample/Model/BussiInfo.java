package sample.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Marko on 05/12/2016.
 */
public class BussiInfo {
    private StringProperty väljumine;
    private DoubleProperty hind;
    private StringProperty misBuss;

    public String getVäljumine() {
        return väljumine.get();
    }

    public StringProperty väljumineProperty() {
        return väljumine;
    }


    public DoubleProperty hindProperty() {
        return hind;
    }

    public String getMisBuss() {
        return misBuss.get();
    }

    public StringProperty misBussProperty() {
        return misBuss;
    }

    public BussiInfo(StringProperty väljumine, DoubleProperty hind, StringProperty misBuss) {
        this.väljumine = väljumine;
        this.hind = hind;
        this.misBuss = misBuss;

    }

}
