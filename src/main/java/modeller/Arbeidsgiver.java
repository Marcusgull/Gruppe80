package modeller;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Arbeidsgiver implements Serializable{

    private static final long serialVersionUID = 1L;

    public transient StringProperty Adresse = new SimpleStringProperty();
    public transient StringProperty Bransje = new SimpleStringProperty();
    public transient StringProperty Email = new SimpleStringProperty();
    public transient StringProperty Tlf = new SimpleStringProperty();

    public Arbeidsmodell data(){
        return new Arbeidsmodell(Adresse.get()
                , Bransje.get()
                , Email.get()
                , Tlf.get());
    }

    public class Arbeidsmodell  implements Serializable{
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

        public String hentString(){
            String s = String.join(" | ", Adresse, Bransje, Email, Tlf);
            return s;
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

