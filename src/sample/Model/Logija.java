package sample.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logija {
    private String nimi;
    private BufferedWriter bfr;

    public Logija(String nimi) throws IOException {
        this.nimi = nimi;
        bfr = new BufferedWriter(new FileWriter(new File(nimi)));
    }

    public void kirjuta(String sõne) throws IOException{
        bfr.write(sõne);
    }
}
