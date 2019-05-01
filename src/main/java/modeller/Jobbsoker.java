
package modeller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Jobbsoker {

    private static final long serialVersionUID = 1L;

    public StringProperty fnavn = new SimpleStringProperty();
    public StringProperty enavn = new SimpleStringProperty();
    public StringProperty tlf = new SimpleStringProperty();
    public StringProperty email = new SimpleStringProperty();
    public StringProperty alder = new SimpleStringProperty();
    public StringProperty jobbKat = new SimpleStringProperty();
    public StringProperty erfaring = new SimpleStringProperty();
    public StringProperty lonnsKrav = new SimpleStringProperty();
    public StringProperty ref = new SimpleStringProperty();

    public Jobbsokermodell data(){
        return new Jobbsokermodell(fnavn.get()
                ,enavn.get()
                ,tlf.get()
                ,email.get()
                ,alder.get() //må castes til int senere?
                ,jobbKat.get()
                ,erfaring.get()
                ,lonnsKrav.get()
                ,ref.get());
    }

    public class Jobbsokermodell {
        private String fnavn;
        private String enavn;
        private String tlf;
        private String email;
        private String alder;
        private String jobbKat;
        private String erfaring;
        private String lonnKrav;
        private String ref;

        public Jobbsokermodell(String fnavn, String enavn, String tlf, String email, String alder, String jobbKat, String erfaring, String lønnKrav, String ref) {
            this.fnavn = fnavn;
            this.enavn = enavn;
            this.tlf = tlf;
            this.email = email;
            this.alder = alder;
            this.jobbKat = jobbKat;
            this.erfaring = erfaring;
            this.lonnKrav = lønnKrav;
            this.ref = ref;
        }

        public String getFnavn() {
            return fnavn;
        }
        public void setFnavn(String fnavn) {
            this.fnavn = fnavn;
        }
        public String getEnavn() {
            return enavn;
        }
        public void setEnavn(String enavn) {
            this.enavn = enavn;
        }
        public String getTlf() {
            return tlf;
        }
        public void setTlf(String tlf) { this.tlf = tlf; }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getAlder() {
            return alder;
        }
        public void setAlder(String alder) {
            this.alder = alder;
        }
        public String getJobbKat() {
            return jobbKat;
        }
        public void setJobbKat(String jobbKat) {
            this.jobbKat = jobbKat;
        }
        public String getErfaring() {
            return erfaring;
        }
        public void setErfaring(String erfaring) {
            this.erfaring = erfaring;
        }
        public String getLønnKrav() {
            return lonnKrav;
        }
        public void setLønnKrav(String lønnKrav) {
            this.lonnKrav = lønnKrav;
        }
        public String getRef() {
            return ref;
        }
        public void setRef(String ref) {
            this.ref = ref;
        }

    }

}
