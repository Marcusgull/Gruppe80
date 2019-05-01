package modeller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class LedigeVikariater {

    public StringProperty Sektor = new SimpleStringProperty();
    public StringProperty Sted = new SimpleStringProperty();
    public StringProperty Arbeidsgiver = new SimpleStringProperty();
    public StringProperty Jobbkategori = new SimpleStringProperty();
    public StringProperty Varighet = new SimpleStringProperty();
    public StringProperty Arbeidstid = new SimpleStringProperty();
    public StringProperty Stillingstype = new SimpleStringProperty();
    public StringProperty Kvalifikasjoner = new SimpleStringProperty();

    public LedigeVikariaterModell data(){
        return new LedigeVikariaterModell(Sektor.get()
                ,Sted.get()
                ,Arbeidsgiver.get() //må castes til Arbeidsgiver et sted også
                ,Jobbkategori.get()
                ,Varighet.get() //må castes til int et sted??
                ,Arbeidstid.get()
                ,Stillingstype.get()
                ,Kvalifikasjoner.get());
    }

    public class LedigeVikariaterModell {
        private String Sektor;
        private String Sted;
        private String Arbeidsgiver;
        private String Jobbkategori;
        private String Varighet;
        private String Arbeidstid;
        private String Stillingstype;
        private String Kvalifikasjoner;

        public LedigeVikariaterModell(String Sektor, String Sted, String Arbeidsgiver, String Jobbkategori, String Varighet, String Arbeidstid, String Stillingstype, String Kvalifikasjoner) {
            this.Sektor = Sektor;
            this.Sted = Sted;
            this.Arbeidsgiver = Arbeidsgiver;
            this.Jobbkategori = Jobbkategori;
            this.Varighet = Varighet;
            this.Arbeidstid = Arbeidstid;
            this.Stillingstype = Stillingstype;
            this.Kvalifikasjoner = Kvalifikasjoner;
        }

        public String getSektor() {
            return Sektor;
        }
        public void setSektor(String Sektor) {
            this.Sektor = Sektor;
        }
        public String getSted() {
            return Sted;
        }
        public void setSted(String Sted) {
            this.Sted = Sted;
        }
        public String getArbeidsgiver() {
            return Arbeidsgiver;
        }
        public void setArbeidsgiver(String Arbeidsgiver) {
            this.Arbeidsgiver = Arbeidsgiver;
        }
        public String getJobbkategori() {
            return Jobbkategori;
        }
        public void setJobbkategori(String Jobbkategori) {
            this.Jobbkategori = Jobbkategori;
        }
        public String getVarighet() {
            return Varighet;
        }
        public void setVarighet(String Varighet) {
            this.Varighet = Varighet;
        }
        public String getArbeidstid() {
            return Arbeidstid;
        }
        public void setArbeidstid(String Arbeidstid) {
            this.Arbeidstid = Arbeidstid;
        }
        public String getStillingstype() {
            return Stillingstype;
        }
        public void setStillingstype(String Stillingstype) {
            this.Stillingstype = Stillingstype;
        }
        public String getKvalifikasjoner() {
            return Kvalifikasjoner;
        }
        public void setKvalifikasjoner(String Kvalifikasjoner) {
            this.Kvalifikasjoner = Kvalifikasjoner;
        }

    }

}
