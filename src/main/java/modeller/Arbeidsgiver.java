package modeller;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Arbeidsgiver implements Serializable {

    private static final long serialVersionUID = 1L;

    public StringProperty Adresse = new SimpleStringProperty();
    public StringProperty Bransje = new SimpleStringProperty();
    public StringProperty Email = new SimpleStringProperty();
    public StringProperty Tlf = new SimpleStringProperty();

    public Arbeidsmodell data(){
        return new Arbeidsmodell(Adresse.get()
                , Bransje.get()
                , Email.get()
                , Tlf.get());
    }

    public static class Arbeidsmodell{
        private String Adresse;
        private String Bransje;
        private String Email;
        private String Tlf;

        public Arbeidsmodell(String adresse, String bransje, String email, String tlf) {
            Adresse = adresse;
            Bransje = bransje;
            Email = email;
            Tlf = tlf;
        }

        public void setAdresse(String adresse) { Adresse = adresse; }
        public void setBransje(String bransje) { Bransje = bransje; }
        public void setEmail(String email) { Email = email; }
        public void setTlf(String tlf) { Tlf = tlf; }
        public String getAdresse() { return Adresse; }
        public String getBransje() { return Bransje; }
        public String getEmail() { return Email; }
        public String getTlf() { return Tlf; }
    }
}

