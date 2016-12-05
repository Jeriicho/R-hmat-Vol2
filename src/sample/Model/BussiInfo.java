package sample.Model;

import javafx.beans.property.StringProperty;

/**
 * Created by Marko on 05/12/2016.
 */
public class BussiInfo {
    private StringProperty väljumine;
    private StringProperty hind;
    private StringProperty misBuss;

    public String getVäljumine() {
        return väljumine.get();
    }

    public StringProperty väljumineProperty() {
        return väljumine;
    }

    public String getHind() {
        return hind.get();
    }

    public StringProperty hindProperty() {
        return hind;
    }

    public String getMisBuss() {
        return misBuss.get();
    }

    public StringProperty misBussProperty() {
        return misBuss;
    }

    public BussiInfo(StringProperty väljumine, StringProperty hind, StringProperty misBuss) {
        this.väljumine = väljumine;
        this.hind = hind;
        this.misBuss = misBuss;

    }

}
