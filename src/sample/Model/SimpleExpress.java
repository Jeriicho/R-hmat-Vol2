package sample.Model;
import javafx.beans.property.StringProperty;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sample.Model.Bussid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class SimpleExpress extends Bussid {
    private StringProperty väljumine;
    private StringProperty kellaaeg;
    private StringProperty misBuss;

    public SimpleExpress(String lähtekoht, String sihtkoht, String päev, String kuu) {
        super(lähtekoht, sihtkoht, päev, kuu);
    }

    public boolean onVabuKohti(){
        return false;
    }

    public String genereeriMaandumisLeht() {
        String algus = "https://pilet.simpleexpress.eu/reiside-soiduplaan/";
        String kuu = "?Date=";
        String lõpp = "";
        if (getKuu().equals("12")) lõpp = "-2016&ReturnDate=&MultiHopSearchSortOrder=StartTimeAndDuration&CampaignCode=&Currency=CURRENCY.EUR";
        else lõpp = "-2017&ReturnDate=&MultiHopSearchSortOrder=StartTimeAndDuration&CampaignCode=&Currency=CURRENCY.EUR";
        String koguURL = algus + getLähtekoht() + "/" + getSihtkoht() + kuu + getKuu() + "-" + getPäev() + lõpp;
        return koguURL;
    }

    public List<AegHind> leiaVabuKohti(){
        System.out.println("Otsin Simple'eid.");
        List<AegHind> ajadHinnad = new ArrayList<>();
        String html = "";
        try {
            URL url = new URL(genereeriMaandumisLeht());
            URLConnection connect = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader((connect.getInputStream())));
            String inputLine;
            html = "";
            html = "";
            while ((inputLine = in.readLine()) != null)
                html += inputLine;
            in.close();
        } catch (IOException e){}
        html = html.split("Teised vedajad")[0];
        Document doc = Jsoup.parse(html);
        Elements elemendid = doc.select(".full-price");
        for (Element element : elemendid) {
            Elements div = element.children().tagName("div");
            if (!div.hasClass("sold-out-text")) {
                String väljumisaeg = element.parent().parent().parent().child(0).child(0).child(0).html();
                String hind = element.child(0).html();
                hind = hind.replaceAll(",", ".");

                ajadHinnad.add(new AegHind(väljumisaeg, Double.parseDouble(hind), "SimpleExpress"));
            }
        }
        System.out.println("Leidsin " + ajadHinnad.size() + " bussi.");
        return ajadHinnad;
    }

    public List<String> andmed(String väljumine,String kellaaeg,String misBuss) {
        List<String> temp = new ArrayList<>();
        temp.add(väljumine);
        temp.add(kellaaeg);
        temp.add(misBuss);
        return temp;
    }
}
