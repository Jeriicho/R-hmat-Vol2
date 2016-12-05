package sample.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

public class AegHind implements Comparable<AegHind>{
    private String aeg;
    private double hind;
    private String buss;

    public AegHind(String aeg, double hind, String buss) {
        this.aeg = aeg;
        this.hind = hind;
        this.buss = buss;
    }

    public DoubleProperty saaHind() {
        return new SimpleDoubleProperty(hind);
    }

    public String getAeg() {
        return aeg;
    }

    public void setAeg(String aeg) {
        this.aeg = aeg;
    }

    public double getHind() {
        return hind;
    }

    public void setHind(double hind) {
        this.hind = hind;
    }

    public String getBuss() {
        return buss;
    }

    public void setBuss(String buss) {
        this.buss = buss;
    }

    @Override
    public String toString() {
        return "AegHind{" +
                "aeg='" + aeg + '\'' +
                ", hind=" + hind +
                ", buss='" + buss + '\'' +
                '}';
    }

    @Override
    public int compareTo(AegHind teine) {
        int minuAeg = Integer.parseInt(aeg.replaceAll(":", ""));
        int teineAeg = Integer.parseInt(teine.getAeg().replaceAll(":", ""));
        if (minuAeg > teineAeg) return 1;
        else if (minuAeg == teineAeg) return 0;
        return -1;
    }
    public List<String> andmed() {
        List<String> temp = new ArrayList<>();
        temp.add(aeg);
        temp.add(String.valueOf(hind));
        temp.add(buss);
        return temp;
    }
}
