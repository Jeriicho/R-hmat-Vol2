package sample.Model;

import java.util.ArrayList;
import java.util.List;

abstract class Bussid implements Pileteid {
    private String lähtekoht;
    private String sihtkoht;
    private String päev;
    private String kuu;

    public Bussid(String lähtekoht, String sihtkoht, String päev, String kuu) {
        this.lähtekoht = lähtekoht;
        this.sihtkoht = sihtkoht;
        this.päev = päev;
        this.kuu = kuu;
    }

    public String getLähtekoht() {
        return lähtekoht;
    }

    public String getSihtkoht() {
        return sihtkoht;
    }

    public String getPäev() {
        return päev;
    }

    public String getKuu() {
        return kuu;
    }
    abstract List<AegHind> leiaVabuKohti();
    abstract List<String> andmed(String väljumine,String kellaaeg,String misBuss);
}
